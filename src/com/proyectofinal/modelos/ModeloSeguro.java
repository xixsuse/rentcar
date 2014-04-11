package com.proyectofinal.modelos;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.proyectofinal.bd.Conexion;
import com.proyectofinal.entidades.Seguro;

public class ModeloSeguro extends AbstractTableModel{
	
	private static ModeloSeguro instancia;
	String[] encabezados = {"Numero de seguro","Categoria","Precio", "Nombre", "Cobertura"};
	ArrayList<Seguro> arraySeguros = new ArrayList<Seguro>();
	
	public static ModeloSeguro getInstacia(){
		if(instancia == null){
			instancia = new ModeloSeguro();
		}
		return instancia;
	}
	
	public ModeloSeguro(){
		arraySeguros = Conexion.getInstacia().cargarSeguro();
	}
	
	@Override
	public int getColumnCount() {
		return encabezados.length;
	}

	@Override
	public String getColumnName(int x) {
		return encabezados[x];
	}

	@Override
	public int getRowCount() {
		return arraySeguros.size();
	}

	@Override
	public Object getValueAt(int x, int y) {
		String retorno = null;
		Seguro seguro = arraySeguros.get(x);
		
		switch (y) {
		case 0:
			retorno = String.valueOf(seguro.getIdSeguro());
			break;
		case 1:
			retorno = seguro.getCategoria();
			break;
		case 2:
			retorno = String.valueOf(seguro.getPrecio());
			break;
		case 3:
			retorno = seguro.getNombre();
			break;
		case 4:
			retorno = seguro.getCobertura();
			break;
		}
		return retorno;
	}
	
	public void agregarSeguro(Seguro seguro){
		Conexion.getInstacia().agregarSeguro(seguro);
		arraySeguros = Conexion.getInstacia().cargarSeguro();
		fireTableDataChanged();
	}
	
	public void eliminarSeguro(int fila){
		Conexion.getInstacia().eliminarSeguro(arraySeguros.get(fila));
		arraySeguros.remove(fila);
		fireTableRowsDeleted(fila, fila);
	}
	
	public void modificarCategoria(Seguro seguro, int index){		
		Seguro clave = arraySeguros.get(index);
		Conexion.getInstacia().modificarSeguro(clave.getIdSeguro(), seguro);
		arraySeguros = Conexion.getInstacia().cargarSeguro(); 
		fireTableDataChanged();
	}

	public ArrayList<Seguro> getCategorias() {
		return arraySeguros;
	}

	public void setCategorias(ArrayList<Seguro> categorias) {
		this.arraySeguros = categorias;
	}
}
