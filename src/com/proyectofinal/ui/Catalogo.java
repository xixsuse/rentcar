package com.proyectofinal.ui;

import javax.swing.JFrame;
import javax.swing.JTable;

import javax.swing.JScrollPane;

import com.proyectofinal.modelos.ModeloCatalogo;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class Catalogo extends JFrame{
	private JTable tblCatalogo;

	public Catalogo(){
		setTitle("Catalogo de vehiculos");
		setSize(756,469);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 319, 408);
		getContentPane().add(scrollPane);
		tblCatalogo = new JTable(ModeloCatalogo.getInstancia());
		tblCatalogo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				setSize(343,469);
			}
		});
		tblCatalogo.setRowHeight(200);
		scrollPane.setViewportView(tblCatalogo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(366, 42, 46, 14);
		getContentPane().add(lblNewLabel);
		setVisible(true);
	}
	
	public static void main(String[] args){
		new Catalogo();
	}
}
