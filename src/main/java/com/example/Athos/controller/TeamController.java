package com.example.Athos.controller;


import com.example.Athos.dto.TeamDTO;
import com.example.Athos.dto.UserDTO;
import com.example.Athos.services.TeamService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Holder;

import org.springframework.ui.Model;
import com.example.Athos.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Athos.GenericResponse;
import com.example.Athos.converter.TeamConverter;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/team")
public class TeamController {
	
	private TeamService teamService;
	private HttpSession session;
	private TeamConverter teamConverter;
	
	@Autowired
	public TeamController(TeamService teamService, TeamConverter teamConverter) {
		this.teamService = teamService;	
		this.teamConverter= teamConverter;
	}
	
	public HttpSession getSession() 
	{return this.session;}
	
	
	@RequestMapping(value = "/insertTeam" , method = RequestMethod.POST)
	public boolean insertTeam(HttpServletRequest request , @RequestBody TeamDTO teamDTO){
		//Team team =  teamConverter.converToEntity(teamDTO);
		//teamService.insertplayers(listuser);
		
		this.session = request.getSession();
		teamService.insert(teamDTO);
		
		return true;
	}
	
	@RequestMapping(value = "/insertPlayers" , method = RequestMethod.POST)
	public void insertPlayers(HttpServletRequest request , @RequestBody List<UserDTO> listuser) {//UserDTO userDTO ){
			this.session = request.getSession();
		Team team = teamService.findLastId();
		 teamService.insertplayers(listuser,team);		
		
	}
	
	@CrossOrigin
	@RequestMapping(value = "/viewTeam", method = RequestMethod.GET)
	public GenericResponse<List<TeamDTO>> getAll(@RequestBody TeamDTO teamDTO){
		Team team = teamConverter.converToEntity(teamDTO);
		List<TeamDTO> teamdto = teamService.getAll();
		return new GenericResponse<List<TeamDTO>>(0,teamdto);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/viewNameTeam", method = RequestMethod.GET)
	public List<String> getNameTeam(){
		List<String> teamName = teamService.getTeamName();
		//return new GenericResponse<List<TeamDTO>>(0,teamName);
		return teamName;
	}
	
}
