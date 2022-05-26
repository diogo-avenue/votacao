package br.com.sicredi.votacao.dto;

import br.com.sicredi.votacao.model.Pauta;

public class ResultadoDto {

	private int idSessao;

	private Pauta pauta;

	private long quantidadeVotosSim;

	private long quantidadeVotosNao;

	private String resultado;

	public ResultadoDto() {
	}

	public ResultadoDto(int idSessao, Pauta pauta, long quantidadeVotosSim, long quantidadeVotosNao, String resultado) {
		this.idSessao = idSessao;
		this.pauta = pauta;
		this.quantidadeVotosSim = quantidadeVotosSim;
		this.quantidadeVotosNao = quantidadeVotosNao;
		this.resultado = resultado;
	}

	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}

	public long getQuantidadeVotosSim() {
		return quantidadeVotosSim;
	}

	public void setQuantidadeVotosSim(long quantidadeVotosSim) {
		this.quantidadeVotosSim = quantidadeVotosSim;
	}

	public long getQuantidadeVotosNao() {
		return quantidadeVotosNao;
	}

	public void setQuantidadeVotosNao(long quantidadeVotosNao) {
		this.quantidadeVotosNao = quantidadeVotosNao;
	}

	public String getResultado() {
		return resultado;
	}

	public int getIdSessao() {
		return idSessao;
	}

	public void setIdSessao(int idSessao) {
		this.idSessao = idSessao;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "ResultadoDto{" +
				"idSessao=" + idSessao +
				", pauta=" + pauta +
				", quantidadeVotosSim=" + quantidadeVotosSim +
				", quantidadeVotosNao=" + quantidadeVotosNao +
				", resultado='" + resultado + '\'' +
				'}';
	}
}