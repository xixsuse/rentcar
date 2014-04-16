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
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class MantenimientoVehiculo extends JFrame {
	private JTextField txtPrecio;
	private JTextField txtMarca;
	private JTextField txtMatricula;
	private JTextField txtPasajeros;
	private JTable tblVehiculos;
	private JFileChooser archivador = new JFileChooser();
	private JLabel lblImagen;
	private FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter(
			"Imagenes", "jpg");
	private Calendar calendario = Calendar.getInstance();
	private ArrayList<String> fechas = new ArrayList<String>();
	private JComboBox cbbAño;
	private JTextArea txtDescripcion;
	private String ruta = "";
	private JTextField txtCombustible;
	private JComboBox cbbCategoria;
	private JComboBox comboTransmision;
	private JTextField txtBuscar;
	private static MantenimientoVehiculo instancia;

	public static MantenimientoVehiculo getInstancia() {
		if (instancia == null) {
			instancia = new MantenimientoVehiculo();
		}
		return instancia;
	}

	private MantenimientoVehiculo() {
		super("Mantenimiento de vehiculos");
		setTitle("Administraci\u00F3n de veh\u00EDculos");
		setResizable(false);
		setSize(884, 708);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		for (int i = calendario.get(Calendar.YEAR) + 1; i >= (calendario
				.get(Calendar.YEAR) - 50); i--) {
			fechas.add(String.valueOf(i));
		}

		Border borde = LineBorder.createBlackLineBorder();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 413, 829, 240);
		getContentPane().add(scrollPane);

		tblVehiculos = new JTable(ModeloVehiculos.getInstancia());
		tblVehiculos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tblVehiculos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				setDatos(tblVehiculos.getSelectedRow());
			}
		});
		scrollPane.setViewportView(tblVehiculos);
		tblVehiculos.getTableHeader().setReorderingAllowed(false);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon("C:\\Users\\Dany\\git\\rentcar\\Imagenes\\Icons\\PNG\\search.png"));
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BuscadorTablas.getInstancia().buscar(tblVehiculos,
						txtBuscar.getText());
			}
		});
		btnBuscar.setBounds(758, 390, 96, 23);
		getContentPane().add(btnBuscar);

		txtBuscar = new JTextField();
		txtBuscar.setBounds(637, 391, 120, 20);
		getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informaci\u00F3n",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(25, 71, 829, 301);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Precio:");
		lblNewLabel.setBounds(37, 38, 42, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtPrecio = new JTextField();
		txtPrecio.setBounds(182, 38, 127, 20);
		panel.add(txtPrecio);
		txtPrecio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if (txtCombustible.getText().length() >= 8)
					e.consume();
				if ((car < '0' || car > '9'))
					e.consume();
			}
		});
		txtPrecio.setColumns(10);

		JLabel lblAo = new JLabel("A\u00F1o:");
		lblAo.setBounds(328, 38, 46, 14);
		panel.add(lblAo);
		lblAo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbbAño = new JComboBox(fechas.toArray());
		cbbAño.setBounds(417, 35, 120, 23);
		panel.add(cbbAño);

		txtPasajeros = new JTextField();
		txtPasajeros.setBounds(417, 83, 120, 20);
		panel.add(txtPasajeros);
		txtPasajeros.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if (txtCombustible.getText().length() >= 8)
					e.consume();
				if ((car < '0' || car > '9'))
					e.consume();
			}
		});
		txtPasajeros.setColumns(10);

		cbbCategoria = new JComboBox(new DefaultComboBoxModel(Conexion
				.getInstacia().obtenerCategorias().toArray()));
		cbbCategoria.setBounds(418, 127, 119, 23);
		panel.add(cbbCategoria);
		cbbCategoria.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblPasajeros = new JLabel("Pasajeros:");
		lblPasajeros.setBounds(328, 85, 74, 14);
		panel.add(lblPasajeros);
		lblPasajeros.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(328, 130, 74, 16);
		panel.add(lblCategoria);
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(328, 157, 98, 17);
		panel.add(lblDescripcion);
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));

		txtMarca = new JTextField();
		txtMarca.setBounds(182, 82, 127, 20);
		panel.add(txtMarca);
		txtMarca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
						&& car != 'á' && car != 'é' && car != 'í' && car != 'ó'
						&& car != 'ú' && car != 'Á' && car != 'É' && car != 'Í'
						&& car != 'Ó' && car != 'Ú'
						&& (car != (char) KeyEvent.VK_SPACE)) {
					e.consume();
				}
			}
		});
		txtMarca.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Marca:");
		lblNewLabel_1.setBounds(37, 82, 46, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblMatricula = new JLabel("Matricula:");
		lblMatricula.setBounds(33, 130, 66, 14);
		panel.add(lblMatricula);
		lblMatricula.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblTransmision = new JLabel("Transmision:");
		lblTransmision.setBounds(33, 177, 98, 14);
		panel.add(lblTransmision);
		lblTransmision.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblNewLabel_2 = new JLabel("Cantidad de combustible:");
		lblNewLabel_2.setBounds(33, 217, 150, 14);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));

		comboTransmision = new JComboBox();
		comboTransmision.setBounds(182, 174, 127, 23);
		panel.add(comboTransmision);
		comboTransmision.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboTransmision.setModel(new DefaultComboBoxModel(new String[] {
				"Automatico", "Mecanico" }));

		txtMatricula = new JTextField();
		txtMatricula.setBounds(183, 130, 126, 20);
		panel.add(txtMatricula);
		txtMatricula.setColumns(10);

		txtCombustible = new JTextField();
		txtCombustible.setBounds(182, 213, 127, 20);
		panel.add(txtCombustible);
		txtCombustible.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if (txtCombustible.getText().length() >= 8)
					e.consume();
				if ((car < '0' || car > '9'))
					e.consume();
			}
		});
		txtCombustible.setColumns(10);
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setIcon(new ImageIcon("C:\\Users\\Dany\\git\\rentcar\\Imagenes\\Icons\\PNG\\dvd3.png"));
		btnAgregar.setBounds(33, 255, 98, 23);
		panel.add(btnAgregar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\Dany\\git\\rentcar\\Imagenes\\Icons\\PNG\\remote.png"));
		btnEliminar.setBounds(141, 255, 98, 23);
		panel.add(btnEliminar);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon("C:\\Users\\Dany\\git\\rentcar\\Imagenes\\Icons\\PNG\\pencil-2.png"));
		btnModificar.setBounds(249, 255, 98, 23);
		panel.add(btnModificar);

		lblImagen = new JLabel("");
		lblImagen.setBounds(567, 29, 228, 204);
		panel.add(lblImagen);
		lblImagen.setLayout(new BorderLayout());
		lblImagen.setBorder(borde);

		JButton btnSubirImagen = new JButton("Agregar imagen");
		btnSubirImagen.setIcon(new ImageIcon("C:\\Users\\Dany\\git\\rentcar\\Imagenes\\Icons\\PNG\\search.png"));
		btnSubirImagen.setBounds(618, 237, 129, 23);
		panel.add(btnSubirImagen);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(328, 174, 209, 64);
		panel.add(scrollPane_1);

		txtDescripcion = new JTextArea();
		scrollPane_1.setViewportView(txtDescripcion);
		txtDescripcion.setLineWrap(true);
		
		JButton btnLimpiarCampos = new JButton("Limpiar campos");
		btnLimpiarCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtCombustible.setText("");
				txtDescripcion.setText("");
				txtMarca.setText("");
				txtMatricula.setText("");
				txtPasajeros.setText("");
				txtPrecio.setText("");
				txtBuscar.setText("");
				lblImagen.setIcon(null);
			}
		});
		btnLimpiarCampos.setBounds(355, 255, 119, 23);
		panel.add(btnLimpiarCampos);

		JLabel lblListadoDeVehculos = new JLabel("Listado de veh\u00EDculos");
		lblListadoDeVehculos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblListadoDeVehculos.setBounds(29, 395, 141, 14);
		getContentPane().add(lblListadoDeVehculos);

		JLabel lblVehculos = new JLabel("Veh\u00EDculos");
		lblVehculos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVehculos.setBounds(390, 22, 89, 38);
		getContentPane().add(lblVehculos);
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
		btnModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (tblVehiculos.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null,
							"Debe seleccionar la fila que desea modificar");
				} else {
					ModeloVehiculos.getInstancia().modificarVehiculo(
							new Vehiculo(Integer.parseInt(txtPrecio.getText()
									.toString()), txtMarca.getText(),
									Integer.parseInt(txtPasajeros.getText()
											.toString()), Integer
											.parseInt((String) cbbAño
													.getSelectedItem()),
									txtMatricula.getText(), comboTransmision
											.getSelectedItem().toString(),
									txtDescripcion.getText(), Integer
											.parseInt(txtCombustible.getText()
													.toString()), false), ruta,
							tblVehiculos.getSelectedRow());
					ruta = "";
				}
			}
		});
		btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (tblVehiculos.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null,
							"Debe seleccionar la fila que desea eliminar");
				} else {
					ModeloVehiculos.getInstancia().eliminarVehiculo(
							tblVehiculos.getSelectedRow());
				}

			}
		});
		btnAgregar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(txtCombustible.getText().isEmpty() || txtDescripcion.getText().isEmpty() || txtMarca.getText().isEmpty() 
						|| txtMatricula.getText().isEmpty() || txtPasajeros.getText().isEmpty() || txtPrecio.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos","Error",JOptionPane.ERROR_MESSAGE);
				}else if (ruta.equals("")) {
					JOptionPane.showMessageDialog(null,
							"Debe seleccionar una foto para este vehiculo");
				}else{
				ModeloVehiculos.getInstancia().agregarVehiculo(
						new Vehiculo(Integer.parseInt(txtPrecio.getText()
								.toString()), txtMarca.getText(), Integer
								.parseInt(txtPasajeros.getText().toString()),
								Integer.parseInt((String) cbbAño
										.getSelectedItem()), txtMatricula
										.getText(), comboTransmision
										.getSelectedItem().toString(),
								txtDescripcion.getText(), Integer
										.parseInt(txtCombustible.getText()),
								false), ruta);
				ruta = "";
				
				}
			}
		});
		setVisible(true);
	}

	public void setDatos(int index) {
		Vehiculo datosVehiculo = ModeloVehiculos.getInstancia().cargarDatos(
				index);
		txtPrecio.setText(String.valueOf(datosVehiculo.getPrecio()));
		txtMarca.setText(datosVehiculo.getMarca());
		txtPasajeros.setText(String.valueOf(datosVehiculo.getPasajeros()));
		txtMatricula.setText(datosVehiculo.getMatricula());
		// txtTransmision.setText(datosVehiculo.getTransmision());
		comboTransmision.setSelectedItem(datosVehiculo.getTransmision());
		txtDescripcion.setText(datosVehiculo.getDescripcion());
		txtCombustible.setText(String.valueOf(datosVehiculo.getCombustible()));
		Image foto = datosVehiculo.getFoto().getScaledInstance(228, 204,
				java.awt.Image.SCALE_SMOOTH);
		ImageIcon icono = new ImageIcon(foto);
		lblImagen.setIcon(icono);
	}
}
