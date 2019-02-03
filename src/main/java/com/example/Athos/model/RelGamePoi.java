package com.example.Athos.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name="rel_game_poi")
public class RelGamePoi implements Serializable {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;

	//@JoinColumn(name = "id_poi")  
	//@ManyToOne
	@Column(name="id_poi")
	@NotNull
  private int id_poi;
	
	//@JoinColumn(name = "id_game")
	//@ManyToOne
	@NotNull
	@Column(name="id_game")
    private int id_game;
	
	@Column(name="ordine")
	@NotNull
	private int ordine;
	
	@OneToMany	(mappedBy="id")
	private List<Game> listgame=new ArrayList<>();

	@OneToMany	(mappedBy="id")
	private List<Poi> listpoi=new ArrayList<>();
		
}

