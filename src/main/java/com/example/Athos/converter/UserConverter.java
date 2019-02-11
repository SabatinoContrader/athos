package com.example.Athos.converter;


import org.springframework.stereotype.Component;
import com.example.Athos.dto.UserDTO;
import com.example.Athos.model.User;

@Component
public class UserConverter implements Converter<User , UserDTO>{
	@Override
	public  User converToEntity(UserDTO userDTO) {
		User user=new User();
		user.setId(userDTO.getId());
		user.setRole(userDTO.getRole());
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setAttivo(userDTO.isAttivo());
		
		return user;
		
	}

	@Override
	public UserDTO convertToDTO(User user) {
		UserDTO userDTO=new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setUsername(user.getUsername());
		userDTO.setPassword(user.getPassword());
		userDTO.setRole(user.getRole());
		userDTO.setAttivo(user.isAttivo());
		
		return userDTO;
		
	}

}
