package com.proyectofinal.modelos;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.proyectofinal.bd.Conexion;
import com.proyectofinal.entidades.Vehiculo;

public class ModeloVehiculos extends AbstractTableModel{
	private ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
	private String[] encabezados = {"ID","Precio","Marca","Pasajeros","Año","Matricula","Transmision","Combustible"};
	private static ModeloVehiculos modelo = null;
	
	private ModeloVehiculos(){
		listaVehiculos = Conexion.getInstacia().cargarVehiculos();
	}
	
	public static ModeloVehiculos getInstancia(){
		if(modelo==null){
			modelo = new ModeloVehiculos();
		}
		return modelo;
	} 
	
	public void agregarVehiculo(Vehiculo vehiculo, String ruta){
		Conexion.getInstacia().guardarVehiculo(vehiculo, ruta);
		listaVehiculos = Conexion.getInstacia().cargarVehiculos();
		fireTableDataChanged();
	}
	
	public void eliminarVehiculo(int index){
		Vehiculo vehiculo = listaVehiculos.get(index);
		Conexion.getInstacia().eliminarVehiculo(vehiculo.getIdVehiculo());
		listaVehiculos = Conexion.getInstacia().cargarVehiculos();
		fireTableDataChanged();
	}
	
	public void modificarVehiculo(Vehiculo movil,String ruta,int index){
		Vehiculo vehiculo2 = listaVehiculos.get(index);
		Conexion.getInstacia().modificarVehiculo(vehiculo2.getIdVehiculo(), movil, ruta);
		listaVehiculos = Conexion.getInstacia().cargarVehiculos();
		fireTableDataChanged();	
	}
	
	public Vehiculo cargarDatos(int index){
		Vehiculo datosVehiculo = listaVehiculos.get(index);
		return datosVehiculo;
	}
	
	public int getColumnCount() {
		return encabezados.length;
	}

	public int getRowCount() {
		
		return listaVehiculos.size();
	}

	public String getColumnName(int index) {
		return encabezados[index];
	}

	public Object getValueAt(int index, int columna) {
		String resultado = null;
		switch(columna){
		case 0:
			resultado = String.valueOf(listaVehiculos.get(index).getIdVehiculo());
			break;
		case 1: 
			resultado = String.valueOf(listaVehiculos.get(index).getPrecio());
			break;
		case 2: 
			resultado = listaVehiculos.get(index).getMarca();
			break;
		case 3: 
			resultado = String.valueOf(listaVehiculos.get(index).getPasajeros());
			break;
		case 4: 
			resultado = String.valueOf(listaVehiculos.get(index).getAño());
			break;
		case 5: 
			resultado = listaVehiculos.get(index).getMatricula();
			break;
		case 6: 
			resultado = listaVehiculos.get(index).getTransmision();
			break;
		case 7:
			resultado = String.valueOf(listaVehiculos.get(index).getCombustible());
			break;
		}
		return resultado;
	}

}
