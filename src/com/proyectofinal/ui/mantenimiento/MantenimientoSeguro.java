package com.proyectofinal.ui.mantenimiento;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class MantenimientoSeguro extends JFrame {

	private JPanel contentPane;
	private JTextField txtCategoria;
	private JTextField txtPrecio;
	private JTextField txtNombre;
	private JTextField txtCobertura;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenimientoSeguro frame = new MantenimientoSeguro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MantenimientoSeguro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 368, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(138, 21, 187, 20);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(138, 57, 86, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(138, 95, 187, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCobertura = new JTextField();
		txtCobertura.setBounds(138, 126, 187, 20);
		contentPane.add(txtCobertura);
		txtCobertura.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(29, 24, 79, 14);
		contentPane.add(lblCategoria);
		
		JLabel lblNewLabel = new JLabel("Precio:");
		lblNewLabel.setBounds(29, 60, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(29, 98, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblNewLabel_1 = new JLabel("Cobertura:");
		lblNewLabel_1.setBounds(29, 129, 79, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(19, 177, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(123, 177, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(236, 177, 89, 23);
		contentPane.add(btnModificar);
	}

}
