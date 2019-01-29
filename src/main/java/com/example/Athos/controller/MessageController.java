package com.example.Athos.controller;

import com.example.Athos.services.MessageService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.example.Athos.model.Message;
import com.example.Athos.model.User;
import com.example.Athos.dto.MessageDTO;
import com.example.Athos.dto.UserDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Athos.GenericResponse;
import com.example.Athos.converter.MessageConverter;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/message")
public class MessageController {
	
	private MessageService messageService;
	//private HttpSession session;
	private MessageConverter messageConverter;
	
	@Autowired
	public MessageController(MessageService messageService) {
		this.messageService = messageService;
		this.messageConverter= messageConverter;
	}
	
	//public HttpSession getSession() 
	//{return this.session;}
	
	@RequestMapping(value = "/insertMessage" , method = RequestMethod.POST)
	public boolean insertMessage(HttpServletRequest request , @RequestBody MessageDTO messageDTO){
		Message message = messageConverter.converToEntity(messageDTO);
		messageService.insert(message);
		return true;
	}
	
	
	@CrossOrigin
	@RequestMapping(value = "/viewMessage", method = RequestMethod.GET)
	public GenericResponse<List<MessageDTO>> getAll( @RequestBody MessageDTO messageDTO){
		Message message = messageConverter.converToEntity(messageDTO);	
		List<MessageDTO> messagedto = messageService.getAll();
		return new GenericResponse<List<MessageDTO>>(0,messagedto);
	}

	//@RequestMapping(value = "/deleteMessage", method = RequestMethod.GET)
	//public String delete(@RequestParam("id") int id, Model model ) 
	//{
	//	 
	//	messageService.deleteById(id);
	//	return "messageView";
	//	}	
	//@RequestMapping(value="/deleteMessage", method=RequestMethod.GET)
	//public String delete(HttpServletRequest request, Model model) {
	//	int id = Integer.parseInt(request.getParameter("id"));
	//	messageService.deleteById(id);
	//	return "messageView";
	//} 

	
}
