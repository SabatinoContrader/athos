package com.virtualpairprogrammers.model;

public class Sponsor {

	private int id;
	private String name;
	private String description;

	public Sponsor() {

	}

	public Sponsor (int id, String name, String description) {

		this.id = id;
		this.name = name;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
