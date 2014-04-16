package com.proyectofinal.entidades;

public class Seguro {
	
	private int idSeguro;
	private String categoria;
	private int precio;
	private String nombre;
	private String cobertura;
	
	public Seguro(){}
	
	
	public Seguro(String categoria, int precio, String nombre,
			String cobertura) {
		super();
		this.categoria = categoria;
		this.precio = precio;
		this.nombre = nombre;
		this.cobertura = cobertura;
	}


	public Seguro(int idSeguro, String categoria, int precio, String nombre,
			String cobertura) {
		super();
		this.idSeguro = idSeguro;
		this.categoria = categoria;
		this.precio = precio;
		this.nombre = nombre;
		this.cobertura = cobertura;
	}

	public int getIdSeguro() {
		return idSeguro;
	}

	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}

	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCobertura() {
		return cobertura;
	}
	
	public void setCobertura(String cobertura) {
		this.cobertura = cobertura;
	}
	
	
}
