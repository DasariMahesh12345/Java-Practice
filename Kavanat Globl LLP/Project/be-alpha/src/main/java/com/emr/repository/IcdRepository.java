package com.emr.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.emr.model.IcdModel;
@Repository
public interface IcdRepository extends JpaRepository<IcdModel, Integer>{

	// Pagination search longdesc
	//@Query(value = "select * from icd10codes where  short_desc like %:Descorcode% or icd_code like %:Descorcode% ",nativeQuery=true)
	@Query("select n from IcdModel n where n.shortDesc like %:Descorcode% or n.icdCode like %:Descorcode% ")
	List<IcdModel> getIcdPagSearch(String Descorcode, Pageable pageable);
	
    //@Query(value = "select * from icd10codes where long_desc like %:search% or icd_code like %:search% ",nativeQuery=true)
	@Query("select n from IcdModel n where n.longDesc like %:search% or icdCode like %:search% ")
	 public Page<IcdModel> getIcdSearchWithString(String search , Pageable pageable);

    // post query
    @Query("select n from IcdModel n where n.id=:id and n.versionState='Valid'")
	Optional<IcdModel> getIcdVersionState(int id);
     
    
   
	
	
	

}
