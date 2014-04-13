package com.proyectofinal.ui;

import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Catalogo extends JFrame{
	private JTextField txtNombre;
	private JPanel pnCatalogo;
	public Catalogo(){
		setTitle("Catalogo de vehiculos");
		setSize(764,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		pnCatalogo = new JPanel();
		pnCatalogo.setBounds(10, 77, 728, 273);
		getContentPane().add(pnCatalogo);
		pnCatalogo.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnCatalogo.add(new JButton("hola"));
			}
		});
		btnNewButton.setBounds(241, 34, 89, 23);
		getContentPane().add(btnNewButton);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(119, 35, 86, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		setVisible(true);
	}
}
