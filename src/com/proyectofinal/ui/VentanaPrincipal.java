package com.proyectofinal.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.proyectofinal.ui.mantenimiento.MantenimientoAccesorio;
import com.proyectofinal.ui.mantenimiento.MantenimientoAlquiler;
import com.proyectofinal.ui.mantenimiento.MantenimientoCategoria;
import com.proyectofinal.ui.mantenimiento.MantenimientoClientes;
import com.proyectofinal.ui.mantenimiento.MantenimientoSeguro;
import com.proyectofinal.ui.mantenimiento.MantenimientoUsuarios;
import com.proyectofinal.ui.mantenimiento.MantenimientoVehiculo;

public class VentanaPrincipal extends JFrame implements ActionListener{

	private JButton btnCatalogo;
	private JButton btnMantenimientoAccesorios;
	private JButton btnMantenimientoClientes;
	private JButton btnMantenimientoUsuarios;
	private JButton btnMantenimientoCategoria;
	private JButton btnMantenimientoVehiculo;
	private JButton btnMantenimientoAlquiler;
	private JButton btnMantenimientoSeguro;
	private JMenuBar barraMenu;
	private JMenu mnArchivo;
	private JMenuItem itemCerrarSesion;
	private JMenuItem itemSalir;
	
	public VentanaPrincipal() {
		//setResizable(false);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		setBounds(100, 100, 683, 509);
		getContentPane().setLayout(null);
		
		
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBounds(10, 11, 209, 427);
		getContentPane().add(panelBotones);
		
		panelBotones.setLayout(new GridLayout(8,1,4,4));
		
		btnCatalogo = new JButton("Catalogo");
		panelBotones.add(btnCatalogo);
		btnCatalogo.addActionListener(this);
		
		btnMantenimientoAccesorios = new JButton("Mantenimiento Accesorios");
		panelBotones.add(btnMantenimientoAccesorios);
		btnMantenimientoAccesorios.addActionListener(this);
		
		btnMantenimientoClientes = new JButton("Mantenimiento Clientes");
		panelBotones.add(btnMantenimientoClientes);
		btnMantenimientoClientes.addActionListener(this);
		
		btnMantenimientoUsuarios = new JButton("Mantenimiento Usuarios");
		panelBotones.add(btnMantenimientoUsuarios);
		btnMantenimientoUsuarios.addActionListener(this);
		
		btnMantenimientoCategoria = new JButton("Mantenimiento Categor\u00EDa");
		panelBotones.add(btnMantenimientoCategoria);
		btnMantenimientoCategoria.addActionListener(this);
		
		btnMantenimientoVehiculo = new JButton("Mantenimiento Vehiculo");
		panelBotones.add(btnMantenimientoVehiculo);
		btnMantenimientoVehiculo.addActionListener(this);
		
		btnMantenimientoAlquiler = new JButton("Mantenimiento Alquiler");
		panelBotones.add(btnMantenimientoAlquiler);
		btnMantenimientoAlquiler.addActionListener(this);
		
		btnMantenimientoSeguro = new JButton("Mantenimiento Seguro");
		panelBotones.add(btnMantenimientoSeguro);
		btnMantenimientoSeguro.addActionListener(this);
		
		barraMenu = new JMenuBar();
		setJMenuBar(barraMenu);
		
		
		mnArchivo = new JMenu("Archivo");
		barraMenu.add(mnArchivo);
				
		itemCerrarSesion = new JMenuItem("Cerrar Sesion");
		itemCerrarSesion.addActionListener(this);
		mnArchivo.add(itemCerrarSesion);
		
		itemSalir = new JMenuItem("Salir");
		itemSalir.addActionListener(this);
		mnArchivo.add(itemSalir);
		
		
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnCatalogo){
			new Catalogo().setVisible(true);
		}else if(e.getSource() == btnMantenimientoAccesorios){
			new MantenimientoAccesorio().setVisible(true);
		}else if(e.getSource() == btnMantenimientoClientes){
			MantenimientoClientes.getInstacia().setVisible(true);
		}else if(e.getSource() == btnMantenimientoUsuarios){
			MantenimientoUsuarios.getInstacia().setVisible(true);
		}else if(e.getSource() == btnMantenimientoCategoria){
			MantenimientoCategoria.getInstacia().setVisible(true);
		}else if(e.getSource() == btnMantenimientoVehiculo){
			MantenimientoVehiculo.getInstancia().setVisible(true);;
		}else if(e.getSource() == btnMantenimientoAlquiler){
			new MantenimientoAlquiler().setVisible(true);;
		}else if(e.getSource() == btnMantenimientoSeguro){
			MantenimientoSeguro.getInstancia().setVisible(true);
		}
	}
}
