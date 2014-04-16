package com.proyectofinal.entidades;

public class Alquiler {

	private int idVehiculo;
	private String desde;
	private String hasta;
	private String usuario;
	private int idAlquiler;
	private int totalAPagar;
	private float descuento;
	private int idSeguro;
	private int idAccesorio;
	
	public Alquiler(int idVehiculo, String desde, String hasta, String usuario,
			int idAlquiler, int totalAPagar, float descuento, int idSeguro,
			int idAccesorio) {
		super();
		this.idVehiculo = idVehiculo;
		this.desde = desde;
		this.hasta = hasta;
		this.usuario = usuario;
		this.idAlquiler = idAlquiler;
		this.totalAPagar = totalAPagar;
		this.descuento = descuento;
		this.idSeguro = idSeguro;
		this.idAccesorio = idAccesorio;
	}
	public Alquiler(int idVehiculo, String desde, String hasta, String usuario,
			int totalAPagar, float descuento, int idSeguro,
			int idAccesorio) {
		super();
		this.idVehiculo = idVehiculo;
		this.desde = desde;
		this.hasta = hasta;
		this.usuario = usuario;
		this.totalAPagar = totalAPagar;
		this.descuento = descuento;
		this.idSeguro = idSeguro;
		this.idAccesorio = idAccesorio;
	}
	public int getIdVehiculo() {
		return idVehiculo;
	}
	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	public String getDesde() {
		return desde;
	}
	public void setDesde(String desde) {
		this.desde = desde;
	}
	public String getHasta() {
		return hasta;
	}
	public void setHasta(String hasta) {
		this.hasta = hasta;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public int getIdAlquiler() {
		return idAlquiler;
	}
	public void setIdAlquiler(int idAlquiler) {
		this.idAlquiler = idAlquiler;
	}
	public int getTotalAPagar() {
		return totalAPagar;
	}
	public void setTotalAPagar(int totalAPagar) {
		this.totalAPagar = totalAPagar;
	}
	public float getDescuento() {
		return descuento;
	}
	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}
	public int getIdSeguro() {
		return idSeguro;
	}
	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}
	public int getIdAccesorio() {
		return idAccesorio;
	}
	public void setIdAccesorio(int idAccesorio) {
		this.idAccesorio = idAccesorio;
	}
}
