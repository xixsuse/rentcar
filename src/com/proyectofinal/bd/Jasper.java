package com.proyectofinal.bd;

import java.awt.BorderLayout;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.icepdf.ri.common.MyAnnotationCallback;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;

import com.proyectofinal.ui.ReporteVehiculo;


public class Jasper {
	SwingController controlador;
	Conexion bd;
	
	public void detener() {
	    if (controlador != null) {
	        controlador.closeDocument();
	    }
	}
	 
	public void destruir(JPanel panelReporte) {
	    if (controlador != null) {
	        controlador.dispose();
	        controlador = null;
	    }
	    panelReporte.removeAll();
	}
	 
	public void dibujarGIU(JPanel panelReporte){
	    controlador=new SwingController();
	    SwingViewBuilder factory = new SwingViewBuilder(controlador);
	    controlador.getDocumentViewController().setAnnotationCallback(
	            new org.icepdf.ri.common.MyAnnotationCallback(
	            controlador.getDocumentViewController()));
	 
	    MyAnnotationCallback myAnnotationCallback = new MyAnnotationCallback(
	            controlador.getDocumentViewController());
	    controlador.getDocumentViewController().setAnnotationCallback(myAnnotationCallback);
	 
	    panelReporte.setLayout(new BorderLayout());
	    JScrollPane scroll = new JScrollPane(factory.buildViewerPanel(),JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	 
	    panelReporte.add(scroll, BorderLayout.CENTER);   
	}
	
	public void generarPdf(){
		if(new File("Documentos/vehiculo.jasper").exists()){
			System.out.println("Esoooo");
		}else{
			System.out.println("Noooo");
		}
		LinkedList info;
		info = bd.getInstacia().getInformacionVehiculos();
		try{ 
		    JasperReport reporte=null;
		    reporte = (JasperReport) JRLoader.loadObject(new File("vehiculo.jasper")); 
		    JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, null, new JRBeanCollectionDataSource(info));
		    JRExporter exporter = new JRPdfExporter(); 
		    exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		    exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File("Documentos/temporal.pdf")); 
		    exporter.exportReport(); 
		}catch(JRException e){ 
		    JOptionPane.showMessageDialog(null, e.getMessage(),"Error al generar PDF", JOptionPane.ERROR_MESSAGE);
		    Logger.getLogger(ReporteVehiculo.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	public void visualizarPdf(JPanel panel_reportes){
		File file=new File("Documentos/temporal.pdf");
		final String url =file.toURI().toString();
		URL documentURL = null;
		try {
		    documentURL = new URL(url);
		} catch (MalformedURLException e) {
		}
		 
		if (documentURL != null) {
		    controlador.openDocument(documentURL);
		}
		panel_reportes.updateUI();
	}
}
