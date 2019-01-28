package com.example.Athos.controller;

import com.example.Athos.dto.TeamDTO;
import com.example.Athos.services.TeamService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.example.Athos.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@CrossOrigin(value = "*")
@RequestMapping("/team")
public class TeamController {
	
	private TeamService teamService;
	private HttpSession session;
	
	@Autowired
	public TeamController(TeamService teamService) {
		this.teamService = teamService;	
	}
	
	public HttpSession getSession() 
	{return this.session;}
	
	@RequestMapping(value = "/insertTeam" , method = RequestMethod.POST)
	public boolean insertTeam(HttpServletRequest request ,Model model){
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
		//boolean attivo = request.getParameter("attivo");
		
		Team team = new Team(0, nome,true);//, attivo);
		teamService.insert(team);
		return true;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/viewTeam", method = RequestMethod.GET)
	public List<TeamDTO> getAll(){
		List<TeamDTO> team = teamService.getAll();
		return team;
	}
		
	
}
