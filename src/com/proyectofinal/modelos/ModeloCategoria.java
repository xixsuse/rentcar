package com.proyectofinal.modelos;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.proyectofinal.bd.Conexion;
import com.proyectofinal.entidades.Categoria;

public class ModeloCategoria extends AbstractTableModel{
	
	
	private static ModeloCategoria instancia;
	String[] encabezados = {"Numero de categoria","Categoria"};
	ArrayList<Categoria> categorias = new ArrayList<Categoria>();
	
	public static ModeloCategoria getInstacia(){
		if(instancia == null){
			instancia = new ModeloCategoria();
		}
		return instancia;
	}
	
	public ModeloCategoria(){
		categorias = Conexion.getInstacia().cargarCategoria();
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
		return categorias.size();
	}

	@Override
	public Object getValueAt(int x, int y) {
		String retorno = null;
		Categoria categoria = categorias.get(x);
		
		switch (y) {
		case 0:
			retorno = String.valueOf(categoria.getIdCategoria());
			break;
		case 1:
			retorno = categoria.getNombre();
			break;
		}
		return retorno;
	}
	
	public void agregarCategoria(Categoria categoria){
		Conexion.getInstacia().agregarCategoria(categoria);
		categorias = Conexion.getInstacia().cargarCategoria();
		fireTableDataChanged();
	}
	
	public void eliminarCategoria(int fila){
		Conexion.getInstacia().eliminarCategoria(categorias.get(fila));
		categorias.remove(fila);
		fireTableRowsDeleted(fila, fila);
	}
	
//	public void modificarCategoria(Categoria2 categoria, int index){
//		Categoria clave = categorias.get(index);
//		Conexion.getInstacia().modificarCategoria(clave.getIdCategoria(),categoria);
//		categorias = Conexion.getInstacia().cargarCategoria(); 
//		fireTableDataChanged();
//	}

}