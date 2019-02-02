/**
 *
 *  @author Weikert Robert S17092
 *
 */

package zad1;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;

public class Purchase {
	
	private VetoableChangeSupport veto = new  VetoableChangeSupport(this);
	private PropertyChangeSupport propertyChange = new PropertyChangeSupport(this);
	private String prod; //nazwa produktu
	private String data; //info(data) (bounded)
	private Double price; //cena (constrained) 

	public Purchase(String prod, String data, double price) {
		this.prod =  prod;
		this.data = data;
		this.price = price;
	}

	public synchronized void setData(String newData) throws PropertyVetoException {
		String oldData = null;
		oldData = data;
		veto.fireVetoableChange("data", oldData, newData);
		data = newData;
	}

	public synchronized void setPrice(double newPrice) throws PropertyVetoException {
		Double oldPrice = null;
		oldPrice = price;
		veto.fireVetoableChange("price", oldPrice, newPrice);
		price = newPrice;
		propertyChange.firePropertyChange("price", oldPrice, newPrice);
		
	}
	
	public synchronized void addVetoableChangeListener(VetoableChangeListener l) {
		veto.addVetoableChangeListener(l);
	}

	public synchronized void removeVetoableChangeListener(VetoableChangeListener l) {
		veto.removeVetoableChangeListener(l);
	}
	
	public synchronized void addPropertyChangeListener(PropertyChangeListener l) {
		propertyChange.addPropertyChangeListener(l);
	}

	public synchronized void removePropertyChangeListener(PropertyChangeListener l) {
		propertyChange.removePropertyChangeListener(l);
	}

	@Override
	public String toString() {
		return "Purchase [prod=" + prod + ", data=" + data + ", price=" + price + "]";
	}
}  
