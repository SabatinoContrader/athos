package com.example.Athos.converter;
import org.springframework.*;//.Override;
import org.springframework.stereotype.Component;
import com.example.Athos.dto.MessageDTO;
import com.example.Athos.model.Message;

@Component

public class MessageConverter implements Converter<Message , MessageDTO> {
	
	@Override
	
	public  Message converToEntity(MessageDTO messageDTO) {
		Message message=new Message();
		message.setId(messageDTO.getId());
		message.setText(messageDTO.getText());
		message.setIdSender(messageDTO.getIdSender());
		message.setIdReceiver(messageDTO.getIdReceiver());
		return message;
	}

	@Override
	
	public MessageDTO convertToDTO(Message message) {
		MessageDTO messageDTO=new MessageDTO();
		messageDTO.setId(message.getId());
		messageDTO.setIdSender(message.getIdSender());
		messageDTO.setIdReceiver(message.getIdReceiver());
		messageDTO.setText(message.getText());
		return messageDTO;
	}
}
