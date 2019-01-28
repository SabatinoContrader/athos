package com.example.Athos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.example.Athos.model.Team;
import com.example.Athos.model.User;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.jca.cci.connection.*;

@Repository
@Transactional
public interface TeamRepository extends CrudRepository<Team, Long>{
	
	Team save(Team team);
	
	Boolean deleteById(int id);
	
	List <Team> findAll();
}

