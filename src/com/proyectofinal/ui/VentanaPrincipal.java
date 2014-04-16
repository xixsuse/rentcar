package com.proyectofinal.ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.proyectofinal.ui.mantenimiento.MantenimientoAccesorio;
import com.proyectofinal.ui.mantenimiento.MantenimientoAlquiler;
import com.proyectofinal.ui.mantenimiento.MantenimientoCategoria;
import com.proyectofinal.ui.mantenimiento.MantenimientoClientes;
import com.proyectofinal.ui.mantenimiento.MantenimientoSeguro;
import com.proyectofinal.ui.mantenimiento.MantenimientoUsuarios;
import com.proyectofinal.ui.mantenimiento.MantenimientoVehiculo;
import javax.swing.JLabel;
import java.awt.Font;

public class VentanaPrincipal extends JFrame implements ActionListener{
	private JMenuBar barraMenu;
	private JMenu mnArchivo;
	private JMenuItem itemCerrarSesion;
	private JMenuItem itemSalir;
	private static String Usuario = "";
	private static int idCliente;
	private JLabel lblBienvenidoAlSistema;
	private JButton btnClientes;
	private JButton btnAlquiler;
	private JButton btnAccesorios;
	private JButton btnSeguro;
	private JButton btnVehiculo;
	private JButton btnUsuarios;
	private JButton btnCategoria;
	private JButton btnReporte;

	public VentanaPrincipal(String Usuario){
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VentanaPrincipal.Usuario = Usuario;
		VentanaPrincipal.idCliente = idCliente;
		setBounds(100, 100, 683, 509);
		getContentPane().setLayout(null);
		
		lblBienvenidoAlSistema = new JLabel("Bienvenido al sistema");
		lblBienvenidoAlSistema.setFont(new Font("Tahoma", Font.PLAIN, 58));
		lblBienvenidoAlSistema.setBounds(50, 11, 565, 100);
		getContentPane().add(lblBienvenidoAlSistema);
		
		btnClientes = new JButton("Clientes");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MantenimientoClientes.getInstacia().setVisible(true);
			}
		});
		btnClientes.setBounds(50, 122, 94, 59);
		getContentPane().add(btnClientes);
		
		btnAlquiler = new JButton("Alquiler");
		btnAlquiler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MantenimientoAlquiler.getInstancia().setVisible(true);
			}
		});
		btnAlquiler.setBounds(50, 202, 94, 59);
		getContentPane().add(btnAlquiler);
		
		btnAccesorios = new JButton("Accesorios");
		btnAccesorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MantenimientoAccesorio.getInstacia().setVisible(true);
			}
		});
		btnAccesorios.setBounds(50, 273, 94, 59);
		getContentPane().add(btnAccesorios);
		
		btnSeguro = new JButton("Seguro");
		btnSeguro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MantenimientoSeguro.getInstancia().setVisible(true);
			}
		});
		btnSeguro.setBounds(50, 343, 94, 59);
		getContentPane().add(btnSeguro);
		
		btnVehiculo = new JButton("Vehiculo");
		btnVehiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MantenimientoVehiculo.getInstancia().setVisible(true);
			}
		});
		btnVehiculo.setBounds(507, 122, 94, 59);
		getContentPane().add(btnVehiculo);
		
		btnUsuarios = new JButton("Usuarios");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MantenimientoUsuarios.getInstacia().setVisible(true);
			}
		});
		btnUsuarios.setBounds(507, 202, 94, 59);
		getContentPane().add(btnUsuarios);
		
		btnCategoria = new JButton("Categoria");
		btnCategoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MantenimientoCategoria.getInstacia().setVisible(true);
			}
		});
		btnCategoria.setBounds(507, 273, 94, 59);
		getContentPane().add(btnCategoria);
		
		btnReporte = new JButton("Reporte");
		btnReporte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReporteVehiculo.getInstancia().setVisible(true);
			}
		});
		btnReporte.setBounds(507, 343, 94, 59);
		getContentPane().add(btnReporte);
		
		
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
	
	

	public void actionPerformed(ActionEvent e) {
	}
	
	public static String getUsuario(){
		return Usuario;
	}

	
	public void setUsuario(String Usuario){
		this.Usuario = Usuario;
	}
	
	public static int getIdCliente(){
		return idCliente;
	}
	
	public void setIdUsuario(int idCliente){
		this.idCliente = idCliente;
	}
	
}
