package com.example.Athos.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.Athos.model.Sponsor;
@Repository
@Transactional
public interface SponsorRepository extends CrudRepository<Sponsor, Long>{
	
	Sponsor save(Sponsor sponsor);
	//Boolean deleteById(int id);
	List<Sponsor> findAll();
	Sponsor findById(int id);
	

}
