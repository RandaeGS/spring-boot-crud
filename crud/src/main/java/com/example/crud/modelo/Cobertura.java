package com.example.crud.modelo;

public class Cobertura {
	private String id;
	private String descripcion;
	private String riesgo;
	private float porcentajeCobertura;
	private long montoCobertura;
	private float deducible;

	public Cobertura(String descripcion, String riesgo, float porcentajeCobertura, long montoCobertura, float deducible) {
		this.descripcion = descripcion;
		this.riesgo = riesgo;
		this.porcentajeCobertura = porcentajeCobertura;
		this.montoCobertura = montoCobertura;
		this.deducible = deducible;
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
}
