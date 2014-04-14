package com.proyectofinal.ui;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;

public class VentanaVendedor extends JFrame {

	public VentanaVendedor() {
		setTitle("Ventana Vendedor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 449);
		
		JMenuBar barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);
		
		JMenu mnArchivo = new JMenu("Archivo");
		barraMenu.add(mnArchivo);
		
		JMenuItem mntmCerrarSesion = new JMenuItem("Cerrar sesion");
		mnArchivo.add(mntmCerrarSesion);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);
		getContentPane().setLayout(null);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBounds(10, 11, 143, 368);
		getContentPane().add(panelBotones);
		panelBotones.setLayout(new GridLayout(3, 1, 4, 4));
		
		JButton btnCatalogo = new JButton("Catalogo");
		panelBotones.add(btnCatalogo);
		
		JButton btnAlquilerDeVehiculos = new JButton("Alquiler de vehiculos");
		panelBotones.add(btnAlquilerDeVehiculos);
		
		JButton btnReportes = new JButton("Reportes");
		panelBotones.add(btnReportes);
		
		
	}
}
