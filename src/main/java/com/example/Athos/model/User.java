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
@Table(name="user")
public class User {
	
//public User() {}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@Column(name="id")
	private int id;

	@Column(name="username")
	@NotNull
	private String username;

	@Column(name="password")
	@NotNull
	private String password;

	@Column(name="role")
	@NotNull
	private int role;
	
	@Column(name="attivo")
	@NotNull
	private boolean attivo;

	//public User(int id, String username, String password, int role) {
	//	this();
	//	this.id=id;
	//	this.username=username;
	//	this.password=password;
	//	this.role=role;
	//}
}