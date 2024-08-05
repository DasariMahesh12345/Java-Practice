package com.icd.microservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.icd.microservice.model.Icd;
@Repository
public interface IcdRepository extends JpaRepository<Icd, Integer>{

	@Query("select m from Icd m where m.icdCode=:icdCode and m.versionState='Valid'")
	
	Optional<Icd> createIcd(String icdCode);

	//@Query("select i from Icd i where i.versionState='Valid'")
	//List<Icd> findAllActiveRecords();

	
}
