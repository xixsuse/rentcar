package com.proyectofinal.ui.mantenimiento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.proyectofinal.entidades.Alquiler;
import com.proyectofinal.modelos.ModeloAlquiler;
import com.proyectofinal.modelos.ModeloAutosActivos;
import com.proyectofinal.ui.BuscadorTablas;
import com.proyectofinal.ui.Catalogo;
import com.proyectofinal.ui.VentanaPrincipal;
import com.toedter.calendar.JDateChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
	private static JTextField txtIdCliente;
	private JTextField txtBuscar;
	
	public MantenimientoAlquiler(){
		setTitle("Le atiende: "+ VentanaPrincipal.getUsuario());
		setSize(795,500);
		getContentPane().setLayout(null);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(2, 6, 777, 427);
		getContentPane().add(tabbedPane);
		JPanel panel = new JPanel();
		tabbedPane.addTab("Alquiler", null, panel, null);
		panel.setLayout(null);
		
		JLabel Accesorio = new JLabel("Accesorio:");
		Accesorio.setBounds(8, 78, 63, 14);
		panel.add(Accesorio);
		
		JLabel lblNewLabel_2 = new JLabel("Seguro:");
		lblNewLabel_2.setBounds(8, 36, 46, 14);
		panel.add(lblNewLabel_2);
		txtIdVehiculo = new JTextField();
		txtIdVehiculo.setEnabled(false);
		txtIdVehiculo.setBounds(177, 75, 132, 20);
		panel.add(txtIdVehiculo);
		txtIdVehiculo.setEnabled(false);
		txtIdVehiculo.setColumns(10);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String desde = new SimpleDateFormat("yyyy-MM-dd").format((dateDesde.getDate()));
				String hasta = new SimpleDateFormat("yyyy-MM-dd").format((dateHasta.getDate()));
				ModeloAlquiler.getInstancia().modificarAlquiler(
						new Alquiler(Integer.parseInt(txtIdVehiculo.getText()),
									 desde,
									 hasta,
									 Integer.parseInt(txtIdCliente.getText()),
									 Integer.parseInt(txtTotal.getText()),
									 Float.parseFloat(txtDescuento.getText()),
									 Integer.parseInt((String) cbbSeguros.getSelectedItem()),
									 Integer.parseInt((String) cbbAccesorio.getSelectedItem())),
									 tblAlquiler.getSelectedRow());
			}
		});
		btnModificar.setBounds(214, 365, 75, 23);
		panel.add(btnModificar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//JOptionPane.showMessageDialog(null, "Seguro que quiere eliminar este alquiler");
				if(tblAlquiler.getSelectedRow()==-1){
					JOptionPane.showMessageDialog(null, "Debe de seleccionar el campo que quiere eliminar");
				}
				else{
					ModeloAlquiler.getInstancia().eliminarAlquiler(tblAlquiler.getSelectedRow());
				}
			}
		});
		btnEliminar.setBounds(129, 365, 69, 23);
		panel.add(btnEliminar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(32, 365, 71, 23);
		panel.add(btnAgregar);
		
		JLabel lblNewLabel_1 = new JLabel("Total a pagar:");
		lblNewLabel_1.setBounds(7, 245, 75, 14);
		panel.add(lblNewLabel_1);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(81, 242, 86, 20);
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
		
		JLabel lblNewLabel = new JLabel("Descuento:");
		lblNewLabel.setBounds(8, 217, 63, 14);
		panel.add(lblNewLabel);
		
		txtDescuento = new JTextField();
		txtDescuento.setBounds(81, 214, 86, 20);
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
		cbbAccesorio.setBounds(81, 75, 86, 20);
		panel.add(cbbAccesorio);
		
		cbbSeguros = new JComboBox(ModeloAlquiler.getInstancia().getSeguros().toArray());
		cbbSeguros.setBounds(81, 33, 86, 20);
		panel.add(cbbSeguros);
		
		dateHasta = new JDateChooser();
		dateHasta.setDateFormatString("yyyy-MM-dd");
		dateHasta.setBounds(48, 181, 86, 20);
		panel.add(dateHasta);
		
		
		JLabel Hasta = new JLabel("Hasta");
		Hasta.setBounds(8, 187, 28, 14);
		panel.add(Hasta);
		
		JLabel Desde = new JLabel("Desde: ");
		Desde.setBounds(172, 184, 37, 14);
		panel.add(Desde);
		
		dateDesde = new JDateChooser();
		dateDesde.setDateFormatString("yyyy-MM-dd");
		dateDesde.setBounds(214, 181, 95, 20);
		panel.add(dateDesde);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(314, 33, 452, 355);
		panel.add(scrollPane);
		tblAlquiler = new JTable(ModeloAlquiler.getInstancia());
		tblAlquiler.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent arg0) {
				txtIdVehiculo.setText(String.valueOf(tblAlquiler.getValueAt(tblAlquiler.getSelectedRow(),2)));
				txtTotal.setText(String.valueOf(tblAlquiler.getValueAt(tblAlquiler.getSelectedRow(),6 )));
				txtIdCliente.setText(String.valueOf(tblAlquiler.getValueAt(tblAlquiler.getSelectedRow(), 1)));
				txtDescuento.setText(String.valueOf(tblAlquiler.getValueAt(tblAlquiler.getSelectedRow(),7)));
			}
		});
		scrollPane.setViewportView(tblAlquiler);
		
		JButton btnCatalogo = new JButton("Seleccionar vehiculo");
		btnCatalogo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Catalogo();
				
			}
		});
		btnCatalogo.setBounds(180, 36, 129, 23);
		panel.add(btnCatalogo);
		
		JButton btnRegistrarUsuario = new JButton("Seleccionar cliente");
		btnRegistrarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MantenimientoClientes.getInstacia().setVisible(true);
			}
		});
		btnRegistrarUsuario.setBounds(8, 116, 132, 23);
		panel.add(btnRegistrarUsuario);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setEditable(false);
		txtIdCliente.setBounds(8, 150, 115, 20);
		panel.add(txtIdCliente);
		txtIdCliente.setColumns(10);
		
		JButton btnCalcularTotal = new JButton("Calcular total");
		btnCalcularTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cbbSeguros.getSelectedIndex()==-1 || cbbAccesorio.getSelectedIndex()==-1 || txtIdVehiculo.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Para calcular el precio total debe tener el vehiculo,el accesorio y el seguro en caso de querer ");
				}
				else{
					txtTotal.setText(String.valueOf(ModeloAlquiler.getInstancia().calcularTotal(
																Integer.parseInt(String.valueOf(txtIdVehiculo.getText())),
																Integer.parseInt(String.valueOf(cbbSeguros.getSelectedItem())),
																Integer.parseInt(String.valueOf(cbbAccesorio.getSelectedItem())),
																Double.parseDouble(String.valueOf(txtDescuento.getText())))));
				}
			}
		});
		btnCalcularTotal.setBounds(8, 270, 106, 23);
		panel.add(btnCalcularTotal);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Vehiculos en uso", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 38, 752, 350);
		panel_1.add(scrollPane_1);
		tblVehiculosActivos = new JTable(ModeloAutosActivos.getInstancia());
		scrollPane_1.setViewportView(tblVehiculosActivos);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(492, 11, 164, 20);
		panel_1.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscadorTablas.getInstancia().buscar(tblVehiculosActivos, txtBuscar.getText());
			}
		});
		btnBuscar.setBounds(666, 10, 89, 23);
		panel_1.add(btnBuscar);
		
		JButton btnRecibir = new JButton("Recibir");
		btnRecibir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tblVehiculosActivos.getSelectedRow()==-1){
					ModeloAutosActivos.getInstancia().recibirVehiculo(tblVehiculosActivos.getSelectedRow());
				}
			}
		});
		btnRecibir.setBounds(144, 10, 89, 23);
		panel_1.add(btnRecibir);
		tblAlquiler.getTableHeader().setReorderingAllowed(false);
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 String desde = new SimpleDateFormat("yyyy-MM-dd").format((dateDesde.getDate()));
				 String hasta = new SimpleDateFormat("yyyy-MM-dd").format((dateHasta.getDate()));
				ModeloAlquiler.getInstancia().agregarAlquiler(
						new Alquiler(Integer.parseInt(txtIdVehiculo.getText()),
								desde,
								hasta,
								Integer.parseInt(txtIdCliente.getText()),																			
									 (int) Double.parseDouble(txtTotal.getText()),
									 Float.parseFloat(txtDescuento.getText()),
									 Integer.parseInt((String) cbbSeguros.getSelectedItem()),
									 Integer.parseInt((String) cbbAccesorio.getSelectedItem())));
							
			ModeloAlquiler.getInstancia().cambiarEstadoVehiculo(Integer.parseInt(txtIdVehiculo.getText()));
			}
		});
		setVisible(true);
		
	}
	public static void setIdVehiculo(int idVehiculo){
		txtIdVehiculo.setText(String.valueOf(idVehiculo));
	}
	
	public static void setIdCliente(int idCliente){
		txtIdCliente.setText(String.valueOf(idCliente));
	}
}
