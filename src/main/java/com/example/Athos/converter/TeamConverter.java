package com.example.Athos.converter;

import org.springframework.stereotype.Component;
import com.example.Athos.dto.TeamDTO;
import com.example.Athos.model.Team;

//@Component
public class TeamConverter {//implements Converter<Team , TeamDTO> {
	
	//@Override
	public static Team converToEntity(TeamDTO teamDTO) {
		Team team=new Team();
		team.setId(teamDTO.getId());
		team.setNome(teamDTO.getNome());
		return team;
	}

	//@Override
	public static TeamDTO convertToDTO(Team team) {
		TeamDTO teamDTO=new TeamDTO();
		teamDTO.setId(team.getId());
		teamDTO.setNome(team.getNome());
		return teamDTO;
		}
}
