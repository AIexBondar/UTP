package zad1;

public class Lilac extends Flower{

	public Lilac(String nazwa, double cena) {
	       super(nazwa,cena);
	}
	
	public Lilac(int ilosc) {
		super(ilosc);
	}

	public Integer getIlosc() {
		return super.ilosc;
	};

	public String getKolor() {
		return "biały";
	}
	
	public double getCena() {
		return super.cena;
	}
	
	public String getNazwa() {
		return "bez";
	}
	
}
