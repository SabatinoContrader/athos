package com.example.Athos.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Athos.converter.TeamConverter;
import com.example.Athos.converter.UserConverter;
import com.example.Athos.dao.TeamRepository;
import com.example.Athos.dto.UserDTO;
import com.example.Athos.dto.TeamDTO;
import com.example.Athos.model.Team;
import com.example.Athos.model.User;

@Service
public class TeamService {

	private TeamRepository teamRepository;

	public TeamService() {}
	
	@Autowired 
	public TeamService(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}
	
	public boolean insert(Team team) {
		teamRepository.save(team);
		return true;
	}
	
	 public List<TeamDTO> getAll() {	    	
	    	List<Team> ListTeam= (List<Team>) teamRepository.findAll();
	    	List<TeamDTO> team=new ArrayList<>();
	    	for(Team t: ListTeam) {
	    		team.add(TeamConverter.convertToDTO(t));
	    	}
	        return team;
	    }
	 
	
 }