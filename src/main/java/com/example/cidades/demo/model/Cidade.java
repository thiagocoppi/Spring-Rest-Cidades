package com.example.cidades.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "City")
public class Cidade implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Column(name = "ibge_id")
	private Long idIbge;
	private String estado;
	private String nome;
	private boolean capital;
	private double longitude;
	private double latitude;
	
	@Column(name = "no_accents")
	private String noAccents;

	@Column(name = "alternative_names")	
	private String alternativenames;
	
	private String microregion;
	private String mesoregion;
	
	public long getIdIbge() {
		return idIbge;
	}
	public void setIdIbge(long idIbge) {
		this.idIbge = idIbge;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(Estados estado) {
		this.estado = estado.toString();
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isCapital() {
		return capital;
	}
	public void setCapital(boolean capital) {
		this.capital = capital;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public String getNoAccents() {
		return noAccents;
	}
	public void setNoAccents(String noAccents) {
		this.noAccents = noAccents;
	}
	public String getAlternativenames() {
		return alternativenames;
	}
	public void setAlternativenames(String alternativenames) {
		this.alternativenames = alternativenames;
	}
	public String getMicroregion() {
		return microregion;
	}
	public void setMicroregion(String microregion) {
		this.microregion = microregion;
	}
	public String getMesoregion() {
		return mesoregion;
	}
	public void setMesoregion(String mesoregion) {
		this.mesoregion = mesoregion;
	}

}
