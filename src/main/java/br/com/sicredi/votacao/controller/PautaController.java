package br.com.sicredi.votacao.controller;

import br.com.sicredi.votacao.dto.PautaDto;
import br.com.sicredi.votacao.model.Pauta;
import br.com.sicredi.votacao.service.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = {"pauta"}, produces = APPLICATION_JSON_VALUE)
public class PautaController {

	@Autowired
	private PautaService pautaService;
	
	
	@PostMapping(consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<Pauta> criarPauta(@RequestBody PautaDto pautaDto) {
		Pauta pauta = pautaService.criarPauta(pautaDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(pauta);
	}
	
}