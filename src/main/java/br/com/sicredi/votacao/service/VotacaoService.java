package br.com.sicredi.votacao.service;

import br.com.sicredi.votacao.dto.VotacaoDto;
import br.com.sicredi.votacao.dto.ResultadoDto;
import br.com.sicredi.votacao.model.Votacao;

public interface VotacaoService {

	Votacao votar(VotacaoDto votacaoDto);

	ResultadoDto obterResultado(int idSessao);

}
