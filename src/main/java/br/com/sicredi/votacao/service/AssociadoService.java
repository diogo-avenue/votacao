package br.com.sicredi.votacao.service;

import br.com.sicredi.votacao.dto.AssociadoDto;
import br.com.sicredi.votacao.model.Associado;

public interface AssociadoService {

	Associado criarAssociado(AssociadoDto associadoDto);

}
