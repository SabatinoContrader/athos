package com.example.Athos.dto;

import com.example.Athos.model.Game;
import com.example.Athos.model.Poi;

public class RelGamePoiDTO {

	private int id;
	private int ordine;
	private Game id_game;
	private Poi id_poi;
	
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

	public Game getId_game() {
		return id_game;
	}

	public void setId_game(Game id_game) {
		this.id_game = id_game;
	}

	public Poi getId_poi() {
		return id_poi;
	}

	public void setId_poi(Poi id_poi) {
		this.id_poi = id_poi;
	}

	public RelGamePoiDTO(int id, int ordine, Game id_game, Poi id_poi) {
		
		this.id = id;
		this.ordine = ordine;
		this.id_game = id_game;
		this.id_poi = id_poi;
	}
	
	
}
