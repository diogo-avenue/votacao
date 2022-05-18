package br.com.sicredi.votacao.service;

import br.com.sicredi.votacao.model.Sessao;
import br.com.sicredi.votacao.dto.SessaoDto;

public interface SessaoService {

	Sessao criarSessao(SessaoDto sessaoDto);

}
