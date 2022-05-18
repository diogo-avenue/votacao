package br.com.sicredi.votacao.model;

import br.com.sicredi.votacao.enumerators.Voto;

import javax.persistence.*;


@Entity
@Table(name = "votacao")
public class Votacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_sessao")
	private Sessao sessao;

	@ManyToOne
	@JoinColumn(name = "id_associado")
	private Associado associado;

	private Voto voto;

	public Votacao() {
	}

	public Votacao(Sessao sessao, Associado associado, Voto voto) {
		this.sessao = sessao;
		this.associado = associado;
		this.voto = voto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public Associado getAssociado() {
		return associado;
	}

	public void setAssociado(Associado associado) {
		this.associado = associado;
	}

	public Voto getVoto() {
		return voto;
	}

	public void setVoto(Voto voto) {
		this.voto = voto;
	}
}
