package com.example.Athos.dto;

import javax.persistence.Entity;

import com.example.Athos.model.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {

	private int id;
	private User id_receiver;
	private User id_sender;
	private String text;
	
}
