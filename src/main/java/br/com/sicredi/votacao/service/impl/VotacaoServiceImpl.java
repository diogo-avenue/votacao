package br.com.sicredi.votacao.service.impl;

import br.com.sicredi.votacao.dto.ResultadoDto;
import br.com.sicredi.votacao.dto.VotacaoDto;
import br.com.sicredi.votacao.enumerators.Voto;
import br.com.sicredi.votacao.model.Associado;
import br.com.sicredi.votacao.model.Pauta;
import br.com.sicredi.votacao.model.Sessao;
import br.com.sicredi.votacao.model.Votacao;
import br.com.sicredi.votacao.repository.SessaoRepository;
import br.com.sicredi.votacao.repository.VotacaoRepository;
import br.com.sicredi.votacao.service.VotacaoService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Service
public class VotacaoServiceImpl implements VotacaoService {

	@Autowired
	private VotacaoRepository votacaoRepository;

	@Autowired
	private SessaoRepository sessaoRepository;

	@Override
	public Votacao votar(VotacaoDto votacaoDto) {
		if(associadoNaoPodeVotar(votacaoDto)){
			throw new RuntimeException("Associado não possui um CPF válido para essa votação!");
		}

		if(sessaoDeVotacaoExpirada(votacaoDto)){
			throw new RuntimeException("O horário desta sessão de votação expirou!");
		}

		if (usuarioJaVotouNestaSessao(votacaoDto)){
			throw new RuntimeException("O associado já votou nesta sessão!");
		}

		Sessao sessao = new Sessao(votacaoDto.getSessao().getId());
		Associado associado = new Associado(votacaoDto.getAssociado().getId());
		Voto voto = votacaoDto.getVoto();

		Votacao votacao = new Votacao(sessao, associado, voto);
		return votacaoRepository.save(votacao);
	}

	private boolean associadoNaoPodeVotar(VotacaoDto votacaoDto){
		final String uri = "https://user-info.herokuapp.com/users/" + votacaoDto.getAssociado().getCpf();
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject(uri, String.class);
		JSONObject jsonObject = new JSONObject(result);
		return jsonObject.get("status").equals("UNABLE_TO_VOTE");
	}

	private boolean usuarioJaVotouNestaSessao(VotacaoDto votacaoDto) {
		Associado associado = new Associado(votacaoDto.getAssociado().getId());
		Sessao sessao = new Sessao(votacaoDto.getSessao().getId());
		return votacaoRepository.existsByAssociadoAndSessao(associado, sessao);
	}

	private boolean sessaoDeVotacaoExpirada(VotacaoDto votacaoDto) {
		Sessao sessao = sessaoRepository.getById(votacaoDto.getSessao().getId());
		return new Date().getTime() > sessao.getHoraFim().getTime();
	}

	@Override
	public ResultadoDto obterResultado(int idSessao) {
		Sessao sessao = sessaoRepository.getById(idSessao);
		List<Votacao> votos = votacaoRepository.findAllBySessao(sessao);
		ResultadoDto resultado = new ResultadoDto();
		Pauta pauta = sessao.getPauta();
		resultado.setPauta(pauta);
		resultado.setQuantidadeVotosSim(votos.stream().filter(voto -> voto.getVoto().equals(Voto.SIM)).count());
		resultado.setQuantidadeVotosNao(votos.stream().filter(voto -> voto.getVoto().equals(Voto.NAO)).count());
		resultado.setResultado(resultado.getQuantidadeVotosSim() > resultado.getQuantidadeVotosNao() ? "Aprovado" : "Reprovado");
		return resultado;
	}
}
