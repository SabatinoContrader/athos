package com.example.Athos.dao;

import com.example.Athos.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.ArrayList;
import org.springframework.jca.cci.connection.*;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Long> {


	User findUserByUsernameAndPassword(String username, String password);
	

	User findByUsernameAndPassword(String username, String password);
	
	List<User> findUserByRole(int role);
	
	User save(User user);
	

	
}
