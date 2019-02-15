package com.example.Athos.dto;


import javax.persistence.Entity;

import com.example.Athos.model.Game;
import com.example.Athos.model.Poi;
import com.example.Athos.model.Sponsor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.example.Athos.model.Game;
import com.example.Athos.model.Poi;
import com.example.Athos.model.Team;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RelGamePoiDTO {

	private int id;
	private int ordine;
	private Game id_game;
	private Poi id_poi;
	private Sponsor id_sponsor;
}
