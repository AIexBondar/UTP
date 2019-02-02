package zad1;

public class Rose extends Flower{

	public Rose(String nazwa, double cena) {
	       super(nazwa,cena);
	}
	
	public Rose(int ilosc) {
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
		return "róża";
	}

}
