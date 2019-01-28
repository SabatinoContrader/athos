package com.example.Athos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="game")

public class Game implements Serializable {
	
		@Id
		@Column(name="id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)	
		private int id;
		
		@ManyToOne()
		@JoinColumn (name="id_creatore")
		private User idcreatore;
		
		@Column (name="nome")
		@NotNull
		private String nome;
		
		@Column (name="descr_percorso")
		@NotNull
		private String descrpercorso;
		
		@Column(name="versione")
		@NotNull
		private int versione;
		
		@Column(name="attivo")
		@NotNull
		private int attivo=1;
		
		@OneToMany(mappedBy="id_game")
		private Set<RelUserGame> relUserGame = new HashSet<RelUserGame>();
		
		/*@ManyToMany
		@JoinTable(name="rel_user_giochi", 
			joinColumns= {@JoinColumn(name="id_game")}, 
			inverseJoinColumns={@JoinColumn(name="id_user")})
		 private Set<User> users = new HashSet<>();
		*/
		
		
}
