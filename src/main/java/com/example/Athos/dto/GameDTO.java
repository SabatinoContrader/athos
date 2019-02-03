package com.example.Athos.dto;

import com.example.Athos.model.User;

public class GameDTO {
	
	private int id;
	private int id_creatore;
	private String nome;
	private String descr_percorso;
	private int versione;
	private boolean attivo;
	
	public GameDTO() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_creatore() {
		return id_creatore;
	}

	public void setId_creatore(int id_creatore) {
		this.id_creatore = id_creatore;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescr_percorso() {
		return descr_percorso;
	}

	public void setDescr_percorso(String descr_percorso) {
		this.descr_percorso = descr_percorso;
	}

	public int getVersione() {
		return versione;
	}

	public void setVersione(int versione) {
		this.versione = versione;
	}

	public boolean isAttivo() {
		return attivo;
	}

	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}

	public GameDTO(int id, int id_creatore, String nome, String descr_percorso, int versione, boolean attivo) {
	
		this.id = id;
		this.id_creatore = id_creatore;
		this.nome = nome;
		this.descr_percorso = descr_percorso;
		this.versione = versione;
		this.attivo = attivo;
	}
	

}
