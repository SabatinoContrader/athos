package com.virtualpairprogrammers.model;

public class Label {

	private long id;
	private long orders;
	private String description;
	private long idGame;

	public Label() {

	}

	public Label(long id, long orders, String description, long idGame) {

		this.id = id;
		this.orders = orders;
		this.description = description;
		this.idGame = idGame;
	}

	public long getId() {
		return id;
	}
	
	public long getOrders() {
		return orders;
	}
	
	public String getDescription() {
		return description;
	}

	public long getIdGame() {
		return idGame;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setOrders(long orders) {
		this.orders = orders;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	public void setIdGame(long idGame) {
		this.idGame = idGame;
	}

	

}
