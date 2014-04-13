package com.proyectofinal.ui.mantenimiento;

import java.awt.EventQueue;
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

public class MantenimientoSeguro extends JFrame {

	private JPanel contentPane;
	private JTextField txtCategoria;
	private JTextField txtPrecio;
	private JTextField txtNombre;
	private JTextField txtCobertura;
	private JTable tableSeguro;

	
	public MantenimientoSeguro() {
		setTitle("Mantenimiento de Seguros");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 368, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtCategoria = new JTextField();
		txtCategoria.setBounds(138, 21, 185, 20);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(138, 57, 86, 20);
		contentPane.add(txtPrecio);
		txtPrecio.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(138, 95, 185, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtCobertura = new JTextField();
		txtCobertura.setBounds(138, 140, 185, 20);
		contentPane.add(txtCobertura);
		txtCobertura.setColumns(10);
		
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
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtCategoria.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Completar campo categoria.");
				}else if(txtPrecio.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Completar campo precio.");
				}else if(!txtPrecio.getText().matches("[0-9].")){
					JOptionPane.showMessageDialog(null, "El precio tiene que ser en numeros.");
				}else if(txtNombre.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Completar campo nombre.");
				}else if(txtCobertura.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Completar campo cobertura.");
				}else{
					Seguro seguro = new Seguro();
					seguro.setCategoria(txtCategoria.getText());
					seguro.setPrecio(Double.parseDouble(txtPrecio.getText()));
					seguro.setNombre(txtNombre.getText());
					seguro.setCobertura(txtCobertura.getText());
					ModeloSeguro.getInstacia().agregarSeguro(seguro);
					txtCategoria.setText("");
					txtPrecio.setText("");
					txtNombre.setText("");
					txtCobertura.setText("");
				}
			}
		});
		btnGuardar.setBounds(29, 177, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
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
						txtCobertura.setText("");
					}
				}
			}
		});
		btnEliminar.setBounds(135, 177, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = tableSeguro.getSelectedRow();
				if(index < 0){
					JOptionPane.showMessageDialog(null, "Debe seleccionar un seguro de la tabla y modificar dicho seguro!", "Error", JOptionPane.ERROR_MESSAGE);
				}else{
					if(txtCategoria.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Completar campo categoria.");
					}else if(txtPrecio.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Completar campo precio.");
					}else if(!txtPrecio.getText().matches("[0-9]")){
						JOptionPane.showMessageDialog(null, "El precio tiene que ser en numeros.");
					}else if(txtNombre.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Completar campo nombre.");
					}else if(txtCobertura.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Completar campo cobertura.");
					}else{
						ModeloSeguro.getInstacia().modificarCategoria(new Seguro(txtCategoria.getText(),
										Double.parseDouble(txtPrecio.getText()), txtNombre.getText(),
										txtCobertura.getText()), index);
						txtCategoria.setText("");
						txtPrecio.setText("");
						txtNombre.setText("");
						txtCobertura.setText("");
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
				txtCobertura.setText(tableSeguro.getValueAt(fila, 4).toString());
			}
		});
		scrollPane.setViewportView(tableSeguro);
		tableSeguro.getTableHeader().setReorderingAllowed(false);
	}
}
