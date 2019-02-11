package com.example.Athos.dto;

import javax.persistence.Entity;

import com.example.Athos.model.Sponsor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PoiDTO {

	private int id;
	private String indizio;
	private String latitudine;
	private String longitudine;
	private boolean attivo;
		
}
