package com.proyectofinal.entidades;

public class VehiculoActivo {

	private int idVehiculo;
	private String marca;
	private String hasta;
	
	public VehiculoActivo(int idVehiculo,String marca, String hasta) {
		super();
		this.setIdVehiculo(idVehiculo);
		this.marca = marca;
		this.hasta = hasta;
	}
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
	public int getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
}
