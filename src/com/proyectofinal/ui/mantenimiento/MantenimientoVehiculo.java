package com.proyectofinal.ui.mantenimiento;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.proyectofinal.bd.Conexion;
import com.proyectofinal.entidades.Vehiculo;
import com.proyectofinal.modelos.ModeloVehiculos;
import com.proyectofinal.ui.BuscadorTablas;

public class MantenimientoVehiculo extends JFrame{
	private JTextField txtPrecio;
	private JTextField txtMarca;
	private JTextField txtMatricula;
	private JTextField txtPasajeros;
	private JTable tblVehiculos;
	private JFileChooser archivador = new JFileChooser();
	private JLabel lblImagen;
	private FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("Imagenes", "jpg");
	private Calendar calendario = Calendar.getInstance();
	private ArrayList<String> fechas = new ArrayList<String>();
	private JComboBox cbbAño;
	private JTextArea txtDescripcion;
	private String ruta = "";
	private JTextField txtCombustible;
	private JComboBox cbbCategoria;
	private JComboBox comboTransmision;
	private JTextField txtBuscar;

	public MantenimientoVehiculo() {
		super("Mantenimiento de vehiculos");
		setSize(842, 469);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Precio:");
		lblNewLabel.setBounds(14, 11, 42, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Marca:");
		lblNewLabel_1.setBounds(14, 55, 46, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(10, 103, 66, 14);
		getContentPane().add(lblMatricula);

		JLabel lblPasajeros = new JLabel("Pasajeros:");
		lblPasajeros.setBounds(296, 55, 74, 14);
		getContentPane().add(lblPasajeros);

		JLabel lblTransmision = new JLabel("Transmision:");
		lblTransmision.setBounds(10, 150, 98, 14);
		getContentPane().add(lblTransmision);

		JLabel lblAo = new JLabel("A\u00F1o:");
		lblAo.setBounds(296, 11, 46, 14);
		getContentPane().add(lblAo);

		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(298, 116, 98, 17);
		getContentPane().add(lblDescripcion);

		txtPrecio = new JTextField();
		txtPrecio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(txtCombustible.getText().length()>=8) e.consume();
				if((car<'0' || car>'9')) e.consume();
			}
		});
		txtPrecio.setBounds(159, 11, 127, 20);
		getContentPane().add(txtPrecio);
		txtPrecio.setColumns(10);

