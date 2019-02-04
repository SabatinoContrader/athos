package com.example.Athos.controller;

import com.example.Athos.dto.MessageDTO;
import com.example.Athos.dto.TeamDTO;
import com.example.Athos.services.TeamService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;

import com.example.Athos.model.Message;
import com.example.Athos.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	//private HttpSession session;
	private TeamConverter teamConverter;
	
	@Autowired
	public TeamController(TeamService teamService) {
		this.teamService = teamService;	
		this.teamConverter= teamConverter;
	}
	
	//public HttpSession getSession() 
	//{return this.session;}
	
	
	
	
	@RequestMapping(value = "/insertTeam" , method = RequestMethod.POST)
	public boolean insertTeam(HttpServletRequest request , @RequestBody TeamDTO teamDTO){
		Team team =  teamConverter.converToEntity(teamDTO);
		teamService.insert(team);
		return true;
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "/viewTeam", method = RequestMethod.GET)
	public GenericResponse<List<TeamDTO>> getAll(@RequestBody TeamDTO teamDTO){
		Team team = teamConverter.converToEntity(teamDTO);
		List<TeamDTO> teamdto = teamService.getAll();
		return new GenericResponse<List<TeamDTO>>(0,teamdto);
	}
	
}
