package com.example.Athos.controller;

import com.example.Athos.dto.UserDTO;
import com.example.Athos.services.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.example.Athos.model.User;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
	public UserController(UserService userService) {		
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
	
	
	@RequestMapping(value = "/logoutControl", method = RequestMethod.GET)
	public String logoutControl(HttpServletRequest request,@RequestBody UserDTO userDTO ) {
		return "index";
	}
	
	@RequestMapping(value = "/loginControl", method = RequestMethod.POST)
	public GenericResponse<UserDTO> loginControl(HttpServletRequest request, @RequestBody UserDTO userDTO){ 
		User user = userConverter.converToEntity(userDTO);
		user = userService.login(user.getUsername(),user.getPassword());
		if (user!=null)
		{
			UserDTO userdto = userConverter.convertToDTO(user);
			return new GenericResponse<UserDTO>(0,userdto);
		}
		else
		{
			return new GenericResponse<UserDTO>(1,null);
		}
		
	}
}

