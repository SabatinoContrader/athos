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
@AllArgsConstructor
@NoArgsConstructor
@Table(name="message")
public class Message {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;

	@Column(name="id_sender")
	@NotNull
	private int id_sender;

	@Column(name="id_receiver")
	@NotNull
	private int id_receiver;

	@Column(name="text")
	@NotNull
	private String text;
	

}