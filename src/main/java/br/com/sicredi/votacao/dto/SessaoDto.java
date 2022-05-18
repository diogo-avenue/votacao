package br.com.sicredi.votacao.dto;

public class SessaoDto {

	private int id;

	private PautaDto pauta;

	private int duracao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PautaDto getPauta() {
		return pauta;
	}

	public void setPauta(PautaDto pauta) {
		this.pauta = pauta;
	}

	public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
}