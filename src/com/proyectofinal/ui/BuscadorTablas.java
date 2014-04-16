package com.proyectofinal.ui;

import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class BuscadorTablas {
	private static BuscadorTablas instancia = null;

	public static BuscadorTablas getInstancia() {
		if (instancia == null) {
			instancia = new BuscadorTablas();
		}
		return instancia;
	}
	
	private BuscadorTablas(){}

	public void buscar(JTable tabla, String valorBusqueda) {
		TableRowSorter<TableModel> modeloOrdenado = new TableRowSorter<TableModel>(tabla.getModel());
		tabla.setRowSorter(modeloOrdenado);
		int numeroColumnas = tabla.getColumnCount();
		for (int i = 0; i < numeroColumnas; i++) {
			modeloOrdenado.setRowFilter(RowFilter.regexFilter("(?i)"
					+ valorBusqueda, i));
			int count = tabla.getRowCount();
			if (count < 1) {
				continue;
			} else {
				break;
			}
		}
		tabla.setModel(tabla.getModel());
	}

}
