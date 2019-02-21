package com.example.Athos.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import javax.transaction.Transactional;
import com.example.Athos.model.Poi;

@Repository
@Transactional
public interface PoiRepository extends CrudRepository<Poi, Long>{
	
	Poi save(Poi poi);
	List<Poi> findAll();
	Poi findById(int id_poi);
	
	@Modifying
	@Query(value="select * from poi where attivo=1 ", nativeQuery = true)
	List<Poi> findAttivi();
	
	@Modifying
	@Query(value="update poi set attivo=0 where id=?", nativeQuery = true)
	int disattivaPoi(int id);
}
