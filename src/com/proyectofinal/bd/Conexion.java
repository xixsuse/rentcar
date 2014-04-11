package com.proyectofinal.bd;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.proyectofinal.entidades.Accesorio;
import com.proyectofinal.entidades.Alquiler;
import com.proyectofinal.entidades.Categoria;
import com.proyectofinal.entidades.Cliente;
import com.proyectofinal.entidades.Usuario;
import com.proyectofinal.entidades.Vehiculo;
//github.com/DannyFeliz/rentcar.git
import com.proyectofinal.ui.VentanaAdministrador;

public class Conexion {

	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement prst = null;
	ArrayList<Usuario> usuario = new ArrayList<Usuario>();
	ArrayList<Cliente> cliente = new ArrayList<Cliente>();
	ArrayList<Accesorio> accesorio = new ArrayList<Accesorio>();
	ArrayList<Categoria> categoria = new ArrayList<Categoria>();
	
	private static Conexion instancia;
	
	public static Conexion getInstacia(){
		if(instancia == null){
			instancia = new Conexion();
		}
		return instancia;
	}
	
	public Conexion(){
	
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","123");
			st = con.createStatement();
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	//Login/////////////////////////////////////////////////////////////////////////////////////////////////
	public void validarUsuario(String usuario, String password){
		try {
			
			rs = st.executeQuery("SELECT usuario, password, cargo FROM usuario WHERE usuario = '"+ usuario 
					+ "' AND password = '" + password	+ "' AND cargo IN ('Administrador','Vendedor')");

			if (rs.next()) {

				if (rs.getString("Cargo").equals("Administrador")) {
					
					VentanaAdministrador ventanaAdminsitrador = new VentanaAdministrador();
					ventanaAdminsitrador.setLocationRelativeTo(null);
					ventanaAdminsitrador.setVisible(true);
					
				} else if (rs.getString("Cargo").equals("Vendedor")) {
					System.out.println("Bienvenido vendedor");
						
				}
				
			} else {
				
				JOptionPane.showMessageDialog(null, "Usuario y/o contraseña es incorrecto.","Error", JOptionPane.ERROR_MESSAGE);	
			}

		} catch (SQLException e) {

			e.printStackTrace();
			
		}
	}
	
	//FINN Login/////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/// INICIO USUARIO /////////////////////////////////////////////////////////////////////////////////////////////////
	public ArrayList<Usuario> cargarUsuarios(){
		usuario = new ArrayList<Usuario>();
		try {
			rs = st.executeQuery("SELECT Nombre, Apellido, Usuario, Password, Cargo FROM Usuario");
			
			while(rs.next()){
				usuario.add(new Usuario(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
			}
			
		} catch (SQLException e) {
			System.out.println("Error:"+e.getMessage());
			e.printStackTrace();
		}
		return usuario;
	}
	
	public void agregarUsuario(Usuario usuario){
			try {
				prst = con.prepareStatement("INSERT INTO USUARIO (Nombre, Apellido, Usuario, Password, Cargo) VALUES (?,?,?,?,?)");
				prst.setString(1, usuario.getNombre());
				prst.setString(2, usuario.getApellido());
				prst.setString(3, usuario.getUsuario());
				prst.setString(4, usuario.getPassword());
				prst.setString(5, usuario.getCargo());
				prst.execute();
				
				if(st != null){
					JOptionPane.showMessageDialog(null, "El usuario ha sido agregado correctamente.", "Usuario agregado.", JOptionPane.INFORMATION_MESSAGE);
				}
				
			
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	
	public void eliminarUsuario(Usuario usuario){
		try {
			prst = con.prepareStatement("DELETE FROM USUARIO WHERE nombre = ?");
			prst.setString(1, usuario.getNombre());
			prst.execute();
			
			if(st != null){
				JOptionPane.showMessageDialog(null, "Se ha usuario ha sido eliminado exitosamente","Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public void modificarUsuario(String clave,Usuario usuario){
		try {
			prst = con.prepareStatement("UPDATE USUARIO SET NOMBRE = ?, apellido =? , usuario= ?, password = ?, cargo = ? WHERE usuario = ?");
			prst.setString(1, usuario.getNombre());
			prst.setString(2, usuario.getApellido());
			prst.setString(3, usuario.getUsuario());
			prst.setString(4, usuario.getPassword());
			prst.setString(5, usuario.getCargo());
			prst.setString(6, clave);
			prst.executeUpdate();
			
			if(prst != null){
				JOptionPane.showMessageDialog(null, "El Usuario ha sido modificado exitosamente.", "Modificación del contacto", JOptionPane.INFORMATION_MESSAGE);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/// FIN USUARIO /////////////////////////////////////////////////////////////////////////////////////////////////

	/// INICIO CLIENTE /////////////////////////////////////////////////////////////////////////////////////////////////
	
	public ArrayList<Cliente> cargarCliente(){
		cliente = new ArrayList<Cliente>();
		try {
			rs = st.executeQuery("SELECT nombre, apellido, telefono, documento, idCliente FROM cliente");
			while(rs.next()){
				cliente.add(new Cliente(rs.getString("nombre"), rs.getString("apellido"), rs.getString("telefono"), rs.getString("documento"), rs.getString("idCliente")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cliente;
	}
	
	public void agregarCliente(Cliente cliente){
		
		
		try {
			System.out.println(cliente.getDocumento());
			File imagen = new File(cliente.getDocumento());
			FileInputStream  foto = new FileInputStream(imagen);
			
			prst = con.prepareStatement("INSERT INTO CLIENTE VALUES (?,?,?,?,?)");
			prst.setString(1, cliente.getNombre());
			prst.setString(2, cliente.getApellido());
			prst.setString(3, cliente.getTelefono());
			prst.setBinaryStream(4, foto, (int) imagen.length());
			prst.setString(5, cliente.getIdCliente());
			prst.execute();
			
			if(prst != null){
				JOptionPane.showMessageDialog(null, "El Cliente ha sido agregado correctamente", "Cliente agregado", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}	
	
	public void eliminarCliente(Cliente cliente){
		try {
			prst = con.prepareStatement("DELETE FROM CLIENTE WHERE idCliente = ?");
			prst.setString(1, cliente.getIdCliente());
			prst.execute();
			if(st != null){
				JOptionPane.showMessageDialog(null, "Se ha Cliente ha sido eliminado exitosamente","Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void modificarCliente(String id, Cliente cliente) {
		try {
			File imagen = new File(cliente.getDocumento());
			FileInputStream  foto = new FileInputStream(imagen);
			
			prst = con.prepareStatement("UPDATE CLIENTE SET nombre = ?, apellido = ?, telefono = ?, documento = ? WHERE idCliente = ?");
			prst.setString(1, cliente.getNombre());
			prst.setString(2, cliente.getApellido());
			prst.setString(3, cliente.getTelefono());
			prst.setBinaryStream(4, foto, (int) imagen.length());
			prst.setString(5, id);
			prst.execute();
			if(prst != null){
				JOptionPane.showMessageDialog(null, "El Cliente ha sido modificado exitosamente.", "Modificación del contacto", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException | FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//// FIN CLIENTEEEEEEEEEEE///////////////////////////////////
	
	/*public ArrayList<Cliente> buscarCliente(String nombre){
		//SELECT * FROM travel WHERE name like '%%%1s%%'", nombre));
		cliente = new ArrayList<Cliente>();
		try {
			rs = st.executeQuery("SELECT nombre, apellido, telefono, documento, idCliente FROM cliente WHERE nombre like '"+nombre+"'");
			while(rs.next()){
				cliente.add(new Cliente(rs.getString("nombre"), rs.getString("apellido"), rs.getString("telefono"), rs.getString("documento"), rs.getString("idCliente")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cliente;
		
	}*/
	///INICIO ACCESORIO
	
	public ArrayList<Accesorio> cargarAcccesorios(){
		accesorio = new ArrayList<Accesorio>();
		try {
			rs = st.executeQuery("SELECT idAccesorio, Nombre, Serial, Descripcion, Precio FROM accesorio");
			while(rs.next()){
				accesorio.add(new Accesorio(rs.getInt("idAccesorio"), rs.getString("nombre"), rs.getString("serial"), rs.getString("descripcion"), rs.getInt("precio")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return accesorio;
	}
	
	
	public void agregarAccesorio(Accesorio accesorio){
		try {
			
			prst = con.prepareStatement("INSERT INTO Accesorio(nombre,Serial,Descripcion,Precio) VALUES (?,?,?,?)");
			prst.setString(1, accesorio.getNombre());
			prst.setString(2, accesorio.getSerial());
			prst.setString(3, accesorio.getDescripcion());
			prst.setInt(4, accesorio.getPrecio());
			prst.execute();
			
			if(prst != null){
				JOptionPane.showMessageDialog(null, "El Accesorio ha sido agregado correctamente", "Accesorio agregado", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void eliminarAccesorio(Accesorio accesorio){
		try {
			prst = con.prepareStatement("DELETE FROM ACCESORIO WHERE idAccesorio = ?");
			prst.setInt(1, accesorio.getIdAccesorio());
			prst.execute();
			
			if(prst != null){
				JOptionPane.showMessageDialog(null, "Se ha eliminado el accesorio correctamente", "Accesorio eliminado", JOptionPane.INFORMATION_MESSAGE);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void modificarAccesorio(int id, Accesorio accesorio){
		try {
			prst = con.prepareStatement("UPDATE ACCESORIO SET Nombre = ?, Serial = ?, Descripcion = ? , precio = ? WHERE idAccesorio = ?");
			
			prst.setString(1, accesorio.getNombre());
			prst.setString(2, accesorio.getSerial());
			prst.setString(3, accesorio.getDescripcion());
			prst.setInt(4, accesorio.getPrecio());
			prst.setInt(5, id);
			prst.executeUpdate();
			
			if(prst != null){
				JOptionPane.showMessageDialog(null, "El Accesorio ha sido modificado correctamente", "Accesorio modificado", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Alquiler> cargarAlquileres(){
		ArrayList<Alquiler> listaAlquileres = null;
		try{
			rs = st.executeQuery("SELECT * FROM alquiler");
			listaAlquileres = new ArrayList<Alquiler>();
			while(rs.next()){
				listaAlquileres.add(new Alquiler(rs.getInt("idVehiculo"),rs.getString("Desde"),rs.getString("Hasta"),
						rs.getInt("idCliente"),rs.getInt("idAlquiler"),rs.getDouble("TotalAPagar"),rs.getFloat("descuento"),
						rs.getInt("idSeguro"),rs.getInt("idAccesorio")));
			}
		}
		catch(SQLException sql){
			sql.printStackTrace();
		}
		return listaAlquileres;
	}
	
	public void guardarVehiculo(Vehiculo vehiculo,String ruta){
		FileInputStream flujo = null;
		
		try {
			prst = con.prepareStatement("INSERT INTO vehiculo(idVehiculo,precio,marca,pasajeros,año,matricula,foto,transmision," +
					"descripcion,cantCombustible,estado)" +	" VALUES(?,?,?,?,?,?,?,?,?,?,?)");
			File archivo = new File(ruta);
			flujo = new FileInputStream(archivo);
			prst.setInt(1, vehiculo.getIdVehiculo());
			prst.setInt(2, vehiculo.getPrecio());
			prst.setString(3, vehiculo.getMarca());
			prst.setInt(4, vehiculo.getPasajeros());
			prst.setInt(5, vehiculo.getAño());
			prst.setString(6,vehiculo.getMatricula());
			prst.setBinaryStream(7, flujo,(int)archivo.length());
			prst.setString(8, vehiculo.getTransmision());
			prst.setString(9, vehiculo.getDescripcion());
			prst.setInt(10, vehiculo.getCombustible());
			prst.setBoolean(11, vehiculo.getEstado());
			prst.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void eliminarVehiculo(int id){
		try{
			prst = con.prepareStatement("DELETE FROM vehiculo WHERE idVehiculo = ?");
			prst.setInt(1,id);
			prst.execute();
					
		}catch(SQLException sql){
			sql.printStackTrace();
		}
	}
	
	public ArrayList<Vehiculo> cargarVehiculos(){
		ArrayList<Vehiculo> listaVehiculos = null;
		try{
			rs = st.executeQuery("SELECT * FROM vehiculo");
			listaVehiculos = new ArrayList<Vehiculo>();
			while(rs.next()){
				Vehiculo vehiculo = new Vehiculo();
				vehiculo.setIdVehiculo(rs.getInt("idVehiculo"));
				vehiculo.setPrecio(rs.getInt("precio"));
				vehiculo.setMarca(rs.getString("marca"));
				vehiculo.setPasajeros(rs.getInt("pasajeros"));
				vehiculo.setAño(rs.getInt("año"));
				vehiculo.setMatricula(rs.getString("matricula"));
				Blob blob = rs.getBlob("Foto");
				byte[] data = blob.getBytes(1, (int)blob.length());
				BufferedImage imagen = null;
				try{
					imagen = ImageIO.read(new ByteArrayInputStream(data));
				}
				catch(IOException ex){
					ex.printStackTrace();
				}
				vehiculo.setFoto(imagen);
				vehiculo.setTransmision(rs.getString("transmision"));
				vehiculo.setDescripcion(rs.getString("descripcion"));
				vehiculo.setIdCategoria(rs.getInt("idCategoria"));
				vehiculo.setCombustible(rs.getInt("cantCombustible"));
				vehiculo.setEstado(rs.getBoolean("estado"));
				listaVehiculos.add(vehiculo);
			}
		}catch(SQLException sql){
			sql.printStackTrace();
		}
		return listaVehiculos;
	}
	
	public void modificarVehiculo(int id,Vehiculo movil,String ubicacion){
		FileInputStream stream = null;
		if(!ubicacion.equals("")){
			try{
				prst = con.prepareStatement("UPDATE vehiculo set idVehiculo=?, precio=?, marca=?, pasajeros=?,año =?," +
						"matricula=?,foto=?,transmision=?,descripcion=?,cantCombustible=?,estado=? WHERE idVehiculo=? ");
				File archivo = new File(ubicacion);
				stream = new FileInputStream(archivo);
				prst.setInt(1, movil.getIdVehiculo());
				prst.setInt(2, movil.getPrecio());
				prst.setString(3, movil.getMarca());
				prst.setInt(4, movil.getPasajeros());
				prst.setInt(5, movil.getAño());
				prst.setString(6, movil.getMatricula());
				prst.setBinaryStream(7, stream,(int)archivo.length());
				prst.setString(8, movil.getTransmision());
				prst.setString(9, movil.getDescripcion());
				//prst.setInt(10, vehiculo.getIdCategoria());
				prst.setInt(10, movil.getCombustible());
				prst.setBoolean(11, movil.getEstado());
				prst.setInt(12, id);
				prst.executeUpdate();
			}
			catch(SQLException s){
				s.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			try{
				prst = con.prepareStatement("UPDATE vehiculo set idVehiculo=?, precio=?, marca=?, pasajeros=?,año =?," +
						"matricula=?,transmision=?,descripcion=?,cantCombustible=?,estado=? WHERE idVehiculo=? ");
				prst.setInt(1, movil.getIdVehiculo());
				prst.setInt(2, movil.getPrecio());
				prst.setString(3, movil.getMarca());
				prst.setInt(4, movil.getPasajeros());
				prst.setInt(5, movil.getAño());
				prst.setString(6, movil.getMatricula());
				prst.setString(7, movil.getTransmision());
				prst.setString(8, movil.getDescripcion());
				//prst.setInt(10, vehiculo.getIdCategoria());
				prst.setInt(9, movil.getCombustible());
				prst.setBoolean(10, movil.getEstado());
				prst.setInt(11, id);
				prst.execute();
			}
			catch(SQLException s){
				s.printStackTrace();
			}
		}
	}
	public ArrayList<Categoria> obtenerCategorias(){
		ArrayList<Categoria> listaCategorias = null;
		try{
			rs = st.executeQuery("SELECT * FROM categoria");
			listaCategorias = new ArrayList<Categoria>();
			while(rs.next()){
				listaCategorias.add(new Categoria(rs.getInt("idCategoria"),rs.getString("nombre")));
			}
		}catch(SQLException sql){
			sql.printStackTrace();
		}
		return listaCategorias;
	}
	
	///////Fin Accesorio
	
	///////Comienzo de categoria
	
	public ArrayList<Categoria> cargarCategoria(){
		categoria = new ArrayList<Categoria>();
		try {
			rs = st.executeQuery("SELECT idCategoria, Nombre FROM categoria");
			while(rs.next()){
				categoria.add(new Categoria(rs.getInt("idCategoria"), rs.getString("nombre")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoria;
	}
	
	public void agregarCategoria(Categoria categoria){
		try {
			prst = con.prepareStatement("INSERT INTO categoria(nombre) VALUES (?)");
			prst.setString(1, categoria.getNombre());
			prst.execute();
			if(prst != null){
				JOptionPane.showMessageDialog(null, "Se ha agregado una nueva categoria", "Categoria agregada...", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (MySQLIntegrityConstraintViolationException mye){
			JOptionPane.showMessageDialog(null, "La categoria ya existe, no puede ser agregada", "Error..", JOptionPane.ERROR_MESSAGE);
		}catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public void eliminarCategoria(Categoria categoria){
		try {
			prst = con.prepareStatement("DELETE FROM categoria WHERE idCategoria = ?");
			prst.setInt(1, categoria.getIdCategoria());
			prst.execute();
			if(prst != null){
				JOptionPane.showMessageDialog(null, "Se elimino categoria", "Categoria eliminada...", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void modificarCategoria(int id, Categoria categoria){
		try {
			prst = con.prepareStatement("UPDATE categoria SET Nombre = ? WHERE idCategoria = ?");
			prst.setString(1, categoria.getNombre());
			prst.setInt(2, id);		
			prst.executeUpdate();
			if(prst != null){
				JOptionPane.showMessageDialog(null, "El Accesorio ha sido modificado correctamente", "Accesorio modificado", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
















