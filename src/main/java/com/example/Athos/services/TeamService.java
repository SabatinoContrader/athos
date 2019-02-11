package com.example.Athos.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Athos.converter.TeamConverter;
import com.example.Athos.converter.UserConverter;
import com.example.Athos.dao.TeamRepository;
import com.example.Athos.dao.UserRepository;
import com.example.Athos.dto.TeamDTO;
import com.example.Athos.dto.UserDTO;
import com.example.Athos.model.Team;
import com.example.Athos.model.User;

@Service
public class TeamService {

	private TeamRepository teamRepository;
	private TeamConverter teamConverter;
	private UserConverter userConverter;
	private UserRepository userRepository;
	
	public TeamService() {}
	
	@Autowired 
	public TeamService(TeamRepository teamRepository, TeamConverter teamConverter, UserConverter userConverter, UserRepository userRepository) {
		this.teamRepository = teamRepository;
		this.teamConverter = teamConverter;
		this.userConverter = userConverter;
	}
	
	public Team insert(TeamDTO teamDTO) {
		 Team team = teamConverter.converToEntity(teamDTO);
		 
		 return this.teamRepository.save(team);
		
	}
	
	 public List<TeamDTO> getAll() {	    	
	    	List<Team> ListTeam= (List<Team>) teamRepository.findAll();
	    	List<TeamDTO> team=new ArrayList<>();
	    	for(Team t: ListTeam) {
	    		team.add(teamConverter.convertToDTO(t));
	    	}
	        return team;
	    }
	 public void insertplayers(List<UserDTO> listuser, Team team) {//UserDTO userDTO , Team team) {	  
		    
		    List<User> squadra =new ArrayList<>();
	    	for(UserDTO u: listuser) {
	    		User user = userConverter.converToEntity(u);	
	    		 teamRepository.saveplayers(user,team);
	    		squadra.add(user);	
	    	}
	    }
	 
		public Team findById(int id) {
			Team team = teamRepository.findById(id);	
				return team;	
		}
		
	public Team findLastId() {
		Team team = teamRepository.findTopByOrderByIdDesc();
		return team;
	}	
	
	public List<String> getTeamName() {	    	
    	List<String> ListTeamName= (List<String>) teamRepository.AllTeamName();
    	//List<TeamDTO> teamName=new ArrayList<>();
    	//for(Team t: ListTeamName) {
    	//	teamName.add(teamConverter.convertToDTO(t));
    	//}
        return ListTeamName;
    }
 }