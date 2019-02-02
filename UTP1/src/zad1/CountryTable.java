package zad1;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CountryTable extends JTable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String countriesFile;
	private MyTableModel model;
	
	public CountryTable(String countriesFileName) {
		this.countriesFile = countriesFileName;
		this.setRowHeight(65);
	}
	
	public CountryTable create() {
		model = new MyTableModel(countriesFile);
		this.setModel(model);

		 this.setDefaultRenderer(Double.class, new DefaultTableCellRenderer(){
	            @Override
	            public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column) {
	                Component cell = super.getTableCellRendererComponent(table,value,isSelected,hasFocus,row,column);
	                cell.setForeground((double) value<20000000 ? Color.BLACK : Color.RED);
	                return cell;
	            }
	        });
		
		return this;
	}
	
}
