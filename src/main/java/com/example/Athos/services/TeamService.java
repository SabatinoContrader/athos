package com.example.Athos.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Athos.converter.TeamConverter;

import com.example.Athos.dao.TeamRepository;
import com.example.Athos.dto.TeamDTO;
import com.example.Athos.model.Team;

@Service
public class TeamService {

	private TeamRepository teamRepository;
	private TeamConverter teamConverter;

	public TeamService() {}
	
	@Autowired 
	public TeamService(TeamRepository teamRepository, TeamConverter teamCoverter) {
		this.teamRepository = teamRepository;
		this.teamConverter = teamConverter;
	}
	
	public boolean insert(Team team) {
		teamRepository.save(team);
		return true;
	}
	
	 public List<TeamDTO> getAll() {	    	
	    	List<Team> ListTeam= (List<Team>) teamRepository.findAll();
	    	List<TeamDTO> team=new ArrayList<>();
	    	for(Team t: ListTeam) {
	    		team.add(teamConverter.convertToDTO(t));
	    	}
	        return team;
	    }
	 
		public Team findById(int id) {
			Team team = teamRepository.findById(id);	
				return team;	
		}
		
 }