package main.model;

public class POI {

	private long id;
	private String city;
	private String historycal;
	
public POI() {
	
}
	public long getId() {
		return id;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getHistorycal() {
		return historycal;
	}
	
	public void setHistorycal(String historycal) {
		this.historycal = historycal;
	}

	public POI(long id, String city, String historycal) {
		
		this.id = id;
		this.city = city;
		this.historycal = historycal;
	}
	

}
