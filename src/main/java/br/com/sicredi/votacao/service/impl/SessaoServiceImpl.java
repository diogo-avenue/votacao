package br.com.sicredi.votacao.service.impl;

import br.com.sicredi.votacao.model.Pauta;
import br.com.sicredi.votacao.model.Sessao;
import br.com.sicredi.votacao.dto.SessaoDto;
import br.com.sicredi.votacao.repository.SessaoRepository;
import br.com.sicredi.votacao.service.SessaoService;
import br.com.sicredi.votacao.task.KafkaSenderTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
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

		agendarEnvioDoResultadoFinal(sessao);

		return sessaoRepository.save(sessao);
	}

	/**
	 * Tarefa Bônus 2 - Mensageria e filas
	 *
	 * Quando a sessão de votação fechar, postar uma mensagem com o resultado da votação.
	 *
	 * @param sessao
	 */
	private void agendarEnvioDoResultadoFinal(Sessao sessao) {
		ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
		long millis = sessao.getHoraFim().getTime() - System.currentTimeMillis();
		service.schedule(new KafkaSenderTask(sessao.getId()), millis, TimeUnit.MILLISECONDS);
	}
}
