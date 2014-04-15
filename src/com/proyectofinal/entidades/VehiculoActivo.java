package com.proyectofinal.entidades;

public class VehiculoActivo {

	public VehiculoActivo(String marca, String hasta) {
		super();
		this.marca = marca;
		this.hasta = hasta;
	}
	private String marca;
	private String hasta;
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getHasta() {
		return hasta;
	}
	public void setHasta(String hasta) {
		this.hasta = hasta;
	}
}
