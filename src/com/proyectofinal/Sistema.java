package com.proyectofinal;


import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.proyectofinal.ui.mantenimiento.MantenimientoCategoria;
import com.proyectofinal.ui.mantenimiento.MantenimientoClientes;
import com.proyectofinal.ui.mantenimiento.MantenimientoSeguro;
import com.proyectofinal.ui.mantenimiento.MantenimientoUsuarios;
import com.proyectofinal.ui.mantenimiento.MantenimientoVehiculo;

public class Sistema {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		/*MantenimientoUsuarios mantenimiento = new MantenimientoUsuarios();
		mantenimiento.setLocationRelativeTo(null);
		mantenimiento.setVisible(true);*/
		/*Login login = new Login();
		login.setLocationRelativeTo(null);
		login.setVisible(true);*/
//		VentanaAdministrador admin = new VentanaAdministrador();
//		admin.setLocationRelativeTo(null);
//		admin.setVisible(true);
		/*MantenimientoClientes m = new MantenimientoClientes();
		m.setLocationRelativeTo(null);
		m.setVisible(true);*/
		
		/*System.out.println("Out");
		new VentanaPrincipal().setVisible(true);*/
		
		//new MantenimientoAccesorio().setVisible(true);
		/*MantenimientoVehiculo v = new MantenimientoVehiculo();
		v.setVisible(true);*/
	
//		MantenimientoVehiculo v = new MantenimientoVehiculo();
//		v.setVisible(true);
		
		//MantenimientoUsuarios.getInstacia().setVisible(true);
		//MantenimientoSeguro.getInstancia().setVisible(true);
		//MantenimientoClientes.getInstacia().setVisible(true);
	//	MantenimientoCategoria.getInstacia().setVisible(true);
		//MantenimientoVehiculo.getInstancia().setVisible(true);
		/*Catalogo c = new Catalogo();
		c.setVisible(true);*/
	}
}
