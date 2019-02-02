package zad1;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DataChanger implements PropertyChangeListener {

	@Override
	public void propertyChange(PropertyChangeEvent e)  {
		System.out.println("Change value of: " + e.getPropertyName() + " from: " + e.getOldValue() + " to: " + e.getNewValue());
		
	}
}
