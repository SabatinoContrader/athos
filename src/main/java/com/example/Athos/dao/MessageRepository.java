package com.example.Athos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.example.Athos.model.Message;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.jca.cci.connection.*;

@Repository
@Transactional
public interface MessageRepository extends CrudRepository<Message, Long>{
	Message save(Message message);
	//Boolean deleteById(int id);
	List<Message> findAll();
	Message findById(int id);
	//List<Message> findByIdSender(int id_sender);
	//List<Message> findByIdReceiver(int id_receiver);
	
	@Modifying
	@Query(value="select text from message", nativeQuery = true)
	List<String> getText();
}
