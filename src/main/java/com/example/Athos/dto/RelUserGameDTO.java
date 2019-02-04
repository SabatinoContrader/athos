package com.example.Athos.dto;

import com.example.Athos.model.Game;
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
private int id_poi;

}