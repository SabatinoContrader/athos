package com.example.Athos.dto;

public class MessageDTO {

	private int id;
	private int idReceiver;
	private int idSender;
	private String text;
	
	public MessageDTO() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdReceiver() {
		return idReceiver;
	}

	public void setIdReceiver(int idReceiver) {
		this.idReceiver = idReceiver;
	}

	public int getIdSender() {
		return idSender;
	}

	public void setIdSender(int idSender) {
		this.idSender = idSender;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public MessageDTO(int id, int idReceiver, int idSender, String text) {
		//super();
		this.id = id;
		this.idReceiver = idReceiver;
		this.idSender = idSender;
		this.text = text;
	}
}
