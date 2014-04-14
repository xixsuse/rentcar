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

public class MantenimientoSeguro extends JFrame {

	private JPanel contentPane;
	private JTextField txtCategoria;
	private JTextField txtPrecio;
	private JTextField txtNombre;
	private JTable tableSeguro;
	private JComboBox cmboCobertura;
	
	public MantenimientoSeguro() {
		setTitle("Mantenimiento de Seguros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 368, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtCategoria = new JTextField();
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
		txtCategoria.setBounds(138, 21, 185, 20);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car = e.getKeyChar();
				if(txtPrecio.getText().length()>=8) e.consume();
				if((car<'0' || car>'9')) e.consume();
			}
		});
		txtPrecio.setBounds(138, 57, 86, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtNombre = new JTextField();
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
		txtNombre.setBounds(138, 95, 185, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(29, 24, 79, 14);
		contentPane.add(lblCategoria);
		
		JLabel lblNewLabel = new JLabel("Precio:");
		lblNewLabel.setBounds(29, 60, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(29, 98, 46, 14);
		contentPane.add(lblNombre);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Cobertura:");
		lblNewLabel_1.setBounds(29, 143, 79, 14);
		contentPane.add(lblNewLabel_1);
		
		cmboCobertura = new JComboBox();
		cmboCobertura.setModel(new DefaultComboBoxModel(new String[] {"Nacional", "Internacional"}));
		cmboCobertura.setBounds(138, 140, 185, 20);
		contentPane.add(cmboCobertura);
		
		JButton btnGuardar = new JButton("Guardar");
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
		btnGuardar.setBounds(29, 177, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnEliminar = new JButton("Eliminar");
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
		btnEliminar.setBounds(135, 177, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnModificar = new JButton("Modificar");
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
		btnModificar.setBounds(234, 177, 89, 23);
		contentPane.add(btnModificar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 230, 295, 184);
		contentPane.add(scrollPane);
		
		tableSeguro = new JTable(ModeloSeguro.getInstacia());
		tableSeguro.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int fila = tableSeguro.getSelectedRow();
				txtCategoria.setText(tableSeguro.getValueAt(fila, 1).toString());
				txtPrecio.setText(tableSeguro.getValueAt(fila, 2).toString());
				txtNombre.setText(tableSeguro.getValueAt(fila, 3).toString());
				cmboCobertura.setSelectedItem(tableSeguro.getValueAt(fila, 4).toString());
			}
		});
		scrollPane.setViewportView(tableSeguro);
		
		
		tableSeguro.getTableHeader().setReorderingAllowed(false);
	}
}
