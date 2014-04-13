package com.proyectofinal.ui;

import javax.swing.JFrame;
import javax.swing.JTable;

import javax.swing.JScrollPane;

import com.proyectofinal.modelos.ModeloCatalogo;

public class Catalogo extends JFrame{
	private JTable tblCatalogo;

	public Catalogo(){
		setTitle("Catalogo de vehiculos");
		setSize(764,400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 96, 671, 227);
		getContentPane().add(scrollPane);
		
		tblCatalogo = new JTable(ModeloCatalogo.getInstancia());
		scrollPane.setViewportView(tblCatalogo);
		setVisible(true);
	}
	
	public static void main(String[] args){
		new Catalogo();
	}
}
