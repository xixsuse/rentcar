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
	
	@Override
	public int getColumnCount() {
		
		return encabezados.length;
	}

	@Override
	public int getRowCount() {
		return listaVehiculos.size();
	}

	@Override
	public Object getValueAt(int fila, int columna) {
		ImageIcon resultado = null;
		switch(columna){
		case 0:
			resultado = new ImageIcon(listaVehiculos.get(fila).getFoto().getScaledInstance(200, 300,java.awt.Image.SCALE_SMOOTH));
		}
		return resultado;
	}

	@Override
	public Class getColumnClass(int columna) {
		if(columna==0){
			return ImageIcon.class;
		}
		return Object.class;
	}

	
	@Override
	public String getColumnName(int index) {
		return encabezados[index];
	}

	
}
