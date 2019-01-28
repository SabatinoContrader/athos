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

	//@Modifying
	//@Query(value = "select u from user u where u.username like ?1 and u.password like ?2")
	User findUserByUsernameAndPassword(String username, String password);
	
	//@Modifying
	//@Query(value = "select u from user u where u.role like ?1 ")
	List <User> findAllByRole(int role);
	
	User save(User user);
	
	
	
}
