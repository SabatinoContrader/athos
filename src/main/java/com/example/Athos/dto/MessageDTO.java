package com.example.Athos.dto;

import com.example.Athos.model.User;

public class MessageDTO {

	private int id;
	private User id_receiver;
	private User id_sender;
	private String text;
	
	public MessageDTO() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getId_receiver() {
		return id_receiver;
	}

	public void setId_receiver(User id_receiver) {
		this.id_receiver = id_receiver;
	}

	public User getId_sender() {
		return id_sender;
	}

	public void setId_sender(User id_sender) {
		this.id_sender = id_sender;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public MessageDTO(int id, User id_receiver, User id_sender, String text) {
		
		this.id = id;
		this.id_receiver = id_receiver;
		this.id_sender = id_sender;
		this.text = text;
	}
}
