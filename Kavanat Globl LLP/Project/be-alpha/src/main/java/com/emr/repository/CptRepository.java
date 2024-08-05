
package com.emr.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emr.model.CptModel;

@Repository
public interface CptRepository  extends JpaRepository<CptModel, Integer>{
	//search with string pagination
	 @Query("select c from CptModel c where c.shortName like %:shortName%")
	 public Page<CptModel> getSearchPagination(String shortName, Pageable pageable);

	
		
		
	  //cpt search with string sort pagination shortName,code
		  @Query("select c from CptModel c where c.shortName like %:code% or c.code like %:code%") 
		  public Page<CptModel> getCptPaginationSearchwithSort(String code, Pageable pageable);
		 
		  
		  @Query("select c from CptModel c where c.code=:code and c.versionState='Valid'")
		  public Optional<CptModel> getByCptModelCodeAndVersionState(String code);



		




		
		
	


}
