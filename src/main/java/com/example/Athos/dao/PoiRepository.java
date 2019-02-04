package com.example.Athos.dao;

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
	
}
