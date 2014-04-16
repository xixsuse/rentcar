package com.proyectofinal.ui.mantenimiento;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.proyectofinal.entidades.Cliente;
import com.proyectofinal.modelos.ModeloCatalogo;
import com.proyectofinal.modelos.ModeloClientes;
import com.proyectofinal.ui.BuscadorTablas;
import com.proyectofinal.ui.Catalogo;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MantenimientoClientes extends JFrame implements ActionListener, MouseListener{
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtTelefono;
	
	private JTable tablaCliente;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnBuscar;
	private String rutaArchivo = "";
	private JLabel lblFoto;
	
	private static MantenimientoClientes instancia;
	private JButton btnExaminar;
	private JTextField textField;
	private JTextField txtNombreDocumento;
	private JTextField txtBuscar;
	
	
	public static MantenimientoClientes getInstacia(){
		if(instancia == null){
			instancia = new MantenimientoClientes();
		}
		return instancia;
	}
	

	private MantenimientoClientes() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				int seleccion = 0;
				seleccion = JOptionPane.showConfirmDialog(null, "Seguro que desea salir?", "Advertencia", JOptionPane.YES_NO_OPTION);
				if(seleccion == JOptionPane.OK_OPTION){
					MantenimientoAlquiler.setIdCliente(ModeloClientes.getInstacia().
					getIdCliente(tablaCliente.getSelectedRow()));
						MantenimientoClientes.this.dispose();
				}
			}
		});
		setResizable(false);
		setTitle("Administraci\u00F3n de clientes");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 831, 597);
		getContentPane().setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane(tablaCliente);
		scrollPane.setBounds(373, 104, 431, 430);
		getContentPane().add(scrollPane);
		
		tablaCliente = new JTable(ModeloClientes.getInstacia());
		tablaCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(tablaCliente);
		tablaCliente.addMouseListener(this);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(523, 77, 190, 19);
		getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setIcon(new ImageIcon("C:\\Users\\Dany\\git\\rentcar\\Imagenes\\Icons\\PNG\\search.png"));
		btnBuscar.addActionListener(this);
		btnBuscar.setBounds(715, 76, 89, 23);
		btnBuscar.setMnemonic('B');
		getContentPane().add(btnBuscar);
		
		Border borde = LineBorder.createBlackLineBorder();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 68, 353, 466);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(21, 27, 62, 14);
		panel.add(lblNombre);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtNombre = new JTextField();
		txtNombre.setBounds(126, 25, 206, 19);
		panel.add(txtNombre);
		txtNombre.addKeyListener(new KeyAdapter() {
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
		txtNombre.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(21, 59, 62, 14);
		panel.add(lblApellido);
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtApellido = new JTextField();
		txtApellido.setBounds(126, 57, 206, 19);
		panel.add(txtApellido);
		txtApellido.addKeyListener(new KeyAdapter() {
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
		txtApellido.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(21, 96, 62, 14);
		panel.add(lblTelefono);
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(213, 94, 119, 19);
		panel.add(txtTelefono);
		txtTelefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char car = e.getKeyChar();
				if(txtTelefono.getText().length()>=12) e.consume();
				if((car<'0' || car>'9')
						&& car !='-'
						) 
					e.consume();
			}
		});
		txtTelefono.setColumns(10);
		
		JLabel lblDocumento = new JLabel("Documento:");
		lblDocumento.setBounds(21, 133, 78, 17);
		panel.add(lblDocumento);
		lblDocumento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtNombreDocumento = new JTextField();
		txtNombreDocumento.setBounds(93, 133, 133, 18);
		panel.add(txtNombreDocumento);
		txtNombreDocumento.setEditable(false);
		txtNombreDocumento.setColumns(10);
		
		btnExaminar = new JButton("Examinar");
		btnExaminar.setBounds(231, 131, 101, 23);
		panel.add(btnExaminar);
		btnExaminar.setIcon(new ImageIcon("C:\\Users\\Dany\\git\\rentcar\\Imagenes\\Icons\\PNG\\search.png"));
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(21, 186, 96, 23);
		panel.add(btnAgregar);
		btnAgregar.setIcon(new ImageIcon("C:\\Users\\Dany\\git\\rentcar\\Imagenes\\Icons\\PNG\\dvd3.png"));
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(130, 186, 96, 23);
		panel.add(btnEliminar);
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\Dany\\git\\rentcar\\Imagenes\\Icons\\PNG\\remote.png"));
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(236, 186, 96, 23);
		panel.add(btnModificar);
		btnModificar.setIcon(new ImageIcon("C:\\Users\\Dany\\git\\rentcar\\Imagenes\\Icons\\PNG\\pencil-2.png"));
		lblFoto = new JLabel("");
		lblFoto.setBounds(21, 220, 311, 228);
		panel.add(lblFoto);
		lblFoto.setBorder(borde);
		
		JLabel lblNewLabel = new JLabel("Listado de clientes:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(373, 79, 140, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblClientes.setBounds(356, 11, 102, 47);
		getContentPane().add(lblClientes);
		btnModificar.addActionListener(this);
		btnEliminar.addActionListener(this);
		btnAgregar.addActionListener(this);
		btnExaminar.addActionListener(this);
		
		
		tablaCliente.getTableHeader().setReorderingAllowed(false);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		int fila = tablaCliente.getSelectedRow();
		JFileChooser jc = new JFileChooser();
		if(e.getSource() == btnAgregar){
			if(txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtTelefono.getText().isEmpty()){
				JOptionPane.showMessageDialog(this, "Debe rellenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
			}else if(rutaArchivo.isEmpty()){
				JOptionPane.showMessageDialog(null, "Debes seleccionar un documento.", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
			if(rutaArchivo != null){
				ModeloClientes.getInstacia().agregarCliente(new Cliente(txtNombre.getText(), txtApellido.getText(), txtTelefono.getText(), rutaArchivo));
				txtNombre.setText("");
				txtApellido.setText("");
				txtNombreDocumento.setText("");
				txtTelefono.setText("");
				lblFoto.setIcon(null);
				//txtIdCliente.setText("");
				}else{
					JOptionPane.showMessageDialog(this, "Debe seleccionar un documento", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}else if(e.getSource() == btnExaminar){
			FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG", "jpg");
			jc.setFileFilter(filtro);
			int seleccion = jc.showOpenDialog(null);

			if(seleccion == JFileChooser.APPROVE_OPTION){
				File archivo = jc.getSelectedFile();
				jc.setFileFilter(filtro);
				//Mostrar imagen
				rutaArchivo = archivo.getPath();
				ImageIcon foto = new ImageIcon(rutaArchivo);
				Image iconoImagen = foto.getImage();
				Image newImage = iconoImagen.getScaledInstance(281, 178, java.awt.Image.SCALE_DEFAULT);
				ImageIcon fotoMostrar = new ImageIcon(newImage);
				lblFoto.setIcon(fotoMostrar);
				String nombreArchivo = archivo.getName();
				txtNombreDocumento.setText(nombreArchivo);
			}else if(seleccion == JFileChooser.CANCEL_OPTION){
			}
			
				
			
			
		}else if(e.getSource() == btnEliminar){
			
			
			if (fila < 0){
				JOptionPane.showMessageDialog(this, "Debes seleccionar una fila", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				ModeloClientes.getInstacia().eliminarCliente(fila);
				txtNombre.setText("");
				txtApellido.setText("");
				txtNombreDocumento.setText("");
				txtTelefono.setText("");
				
			}
		}else if(e.getSource() == btnModificar){
			if(fila < 0){
				JOptionPane.showMessageDialog(this, "Debes seleccionar una fila", "Error", JOptionPane.ERROR_MESSAGE);
			}else if(txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtTelefono.getText().isEmpty() || txtNombreDocumento.getText().isEmpty()){
				JOptionPane.showMessageDialog(this, "Debes rellenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG", "jpg");
				jc.setFileFilter(filtro);
				
				jc.showOpenDialog(null);
				File archivo = jc.getSelectedFile();
				
				jc.setFileFilter(filtro);
				
				rutaArchivo = archivo.getAbsolutePath();
				String nombreArchivo = archivo.getName();
				txtNombreDocumento.setText(nombreArchivo);
				
				ModeloClientes.getInstacia().modificarCliente(new Cliente(txtNombre.getText(), txtApellido.getText(), txtTelefono.getText(), rutaArchivo),fila);
				txtNombre.setText("");
				txtApellido.setText("");
				txtNombreDocumento.setText("");
				txtTelefono.setText("");
				
			}	
		}else if(e.getSource() == btnBuscar){
			BuscadorTablas.getInstancia().buscar(tablaCliente, txtBuscar.getText());
		}
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
	int fila = tablaCliente.getSelectedRow();
	txtNombre.setText(tablaCliente.getValueAt(fila, 0).toString());
	txtApellido.setText(tablaCliente.getValueAt(fila, 1).toString());
	txtTelefono.setText(tablaCliente.getValueAt(fila, 2).toString());
	txtNombreDocumento.setText("Documento del cliente");
	
	
	
		
	}
	
	/*public void setDatos(int fila){
		//Vehiculo datosVehiculo = ModeloVehiculos.getInstancia().cargarDatos(index);
		Cliente datosCliente = ModeloClientes.getInstacia().cargarDatos(fila);
		txtNombre.setText(tablaCliente.getValueAt(fila, 0).toString());
		txtApellido.setText(tablaCliente.getValueAt(fila, 1).toString());
		txtTelefono.setText(tablaCliente.getValueAt(fila, 2).toString());
		Image foto = datosCliente.getDocumento().getScaledInstance(228, 204, java.awt.Image.SCALE_SMOOTH);
		ImageIcon icono = new ImageIcon(foto);
		lblFoto.setIcon(icono);
		
	}*/


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
