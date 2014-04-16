package com.proyectofinal.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.proyectofinal.bd.Jasper;

public class ReporteVehiculo extends JFrame {

	private JPanel contentPane;
	private JPanel panelReporte;
	private static ReporteVehiculo instancia;
	
	public static ReporteVehiculo getInstancia(){
		if(instancia  == null){
			instancia = new ReporteVehiculo();
		}
		return instancia;
	}
	
	private ReporteVehiculo() {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				Jasper jasper = new Jasper();
				jasper.generarPdf();
				jasper.dibujarGIU(panelReporte);
				jasper.visualizarPdf(panelReporte);
			}
		});
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelReporte = new JPanel();
		contentPane.add(panelReporte, BorderLayout.CENTER);
	}
}
