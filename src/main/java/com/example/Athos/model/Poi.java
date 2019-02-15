package com.example.Athos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="poi")

public class Poi implements Serializable {
	
		@Id
		@Column (name="id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)	
		private int id;
				
		@Column (name="latitudine")
		@NotNull
		private String latitudine;
		
		@Column (name="longitudine")
		@NotNull
		private String longitudine;
		
		@Column (name="indizio")
		@NotNull
		private String indizio;

		
		@Column(name="attivo")
		@NotNull
		private boolean attivo=true;

			
	//	@NotNull
	//	@JoinColumn(name="id_sponsor")
	//	private int id_sponsor;
		
	//	@OneToMany(mappedBy="id")
	//	private List<Game> listgame=new ArrayList<>();
		
	//	@OneToMany	(mappedBy="id")
	//	private List<RelGamePoi> listgamepoi=new ArrayList<>();
	

}
