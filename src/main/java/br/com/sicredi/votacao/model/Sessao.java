package br.com.sicredi.votacao.model;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "sessao")
public class Sessao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "id_pauta")
	private Pauta pauta;

	private Timestamp horaInicio;

	private Timestamp horaFim;

	public Sessao() {

	}

	public Sessao(Pauta pauta, Timestamp horaInicio, Timestamp horaFim) {
		this.pauta = pauta;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
	}

	public Sessao(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pauta getPauta() {
		return pauta;
	}

	public void setPauta(Pauta pauta) {
		this.pauta = pauta;
	}

	public Timestamp getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Timestamp horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Timestamp getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(Timestamp horaFim) {
		this.horaFim = horaFim;
	}
}
