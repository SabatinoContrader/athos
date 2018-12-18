package main.model;

public class Poi {

	private int id;
	private String city;
	private String historycal;

	public Poi() {

	}

	public Poi(int id, String city, String historycal) {

		this.id = id;
		this.city = city;
		this.historycal = historycal;
	}

	public String getCity() {
		return city;
	}

	public String getHistorycal() {
		return historycal;
	}

	public int getId() {
		return id;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setHistorycal(String historycal) {
		this.historycal = historycal;
	}

	public void setId(int id) {
		this.id = id;
	}

}
