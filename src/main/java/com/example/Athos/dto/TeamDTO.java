package com.example.Athos.dto;

public class TeamDTO {
	
	private int id;
	private String nome;
	
	public TeamDTO() {}
	
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

	public TeamDTO(int id, String nome) {
		super();
		this.id= id;
		this.nome=nome;
	}

}
