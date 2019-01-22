package com.example.Athos.controller;

import com.example.Athos.dto.UserDTO;
import com.example.Athos.services.UserService;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/Login")
public class UserController {

	private UserService userService;
	private UserDTO userDTO;
	private HttpSession session;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/loginControl", method = RequestMethod.POST)
	public String loginControl(HttpServletRequest request, Model model ) {
		
		this.session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean role = this.userService.login(username, password);
		if (role)
		{return "homeSuper";}
		//else if (role==1)
		//{return "homeGamer";}
		//else if (role==2) 
		//{return "homePlayer";}	
		else 
		{model.addAttribute("feedback", "wrong");}
		return "index";
	}
	
	public HttpSession getSession() 
	{return this.session;}
	
}

