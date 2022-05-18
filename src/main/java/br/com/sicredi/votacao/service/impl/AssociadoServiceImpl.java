package br.com.sicredi.votacao.service.impl;

import br.com.sicredi.votacao.repository.AssociadoRepository;
import br.com.sicredi.votacao.service.AssociadoService;
import br.com.sicredi.votacao.dto.AssociadoDto;
import br.com.sicredi.votacao.model.Associado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssociadoServiceImpl implements AssociadoService {
	
	@Autowired
	private AssociadoRepository associadoRepository;

	@Override
	public Associado criarAssociado(AssociadoDto associadoDto) {
		Associado associado = new Associado(associadoDto.getNome());
		return associadoRepository.save(associado);
	}
}
