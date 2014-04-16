package com.proyectofinal;


import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.proyectofinal.bd.Jasper;
import com.proyectofinal.ui.Login;
import com.proyectofinal.ui.mantenimiento.MantenimientoAlquiler;

public class Sistema {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			Login.getInstacia().setVisible(true);
			
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}	
		
		
	}
}
