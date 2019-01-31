package com.example.Athos.dto;

import com.example.Athos.model.Game;
import com.example.Athos.model.Team;

public class RelTeamGameDTO {

	private int id;
	private Team id_team;
	private Game id_game;
	private int id_poi;
	
	public RelTeamGameDTO() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Team getId_team() {
		return id_team;
	}

	public void setId_team(Team id_team) {
		this.id_team = id_team;
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

	public RelTeamGameDTO(int id, Team id_team, Game id_game, int id_poi) {
		
		this.id = id;
		this.id_team = id_team;
		this.id_game = id_game;
		this.id_poi = id_poi;
	}
	
	
}
