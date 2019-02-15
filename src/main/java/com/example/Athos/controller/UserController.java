package com.example.Athos.controller;

import com.example.Athos.dto.UserDTO;
import com.example.Athos.services.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import com.example.Athos.model.Game;
import com.example.Athos.model.User;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.Athos.converter.UserConverter;
import com.example.Athos.GenericResponse;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/Login")
public class UserController {

	private UserService userService;
	//private HttpSession session;
	private UserConverter userConverter;
	
	@Autowired
	public UserController(UserService userService, UserConverter userConverter) {		
		this.userService = userService;
		this.userConverter = userConverter;
	}

	@CrossOrigin
	@RequestMapping(value = "/viewUser", method = RequestMethod.GET)
	public GenericResponse<List<UserDTO>> getAll(HttpServletRequest request, @RequestBody UserDTO userDTO){ 
		User user = userConverter.converToEntity(userDTO);
		List<UserDTO> userdto = userService.getAll(user.getRole());
		return new GenericResponse<List<UserDTO>>(0,userdto);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/viewPlayers", method = RequestMethod.GET)
	public GenericResponse<List<UserDTO>> getAll(HttpServletRequest request){//, @RequestBody UserDTO userDTO){ 
		List<UserDTO> userdto = userService.getAll(2);
		return new GenericResponse<List<UserDTO>>(0,userdto);
	}
	
	@RequestMapping(value = "/logoutControl", method = RequestMethod.GET)
	public String logoutControl(HttpServletRequest request, @RequestBody UserDTO userDTO ) {
		return "index";
	}
	
	@RequestMapping(value = "/loginControl", method = RequestMethod.POST)
	public UserDTO loginControl(HttpServletRequest request, @RequestBody UserDTO userDTO){ 
		

		 UserDTO userDTO2 = userService.login(userDTO.getUsername(),userDTO.getPassword());
		 
		 return userDTO2;
				
		 //userService.login(userDTO.getUsername(),userDTO.getPassword());
		// if (role == 0) {return userDTO;} //"homesuper"
		 //else if (role ==1) {return userDTO;} //"homegamer"
		 //else if (role ==2) {return userDTO;} //"homeplayer"
		 //else {userDTO = null;}
		 //return userDTO;
				
	}
	@RequestMapping(value = "/insertUser", method = RequestMethod.POST)
	public boolean save(@RequestBody UserDTO userDTO , HttpServletRequest request) {
		userService.insert(userDTO);
		return true;

	}
}

