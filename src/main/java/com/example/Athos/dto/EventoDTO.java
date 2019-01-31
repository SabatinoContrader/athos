package com.example.Athos.dto;

import java.sql.Date;

public class EventoDTO {
	
	private int id;
	private int id_game;
	private String descr_evento;
	private Date data_inizio;
	private Date data_fine;
	
	public EventoDTO() {}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_game() {
		return id_game;
	}
	public void setId_game(int id_game) {
		this.id_game = id_game;
	}
	public String getDescr_evento() {
		return descr_evento;
	}
	public void setDescr_evento(String descr_evento) {
		this.descr_evento = descr_evento;
	}
	public Date getData_inizio() {
		return data_inizio;
	}
	public void setData_inizio(Date data_inizio) {
		this.data_inizio = data_inizio;
	}
	public Date getData_fine() {
		return data_fine;
	}
	public void setData_fine(Date data_fine) {
		this.data_fine = data_fine;
	}
	public EventoDTO(int id, int id_game, String descr_evento, Date data_inizio, Date data_fine) {
		
		this.id = id;
		this.id_game = id_game;
		this.descr_evento = descr_evento;
		this.data_inizio = data_inizio;
		this.data_fine = data_fine;
	}

}
