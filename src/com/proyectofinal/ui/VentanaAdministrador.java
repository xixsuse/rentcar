package com.proyectofinal.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

public class VentanaAdministrador extends JFrame implements ActionListener{

	
	public VentanaAdministrador() {
		setTitle("Administraci\u00F3n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JMenuBar barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);
		
		JMenu mnArchivo = new JMenu("Archivo");
		barraMenu.add(mnArchivo);
		
		JMenuItem mntmListaDeUsuarios = new JMenuItem("Lista de usuarios");
		mnArchivo.add(mntmListaDeUsuarios);
		
		JSeparator separator = new JSeparator();
		mnArchivo.add(separator);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);
		
		JMenu mnMantenimiento = new JMenu("Mantenimiento");
		barraMenu.add(mnMantenimiento);
		
		JMenuItem mntmUsuarios = new JMenuItem("Usuarios");
		mntmUsuarios.addActionListener(this);
		mnMantenimiento.add(mntmUsuarios);
		
	}

	
	public void actionPerformed(ActionEvent e) {
		MatenimientoUsuarios matenimientoUsuarios = new MatenimientoUsuarios();
		
		matenimientoUsuarios.setVisible(true);
		
	}
}
