package com.proyectofinal.ui.mantenimiento;

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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.proyectofinal.entidades.Usuario;
import com.proyectofinal.modelos.ModeloUsuarios;
import com.proyectofinal.ui.BuscadorTablas;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;


public class MantenimientoUsuarios extends JFrame implements ActionListener, MouseListener{

	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtUsuario;
	private JPasswordField txtContrasena;
	private JButton btnAgregar;
	private JButton btnEliminar;
	private JComboBox comboCargo;
	

	private JTable tablaUsuarios;
	
	private static MantenimientoUsuarios instancia;
	private JButton btnActualizar;
	private JTextField txtBuscar;
	private JButton btnBuscar;
	private JPanel panel;
	private JLabel lblUsuarios;
	
	public static MantenimientoUsuarios getInstacia(){
		if(instancia == null){
			instancia = new MantenimientoUsuarios();
		}
		return instancia;
	}
	
	private MantenimientoUsuarios() {
		setResizable(false);
		ModeloUsuarios modeloUsuario = new ModeloUsuarios();
		setTitle("Administraci\u00F3n de usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 401);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(tablaUsuarios);
		scrollPane.setBounds(351, 100, 396, 233);
		getContentPane().add(scrollPane);
		
		tablaUsuarios = new JTable(ModeloUsuarios.getInstacia());
		scrollPane.setViewportView(tablaUsuarios);
		tablaUsuarios.addMouseListener(this);
		tablaUsuarios.getTableHeader().setReorderingAllowed(false);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(466, 77, 208, 19);
		getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(672, 76, 75, 23);
		btnBuscar.addActionListener(this);
		btnBuscar.setMnemonic('B');
		getContentPane().add(btnBuscar);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(26, 80, 318, 254);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(17, 30, 62, 14);
		panel.add(lblNombre);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setBounds(17, 67, 62, 14);
		panel.add(lblApellido);
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtNombre = new JTextField();
		txtNombre.setBounds(128, 28, 170, 19);
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
		
		txtApellido = new JTextField();
		txtApellido.setBounds(128, 67, 170, 19);
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
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(17, 107, 62, 14);
		panel.add(lblUsuario);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(17, 142, 70, 14);
		panel.add(lblContrasea);
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(128, 105, 170, 19);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		txtContrasena = new JPasswordField();
		txtContrasena.setBounds(128, 140, 170, 19);
		panel.add(txtContrasena);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(17, 178, 62, 17);
		panel.add(lblCargo);
		lblCargo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		comboCargo = new JComboBox();
		comboCargo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboCargo.setBounds(128, 178, 170, 19);
		panel.add(comboCargo);
		comboCargo.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Vendedor"}));
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(110, 220, 89, 23);
		panel.add(btnEliminar);
		
		btnActualizar = new JButton("Modificar");
		btnActualizar.setBounds(209, 220, 89, 23);
		panel.add(btnActualizar);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10, 220, 89, 23);
		panel.add(btnAgregar);
		
		lblUsuarios = new JLabel("Usuarios");
		lblUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsuarios.setBounds(338, 11, 124, 41);
		getContentPane().add(lblUsuarios);
		btnAgregar.addActionListener(this);
		btnActualizar.addActionListener(this);
		btnEliminar.addActionListener(this);
				
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAgregar){
			if(txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtUsuario.getText().isEmpty() || txtContrasena.getText().isEmpty()){
				JOptionPane.showMessageDialog(this, "Debe rellenar todos los campos!", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				ModeloUsuarios.getInstacia().AgregarUsuario(new Usuario(txtNombre.getText(), txtApellido.getText(), txtUsuario.getText(), txtContrasena.getText(), comboCargo.getSelectedItem().toString()));
				txtNombre.setText("");
				txtApellido.setText("");
				txtContrasena.setText("");
				txtUsuario.setText("");
				}
			}else if(e.getSource() == btnEliminar){
				int fila = tablaUsuarios.getSelectedRow();
				if (fila < 0){
					JOptionPane.showMessageDialog(this, "Debes seleccionar una fila", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					ModeloUsuarios.getInstacia().eliminarUsuario(tablaUsuarios.getSelectedRow());
					txtNombre.setText("");
					txtApellido.setText("");
					txtContrasena.setText("");
					txtUsuario.setText("");
				}
			}else if(e.getSource() == btnActualizar){
				if(txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtUsuario.getText().isEmpty() || txtContrasena.getText().isEmpty()){
					JOptionPane.showMessageDialog(this, "Debes seleccionar una fila", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					int index = tablaUsuarios.getSelectedRow();
					ModeloUsuarios.getInstacia().modificarUsuario(new Usuario(txtNombre.getText(), txtApellido.getText(), txtUsuario.getText(), txtContrasena.getText(), comboCargo.getSelectedItem().toString()),index);
					txtNombre.setText("");
					txtApellido.setText("");
					txtContrasena.setText("");
					txtUsuario.setText("");
				}
			}else if(e.getSource() == btnBuscar){
				BuscadorTablas.getInstancia().buscar(tablaUsuarios, txtBuscar.getText());
			}
		}

	
	@Override
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
