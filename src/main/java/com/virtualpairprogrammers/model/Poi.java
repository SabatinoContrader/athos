package com.virtualpairprogrammers.model;

public class Poi {

	private int id;
	private String city;
	private String hystorical;
	

	public Poi() {
	}

	public int getId() {
		return id;
	}

	public Poi(int id, String city, String hystorical) {
		
		this.id = id;
		this.city = city;
		this.hystorical = hystorical;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHystorical() {
		return hystorical;
	}

	public void setHystorical(String hystorical) {
		this.hystorical = hystorical;
	}
}
