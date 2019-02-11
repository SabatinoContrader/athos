package com.example.Athos.dto;


import java.util.Date;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.Athos.model.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamDTO {
	
	private int id;
	private String nome;
	private boolean attivo;

	private Date data_creazione;
	

	private User id_user;
	

}
