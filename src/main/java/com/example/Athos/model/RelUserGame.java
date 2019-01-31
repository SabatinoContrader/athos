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
@Table(name="rel_user_game")
public class RelUserGame implements Serializable {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id;

	@ManyToOne()
    @JoinColumn(name = "id_user")  
	@NotNull
	private User id_user;
	
	@ManyToOne()
    @JoinColumn(name = "id_game")
	@NotNull
	private Game id_game;
	
	@Column(name="id_poi")
	@NotNull
	private int id_poi;
	
	/*@ManyToMany(mappedBy="users")
	private Set<Game> games = new HashSet<Game>();
	*/
	
	
    
	
	
}
	

