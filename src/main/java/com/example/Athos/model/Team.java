package com.example.Athos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="team")

public class Team implements Serializable {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;

	@Column(name="nome")
	@NotNull
	private String nome;
	
	//@Column(name="id_user")
	//@NotNull
	//private User id_user;
	@ManyToOne
	@JoinColumn (name="id_user")	
	private User id_user;	
	
	@Column(name="attivo")
	@NotNull
	private boolean attivo = true;
	
	

	@Column (name="data_creazione")
	private Date data_creazione;

	@ManyToMany
	@JoinTable(name="rel_user_team", 
	joinColumns= {@JoinColumn(name="id_team")}, 
	inverseJoinColumns={@JoinColumn(name="id_user")})
	 private Set<User> users = new HashSet<>();
	

}