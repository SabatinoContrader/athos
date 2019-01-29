package com.example.Athos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Athos.dao.UserRepository;
import com.example.Athos.model.User;
import com.example.Athos.dto.UserDTO;
import com.example.Athos.converter.UserConverter;
import java.util.List;
import java.util.ArrayList;

@Service
public class UserService {

	private UserRepository userRepository;
	private UserConverter userConverter;
	
	public UserService() {}

	@Autowired 
	public UserService(UserRepository userRepository,UserConverter userConverter) {

		this.userRepository = userRepository;
		this.userConverter = userConverter;
	}
	
	    public UserRepository getUserRepository() {
	    	return this.userRepository;
	    }
	
	
	public User login(String username, String password) {
		User user = userRepository.findByUsernameAndPassword(username,password);
		//UserDTO userDTO = userConverter.convertToDTO(user);
		return user;
	}


	 public List<UserDTO> getAll(int role) {	    	
	    	List<User> ListUser= (List<User>) this.userRepository.findUserByRole(role);
	    	List<UserDTO> user=new ArrayList<>();
	    	for(User u: ListUser) {
	    		user.add(userConverter.convertToDTO(u));
	    	}
	        return user;
	    }
	 
	 public User insert(UserDTO userDTO) {
		 User user = userConverter.converToEntity(userDTO);
		 return this.userRepository.save(user);
		 	 }
	 
	 
	  }
