package com.example.Athos.dto;

import com.example.Athos.model.Game;
import com.example.Athos.model.Poi;

public class RelGamePoiDTO {

	private int id;
	private int ordine;
	private int id_game;
	private int id_poi;
	
	public RelGamePoiDTO() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrdine() {
		return ordine;
	}

	public void setOrdine(int ordine) {
		this.ordine = ordine;
	}

	public int getId_game() {
		return id_game;
	}

	public void setId_game(int id_game) {
		this.id_game = id_game;
	}

	public int getId_poi() {
		return id_poi;
	}

	public void setId_poi(int id_poi) {
		this.id_poi = id_poi;
	}

	public RelGamePoiDTO(int id, int ordine, int id_game, int id_poi) {
		
		this.id = id;
		this.ordine = ordine;
		this.id_game = id_game;
		this.id_poi = id_poi;
	}
	
	
}
