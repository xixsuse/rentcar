package com.proyectofinal;


import com.proyectofinal.ui.Login;
import com.proyectofinal.ui.VentanaPrincipal;
import com.proyectofinal.ui.mantenimiento.MantenimientoAccesorio;
import com.proyectofinal.ui.mantenimiento.MantenimientoSeguro;
import com.proyectofinal.ui.mantenimiento.MantenimientoUsuarios;
import com.proyectofinal.ui.mantenimiento.MantenimientoVehiculo;

public class Sistema {
	public static void main(String[] args) {
		/*MantenimientoUsuarios mantenimiento = new MantenimientoUsuarios();
		mantenimiento.setLocationRelativeTo(null);
		mantenimiento.setVisible(true);*/
		/*Login login = new Login();
		login.setLocationRelativeTo(null);
		login.setVisible(true);*/
//		VentanaAdministrador admin = new VentanaAdministrador();
//		admin.setLocationRelativeTo(null);
//		admin.setVisible(true);
	/*	MantenimientoClientes m = new MantenimientoClientes();
		m.setLocationRelativeTo(null);
		m.setVisible(true);
		*/
		/*System.out.println("Out");
		new VentanaPrincipal().setVisible(true);*/
		
		//new MantenimientoAccesorio().setVisible(true);
		/*MantenimientoVehiculo v = new MantenimientoVehiculo();
		v.setVisible(true);*/
		
		MantenimientoSeguro s = new MantenimientoSeguro();
		s.setLocationRelativeTo(null);
		s.setVisible(true);
		
	}
}
