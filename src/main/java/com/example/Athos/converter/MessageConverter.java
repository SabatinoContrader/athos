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
		message.setId_sender(messageDTO.getId_sender());
		message.setId_receiver(messageDTO.getId_receiver());
		return message;
	}

	@Override
	
	public MessageDTO convertToDTO(Message message) {
		MessageDTO messageDTO=new MessageDTO();
		messageDTO.setId(message.getId());
		messageDTO.setId_sender(message.getId_sender());
		messageDTO.setId_receiver(message.getId_receiver());
		messageDTO.setText(message.getText());
		return messageDTO;
	}
}
