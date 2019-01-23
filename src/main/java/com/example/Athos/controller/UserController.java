package com.example.Athos.controller;

import com.example.Athos.dto.UserDTO;
import com.example.Athos.services.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.example.Athos.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class UserController {

	private UserService userService;
	private UserDTO userDTO;
	private HttpSession session;
	private User role;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/loginControl", method = RequestMethod.POST)
	public String loginControl(@RequestParam("username") String username, @RequestParam("password") String password,HttpServletRequest request, Model model ) {
		
		this.role = this.userService.login(username, password);
		HttpSession session = request.getSession(true);
		//String username = request.getParameter("username");
		//String password = request.getParameter("password");
		
		if (role.getRole() == 0)
		{return "homeSuper";}
		else if (role.getRole()==1)
		{return "homeGamer";}
		else if (role.getRole()==2) 
		{return "homePlayer";}	
		else 
		{model.addAttribute("feedback", "wrong");}
		return "index";
	}
	
	public HttpSession getSession() 
	{return this.session;}
	
}

