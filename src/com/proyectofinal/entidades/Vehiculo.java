package com.proyectofinal.entidades;

import java.awt.Image;

public class Vehiculo {

	private int idVehiculo;
	private int precio;
	private String marca;
	private int pasajeros;
	private int año;
	private String matricula;
	private Image foto;
	private String transmision;
	private String descripcion;
	private int idCategoria;
	private int combustible;

	private boolean estado;
	
	public Vehiculo(int precio, String marca, int pasajeros, int año,
			String matricula, String transmision,
			String descripcion,int combustible, boolean estado) {
		super();
		this.precio = precio;
		this.marca = marca;
		this.pasajeros = pasajeros;
		this.año = año;
		this.matricula = matricula;
		this.transmision = transmision;
		this.descripcion = descripcion;
		this.estado = estado;
		this.combustible = combustible;
	}
	public Vehiculo(int idVehiculo, int precio, String marca, int pasajeros,
			int año, String matricula, Image foto, String transmision,
			String descripcion, int idCategoria,int combustible, boolean estado) {
		super();
		this.idVehiculo = idVehiculo;
		this.precio = precio;
		this.marca = marca;
		this.pasajeros = pasajeros;
		this.año = año;
		this.matricula = matricula;
		this.foto = foto;
		this.transmision = transmision;
		this.descripcion = descripcion;
		this.idCategoria = idCategoria;
		this.combustible = combustible;
		this.estado = estado;
	}
	
	public Vehiculo() {
	}

	public int getCombustible() {
		return combustible;
	}
	public void setCombustible(int combustible) {
		this.combustible = combustible;
	}
	public int getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getPasajeros() {
		return pasajeros;
	}
	public void setPasajeros(int pasajeros) {
		this.pasajeros = pasajeros;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public Image getFoto() {
		return foto;
	}
	public void setFoto(Image foto) {
		this.foto = foto;
	}
	public String getTransmision() {
		return transmision;
	}
	public void setTransmision(String transmision) {
		this.transmision = transmision;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public boolean getEstado(){
		return estado;
	}
}
