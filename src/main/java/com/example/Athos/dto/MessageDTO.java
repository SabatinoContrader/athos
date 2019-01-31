package com.example.Athos.dto;

public class MessageDTO {

	private int id;
	private int id_receiver;
	private int id_sender;
	private String text;
	
	public MessageDTO() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_receiver() {
		return id_receiver;
	}

	public void setId_receiver(int id_receiver) {
		this.id_receiver = id_receiver;
	}

	public int getId_sender() {
		return id_sender;
	}

	public void setId_sender(int id_sender) {
		this.id_sender = id_sender;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public MessageDTO(int id, int id_receiver, int id_sender, String text) {
		
		this.id = id;
		this.id_receiver = id_receiver;
		this.id_sender = id_sender;
		this.text = text;
	}
}
