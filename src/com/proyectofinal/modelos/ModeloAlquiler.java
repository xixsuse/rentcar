package com.proyectofinal.modelos;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.proyectofinal.bd.Conexion;
import com.proyectofinal.entidades.Alquiler;

public class ModeloAlquiler extends AbstractTableModel{
	private ArrayList<Alquiler> listaAlquileres = new ArrayList<Alquiler>();
	private String[] encabezados = {"idAlquiler,idCliente,idVehiculo,idAccesorio,Desde,Hasta,Total a pagar"};
	private ModeloAlquiler modelo;
	
	private ModeloAlquiler(){
		listaAlquileres = Conexion.getInstacia().cargarAlquileres();
	}
	
	public ModeloAlquiler getInstancia(){
		if(modelo==null){
			modelo = new ModeloAlquiler();
		}
		return modelo;
	}

	public void agregarAlquiler(Alquiler alquiler){
		//Conexion.getInstacia().agregarAlquiler(alguiler);
		listaAlquileres = Conexion.getInstacia().cargarAlquileres();
		fireTableDataChanged();
	}
	
	public void eliminarAlquiler(int index){
		Alquiler alquiler = listaAlquileres.get(index);
		//Conexion.getInstacia().eliminarAlquiler(alquiler.getIdAlquiler());
		listaAlquileres = Conexion.getInstacia().cargarAlquileres();
		fireTableDataChanged();
	}
	
	public void modificarAlquiler(Alquiler alquiler, int index){
		Alquiler alquiler2 = listaAlquileres.get(index);
		//Conexion.getInstacia().modificarAlquiler(alquiler,alquiler2.getIdAlquiler());
		listaAlquileres  = Conexion.getInstacia().cargarAlquileres(); 
		fireTableDataChanged();
	}
	
	@Override
	public int getColumnCount() {
		return encabezados.length;
	}

	
	@Override
	public int getRowCount() {
		return listaAlquileres.size();
	}

	@Override
	public String getColumnName(int index) {
		return encabezados[index];
	}


	@Override
	public Object getValueAt(int fila, int columna) {
		String resultado = null;
		Alquiler alquiler = listaAlquileres.get(fila);
		switch(columna){
		case 0:
			resultado = String.valueOf(alquiler.getIdAlquiler());
			break;
		case 1:
			resultado = String.valueOf(alquiler.getDesde());
			break;
		case 2: 
			resultado = String.valueOf(alquiler.getIdVehiculo());
			break;
		case 3:
			resultado = String.valueOf(alquiler.getIdAccesorio());
			break;
		case 4: 
			resultado = alquiler.getHasta();
			break;
		case 5:
			resultado = alquiler.getDesde();
			break;
		case 6: 
			resultado = String.valueOf(alquiler.getTotalAPagar());
			break;
		}
		return resultado;
	}

	
}
