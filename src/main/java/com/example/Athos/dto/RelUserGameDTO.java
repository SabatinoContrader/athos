package com.example.Athos.dto;

import java.util.Date;

import com.example.Athos.model.Game;
import com.example.Athos.model.Poi;
import com.example.Athos.model.Team;
import com.example.Athos.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class RelUserGameDTO {
	
		private int id;
		private User id_user;
		private Game id_game;
		private Poi id_poi;
		private Team id_team;
		private Date data_inizio;
		private Date data_fine;

}