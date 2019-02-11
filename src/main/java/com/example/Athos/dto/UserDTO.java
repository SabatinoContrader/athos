package com.example.Athos.dto;

import java.util.Date;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
	
	private int id;
	private int role;
	private String username;
	private String password;
	private boolean attivo;
	private Date data_iscrizione;
}
