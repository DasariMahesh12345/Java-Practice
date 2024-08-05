package com.emr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emr.model.CptCategoryModel;
@Repository
public interface CptCategoryRepository extends JpaRepository<CptCategoryModel, Integer>{
	
	
	@Query(value = "CALL getCptSearch(:codeOrDescription)",nativeQuery = true)
	List<CptCategoryModel> getCptSearch(String codeOrDescription);

	
	
	
	
}
