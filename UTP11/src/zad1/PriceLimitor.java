package zad1;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

public class PriceLimitor implements VetoableChangeListener {

	@Override
	public void vetoableChange(PropertyChangeEvent e) throws PropertyVetoException {
		
		if(e.getPropertyName().equals("price") && ((Double) e.getNewValue() < 1000.0)) 
			throw new PropertyVetoException("Price change to: " + e.getNewValue() + " not allowed", e);
	}
}

