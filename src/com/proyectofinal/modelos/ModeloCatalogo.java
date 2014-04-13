package com.proyectofinal.modelos;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import com.proyectofinal.bd.Conexion;
import com.proyectofinal.entidades.Vehiculo;

public class ModeloCatalogo extends AbstractTableModel{
	private String[] encabezados = {"Foto"};
	private ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
	private static ModeloCatalogo modelo;
	
	
	public static ModeloCatalogo getInstancia(){
		if(modelo==null){
			modelo = new ModeloCatalogo();
		}
		return modelo;
	}
	
	private ModeloCatalogo(){
		listaVehiculos = Conexion.getInstacia().cargarVehiculos();
	}
	
	public int getColumnCount() {
		
		return encabezados.length;
	}

	public int getRowCount() {
		return listaVehiculos.size();
	}

	public Object getValueAt(int fila, int columna) {
		Object resultado = null;
		switch(columna){
		case 0:
			resultado = listaVehiculos.get(fila).getFoto();
		}
		return resultado;
	}

	public Class getColumnClass(int columna) {
		if(columna==0){
			return ImageIcon.class;
		}
		return Object.class;
	}

	
	public String getColumnName(int index) {
		return encabezados[index];
	}

	
}
