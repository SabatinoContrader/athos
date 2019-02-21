package com.example.Athos.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Athos.converter.RelUserGameConverter;
import com.example.Athos.converter.UserConverter;
import com.example.Athos.dao.RelUserGameRepository;
import com.example.Athos.dao.UserRepository;
import com.example.Athos.dto.GameDTO;
import com.example.Athos.dto.RelUserGameDTO;
import com.example.Athos.dto.UserDTO;
import com.example.Athos.model.Game;
import com.example.Athos.model.RelUserGame;
import com.example.Athos.model.User;

@Service
public class RelUserGameService {

	private RelUserGameRepository relUserGameRepository;
	private UserConverter userConverter;
	private RelUserGameConverter  relUserGameConverter;
	

	@Autowired 
	public RelUserGameService(RelUserGameRepository relUserGameRepository, UserConverter userConverter, RelUserGameConverter relUserGameConverter) {
		this.relUserGameRepository = relUserGameRepository;
		this.userConverter= userConverter;
		this.relUserGameConverter = relUserGameConverter;
	}
	
	public boolean saveRelUserGame(RelUserGame relUserGame) {
		relUserGameRepository.save(relUserGame);		
		return true;	
	}
	
	public List<RelUserGame> chiGiocatoGioco(int id_game) {
		return relUserGameRepository.chiGiocatoGioco(id_game);	
	}
	
	public List<RelUserGame> diverso(int id_game) {
		return relUserGameRepository.findById_game(id_game);	
	}
	
	public List<RelUserGame> findAll() {
		return relUserGameRepository.findAll();	
	}
	
	public int disattiva(int id) {

		return relUserGameRepository.disattiva(id);
		
	}
	public List<RelUserGameDTO> findXGiocatore(UserDTO userDTO) {
		
		User user=userConverter.converToEntity(userDTO);
		List<RelUserGame> game =  relUserGameRepository.findXGiocatore(user);
		List<RelUserGameDTO> gameDTO= new ArrayList<>();
		game.forEach(i->gameDTO.add(relUserGameConverter.convertToDTO(i)));
		return gameDTO;
		
	}
public List<RelUserGameDTO> giochiFiniti(UserDTO userDTO) {
		
		User user=userConverter.converToEntity(userDTO);
		List<RelUserGame> game =  relUserGameRepository.giochiFiniti(user);
		List<RelUserGameDTO> gameDTO= new ArrayList<>();
		game.forEach(i->gameDTO.add(relUserGameConverter.convertToDTO(i)));
		return gameDTO;
		
	}
}
