package com.example.Athos.dao;

import com.example.Athos.model.Game;
import com.example.Athos.model.RelUserGame;
import com.example.Athos.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.ArrayList;
import org.springframework.jca.cci.connection.*;

@Repository
@Transactional
public interface RelUserGameRepository extends CrudRepository<RelUserGame, Long> {

	@Modifying
	@Query(value="delete from rel_user_giochi where id_game=?", nativeQuery = true)
	int deleteById_game(int id_game);
	
}
