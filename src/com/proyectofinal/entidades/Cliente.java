package com.proyectofinal.entidades;

import java.awt.Image;


public class Cliente {

	private String nombre;
	private String apellido;
	private String telefono;
	private Image documento;
	private int idCliente;
	
	public Cliente(String nombre, String apellido, String telefono,
			Image documento, int idCliente) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.documento = documento;
		this.idCliente = idCliente;
		
	}
	
	public Cliente(String nombre, String apellido, String telefono) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}

	public Cliente() {
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Image getDocumento() {
		return documento;
	}
	public void setDocumento(Image documento) {
		this.documento = documento;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
}
