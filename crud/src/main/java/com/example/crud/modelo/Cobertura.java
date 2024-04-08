package com.example.crud.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "cobertura")
public class Cobertura {

	@Id
	private String id;

	private String descripcion;
	private String riesgo;
	private float porcentajeCobertura;
	private long montoCobertura;
	private float deducible;

	public Cobertura(String descripcion, String riesgo, float porcentajeCobertura, long montoCobertura, float deducible) {
		this.id = UUID.randomUUID().toString();
		this.descripcion = descripcion;
		this.riesgo = riesgo;
		this.porcentajeCobertura = porcentajeCobertura;
		this.montoCobertura = montoCobertura;
		this.deducible = deducible;
	}

	protected Cobertura() {
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getId() {
		return id;
	}

	public String getRiesgo() {
		return riesgo;
	}

	public float getPorcentajeCobertura() {
		return porcentajeCobertura;
	}

	public long getMontoCobertura() {
		return montoCobertura;
	}

	public float getDeducible() {
		return deducible;
	}

	public void setDeducible(float deducible) {
		this.deducible = deducible;
	}

	public void setMontoCobertura(long montoCobertura) {
		this.montoCobertura = montoCobertura;
	}

	public void setPorcentajeCobertura(float porcentajeCobertura) {
		this.porcentajeCobertura = porcentajeCobertura;
	}

	public void setRiesgo(String riesgo) {
		this.riesgo = riesgo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
