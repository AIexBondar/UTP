/**
 *
 *  @author Weikert Robert S17092
 *
 */

package zad2;

public class Purchase {
	String id_klienta;
	String nazwisko;
	String imie;
	String nazwa_towaru;
	double cena;
	double zakupiona_ilość;
	double koszt;

	public Purchase(String id_klienta,String nazwisko, String imie, String nazwa_towaru, double cena, double zakupiona_ilość, double koszt) {
		this.id_klienta = id_klienta;
		this.nazwisko = nazwisko;
		this.imie = imie;
		this.nazwa_towaru = nazwa_towaru;
		this.cena = cena;
		this.zakupiona_ilość = zakupiona_ilość;
		this.koszt = koszt;
	}
	
	@Override
	public String toString() {
		return id_klienta + ";" + nazwisko + " " + imie + ";" + nazwa_towaru + ";" + cena + ";" + zakupiona_ilość;
	}

	public String getId_klienta() {
		return id_klienta;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public String getImie() {
		return imie;
	}

	public String getNazwa_towaru() {
		return nazwa_towaru;
	}

	public double getCena() {
		return cena;
	}

	public double getZakupiona_ilość() {
		return zakupiona_ilość;
	}

	public double getKoszt() {
		return koszt;
	}
	
}
