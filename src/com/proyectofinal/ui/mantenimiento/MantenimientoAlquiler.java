package com.proyectofinal.ui.mantenimiento;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MantenimientoAlquiler extends JFrame{
	private JTable tblAlquiler;
	private JTextField txtDescuento;
	private JTextField txtTotal;
	public MantenimientoAlquiler(){
		setTitle("Alguiler");
		setSize(795,500);
		getContentPane().setLayout(null);
		
		JButton btnCatalogo = new JButton("Ir al catalogo");
		btnCatalogo.setBounds(374, 22, 130, 23);
		getContentPane().add(btnCatalogo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 306, 779, 155);
		getContentPane().add(scrollPane);
		tblAlquiler = new JTable();
		scrollPane.setViewportView(tblAlquiler);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(139, 11, 148, 29);
		getContentPane().add(dateChooser);
		
		JLabel Desde = new JLabel("Desde: ");
		Desde.setBounds(27, 26, 46, 14);
		getContentPane().add(Desde);
		
		JLabel Hasta = new JLabel("Hasta");
		Hasta.setBounds(27, 64, 46, 14);
		getContentPane().add(Hasta);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(139, 51, 148, 27);
		getContentPane().add(dateChooser_1);
		
		JComboBox cbbSeguros = new JComboBox();
		cbbSeguros.setBounds(27, 114, 116, 23);
		getContentPane().add(cbbSeguros);
		
		JComboBox cbbAccesorio = new JComboBox();
		cbbAccesorio.setBounds(27, 166, 116, 23);
		getContentPane().add(cbbAccesorio);
		
		txtDescuento = new JTextField();
		txtDescuento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(txtDescuento.getText().length()>=10) e.consume();
				if((car<'0' || car>'9')) e.consume();

			}
		});
		txtDescuento.setBounds(309, 115, 86, 20);
		getContentPane().add(txtDescuento);
		txtDescuento.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Descuento");
		lblNewLabel.setBounds(206, 118, 72, 19);
		getContentPane().add(lblNewLabel);
		
		txtTotal = new JTextField();
		txtTotal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(txtTotal.getText().length()>=8) e.consume();
				if((car<'0' || car>'9')) e.consume();

			}
		});
		txtTotal.setBounds(309, 167, 86, 23);
		getContentPane().add(txtTotal);
		txtTotal.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Total a pagar");
		lblNewLabel_1.setBounds(206, 175, 81, 14);
		getContentPane().add(lblNewLabel_1);
		setVisible(true);
		tblAlquiler.getTableHeader().setReorderingAllowed(false);
		
	}
}
