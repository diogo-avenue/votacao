package br.com.sicredi.votacao.controller;

import br.com.sicredi.votacao.dto.ResultadoDto;
import br.com.sicredi.votacao.dto.VotacaoDto;
import br.com.sicredi.votacao.model.Votacao;
import br.com.sicredi.votacao.service.VotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = {"votacao"}, produces = APPLICATION_JSON_VALUE)
public class VotacaoController {

	@Autowired
	private VotacaoService votacaoService;

	@PostMapping( consumes = APPLICATION_JSON_VALUE)
	public ResponseEntity<Votacao> votar(@RequestBody VotacaoDto votacaoDto) {
		Votacao votacao = votacaoService.votar(votacaoDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(votacao);
	}
	
	@GetMapping(path = "/resultado/{idPauta}")
	public ResponseEntity<ResultadoDto> obterResultado(@PathVariable(value = "idPauta") int idPauta) {
			ResultadoDto resultadoDto = votacaoService.obterResultado(idPauta);
			return ResponseEntity.status(HttpStatus.OK).body(resultadoDto);
	}
	
}