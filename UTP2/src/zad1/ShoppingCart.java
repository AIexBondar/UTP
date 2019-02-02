package zad1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ShoppingCart extends Container{
	
	public HashMap<Flower,Integer> flowersList = null;
	private PriceList priceList = PriceList.getInstance();
	private Customer c;
	
	public ShoppingCart(Customer c) {
		super(c);
		this.c=c;
		flowersList = new HashMap<Flower,Integer>();
	}
	
	public HashMap<Flower, Integer> getFlowersList() {
		return flowersList;
	}
	
	
	@Override
	public String toString() {
		if(c.getPackFlag() == false) {
		System.out.println("Wózek własciciel " + c.getName());
		Iterator<Entry<Flower, Integer>> itr = flowersList.entrySet().iterator();
		
			while(itr.hasNext())
			{
			   Entry<Flower, Integer> entry = itr.next();
			   Flower f = entry.getKey();
			   
			   double cena = 0;
			   if((priceList.pList.get(entry.getKey().getNazwa())) != null) {
				   cena = priceList.getCena(f.getNazwa());
			   }else cena = -1;
			   System.out.println(f.getNazwa() + ", kolor: " + f.getKolor() + ", ilość: " + f.getIlosc() + ", cena: " + cena);  
			}
		}else if(c.getPackFlag() == true) {
			System.out.println("Wózek własciciel " + c.getName() + " -- pusto");
		}
		return "";
	}
	
	
	public void check() {
		Iterator<Entry<Flower, Integer>> itr = flowersList.entrySet().iterator();
		while(itr.hasNext())
		{
		   Entry<Flower, Integer> entry = itr.next();
		   
		   if((priceList.pList.get(entry.getKey().getNazwa())) == null) {
			   itr.remove();
		   }   
		}
	}
	
	

	public void addFlower(Flower f) {
		flowersList.put(f, f.getIlosc());	
	}
	
	public double obliczKoszyk(){ 
		double cenaTmp = 0;
		double moneyTmp = c.getCash();
		
		for (Flower key : this.flowersList.keySet()) {
			if( priceList.pList.get(key.getNazwa()) != null){
				cenaTmp = (priceList.pList.get(key.getNazwa()) * this.flowersList.get(key));
				if(moneyTmp >= cenaTmp) {
					moneyTmp -= cenaTmp;
					cenaTmp= 0;
				}else if(moneyTmp < cenaTmp) {
					this.flowersList.remove(key);
				}
					
			}
		}
		return moneyTmp;
	}
	
}
