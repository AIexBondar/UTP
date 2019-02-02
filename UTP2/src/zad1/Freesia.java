package zad1;

public class Freesia extends Flower {
	
	public Freesia(String nazwa, double cena) {
	       super(nazwa,cena);
	}
	
	public Freesia(int ilosc) {
		super(ilosc);
	}

	public Integer getIlosc() {
		return super.ilosc;
	};

	public String getKolor() {
		return "żółty";
	}
	
	public double getCena() {
		return super.cena;
	}
	
	public String getNazwa() {
		return "frezja";
	}
	
}
