package zad1;

public abstract class Flower {

    protected String nazwa;
    protected double cena;
    protected String kolor;
    protected Integer ilosc;

    public Flower(String nazwa, double cena) {
        this.nazwa = nazwa;
        this.cena = cena;
    }

   public Flower(int ilosc) {
		this.ilosc = ilosc;
	}

   abstract String getKolor();
    abstract Integer getIlosc();
    abstract String getNazwa();

}
