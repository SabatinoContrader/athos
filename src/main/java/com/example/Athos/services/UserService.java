package com.example.Athos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Athos.dao.UserRepository;
import com.example.Athos.model.User;

@Service
public class UserService {

	private UserRepository userRepository;

	@Autowired 
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User login(String username, String password) {
		User user = this.userRepository.findByUsernameAndPassword(username,password);
		if (user == null) 
		{
			return null;
		}
		else 
		{
				return user;
		}
	}
}
