package com.example.Athos.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="sponsor")

public class Sponsor implements Serializable {
		
		@Id
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.IDENTITY)	
		private int id;
		
		@Column(name = "name")
		@NotNull
		private String name;
		
		@Column(name = "messagio")
		@NotNull
		private String messaggio;
		
		@Column(name = "attivo")
		@NotNull
		private boolean attivo;
}
