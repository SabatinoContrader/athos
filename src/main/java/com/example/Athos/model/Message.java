package com.example.Athos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.persistence.Table;

@Getter
@Setter
@Entity
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name="message")

public class Message {//implements Serializable{
	
	public Message() {}

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;

	@Column(name="idSender")
	@NotNull
	private int idSender;

	@Column(name="idReceiver")
	@NotNull
	private int idReceiver;

	@Column(name="tipo")
	@NotNull
	private String tipo;
	
	public Message(int id, int idSender, int idReceiver, String tipo) {
		super();
		this.id=id;
		this.idSender=idSender;
		this.idReceiver=idReceiver;
		this.tipo=tipo;
	}

}