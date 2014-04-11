package com.proyectofinal.ui.mantenimiento;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame{

	public VentanaPrincipal(){
		setTitle("Ventana principal");
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel pnBotones = new JPanel();
		pnBotones.setBounds(24, 26, 124, 539);
		getContentPane().add(pnBotones);
		pnBotones.setLayout(null);
		
		JButton btnAlquiler = new JButton("Alquiler");
		btnAlquiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MantenimientoAlquiler();
			}
		});
		btnAlquiler.setBounds(25, 26, 67, 23);
		pnBotones.add(btnAlquiler);
		
		JButton btnVehiculos = new JButton("Vehiculos");
		btnVehiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MantenimientoVehiculo();
			}
		});
		btnVehiculos.setBounds(22, 100, 77, 23);
		pnBotones.add(btnVehiculos);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MantenimientoClientes();
			}
		});
		btnClientes.setBounds(25, 151, 89, 23);
		pnBotones.add(btnClientes);
		
		JButton btnHold = new JButton("Hold");
		btnHold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MantenimientoHold();
			}
		});
		btnHold.setBounds(25, 201, 89, 23);
		pnBotones.add(btnHold);
		
		JButton btnSeguro = new JButton("Seguro");
		btnSeguro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MantenimientoSeguro();
			}
		});
		btnSeguro.setBounds(25, 253, 89, 23);
		pnBotones.add(btnSeguro);
		
		JButton btnAccesorio = new JButton("Accesorio");
		btnAccesorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MantenimientoAccesorio();
			}
		});
		btnAccesorio.setBounds(25, 307, 89, 23);
		pnBotones.add(btnAccesorio);
		
		JButton btnCategoria = new JButton("Categoria");
		btnCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MantenimientoCategoria();
			}
		});
		btnCategoria.setBounds(25, 372, 89, 23);
		pnBotones.add(btnCategoria);
		
		JButton btnUsuarios = new JButton("Usuarios");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MantenimientoUsuarios();
			}
		});
		btnUsuarios.setBounds(25, 423, 89, 23);
		pnBotones.add(btnUsuarios);
		setVisible(true);
	}
}
