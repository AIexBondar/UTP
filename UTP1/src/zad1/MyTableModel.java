package zad1;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String countriesPath;
	private String[] columnNames;
	private String[] columnData;
	private String textLine;
	private URL url;
	private BufferedImage img;
	private ImageIcon icon;
	private List<Panstwo> list = new ArrayList<>();
	
	
	public MyTableModel(String countriesFile) {
		this.countriesPath = countriesFile;

		File file = new File(countriesPath);
		BufferedReader bufferedReader = null;
		
		 try {
			 FileReader fileReader = new FileReader(file);
			 bufferedReader = new BufferedReader(fileReader);
		   } catch (FileNotFoundException e) {
		       System.out.println("Blad otwierania pliku");
		       e.printStackTrace();
		   }
		 
		 try {
			 textLine = bufferedReader.readLine();
			 columnNames = textLine.split("\\t");
			 
			 while((textLine = bufferedReader.readLine()) != null){
				columnData = textLine.split("\\t");
				
				if(columnData.length <= 3) {
					url = new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/5/55/Brak_obrazka.svg/600px-Brak_obrazka.svg.png");
		            img = ImageIO.read(url);
		            icon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(70,50,Image.SCALE_SMOOTH));
					this.list.add(new Panstwo(columnData[0],columnData[1],Integer.parseInt(columnData[2]),icon));
					 
				}else {
					url = new URL(columnData[3]);
		            img = ImageIO.read(url);
		            icon = new ImageIcon(new ImageIcon(img).getImage().getScaledInstance(70,50,Image.SCALE_SMOOTH));
					this.list.add(new Panstwo(columnData[0],columnData[1],Integer.parseInt(columnData[2]),icon));
				}	 
			  }
			 
		   } catch (IOException e) {
		       System.out.println("Blad odczytu pliku");
		       e.printStackTrace();
		   }
		 
	}


	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public String getColumnName(int arg0) {
		return columnNames[arg0];
	}

	@Override
	public int getRowCount() {
		return list.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		
		switch(arg1) {
			case 0: 
				return list.get(arg0).getNazwa();
			case 1: 
				return list.get(arg0).getStolica();
			case 2: 
				return list.get(arg0).getPopulacja();
			case 3: 
				return list.get(arg0).getFlaga();
		}
	
		return null;
	}

	@Override
	public boolean isCellEditable(int arg0, int arg1) {
		if(arg1==2) return true;
	       return false; 
	}


	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Panstwo p = list.get(rowIndex);
		p.setPopulacja((double) aValue);
		list.set(rowIndex, p);
        fireTableCellUpdated(rowIndex, columnIndex);
		
	}
	
	public void addRow(Panstwo p){
		this.list.add(p);
	}
	
	public void removeRow(int i) {
		list.remove(i);
	}
	
	@Override
	public Class<?> getColumnClass(int column) {
		Object value=this.getValueAt(0,column);
		return (value==null?Object.class:value.getClass());
	}

}

