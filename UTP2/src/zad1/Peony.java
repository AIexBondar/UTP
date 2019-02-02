package zad1;

public class Peony extends Flower {

	public Peony(String nazwa, double cena) {
	       super(nazwa,cena);
	}
	
	public Peony(int ilosc) {
		super(ilosc);
	}

	public Integer getIlosc() {
		return super.ilosc;
	};

	public String getKolor() {
		return "czerwony";
	}
	
	public double getCena() {
		return super.cena;
	}
	
	public String getNazwa() {
		return "piwonia";
	}

}
