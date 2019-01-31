package com.example.Athos.dto;

public class SponsorDTO {
	
	private int id;
	private String nome;
	private String descrizione;
	private String messaggio;
	private boolean attivo;
	
	public SponsorDTO() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getMessaggio() {
		return messaggio;
	}

	public void setMessaggio(String messaggio) {
		this.messaggio = messaggio;
	}

	public boolean isAttivo() {
		return attivo;
	}

	public void setAttivo(boolean attivo) {
		this.attivo = attivo;
	}

	public SponsorDTO(int id, String nome, String descrizione, String messaggio, boolean attivo) {
		
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.messaggio = messaggio;
		this.attivo = attivo;
	}
	
	

}
