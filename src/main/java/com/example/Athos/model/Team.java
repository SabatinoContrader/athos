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
@Table(name="team")

public class Team {//implements Serializable{
	
	public Team() {}

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;

	@Column(name="nome")
	@NotNull
	private String nome;
	
	public Team(int id, String nome) {
		super();
		this.id=id;
		this.nome=nome;
	}
	
}