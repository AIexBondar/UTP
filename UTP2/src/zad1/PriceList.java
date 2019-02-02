package zad1;

import java.util.HashMap;

public class PriceList{
	
	protected static String nazwa;
	protected static double cena;
	public volatile static PriceList instance;
	public HashMap<String,Double> pList = null;
	
	public void put(String nazwa, double cena) {
		this.nazwa = nazwa;
		this.cena = cena;
		pList.put(nazwa,cena);
	}
	
	public PriceList() {
		pList = new HashMap<String,Double>();
	}
	
	public static synchronized PriceList getInstance() {
	        if (instance == null) {
	            instance = new PriceList();
	        }
	        
	        return instance;
	    }
	
	public double getCena(String nazwa){
		return this.pList.get(nazwa);
	}

	
	
}
