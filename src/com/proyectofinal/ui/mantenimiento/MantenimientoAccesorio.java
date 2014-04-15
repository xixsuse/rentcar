package com.proyectofinal.ui.mantenimiento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.proyectofinal.entidades.Accesorio;
import com.proyectofinal.modelos.ModeloAccesorios;
import com.proyectofinal.ui.BuscadorTablas;
import java.awt.event.KeyAdapter;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;


public class MantenimientoAccesorio extends JFrame implements ActionListener, MouseListener{
	private JTextField txtNombre;
	private JTextField txtSerial;
	private JTextField txtPrecio;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JTable tablaAccesorios;
	private JTextArea txtDescripcion;
	private JButton btnModificar;
	private JButton btnBuscar;
	private static MantenimientoAccesorio instancia;
	private JTextField txtBuscar;
	private JLabel lblListadoDeAccesorios;
	
	public static MantenimientoAccesorio getInstacia(){
		if(instancia == null){
			instancia = new MantenimientoAccesorio();
		}
		return instancia;
	}
	
	public MantenimientoAccesorio() {
		setResizable(false);
		setTitle("Administraci\u00F3n de accesorios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 677, 505);
		getContentPane().setLayout(null);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n:");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDescripcion.setBounds(20, 205, 71, 14);
		getContentPane().add(lblDescripcion);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(20, 358, 71, 23);
		btnAgregar.addActionListener(this);
		getContentPane().add(btnAgregar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(98, 358, 63, 23);
		btnBorrar.addActionListener(this);
		getContentPane().add(btnBorrar);
		
		JScrollPane scrollPaneTabla = new JScrollPane(tablaAccesorios);
		scrollPaneTabla.setBounds(268, 101, 383, 322);
		getContentPane().add(scrollPaneTabla);
		
		tablaAccesorios = new JTable(ModeloAccesorios.getInstacia());
		scrollPaneTabla.setViewportView(tablaAccesorios);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 219, 220, 130);
		getContentPane().add(scrollPane);
		
		txtDescripcion = new JTextArea();
		scrollPane.setViewportView(txtDescripcion);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(167, 358, 75, 23);
		btnModificar.addActionListener(this);
		getContentPane().add(btnModificar);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(400, 81, 180, 19);
		getContentPane().add(txtBuscar);
		txtBuscar.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBuscar.setBounds(580, 79, 71, 23);
		btnBuscar.addActionListener(this);
		btnBuscar.setMnemonic('B');
		getContentPane().add(btnBuscar);
		
		JLabel lblAccesorios = new JLabel("Accesorios");
		lblAccesorios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAccesorios.setBounds(268, 29, 108, 23);
		getContentPane().add(lblAccesorios);
		
		lblListadoDeAccesorios = new JLabel("Listado de accesorios:");
		lblListadoDeAccesorios.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblListadoDeAccesorios.setBounds(268, 83, 141, 14);
		getContentPane().add(lblListadoDeAccesorios);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Informaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 74, 248, 349);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 105, 71, 14);
		panel.add(lblPrecio);
		lblPrecio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtPrecio = new JTextField();
		txtPrecio.setBounds(91, 104, 141, 17);
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
		
		JLabel lblSerial = new JLabel("Serial:");
		lblSerial.setBounds(10, 69, 71, 14);
		panel.add(lblSerial);
		lblSerial.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtSerial = new JTextField();
		txtSerial.setBounds(91, 68, 141, 17);
		panel.add(txtSerial);
		txtSerial.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 31, 71, 14);
		panel.add(lblNombre);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		txtNombre = new JTextField();
		txtNombre.setBounds(91, 30, 141, 17);
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
		tablaAccesorios.addMouseListener(this);
		
		tablaAccesorios.getTableHeader().setReorderingAllowed(false);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnAgregar){
			if(txtNombre.getText().isEmpty() || txtSerial.getText().isEmpty() || txtPrecio.getText().isEmpty() || txtDescripcion.getText().isEmpty()){
				JOptionPane.showMessageDialog(this, "Debe rellenar todos los campos!", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
			ModeloAccesorios.getInstacia().agregarAccesorio(new Accesorio(txtNombre.getText(),txtSerial.getText(),txtDescripcion.getText(),(Integer.parseInt(txtPrecio.getText()))));
			
			txtNombre.setText("");
			txtSerial.setText("");
			txtDescripcion.setText("");
			txtPrecio.setText("");
			}
		}else if (e.getSource() == btnBorrar){
			int fila = tablaAccesorios.getSelectedRow();
			if (fila < 0){
				JOptionPane.showMessageDialog(this, "Debes seleccionar una fila", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
				ModeloAccesorios.getInstacia().eliminarAccesorio(fila);
				
				txtNombre.setText("");
				txtSerial.setText("");
				txtDescripcion.setText("");
				txtPrecio.setText("");
		}
		
		}else if(e.getSource() == btnModificar){
			int index = tablaAccesorios.getSelectedRow();
			if(txtNombre.getText().isEmpty() || txtSerial.getText().isEmpty() || txtPrecio.getText().isEmpty() || txtDescripcion.getText().isEmpty()){
				JOptionPane.showMessageDialog(this, "Debe rellenar todos los campos!", "Error", JOptionPane.ERROR_MESSAGE);
			}else{
			
			ModeloAccesorios.getInstacia().modificarAccesorio(new Accesorio(txtNombre.getText(),txtSerial.getText(),txtDescripcion.getText(),(Integer.parseInt(txtPrecio.getText()))),index);
		
			txtNombre.setText("");
			txtSerial.setText("");
			txtDescripcion.setText("");
			txtPrecio.setText("");
			}
		}else if(e.getSource() == btnBuscar){
			BuscadorTablas.getInstancia().buscar(tablaAccesorios, txtBuscar.getText());
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int fila = tablaAccesorios.getSelectedRow();
		
		 txtNombre.setText(tablaAccesorios.getValueAt(fila, 1).toString());
		 txtSerial.setText(tablaAccesorios.getValueAt(fila, 2).toString());
		 txtDescripcion.setText(tablaAccesorios.getValueAt(fila, 3).toString());
		 txtPrecio.setText(tablaAccesorios.getValueAt(fila, 4).toString());
		 
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
