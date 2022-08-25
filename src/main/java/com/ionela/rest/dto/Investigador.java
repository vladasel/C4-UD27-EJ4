package com.ionela.rest.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="investigadores")
public class Investigador {
	@Id
	private String dni;
	@Column
	private String nom_apell;
	
	@ManyToOne
	@JoinColumn(name="facultad")
	private Facultad facultad;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "investigador")
	private List<Reserva> reservas;

	public Investigador(String dni, String nom_apell, Facultad facultad, List<Reserva> reservas) {
		this.dni = dni;
		this.nom_apell = nom_apell;
		this.facultad = facultad;
		this.reservas = reservas;
	}

	public Investigador() {
	}

	public String getDni() {
		return dni;
	}


	public String getNom_apell() {
		return nom_apell;
	}

	public void setNom_apell(String nom_apell) {
		this.nom_apell = nom_apell;
	}

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Reserva")
	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Investigador [dni=" + dni + ", nom_apell=" + nom_apell + ", facultad=" + facultad + ", reservas="
				+ reservas + "]";
	}

	
	
	
}