		txtMarca = new JTextField();
		txtMarca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();        
				if((car<'a' || car>'z') && (car<'A' || car>'Z')            
				    && car !='á'         
				    && car !='é'            
				    && car !='í'            
				    && car !='ó'          
				    && car !='ú'  
				    && car !='Á'           
				    && car !='É'            
				    && car !='Í'            
				    && car !='Ó'          
				    && car !='Ú'            
				    && (car!=(char)KeyEvent.VK_SPACE))
				{      
				  e.consume();  
				}
			}
		});
		txtMarca.setBounds(159, 55, 127, 20);
		getContentPane().add(txtMarca);
		txtMarca.setColumns(10);

		txtMatricula = new JTextField();
		txtMatricula.setBounds(160, 103, 126, 20);
		getContentPane().add(txtMatricula);
		txtMatricula.setColumns(10);

		txtPasajeros = new JTextField();
		txtPasajeros.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(txtCombustible.getText().length()>=8) e.consume();
				if((car<'0' || car>'9')) e.consume();
			}
		});
		txtPasajeros.setBounds(394, 52, 120, 20);
		getContentPane().add(txtPasajeros);
		txtPasajeros.setColumns(10);
		for (int i = calendario.get(Calendar.YEAR) + 1; i >= (calendario
				.get(Calendar.YEAR) - 50); i--) {
			fechas.add(String.valueOf(i));
		}
		cbbAño = new JComboBox(fechas.toArray());
		cbbAño.setBounds(394, 8, 120, 23);
		getContentPane().add(cbbAño);

		Border borde = LineBorder.createBlackLineBorder();
		
		lblImagen = new JLabel("");
		lblImagen.setLayout(new BorderLayout());
		lblImagen.setBounds(588, 11, 228, 204);
		lblImagen.setBorder(borde);
		getContentPane().add(lblImagen);

		JButton btnSubirImagen = new JButton("Adjuntar imagen");
		btnSubirImagen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				archivador.setFileFilter(filtroImagen);
				int seleccion = archivador.showOpenDialog(archivador);
				if (seleccion == JFileChooser.APPROVE_OPTION) {
					
					File foto = archivador.getSelectedFile();
					ruta = foto.getPath();
					ImageIcon imagen = new ImageIcon(ruta);
					Image iconImage = imagen.getImage();
					Image newImage = iconImage.getScaledInstance(228, 204,
							java.awt.Image.SCALE_SMOOTH);
					ImageIcon fotoImagen = new ImageIcon(newImage);
					lblImagen.setIcon(fotoImagen);
				}
			}
		});
		btnSubirImagen.setBounds(648, 226, 124, 23);
		getContentPane().add(btnSubirImagen);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 265, 806, 154);
		getContentPane().add(scrollPane);


		tblVehiculos = new JTable(ModeloVehiculos.getInstancia());
		tblVehiculos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setDatos(tblVehiculos.getSelectedRow());
			}
		});
		scrollPane.setViewportView(tblVehiculos);
		tblVehiculos.getTableHeader().setReorderingAllowed(false);
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(ruta.equals("")){
					JOptionPane.showMessageDialog(null, "Debe seleccionar la fota para este vehiculo");
				}
				ModeloVehiculos.getInstancia().agregarVehiculo(
						new Vehiculo(Integer.parseInt(txtPrecio.getText().toString()),
								txtMarca.getText(), Integer
										.parseInt(txtPasajeros.getText().toString()),
								Integer.parseInt((String) cbbAño
										.getSelectedItem()), txtMatricula
										.getText(), comboTransmision.getSelectedItem().toString(),
								txtDescripcion.getText(),Integer.parseInt(txtCombustible.getText()), false),ruta);
				ruta = "";
				System.out.println(txtCombustible.getText());
			}
		});
		btnAgregar.setBounds(10, 237, 89, 23);
		getContentPane().add(btnAgregar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(tblVehiculos.getSelectedRow()==-1){
					JOptionPane.showMessageDialog(null, "Debe seleccionar la fila que desea eliminar");
				}
				else{
					ModeloVehiculos.getInstancia().eliminarVehiculo(tblVehiculos.getSelectedRow());
				}
				
			}
		});
		btnEliminar.setBounds(110, 237, 89, 23);
		getContentPane().add(btnEliminar);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tblVehiculos.getSelectedRow()==-1){
					JOptionPane.showMessageDialog(null, "Debe seleccionar la fila que desea modificar");
				}
				else{
					ModeloVehiculos.getInstancia().modificarVehiculo(new Vehiculo(Integer.parseInt(txtPrecio.getText().toString()),
							txtMarca.getText(), Integer
							.parseInt(txtPasajeros.getText().toString()),
					Integer.parseInt((String) cbbAño
							.getSelectedItem()), txtMatricula
							.getText(), comboTransmision.getSelectedItem().toString(),
					txtDescripcion.getText(),Integer.parseInt(txtCombustible.getText().toString()), false),ruta, tblVehiculos.getSelectedRow());
					ruta = "";
				}
			}
		});
		btnModificar.setBounds(209, 237, 89, 23);
		getContentPane().add(btnModificar);
		
		txtCombustible = new JTextField();
		txtCombustible.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(txtCombustible.getText().length()>=8) e.consume();
				if((car<'0' || car>'9')) e.consume();
			}
		});
		txtCombustible.setBounds(159, 186, 127, 20);
		getContentPane().add(txtCombustible);
		txtCombustible.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cantidad de combustible:");
		lblNewLabel_2.setBounds(10, 190, 150, 14);
		getContentPane().add(lblNewLabel_2);
		
		cbbCategoria = new JComboBox(new DefaultComboBoxModel(Conexion.getInstacia().obtenerCategorias().toArray()));
		cbbCategoria.setBounds(395, 85, 119, 23);
		getContentPane().add(cbbCategoria);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(296, 89, 74, 16);
		getContentPane().add(lblCategoria);
		
		comboTransmision = new JComboBox();
		comboTransmision.setModel(new DefaultComboBoxModel(new String[] {"Autom\u00E1tico", "Mec\u00E1nico"}));
		comboTransmision.setBounds(159, 147, 127, 23);
		getContentPane().add(comboTransmision);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(296, 139, 218, 64);
		getContentPane().add(scrollPane_1);
		
				txtDescripcion = new JTextArea();
				txtDescripcion.setLineWrap(true);
				scrollPane_1.setViewportView(txtDescripcion);
				
				JButton btnBuscar = new JButton("Buscar");
				btnBuscar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						BuscadorTablas.getInstancia().buscar(tblVehiculos, txtBuscar.getText());
					}
				});
				btnBuscar.setBounds(481, 237, 89, 23);
				getContentPane().add(btnBuscar);
				
				txtBuscar = new JTextField();
				txtBuscar.setBounds(348, 238, 120, 20);
				getContentPane().add(txtBuscar);
				txtBuscar.setColumns(10);
		setVisible(true);
	}
	
	public void setDatos(int index){
		Vehiculo datosVehiculo = ModeloVehiculos.getInstancia().cargarDatos(index);
		txtPrecio.setText(String.valueOf(datosVehiculo.getPrecio()));
		txtMarca.setText(datosVehiculo.getMarca());
		txtPasajeros.setText(String.valueOf(datosVehiculo.getPasajeros()));
		txtMatricula.setText(datosVehiculo.getMatricula());
		//txtTransmision.setText(datosVehiculo.getTransmision());
		comboTransmision.setSelectedItem(datosVehiculo.getTransmision());
		txtDescripcion.setText(datosVehiculo.getDescripcion());
		System.out.println(datosVehiculo.getCombustible() + datosVehiculo.getTransmision());
		txtCombustible.setText(String.valueOf(datosVehiculo.getCombustible()));
		Image foto = datosVehiculo.getFoto().getScaledInstance(228, 204, java.awt.Image.SCALE_SMOOTH);
		ImageIcon icono = new ImageIcon(foto);
		lblImagen.setIcon(icono);
	}
}
