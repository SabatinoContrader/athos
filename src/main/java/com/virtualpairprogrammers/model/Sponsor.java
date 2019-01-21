package com.virtualpairprogrammers.model;

public class Sponsor {

	private int id;
	private String name;
	private String messaggio;

	public Sponsor() {

	}

	public Sponsor (int id, String name, String messaggio) {

		this.id = id;
		this.name = name;
		this.messaggio = messaggio;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
