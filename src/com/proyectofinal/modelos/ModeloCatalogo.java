package com.proyectofinal.modelos;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import com.proyectofinal.bd.Conexion;
import com.proyectofinal.entidades.Vehiculo;

public class ModeloCatalogo extends AbstractTableModel{
	private String[] encabezados = {"Vehiculos"};
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
	
	public int getIdVehiculo(int index){
		return listaVehiculos.get(index).getIdVehiculo();
	}
	
	public String[] setDatos(int index){
		Vehiculo vehiculo = listaVehiculos.get(index);
		String[] datos = new String[]{String.valueOf(vehiculo.getPrecio()),vehiculo.getTransmision(),
				vehiculo.getMarca(),String.valueOf(vehiculo.getA�o()),String.valueOf(vehiculo.getPasajeros()),
				vehiculo.getDescripcion()};
		return datos;
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
			resultado = new ImageIcon(listaVehiculos.get(fila).getFoto().getScaledInstance(200, 200,java.awt.Image.SCALE_SMOOTH));
			break;
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
