package com.example.Athos.dto;

import java.util.Date;

import com.example.Athos.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class GameDTO {
	
	private int id;
	private User id_creatore;
	private String nome;
	private String descr_percorso;
	private int versione;
	private boolean attivo;
	private String descrevento;
	private Date data_inizio;
	private Date data_fine;
}