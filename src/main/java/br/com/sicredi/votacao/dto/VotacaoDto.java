package br.com.sicredi.votacao.dto;

import br.com.sicredi.votacao.enumerators.Voto;

public class VotacaoDto {

	private AssociadoDto associado;

	private SessaoDto sessao;

	private Voto voto;

	public VotacaoDto(AssociadoDto associado, SessaoDto sessao, Voto voto) {
		this.associado = associado;
		this.sessao = sessao;
		this.voto = voto;
	}

	public AssociadoDto getAssociado() {
		return associado;
	}

	public void setAssociado(AssociadoDto associado) {
		this.associado = associado;
	}

	public SessaoDto getSessao() {
		return sessao;
	}

	public void setSessao(SessaoDto sessao) {
		this.sessao = sessao;
	}

	public Voto getVoto() {
		return voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}
}