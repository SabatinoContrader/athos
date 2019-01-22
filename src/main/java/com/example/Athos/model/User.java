package com.example.Athos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {
	
public User() {}

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;

	@Column
	@NotNull
	private String username;

	@Column
	@NotNull
	private String password;

	@Column
	@NotNull
	private int role;

	public User(int id, String username, String password, int role) {
		this();
		this.id=id;
		this.username=username;
		this.password=password;
		this.role=role;
	}
}