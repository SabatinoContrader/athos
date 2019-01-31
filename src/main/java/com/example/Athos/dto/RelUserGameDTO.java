package com.example.Athos.dto;

import com.example.Athos.model.Game;
import com.example.Athos.model.User;

public class RelUserGameDTO {
	
	private int id;
	private User id_user;
	private Game id_game;
	private int id_poi;
	
	public RelUserGameDTO() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getId_user() {
		return id_user;
	}

	public void setId_user(User id_user) {
		this.id_user = id_user;
	}

	public Game getId_game() {
		return id_game;
	}

	public void setId_game(Game id_game) {
		this.id_game = id_game;
	}

	public int getId_poi() {
		return id_poi;
	}

	public void setId_poi(int id_poi) {
		this.id_poi = id_poi;
	}

	public RelUserGameDTO(int id, User id_user, Game id_game, int id_poi) {
		
		this.id = id;
		this.id_user = id_user;
		this.id_game = id_game;
		this.id_poi = id_poi;
	}
	
	

}
