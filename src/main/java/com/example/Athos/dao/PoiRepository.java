package com.example.Athos.dao;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.example.Athos.model.Poi;

public interface PoiRepository extends CrudRepository<Poi, Long>{
	
	Poi save(Poi poi);
	List<Poi> findAll();
	Poi findById(int id_poi);
	
}
