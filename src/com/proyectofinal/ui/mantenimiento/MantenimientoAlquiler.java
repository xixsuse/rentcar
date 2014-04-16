package com.proyectofinal.ui.mantenimiento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.proyectofinal.entidades.Alquiler;
import com.proyectofinal.modelos.ModeloAlquiler;
import com.proyectofinal.ui.Catalogo;
import com.proyectofinal.ui.VentanaPrincipal;
import com.toedter.calendar.JDateChooser;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MantenimientoAlquiler extends JFrame{
	private JTable tblAlquiler;
	private JTextField txtDescuento;
	private JTextField txtTotal;
	public static boolean estado = false;
	private static JTextField txtIdVehiculo;
	private JTable tblVehiculosActivos;
	private JDateChooser dateDesde;
	private JDateChooser dateHasta;
	private JComboBox cbbSeguros;
	private JComboBox cbbAccesorio;
	
	public MantenimientoAlquiler(){
		setTitle("Le atiende: ");
		setSize(795,500);
		getContentPane().setLayout(null);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(2, 6, 777, 427);
		getContentPane().add(tabbedPane);
		JPanel panel = new JPanel();
		tabbedPane.addTab("New tab", null, panel, null);
		panel.setLayout(null);
		
		JLabel Accesorio = new JLabel("Accesorio");
		Accesorio.setBounds(8, 75, 46, 14);
		panel.add(Accesorio);
		
		JLabel lblNewLabel_2 = new JLabel("Seguro");
		lblNewLabel_2.setBounds(20, 33, 34, 14);
		panel.add(lblNewLabel_2);
		txtIdVehiculo = new JTextField();
		txtIdVehiculo.setBounds(214, 101, 95, 20);
		panel.add(txtIdVehiculo);
		txtIdVehiculo.setEnabled(false);
		txtIdVehiculo.setColumns(10);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModeloAlquiler.getInstancia().modificarAlquiler(
						new Alquiler(Integer.parseInt(txtIdVehiculo.getText()),
									 dateDesde.getDateFormatString(),
									 dateHasta.getDateFormatString(),
									 VentanaPrincipal.getIdCliente(),
									 Integer.parseInt(txtTotal.getText()),
									 Float.parseFloat(txtDescuento.getText()),
									 Integer.parseInt((String) cbbSeguros.getSelectedItem()),
									 Integer.parseInt((String) cbbAccesorio.getSelectedItem())),
									 tblAlquiler.getSelectedRow());
			}
		});
		btnModificar.setBounds(229, 321, 75, 23);
		panel.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Seguro que quiere eliminar este alquiler");
				if(tblAlquiler.getSelectedRow()==-1){
					JOptionPane.showMessageDialog(null, "Debe de seleccionar el campo que quiere eliminar");
				}
				else{
					ModeloAlquiler.getInstancia().eliminarAlquiler(tblAlquiler.getSelectedRow());
				}
			}
		});
		btnEliminar.setBounds(139, 321, 69, 23);
		panel.add(btnEliminar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(39, 321, 71, 23);
		panel.add(btnAgregar);
		
		JLabel lblNewLabel_1 = new JLabel("Total a pagar");
		lblNewLabel_1.setBounds(7, 135, 64, 14);
		panel.add(lblNewLabel_1);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(81, 132, 86, 20);
		panel.add(txtTotal);
		txtTotal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(txtTotal.getText().length()>=8) e.consume();
				if((car<'0' || car>'9')) e.consume();

			}
		});
		txtTotal.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Descuento");
		lblNewLabel.setBounds(8, 183, 51, 14);
		panel.add(lblNewLabel);
		
		txtDescuento = new JTextField();
		txtDescuento.setBounds(81, 180, 86, 20);
		panel.add(txtDescuento);
		txtDescuento.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(txtDescuento.getText().length()>=10) e.consume();
				if((car<'0' || car>'9')) e.consume();

			}
		});
		txtDescuento.setColumns(10);
		cbbAccesorio = new JComboBox(ModeloAlquiler.getInstancia().getAccesorios().toArray());
		cbbAccesorio.setBounds(81, 72, 86, 20);
		panel.add(cbbAccesorio);
		
		cbbSeguros = new JComboBox(ModeloAlquiler.getInstancia().getSeguros().toArray());
		cbbSeguros.setBounds(81, 30, 86, 20);
		panel.add(cbbSeguros);
		
		dateHasta = new JDateChooser();
		dateHasta.setBounds(48, 236, 86, 20);
		panel.add(dateHasta);
		dateHasta.setEnabled(false);
		
		JLabel Hasta = new JLabel("Hasta");
		Hasta.setBounds(8, 242, 28, 14);
		panel.add(Hasta);
		
		JLabel Desde = new JLabel("Desde: ");
		Desde.setBounds(172, 239, 37, 14);
		panel.add(Desde);
		
		dateDesde = new JDateChooser();
		dateDesde.setBounds(214, 236, 95, 20);
		panel.add(dateDesde);
		dateDesde.setEnabled(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(314, 33, 452, 427);
		panel.add(scrollPane);
		tblAlquiler = new JTable(ModeloAlquiler.getInstancia());
		scrollPane.setViewportView(tblAlquiler);
		
		JButton btnCatalogo = new JButton("Ir al catalogo");
		btnCatalogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Catalogo();
			}
		});
		btnCatalogo.setBounds(214, 66, 96, 23);
		panel.add(btnCatalogo);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 752, 377);
		panel_1.add(scrollPane_1);
		
		tblVehiculosActivos = new JTable();
		scrollPane_1.setViewportView(tblVehiculosActivos);
		tblAlquiler.getTableHeader().setReorderingAllowed(false);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ModeloAlquiler.getInstancia().agregarAlquiler(
						new Alquiler(Integer.parseInt(txtIdVehiculo.getText()),
									 dateDesde.getDateFormatString(),
									 dateHasta.getDateFormatString(),
									 VentanaPrincipal.getIdCliente(),																			
									 Integer.parseInt(txtTotal.getText()),
									 Float.parseFloat(txtDescuento.getText()),
									 Integer.parseInt((String) cbbSeguros.getSelectedItem()),
									 Integer.parseInt((String) cbbAccesorio.getSelectedItem())));
			}
		});
		setVisible(true);
	}	
	
	public static void main(String[] args){
		new MantenimientoAlquiler();
	}
}
