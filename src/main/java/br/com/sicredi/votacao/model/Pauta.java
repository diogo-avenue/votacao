package br.com.sicredi.votacao.model;

import javax.persistence.*;


@Entity
@Table(name = "pauta")
public class Pauta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	private String titulo;

	private String descricao;

	public Pauta() {

	}

	public Pauta(String titulo, String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
	}

    public Pauta(int id) {
		this.id = id;
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Pauta{" +
				"id=" + id +
				", titulo='" + titulo + '\'' +
				", descricao='" + descricao + '\'' +
				'}';
	}
}
