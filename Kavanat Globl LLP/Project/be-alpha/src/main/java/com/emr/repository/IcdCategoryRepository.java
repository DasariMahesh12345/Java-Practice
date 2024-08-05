package com.emr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emr.model.IcdCategoryModel;
@Repository
public interface IcdCategoryRepository extends JpaRepository<IcdCategoryModel, Integer> {
	
	
	@Query(value = "CALL getIcdSearchName(:icdNameCode)", nativeQuery = true)
	List<IcdCategoryModel> getIcdSearchName(String icdNameCode);

	
}
