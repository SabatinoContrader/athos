package com.example.Athos.controller;

import com.example.Athos.dto.UserDTO;
import com.example.Athos.services.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.example.Athos.model.User;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin
@RequestMapping("/Login")
public class UserController {

	private UserService userService;
	private UserDTO userDTO;
	private HttpSession session;
	private User user;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

//	@RequestMapping(value = "/loginControl", method = RequestMethod.POST)
//	public String loginControl(@RequestParam("username") String username, @RequestParam("password") String password,HttpServletRequest request, Model model ) {
//		
//		this.user = this.userService.login(username, password);
//		HttpSession session = request.getSession(true);
//		this.session = request.getSession();
//		
//		if (user.getRole() == 0)
//		{return "homeSuper";}
//		else if (user.getRole()==1)
//		{return "homeGamer";}
//		else if (user.getRole()==2) 
//		{return "homePlayer";}	
//		else 
//		{model.addAttribute("feedback", "wrong");}
//		return "index";
//	}

	@CrossOrigin
	@RequestMapping(value = "/viewUser", method = RequestMethod.GET)
	public List<UserDTO> getAll(int role){
		List<UserDTO> user = userService.getAll(role);
		return user;
	}
	
	public HttpSession getSession() 
	{return this.session;}
	
	@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	public String delete(@RequestParam("id") int id, Model model ) 
	{
		
		userService.deleteById(id);
		return "userView";
		}
	
	@RequestMapping(value="/deleteUser", method=RequestMethod.GET)
	public String delete(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		userService.deleteById(id);
		return "userView";
	} 
	
	@RequestMapping(value = "/logoutControl", method = RequestMethod.GET)
	public String logoutControl(HttpServletRequest request, Model model ) {
		return "index";
	}
	
	@RequestMapping(value = "/loginControl", method = RequestMethod.POST)
	public String loginControl(HttpServletRequest request, Model model ) {
		
		this.session = request.getSession();
		//HttpSession session = request.getSession(true);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		this.user = this.userService.login(username, password);
		if (user.getRole() == 0)
		{return "homeSuper";}
		else if (user.getRole()==1)
		{return "homeGamer";}
		else if (user.getRole()==2) 
		{return "homePlayer";}	
		else 
		{model.addAttribute("feedback", "wrong");}
		return "index";
		
	}
	
}

