package br.com.sicredi.votacao.controller;

import br.com.sicredi.votacao.dto.SessaoDto;
import br.com.sicredi.votacao.model.Sessao;
import br.com.sicredi.votacao.service.SessaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = {"sessao"}, produces = APPLICATION_JSON_VALUE)
public class SessaoController {

	@Autowired
	private SessaoService sessaoService;
	
	
	@PostMapping(consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<Sessao> abrirSessao(@RequestBody SessaoDto sessaoDto) {
		Sessao sessao = sessaoService.criarSessao(sessaoDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(sessao);
	}
	
}