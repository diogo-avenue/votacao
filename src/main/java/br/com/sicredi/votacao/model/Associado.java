package br.com.sicredi.votacao.model;

import javax.persistence.*;


@Entity
@Table(name = "associado")
public class Associado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	private String nome;

	public Associado() {

	}


	public Associado(String nome) {
		this.nome = nome;
	}

    public Associado(int id) {
		this.id = id;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
