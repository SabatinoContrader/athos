package com.virtualpairprogrammers.model;

public class Game {

	private int id;
	private int idCreatore;
	private String nome;
	private String descrPercorso;

	public Game() {
	}

	public Game(int id, int idCreatore, String nome, String descrPercorso) {

		this.id = id;
		this.idCreatore = idCreatore;
		this.nome = nome;
		this.descrPercorso = descrPercorso;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdCreatore() {
		return idCreatore;
	}

	public void setIdCreatore(int idCreatore) {
		this.idCreatore = idCreatore;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrPercorso() {
		return descrPercorso;
	}

	public void setDescrPercorso(String descrPercorso) {
		this.descrPercorso = descrPercorso;
	}



	


}
