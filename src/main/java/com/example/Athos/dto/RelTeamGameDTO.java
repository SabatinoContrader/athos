package com.example.Athos.dto;

import com.example.Athos.model.Game;
import com.example.Athos.model.Team;

public class RelTeamGameDTO {

	private int id;
	private int id_team;
	private int id_game;
	private int id_poi;
	
	public RelTeamGameDTO() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_team() {
		return id_team;
	}

	public void setId_team(int id_team) {
		this.id_team = id_team;
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

	public RelTeamGameDTO(int id, int id_team, int id_game, int id_poi) {
		
		this.id = id;
		this.id_team = id_team;
		this.id_game = id_game;
		this.id_poi = id_poi;
	}
	
	
}
