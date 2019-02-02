package zad1;

import javax.swing.ImageIcon;

public class Panstwo {
	String nazwa,stolica;
	double populacja;
	ImageIcon flaga;
	
	public Panstwo(String nazwa, String stolica, double populacja, ImageIcon flaga) {
		super();
		this.nazwa = nazwa;
		this.stolica = stolica;
		this.populacja = populacja;
		this.flaga = flaga;
	}
	
	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public String getStolica() {
		return stolica;
	}

	public void setStolica(String stolica) {
		this.stolica = stolica;
	}

	public double getPopulacja() {
		return populacja;
	}

	public void setPopulacja(double aValue) {
		this.populacja = aValue;
	}

	public ImageIcon getFlaga() {
		return flaga;
	}

	public void setFlaga(ImageIcon flaga) {
		this.flaga = flaga;
	}

	
}
