package zad1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class Box extends Container{

	protected HashMap<Flower,Integer> products = null;
	public PriceList priceList = PriceList.getInstance();
	
	public Box(Customer c) {
		super(c);
	}
	
	public HashMap<Flower,Integer> getProducts(){
		return products;
	}
	
	@Override
	public String toString() {
		System.out.println("Pudełko własciciel " + super.c.getName());
		Iterator<Entry<Flower, Integer>> itr = products.entrySet().iterator();
		while(itr.hasNext())
		{
			
		   Entry<Flower, Integer> entry = itr.next();
		   Flower f = entry.getKey();
	
		   System.out.println(f.getNazwa() + ", kolor: " + f.getKolor() + ", ilość: " + f.getIlosc() + ", cena: " + priceList.getCena(entry.getKey().getNazwa())); 
		}
		return "";
	}
}
