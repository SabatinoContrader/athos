package com.virtualpairprogrammers.model;

public class Poi {

	private int id;
	private float latitudine;
	private float longitudine;
	private int idSponsor;
	private String indizio;

	public Poi() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getLatitudine() {
		return latitudine;
	}

	public void setLatitudine(float latitudine) {
		this.latitudine = latitudine;
	}

	public float getLongitudine() {
		return longitudine;
	}

	public void setLongitudine(float longitudine) {
		this.longitudine = longitudine;
	}

	public int getIdSponsor() {
		return idSponsor;
	}

	public void setIdSponsor(int idSponsor) {
		this.idSponsor = idSponsor;
	}

	public String getIndizio() {
		return indizio;
	}

	public void setIndizio(String indizio) {
		this.indizio = indizio;
	}

	public Poi(int id, float latitudine, float longitudine, int idSponsor, String indizio) {
		
		this.id = id;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
		this.idSponsor = idSponsor;
		this.indizio = indizio;
	}
}
