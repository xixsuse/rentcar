package com.proyectofinal.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.proyectofinal.bd.Conexion;
import com.proyectofinal.entidades.Usuario;
import com.proyectofinal.modelos.ModeloUsuarios;


public class MatenimientoUsuarios extends JFrame implements ActionListener, MouseListener{

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JComboBox comboCargo;
	

	public JTable tablaUsuarios;
	
	private static MatenimientoUsuarios instancia;
	private JButton btnActualizar;
	private JButton btnNewButton;
	public static MatenimientoUsuarios getInstacia(){
		if(instancia == null){
			instancia = new MatenimientoUsuarios();
		}
		return instancia;
	}
	
	public MatenimientoUsuarios() {
		ModeloUsuarios modeloUsuario = new ModeloUsuarios();
		setTitle("Matenimiento de Usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 491);
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNombre.setBounds(188, 11, 62, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblApellido.setBounds(188, 36, 62, 14);
		getContentPane().add(lblApellido);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsuario.setBounds(188, 64, 62, 14);
		getContentPane().add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblContrasea.setBounds(188, 92, 70, 14);
		getContentPane().add(lblContrasea);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCargo.setBounds(188, 120, 62, 17);
		getContentPane().add(lblCargo);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(299, 11, 170, 19);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(299, 36, 170, 19);
		getContentPane().add(txtApellido);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(299, 64, 170, 19);
		getContentPane().add(txtUsuario);
		
		comboCargo = new JComboBox();
		comboCargo.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Vendedor"}));
		comboCargo.setBounds(299, 120, 170, 19);
		getContentPane().add(comboCargo);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(299, 90, 170, 19);
		getContentPane().add(txtContrasena);
		
		JScrollPane scrollPane = new JScrollPane(tablaUsuarios);
		scrollPane.setBounds(10, 202, 635, 240);
		getContentPane().add(scrollPane);
		
		tablaUsuarios = new JTable();
		scrollPane.setViewportView(tablaUsuarios);
		tablaUsuarios.setModel(modeloUsuario);
		tablaUsuarios.addMouseListener(this);
				
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(209, 159, 89, 23);
		btnAgregar.addActionListener(this);
		getContentPane().add(btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(308, 159, 89, 23);
		btnEliminar.addActionListener(this);
		getContentPane().add(btnEliminar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(414, 159, 97, 23);
		btnActualizar.addActionListener(this);
		getContentPane().add(btnActualizar);
				
	}


	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAgregar){
			if(txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtUsuario.getText().isEmpty() || txtContrasena.getText().isEmpty()){
				JOptionPane.showMessageDialog(this, "Debe rellenar todos los campos!", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				ModeloUsuarios.getInstacia().AgregarUsuario(new Usuario(txtNombre.getText(), txtApellido.getText(), txtUsuario.getText(), txtContrasena.getText(), comboCargo.getSelectedItem().toString()));
				}
			
			}else if(e.getSource() == btnEliminar){
				ModeloUsuarios.getInstacia().eliminarUsuario(tablaUsuarios.getSelectedRow());
			}else if(e.getSource() == btnActualizar){
				if(txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtUsuario.getText().isEmpty() || txtContrasena.getText().isEmpty()){
					JOptionPane.showMessageDialog(this, "Debes seleccionar una fila", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					Conexion.getInstacia().modificarUsuario(new Usuario(txtNombre.getText(), txtApellido.getText(), txtUsuario.getText(), txtContrasena.getText(), comboCargo.getSelectedItem().toString()));
				}
			}
		}

	
	public void mouseClicked(MouseEvent e) {
		int fila = tablaUsuarios.getSelectedRow();
		
		txtNombre.setText(tablaUsuarios.getValueAt(fila, 0).toString());
		txtApellido.setText(tablaUsuarios.getValueAt(fila, 1).toString());
		txtUsuario.setText(tablaUsuarios.getValueAt(fila, 2).toString());
		txtContrasena.setText(tablaUsuarios.getValueAt(fila, 3).toString());
		comboCargo.setSelectedItem(tablaUsuarios.getValueAt(fila, 4).toString());
				
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {

		
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
