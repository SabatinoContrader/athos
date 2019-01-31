package com.example.Athos.dto;

public class PoiDTO {

	private int id;
	private int id_sponsor;
	private String indizio;
	private String latitudine;
	private String longitudine;
	
	public PoiDTO() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_sponsor() {
		return id_sponsor;
	}

	public void setId_sponsor(int id_sponsor) {
		this.id_sponsor = id_sponsor;
	}

	public String getIndizio() {
		return indizio;
	}

	public void setIndizio(String indizio) {
		this.indizio = indizio;
	}

	public String getLatitudine() {
		return latitudine;
	}

	public void setLatitudine(String latitudine) {
		this.latitudine = latitudine;
	}

	public String getLongitudine() {
		return longitudine;
	}

	public void setLongitudine(String longitudine) {
		this.longitudine = longitudine;
	}

	public PoiDTO(int id, int id_sponsor, String indizio, String latitudine, String longitudine) {
		
		this.id = id;
		this.id_sponsor = id_sponsor;
		this.indizio = indizio;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
	}
	
	
}
