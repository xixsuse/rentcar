package com.proyectofinal;


import com.proyectofinal.bd.Conexion;
import com.proyectofinal.ui.Login;
import com.proyectofinal.ui.VentanaAdministrador;
import com.proyectofinal.ui.mantenimiento.MantenimientoClientes;
import com.proyectofinal.ui.mantenimiento.MatenimientoAccesorio;
import com.proyectofinal.ui.mantenimiento.MatenimientoUsuarios;

public class Sistema {
	public static void main(String[] args) {
		/*MatenimientoUsuarios mantenimiento = new MatenimientoUsuarios();
		mantenimiento.setLocationRelativeTo(null);
		mantenimiento.setVisible(true);*/
		/*Login login = new Login();
		login.setLocationRelativeTo(null);
		login.setVisible(true);*/
		VentanaAdministrador admin = new VentanaAdministrador();
		admin.setLocationRelativeTo(null);
		admin.setVisible(true);
		
	/*	MantenimientoClientes m = new MantenimientoClientes();
		m.setLocationRelativeTo(null);
		m.setVisible(true);
		*/
	}
}