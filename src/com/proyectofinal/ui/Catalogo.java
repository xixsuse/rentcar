package com.proyectofinal.ui;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import com.proyectofinal.modelos.ModeloAutosActivos;
import com.proyectofinal.modelos.ModeloCatalogo;
import com.proyectofinal.ui.mantenimiento.MantenimientoAlquiler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Catalogo extends JFrame{
	private JTable tblCatalogo;
	private JLabel lblPrecio;
	private JTextArea txtDescripcion;
	private JLabel lblMarca;
	private JLabel lblTransmision;
	private JLabel lblPasajeros;
	private JLabel lblAño;
	private boolean vuelta = false;
	public Catalogo(){
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				MantenimientoAlquiler.setIdVehiculo(ModeloCatalogo.getInstancia().
						getIdVehiculo(tblCatalogo.getSelectedRow()));
				
				
			}
		});
		setTitle("Catalogo de vehiculos");
		setSize(339,469);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 319, 408);
		getContentPane().add(scrollPane);
		tblCatalogo = new JTable(ModeloCatalogo.getInstancia());
		tblCatalogo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				if(vuelta == false){
				for(int i=339; i < 756;i++){
					setSize(i,469);
					}
				vuelta = true;
				}
				//setSize(339,469);
				mostrarDatos(tblCatalogo.getSelectedRow());
			}
		});
		tblCatalogo.setRowHeight(200);
		scrollPane.setViewportView(tblCatalogo);
		
		JLabel precio = new JLabel("Precio");
		precio.setBounds(351, 42, 46, 14);
		getContentPane().add(precio);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(339, 273, 61, 14);
		getContentPane().add(lblDescripcion);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(339, 298, 319, 81);
		getContentPane().add(scrollPane_1);
		
		txtDescripcion = new JTextArea();
		scrollPane_1.setViewportView(txtDescripcion);
		
		lblPrecio = new JLabel("klk");
		lblPrecio.setBounds(422, 42, 75, 14);
		getContentPane().add(lblPrecio);
		
		JLabel lblNewLabel_1 = new JLabel("Transmision");
		lblNewLabel_1.setBounds(351, 95, 90, 14);
		getContentPane().add(lblNewLabel_1);
		
		lblTransmision = new JLabel("Transmision");
		lblTransmision.setBounds(481, 95, 75, 14);
		getContentPane().add(lblTransmision);
		
		JLabel Marca = new JLabel("Marca");
		Marca.setBounds(339, 147, 46, 14);
		getContentPane().add(Marca);
		
		JLabel Año = new JLabel("A\u00F1o");
		Año.setBounds(351, 186, 46, 14);
		getContentPane().add(Año);
		
		JLabel Pasajeros = new JLabel("Pasajeros");
		Pasajeros.setBounds(351, 234, 46, 14);
		getContentPane().add(Pasajeros);
		
		lblPasajeros = new JLabel("Pasajeros");
		lblPasajeros.setBounds(422, 234, 46, 14);
		getContentPane().add(lblPasajeros);
		
		lblMarca = new JLabel("New label");
		lblMarca.setBounds(422, 147, 46, 14);
		getContentPane().add(lblMarca);
		
		lblAño = new JLabel("New label");
		lblAño.setBounds(422, 186, 46, 14);
		getContentPane().add(lblAño);
		setVisible(true);
	}
	
	public void mostrarDatos(int index){
		String[] datos = ModeloCatalogo.getInstancia().setDatos(index);
		lblPrecio.setText(datos[0]);
		lblTransmision.setText(datos[1]);
		lblMarca.setText(datos[2]);
		lblAño.setText(datos[3]);
		lblPasajeros.setText(datos[4]);
		txtDescripcion.setText(datos[5]);
		
	}

}
