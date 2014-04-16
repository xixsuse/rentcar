package com.proyectofinal;


import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.proyectofinal.ui.Login;
import com.proyectofinal.ui.mantenimiento.MantenimientoAlquiler;

public class Sistema {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		//new Login().setVisible(true);;
		new MantenimientoAlquiler().setVisible(true);
	}
}
