package com.proyectofinal.ui.mantenimiento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.proyectofinal.entidades.Seguro;
import com.proyectofinal.modelos.ModeloSeguro;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class MantenimientoSeguro extends JFrame {

	private JPanel contentPane;
	private JTextField txtCategoria;
	private JTextField txtPrecio;
	private JTextField txtNombre;
	private JTable tableSeguro;
	private JComboBox cmboCobertura;
	private static MantenimientoSeguro instancia;
	
	public static MantenimientoSeguro getInstancia(){
		if(instancia == null){
			instancia = new MantenimientoSeguro();
		}
		return instancia;
	}
	
	private MantenimientoSeguro() {
		setResizable(false);
		setTitle("Administraci\u00F3n de seguros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 397, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 289, 371, 210);
		contentPane.add(scrollPane);
		
		tableSeguro = new JTable(ModeloSeguro.getInstacia());
		tableSeguro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tableSeguro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int fila = tableSeguro.getSelectedRow();
				txtCategoria.setText(tableSeguro.getValueAt(fila, 0).toString());
				txtPrecio.setText(tableSeguro.getValueAt(fila, 1).toString());
				txtNombre.setText(tableSeguro.getValueAt(fila, 2).toString());
				cmboCobertura.setSelectedItem(tableSeguro.getValueAt(fila, 3).toString());
			}
		});
		scrollPane.setViewportView(tableSeguro);
		
		JLabel lblListadoDeSeguros = new JLabel("Listado de seguros:");
		lblListadoDeSeguros.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblListadoDeSeguros.setBounds(10, 270, 121, 20);
		contentPane.add(lblListadoDeSeguros);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 49, 371, 219);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(10, 27, 79, 14);
		panel.add(lblCategoria);
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(119, 25, 185, 20);
		panel.add(txtCategoria);
		txtCategoria.addKeyListener(new KeyAdapter() {
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
		txtCategoria.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(119, 61, 86, 20);
		panel.add(txtPrecio);
		txtPrecio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(txtPrecio.getText().length()>=8) e.consume();
				if((car<'0' || car>'9')) e.consume();
			}
		});
		txtPrecio.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Precio:");
		lblNewLabel.setBounds(10, 64, 46, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 102, 60, 14);
		panel.add(lblNombre);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtNombre = new JTextField();
		txtNombre.setBounds(119, 99, 185, 20);
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
		
		cmboCobertura = new JComboBox();
		cmboCobertura.setBounds(119, 144, 185, 20);
		panel.add(cmboCobertura);
		cmboCobertura.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cmboCobertura.setModel(new DefaultComboBoxModel(new String[] {"Nacional", "Internacional"}));
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Cobertura:");
		lblNewLabel_1.setBounds(10, 147, 79, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		JButton btnGuardar = new JButton("Agregar");
		btnGuardar.setIcon(new ImageIcon("C:\\Users\\Dany\\git\\rentcar\\Imagenes\\Icons\\PNG\\dvd3.png"));
		btnGuardar.setBounds(10, 181, 97, 23);
		panel.add(btnGuardar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setIcon(new ImageIcon("C:\\Users\\Dany\\git\\rentcar\\Imagenes\\Icons\\PNG\\remote.png"));
		btnEliminar.setBounds(129, 181, 106, 23);
		panel.add(btnEliminar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setIcon(new ImageIcon("C:\\Users\\Dany\\git\\rentcar\\Imagenes\\Icons\\PNG\\pencil-2.png"));
		btnModificar.setBounds(255, 181, 106, 23);
		panel.add(btnModificar);
		
		JLabel lblSeguros = new JLabel("Seguros");
		lblSeguros.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSeguros.setBounds(144, 11, 78, 25);
		contentPane.add(lblSeguros);
		btnModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int index = tableSeguro.getSelectedRow();
				if(index < 0){
					JOptionPane.showMessageDialog(null, "Debe seleccionar un seguro de la tabla y modificar dicho seguro!", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					if(txtCategoria.getText().isEmpty() || txtNombre.getText().isEmpty() || txtPrecio.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
					
					}else{
						ModeloSeguro.getInstacia().modificarCategoria(new Seguro(txtCategoria.getText(),
										Double.parseDouble(txtPrecio.getText()), txtNombre.getText(),
										cmboCobertura.getSelectedItem().toString()), index);
						txtCategoria.setText("");
						txtPrecio.setText("");
						txtNombre.setText("");
						
					}
				}
			}
		});
		btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int fila = tableSeguro.getSelectedRow();
				if(fila < 0){
					JOptionPane.showMessageDialog(null, "Porfavor seleccione un seguro de la tabla");
				}else{
					if(txtCategoria.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Seleccione un seguro de la tabla");
					}else{
						ModeloSeguro.getInstacia().eliminarSeguro(fila);
						txtCategoria.setText("");
						txtPrecio.setText("");
						txtNombre.setText("");
						
					}
				}
			}
		});
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(txtCategoria.getText().isEmpty() || txtNombre.getText().isEmpty() || txtPrecio.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
				
				}else{
					Seguro seguro = new Seguro();
					seguro.setCategoria(txtCategoria.getText());
					seguro.setPrecio(Double.parseDouble(txtPrecio.getText()));
					seguro.setNombre(txtNombre.getText());
					seguro.setCobertura(cmboCobertura.getSelectedItem().toString());
					ModeloSeguro.getInstacia().agregarSeguro(seguro);
					txtCategoria.setText("");
					txtPrecio.setText("");
					txtNombre.setText("");	
				}
			}
		});
		tableSeguro.getTableHeader().setReorderingAllowed(false);
	}
	
	
}
