package com.example.Athos.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
		@Column
		@GeneratedValue(strategy = GenerationType.IDENTITY)	
		private int id;
		
		@Column
		@NotNull
		private String name;
		
		@Column
		@NotNull
		private String messaggio;

}
