package com.icd.microservice.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.icd.microservice.model.Icd;
@Repository
public interface IcdRepository extends JpaRepository<Icd, Integer> {
	
	@Query("select m from Icd m where m.shortDesc like %:icdcode% or m.icdCode like %:icdcode%")
	Page<Icd> findByCodeOrShortName(String icdcode, Pageable pageable);
	
	@Query("select t from Icd t where t.shortDesc like %:searchQuery% or t.icdCode like %:searchQuery%")
	Page<Icd> findByCodeOrShortNameLike(String searchQuery, Pageable pageable);
	

}
