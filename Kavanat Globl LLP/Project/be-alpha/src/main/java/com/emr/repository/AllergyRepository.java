package com.emr.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emr.model.AllergyModel;

@Repository
public interface AllergyRepository extends JpaRepository<AllergyModel, Integer> {

	
    //create query
	@Query( "select a from AllergyModel a where a.id=:id and a.versionState='Validated'")
	Optional<AllergyModel> createAllergyModel(int id);
	
	//Pagination search with string
  @Query( "select a from AllergyModel a where a.allergyDesc like %:searchString% or a.damConceptId"
  		+ " like %:searchString%  ")
	List<AllergyModel> getPageSearch(String searchString, Pageable pageable);
    // pagination search string with sort order
  @Query( "select a from AllergyModel a where a.allergyDesc like %:allergy% ")
    List<AllergyModel> getAllergySearchPag(String allergy, Pageable pageable);

}

