package br.com.sicredi.votacao.service.impl;

import br.com.sicredi.votacao.model.Pauta;
import br.com.sicredi.votacao.model.Sessao;
import br.com.sicredi.votacao.dto.SessaoDto;
import br.com.sicredi.votacao.repository.SessaoRepository;
import br.com.sicredi.votacao.service.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class SessaoServiceImpl implements SessaoService {

	@Autowired
	private SessaoRepository sessaoRepository;

	@Override
	public Sessao criarSessao(SessaoDto sessaoDto) {

		long tempoReferencia = new Date().getTime();

		Timestamp tempoInicial = new Timestamp(tempoReferencia);
		Timestamp tempoFinal = new Timestamp(tempoReferencia + TimeUnit.MINUTES.toMillis(sessaoDto.getDuracao()));

		Pauta pauta = new Pauta(sessaoDto.getPauta().getId());

		Sessao sessao = new Sessao(pauta, tempoInicial, tempoFinal);

		return sessaoRepository.save(sessao);
	}
}
