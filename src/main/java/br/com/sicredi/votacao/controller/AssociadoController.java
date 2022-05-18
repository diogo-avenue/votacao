package br.com.sicredi.votacao.controller;

import br.com.sicredi.votacao.service.AssociadoService;
import br.com.sicredi.votacao.dto.AssociadoDto;
import br.com.sicredi.votacao.model.Associado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = {"associado"}, produces = APPLICATION_JSON_VALUE)
public class AssociadoController {

	@Autowired
	private AssociadoService associadoService;
	
	
	@PostMapping(consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<Associado> criarAssociado(@RequestBody AssociadoDto associadoDto) {
		Associado associado = associadoService.criarAssociado(associadoDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(associado);
	}
	
}