package com.proyectofinal.entidades;

public class Categoria {

	private int idCategoria;
	private String nombre;
	private int idVehiculo;
	
	public int getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Categoria(int idCategoria, String nombre,int idVehiculo) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
		this.idVehiculo = idVehiculo;
	}
	
}
