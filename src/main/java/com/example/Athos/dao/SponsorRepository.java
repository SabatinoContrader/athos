package com.example.Athos.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.Athos.model.Sponsor;

public interface SponsorRepository extends CrudRepository<Sponsor, Long>{
	
	Sponsor save(Sponsor sponsor);
	//Boolean deleteById(int id);
	List<Sponsor> findAll();
	Sponsor findById(int id);
	

}
