package com.proyectofinal.ui.mantenimiento;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.proyectofinal.bd.Conexion;
import com.proyectofinal.entidades.Categoria;
import com.proyectofinal.modelos.ModeloCategoria;

public class MantenimientoCategoria extends JFrame {

	private JPanel contentPane;
	private JTextField txtCategoria;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MantenimientoCategoria frame = new MantenimientoCategoria();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
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
				Categoria categoria = new Categoria();
				categoria.setNombre(txtCategoria.getText());
				ModeloCategoria.getInstacia().agregarCategoria(categoria);;
			}
		});
		btnGuardar.setBounds(10, 92, 89, 23);
		contentPane.add(btnGuardar);
		
		JButton btnEliminar = new JButton("Eliminarr");
		btnEliminar.setBounds(117, 92, 89, 23);
		contentPane.add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 156, 310, 185);
		contentPane.add(scrollPane);
		
		table = new JTable(ModeloCategoria.getInstacia());
		scrollPane.setViewportView(table);
		
		JLabel lblListadoDeCategorias = new JLabel("Listado de categorias:");
		lblListadoDeCategorias.setBounds(10, 131, 126, 14);
		contentPane.add(lblListadoDeCategorias);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(220, 92, 89, 23);
		contentPane.add(btnModificar);
	}
}
