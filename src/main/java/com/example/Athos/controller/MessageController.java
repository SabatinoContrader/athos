package com.example.Athos.controller;

import com.example.Athos.services.MessageService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import com.example.Athos.model.Message;
import com.example.Athos.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@CrossOrigin(value = "*")
@RequestMapping("/message")
public class MessageController {
	
	private MessageService messageService;
	private HttpSession session;
	
	@Autowired
	public MessageController(MessageService messageService) {
		this.messageService = messageService;
	}
	
	public HttpSession getSession() 
	{return this.session;}
	
	@RequestMapping(value = "/insertMessage" , method = RequestMethod.POST)
	public boolean insertMessage(HttpServletRequest request ,Model model){
		int id = Integer.parseInt(request.getParameter("id"));
		int idSender = Integer.parseInt(request.getParameter("idSender"));
		int idReceiver = Integer.parseInt(request.getParameter("idReceiver"));
		String text = request.getParameter("text");
		Message message = new Message(0,idReceiver, idSender, text);
		messageService.insert(message);
		return true;
	}
	
	@CrossOrigin
	@RequestMapping(value = "/viewMessage", method = RequestMethod.GET)
	public List<MessageDTO> getAll(){
		List<MessageDTO> message = messageService.getAll();
		return message;
	}
	
	
}
