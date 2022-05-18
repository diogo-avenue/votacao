package br.com.sicredi.votacao.service;

import br.com.sicredi.votacao.dto.PautaDto;
import br.com.sicredi.votacao.model.Pauta;

public interface PautaService {

	Pauta criarPauta(PautaDto pautaDto);

}
