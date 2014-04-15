package com.proyectofinal.modelos;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.proyectofinal.bd.Conexion;
import com.proyectofinal.entidades.Vehiculo;

public class ModeloVehiculos extends AbstractTableModel{
	private ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
	private String[] encabezados = {"Marca","Pasajeros","Año","Matricula","Transmision","Combustible","Precio"};
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
	
	@Override
	public int getColumnCount() {
		return encabezados.length;
	}

	@Override
	public int getRowCount() {
		
		return listaVehiculos.size();
	}

	@Override
	public String getColumnName(int index) {
		return encabezados[index];
	}

	@Override
	public Object getValueAt(int index, int columna) {
		String resultado = null;
		switch(columna){
		case 0: 
			resultado = listaVehiculos.get(index).getMarca();
			break;
		case 1: 
			resultado = String.valueOf(listaVehiculos.get(index).getPasajeros());
			break;
		case 2: 
			resultado = String.valueOf(listaVehiculos.get(index).getAño());
			break;
		case 3: 
			resultado = listaVehiculos.get(index).getMatricula();
			break;
		case 4: 
			resultado = listaVehiculos.get(index).getTransmision();
			break;
		case 5:
			resultado = String.valueOf(listaVehiculos.get(index).getCombustible());
			break;
		case 6: 
			resultado = String.valueOf(listaVehiculos.get(index).getPrecio());
			break;
		}
		return resultado;
	}

}
