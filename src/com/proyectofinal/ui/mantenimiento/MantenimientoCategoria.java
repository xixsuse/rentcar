package com.proyectofinal.ui.mantenimiento;

import java.awt.EventQueue;
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

public class MantenimientoCategoria extends JFrame {

	private JPanel contentPane;
	private JTextField txtCategoria;
	private JTable table;

	private static MantenimientoCategoria instancia;
	public static MantenimientoCategoria getInstacia(){
		if(instancia == null){
			instancia = new MantenimientoCategoria();
		}
		return instancia;
	}
	
	public MantenimientoCategoria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 348, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(120, 43, 86, 20);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setBounds(29, 46, 70, 14);
		contentPane.add(lblCategoria);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
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
			public void actionPerformed(ActionEvent arg0) {
				int fila = table.getSelectedRow();
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
		scrollPane.setBounds(10, 156, 310, 185);
		contentPane.add(scrollPane);
		
		table = new JTable(ModeloCategoria.getInstacia());
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int fila = table.getSelectedRow();
				txtCategoria.setText(table.getValueAt(fila, 1).toString());
			}
		});
		scrollPane.setViewportView(table);
		table.getTableHeader().setReorderingAllowed(false);
		
		JLabel lblListadoDeCategorias = new JLabel("Listado de categorias:");
		lblListadoDeCategorias.setBounds(10, 131, 126, 14);
		contentPane.add(lblListadoDeCategorias);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = table.getSelectedRow();
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
	}
}
