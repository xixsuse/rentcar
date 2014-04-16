package com.proyectofinal.ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
				int seleccion = 0;
				seleccion = JOptionPane.showConfirmDialog(null, "Seguro que desea salir?", "Advertencia", JOptionPane.YES_NO_OPTION);
				if(seleccion == JOptionPane.OK_OPTION){
					MantenimientoAlquiler.setIdVehiculo(ModeloCatalogo.getInstancia().
					getIdVehiculo(tblCatalogo.getSelectedRow()));
						Catalogo.this.dispose();
				}
				
			}
		});
		setTitle("Catalogo de vehiculos");
		setSize(352,469);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 319, 408);
		getContentPane().add(scrollPane);
		tblCatalogo = new JTable(ModeloCatalogo.getInstancia());
		tblCatalogo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
					int contador = 0;
					boolean vuelta = true;
					Thread hilo = new Thread();
					while(vuelta == true){
						contador++;
						try {
							hilo.sleep(00001);
							for(int i=339; i < 756;i++){
								setSize(i,469);
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						vuelta = false;
					}
				mostrarDatos(tblCatalogo.getSelectedRow());
			}
		});
		tblCatalogo.setRowHeight(200);
		scrollPane.setViewportView(tblCatalogo);
		
		JLabel precio = new JLabel("Precio:");
		precio.setBounds(339, 18, 46, 14);
		getContentPane().add(precio);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(339, 148, 61, 14);
		getContentPane().add(lblDescripcion);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(339, 173, 319, 81);
		getContentPane().add(scrollPane_1);
		
		txtDescripcion = new JTextArea();
		txtDescripcion.setEditable(false);
		scrollPane_1.setViewportView(txtDescripcion);
		
		lblPrecio = new JLabel("0");
		lblPrecio.setBounds(424, 18, 75, 14);
		getContentPane().add(lblPrecio);
		
		JLabel lblNewLabel_1 = new JLabel("Transmision:");
		lblNewLabel_1.setBounds(339, 43, 90, 14);
		getContentPane().add(lblNewLabel_1);
		
		lblTransmision = new JLabel("0");
		lblTransmision.setBounds(424, 43, 75, 14);
		getContentPane().add(lblTransmision);
		
		JLabel Marca = new JLabel("Marca:");
		Marca.setBounds(339, 68, 46, 14);
		getContentPane().add(Marca);
		
		JLabel Año = new JLabel("A\u00F1o:");
		Año.setBounds(339, 93, 46, 14);
		getContentPane().add(Año);
		
		JLabel Pasajeros = new JLabel("Pasajeros:");
		Pasajeros.setBounds(341, 123, 63, 14);
		getContentPane().add(Pasajeros);
		
		lblPasajeros = new JLabel("0");
		lblPasajeros.setBounds(424, 123, 46, 14);
		getContentPane().add(lblPasajeros);
		
		lblMarca = new JLabel("0");
		lblMarca.setBounds(424, 68, 158, 14);
		getContentPane().add(lblMarca);
		
		lblAño = new JLabel("0");
		lblAño.setBounds(424, 93, 46, 14);
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
