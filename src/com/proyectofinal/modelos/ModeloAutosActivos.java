package com.proyectofinal.modelos;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.proyectofinal.bd.Conexion;
import com.proyectofinal.entidades.VehiculoActivo;

public class ModeloAutosActivos extends AbstractTableModel{
	private String[] encabezados = {"Marca","Hasta"};
	private ArrayList<VehiculoActivo> listaVehiculos = new ArrayList<VehiculoActivo>();
	private static ModeloAutosActivos modelo;
	
	private ModeloAutosActivos(){
		listaVehiculos = Conexion.getInstacia().desplegarVehiculosEnUso();
	}
	
	public static ModeloAutosActivos getInstancia(){
		if(modelo==null){
			modelo = new ModeloAutosActivos();
		}
		return modelo;
	}
	
	public int getColumnCount() {
		return encabezados.length;
	}
	
	public void recibirVehiculo(int index){
		Conexion.getInstacia().recibirVehiculo(listaVehiculos.get(index).getIdVehiculo());
		listaVehiculos = Conexion.getInstacia().desplegarVehiculosEnUso();
		fireTableDataChanged();
	}

	public int getRowCount() {
		return listaVehiculos.size();
	}

	public String getColumnName(int index) {
		return encabezados[index];
	}

	public Object getValueAt(int fila, int columna) {
		String resultado = null; 
		switch(columna){
		case 0:
			resultado = listaVehiculos.get(fila).getMarca();
			break;
		case 1:
			resultado = listaVehiculos.get(fila).getHasta();
			break;
		}
		return resultado;
	}

}
