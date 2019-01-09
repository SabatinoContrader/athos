package com.virtualpairprogrammers.model;

public class Game {

	private int id;
	private String name;
	private int gamerId;
	private String location;
	private String help;

	public Game() {
	}

	public Game(int id, String name, int gamerId, String location, String help) {

		this.id = id;
		this.name = name;
		this.gamerId = gamerId;
		this.location = location;
		this.help = help;
	}

	public int getGamerId() {
		return gamerId;
	}

	public String getHelp() {
		return help;
	}

	public long getId() {
		return id;
	}

	public String getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}

	public void setGamerId(int gamerId) {
		this.gamerId = gamerId;
	}

	public void setHelp(String help) {
		this.help = help;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setName(String name) {
		this.name = name;
	}

}
