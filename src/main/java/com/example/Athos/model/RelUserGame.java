package com.example.Athos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
@Table(name="rel_user_game_team")
public class RelUserGame implements Serializable {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;

	@ManyToOne()
    @JoinColumn(name = "id_user")  
	private User id_user;
	
	@ManyToOne()
    @JoinColumn(name = "id_game")
	private Game id_game;
	
	@ManyToOne()
    @JoinColumn(name = "id_poi")
	private Poi id_poi;
	
	@ManyToOne()
    @JoinColumn(name = "id_team")
	private Team id_team;
	
	@Column (name="data_inizio")
	private Date data_inizio;
	
	@Column (name="data_fine")
	private Date data_fine;
	
	@Column(name="attivo")
	@NotNull
	private boolean attivo=true;

	
}
	

