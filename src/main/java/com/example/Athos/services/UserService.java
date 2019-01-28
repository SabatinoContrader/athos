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
	
	public UserService() {}

	@Autowired 
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User login(String username, String password) {
		User user = (User) this.userRepository.findUserByUsernameAndPassword(username,password);
		if (user == null) 
		{
			return null;
		}
		else 
		{
				return user;
		}
	}
//	public List<UserDTO> getAll(){
//				
//		List<User> listaUser = (List<User>) this.userRepository.findAll();
//		List<UserDTO> user= new ArrayList<>();
//		listaUser.forEach(i->user.add(UserConverter.convertToDTO(i)));
//		return user;
//	}

	 public List<UserDTO> getAll(int role) {	    	
	    	List<User> ListUser= (List<User>) this.userRepository.findAllByRole(role);
	    	List<UserDTO> user=new ArrayList<>();
	    	for(User u: ListUser) {
	    		user.add(UserConverter.convertToDTO(u));
	    	}
	        return user;
	    }
	 
	 public User insert(UserDTO userDTO) {
		 User user = UserConverter.converToEntity(userDTO);
		 return this.userRepository.save(user);
		 	 }
	 
	 
	  }
