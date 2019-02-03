package com.example.Athos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user")
public class User {
	
	
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
	
	@OneToMany	(mappedBy="id_game")
	private List<RelUserGame> listgame=new ArrayList<>();

	@OneToMany	(mappedBy="id")
	private List<Team> listteam=new ArrayList<>();


	//@OneToMany(mappedBy = "id_user")
	//private Set<RelUserGame> relUserGame = new HashSet<RelUserGame>();
	 
	/*public void addUserGiochi(RelUserGame userGame) {
        this.userGame.add(userGame);
    }*/
}