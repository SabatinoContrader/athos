package com.example.Athos.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Athos.converter.MessageConverter;
import com.example.Athos.dao.MessageRepository;
import com.example.Athos.dto.MessageDTO;
import com.example.Athos.model.Message;

@Service
public class MessageService {

	private MessageRepository messageRepository;
	private MessageConverter messageConverter;
	
	public MessageService() {}

	@Autowired 
	public MessageService(MessageRepository messageRepository, MessageConverter messageConverter) {
		this.messageRepository = messageRepository;
		this.messageConverter = messageConverter;
	}
	
	public Message insert(MessageDTO messageDTO) {
		Message message = messageConverter.converToEntity(messageDTO);
		
		return this.messageRepository.save(message);
	}
	 public List<MessageDTO> getAll() {	    	
	    	List<Message> ListMessage= (List<Message>) messageRepository.findAll();
	    	List<MessageDTO> message=new ArrayList<>();
	    	for(Message m: ListMessage) {
	    		message.add(messageConverter.convertToDTO(m));
	    	}
	        return message;
	    }
		public Message findById(int id) {
			Message message = messageRepository.findById(id);	
				return message;	
		}
		
		 public List<String> getText() {	    	
		    	List<String> listMessage= (List<String>) messageRepository.getText();
		        return listMessage;
		    }
	 
	 // public void deleteById(int id) {
	  //  	this.messageRepository.deleteById(id);}
}
