package com.example.Athos.dto;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SponsorDTO {
	
	private int id;
	private String name;
	private String messaggio;
	private boolean attivo;

}
