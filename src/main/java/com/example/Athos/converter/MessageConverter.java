package com.example.Athos.converter;

import org.springframework.stereotype.Component;
import com.example.Athos.dto.MessageDTO;
import com.example.Athos.model.Message;

//@Component
public class MessageConverter {//implements Converter<Message , MessageDTO> {
	
	
	public static Message converToEntity(MessageDTO messageDTO) {
		Message message=new Message();
		message.setId(messageDTO.getId());
		message.setTipo(messageDTO.getTipo());
		message.setIdSender(messageDTO.getIdSender());
		message.setIdReceiver(messageDTO.getIdReceiver());
		return message;
	}

	
	public static MessageDTO convertToDTO(Message message) {
		MessageDTO messageDTO=new MessageDTO();
		messageDTO.setId(message.getId());
		messageDTO.setIdSender(message.getIdSender());
		messageDTO.setIdReceiver(message.getIdReceiver());
		messageDTO.setTipo(message.getTipo());
		return messageDTO;
	}
}
