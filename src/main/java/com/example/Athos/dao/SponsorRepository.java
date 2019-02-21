package com.example.Athos.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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
	
	@Modifying
	@Query(value="select * from sponsor where attivo=1 ", nativeQuery = true)
	List<Sponsor> findAttivi();
	
	@Modifying
	@Query(value="update sponsor set attivo=0 where id=?", nativeQuery = true)
	int disattivaSponsor(int id);
}
