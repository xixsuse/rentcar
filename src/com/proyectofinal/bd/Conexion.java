package com.proyectofinal.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.proyectofinal.entidades.Usuario;
import com.proyectofinal.ui.VentanaAdministrador;

public class Conexion {

	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	PreparedStatement prst = null;
	ArrayList<Usuario> usuario = new ArrayList<Usuario>();
	
	
	
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
			con = DriverManager.getConnection("jdbc:mysql://localhost/mydb","root","");
			st = con.createStatement();
			
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
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
	
	public ArrayList<Usuario> cargarUsuarios(){
		usuario = new ArrayList<Usuario>();
		try {
			rs = st.executeQuery("SELECT Nombre, Apellido, Usuario, Password, Cargo FROM Usuario");
			//rs = st.executeQuery("SELECT * FROM Usuario");
			while(rs.next()){
				//usuario.add(new Usuario(rs.getString("Nombre"), rs.getString("Apellido"), rs.getString("Usuario"), rs.getString("Password"), rs.getString("Cargo")));
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
				/*prst = con.prepareStatement("INSERT INTO USUARIO (Nombre, Apellido, Usuario, Password, Cargo) VALUES (?,?,?,?,?)");
				prst.setString(1, usuario.getNombre());
				prst.setString(2, usuario.getApellido());
				prst.setString(3, usuario.getUsuario());
				prst.setString(4, usuario.getPassword());
				prst.setString(5, usuario.getCargo());
				prst.execute();*/
				st.execute("INSERT INTO USUARIO (Nombre, apellido, usuario, password, cargo) values ('"+usuario.getNombre()+"','"+usuario.getApellido()+"','"+usuario.getUsuario()+"','"+usuario.getPassword()+"','"+usuario.getCargo()+"')"); 
				
				
			
			}catch (MySQLIntegrityConstraintViolationException e) {
				JOptionPane.showMessageDialog(null, "Nombre de usuario no disponible, intente con otro", "Nombre de usuario en uso", JOptionPane.ERROR_MESSAGE);
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	
	public void eliminarUsuario(Usuario usuario){
		try {
			st.execute("DELETE FROM USUARIO WHERE nombre = '"+usuario.getNombre()+"'");
			
			if(st != null){
				JOptionPane.showMessageDialog(null, "Se ha usuario ha sido eliminado exitosamente","Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void modificarUsuario(Usuario usuario){
		try {
			prst = con.prepareStatement("UPDATE USUARIO SET nombre = '"+usuario.getNombre()+"',apellido = '"+usuario.getApellido()+"',usuario='"+usuario.getUsuario()+"',password='"+usuario.getPassword()+"',cargo = '"+usuario.getCargo()+"' WHERE Usuario = '"+usuario.getUsuario()+"'");
			prst.executeUpdate();
			if(prst != null){
				JOptionPane.showMessageDialog(null, "El usuario ha sido modificado exitosamente","Informacion", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}















