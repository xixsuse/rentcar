package com.proyectofinal.ui.mantenimiento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.proyectofinal.entidades.Categoria;
import com.proyectofinal.modelos.ModeloCategoria;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class MantenimientoCategoria extends JFrame {

	private JPanel contentPane;
	private JTextField txtCategoria;
	private JTable tlbCategoria;

	private static MantenimientoCategoria instancia;
	public static MantenimientoCategoria getInstacia(){
		if(instancia == null){
			instancia = new MantenimientoCategoria();
		}
		return instancia;
	}
	
	private MantenimientoCategoria() {
		setResizable(false);
		setTitle("Administraci\u00F3n de categoria");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 390);
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
		txtCategoria.setBounds(109, 61, 200, 20);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCategoria.setBounds(10, 63, 70, 14);
		contentPane.add(lblCategoria);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(txtCategoria.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Ha de completar el campo antes de agregar.");
				}else{
					Categoria categoria = new Categoria();
					categoria.setNombre(txtCategoria.getText());
					ModeloCategoria.getInstacia().agregarCategoria(categoria);
					txtCategoria.setText("");
				}
			}
		});
		btnGuardar.setBounds(10, 92, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int fila = tlbCategoria.getSelectedRow();
				if(fila < 0){
					JOptionPane.showMessageDialog(null, "Porfavor seleccione un dato de la fila");
				}else{
					if(txtCategoria.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Seleccione una categoria de la tabla");
					}else{
						ModeloCategoria.getInstacia().eliminarCategoria(fila);
						txtCategoria.setText("");
					}
				}
			}
		});
		btnEliminar.setBounds(117, 92, 89, 23);
		contentPane.add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 156, 299, 185);
		contentPane.add(scrollPane);
		
		tlbCategoria = new JTable(ModeloCategoria.getInstacia());
		tlbCategoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tlbCategoria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int fila = tlbCategoria.getSelectedRow();
				txtCategoria.setText(tlbCategoria.getValueAt(fila, 0).toString());
			}
		});
		scrollPane.setViewportView(tlbCategoria);
		tlbCategoria.getTableHeader().setReorderingAllowed(false);
		
		JLabel lblListadoDeCategorias = new JLabel("Listado de categorias:");
		lblListadoDeCategorias.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblListadoDeCategorias.setBounds(10, 131, 129, 20);
		contentPane.add(lblListadoDeCategorias);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int index = tlbCategoria.getSelectedRow();
				if(index < 0){
					JOptionPane.showMessageDialog(null, "Debe seleccionar una categoria de la tabla y modificar dicha categoria !", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					if(txtCategoria.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos!", "Error", JOptionPane.ERROR_MESSAGE);
					}else{
						ModeloCategoria.getInstacia().modificarCategoria(new Categoria(txtCategoria.getText()), index);
						txtCategoria.setText("");
					}
				}
			}
		});
		btnModificar.setBounds(220, 92, 89, 23);
		contentPane.add(btnModificar);
		
		JLabel lblCategorias = new JLabel("Categorias");
		lblCategorias.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCategorias.setBounds(111, 11, 118, 39);
		contentPane.add(lblCategorias);
	}
}
