package com.proyectofinal.entidades;

public class Seguro {
	
	private int idSeguro;
	private String categoria;
	private double precio;
	private String nombre;
	private String cobertura;
	
	public Seguro(){}
	
	
	public Seguro(String categoria, double precio, String nombre,
			String cobertura) {
		super();
		this.categoria = categoria;
		this.precio = precio;
		this.nombre = nombre;
		this.cobertura = cobertura;
	}


	public Seguro(int idSeguro, String categoria, double precio, String nombre,
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
	
	public double getPrecio() {
		return precio;
	}
	
	public void setPrecio(double precio) {
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
