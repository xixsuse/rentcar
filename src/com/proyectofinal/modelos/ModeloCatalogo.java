package com.proyectofinal.modelos;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import com.proyectofinal.bd.Conexion;
import com.proyectofinal.entidades.Vehiculo;

public class ModeloCatalogo extends AbstractTableModel{
	private String[] encabezados = {"Foto","Otra foto","Foto","Foto"};
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
		ImageIcon resultado = null;
		switch(columna){
		case 0:
			resultado = new ImageIcon(listaVehiculos.get(fila).getFoto().getScaledInstance(200, 300,java.awt.Image.SCALE_SMOOTH));
			break;
		case 1:
			resultado = new ImageIcon(listaVehiculos.get(fila+1).getFoto().getScaledInstance(200, 300,java.awt.Image.SCALE_SMOOTH));
			break;
		case 2: 
			resultado = new ImageIcon(listaVehiculos.get(fila+2).getFoto().getScaledInstance(200, 300,java.awt.Image.SCALE_SMOOTH));
			break;
		case 3:
			resultado = new ImageIcon(listaVehiculos.get(fila+3).getFoto().getScaledInstance(200, 300,java.awt.Image.SCALE_SMOOTH));
			break;
		}
		return resultado;
	}

	public Class getColumnClass(int columna) {
		if(columna==0){
			return ImageIcon.class;
		}
		else if(columna==1){
			return ImageIcon.class;
		}
		else if(columna==2){
			return ImageIcon.class;
		}
		else if(columna==3){
			return ImageIcon.class;
		}
		return Object.class;
	}

	
	public String getColumnName(int index) {
		return encabezados[index];
	}

	
}
