package com.proyectofinal.modelos;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import com.proyectofinal.bd.Conexion;
import com.proyectofinal.entidades.Cliente;


public class ModeloClientes extends AbstractTableModel {
	
	private static ModeloClientes instancia;
	ArrayList<Cliente> ArrayClientes = new ArrayList<Cliente>();
	String tituloTabla[] = {"Nombre", "Apellido", "Telefono"};
	
	public static ModeloClientes getInstacia(){
		if(instancia == null){
			instancia = new ModeloClientes();
		}
		return instancia;
	}
	
	private ModeloClientes() {
		ArrayClientes = Conexion.getInstacia().cargarCliente();
	}

	@Override
	public int getColumnCount() {

		return tituloTabla.length;
	}
	
	public int getIdCliente(int index){
		return ArrayClientes.get(index).getIdCliente();
	}

	@Override
	public String getColumnName(int x) {
		return tituloTabla[x];
	}

	@Override
	public int getRowCount() {
		return ArrayClientes.size();
	}
	
	public Cliente cargarDatos(int fila){
		Cliente datosCliente = ArrayClientes.get(fila);
		return datosCliente;
	}

	@Override
	public Object getValueAt(int x, int y) {
		String respuesta = null;
		Cliente cliente = ArrayClientes.get(x);
		
		switch (y) {
		case 0:
			respuesta = cliente.getNombre();
			break;
		case 1:
			respuesta = cliente.getApellido();
			break;
		case 2:
			respuesta = cliente.getTelefono();
			break;
		}

		return respuesta;
	}
	
	public void agregarCliente(Cliente cliente,String ruta){
		Conexion.getInstacia().agregarCliente(cliente,ruta);
		ArrayClientes = Conexion.getInstacia().cargarCliente();
		fireTableDataChanged();
		
	}
	
	public boolean eliminarCliente(int fila){
		if(Conexion.getInstacia().eliminarCliente(ArrayClientes.get(fila))){
			ArrayClientes.remove(fila);
			fireTableRowsDeleted(fila, fila);
			return true;
		}else{
			return false;
		}
	}
	
	public void modificarCliente(Cliente cliente, int index,String ruta){
		Cliente clave = ArrayClientes.get(index);
		Conexion.getInstacia().modificarCliente(clave.getIdCliente(),cliente,ruta);
		ArrayClientes = Conexion.getInstacia().cargarCliente(); 
		fireTableDataChanged();
	}


}
