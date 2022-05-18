package br.com.sicredi.votacao.service.impl;

import br.com.sicredi.votacao.dto.PautaDto;
import br.com.sicredi.votacao.model.Pauta;
import br.com.sicredi.votacao.repository.PautaRepository;
import br.com.sicredi.votacao.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PautaServiceImpl implements PautaService {
	
	@Autowired
	private PautaRepository pautaRepository;
	
	@Override
	public Pauta criarPauta(PautaDto pautaDto) {
		Pauta pauta = new Pauta(pautaDto.getTitulo(), pautaDto.getDescricao());
		return pautaRepository.save(pauta);
	}

}
