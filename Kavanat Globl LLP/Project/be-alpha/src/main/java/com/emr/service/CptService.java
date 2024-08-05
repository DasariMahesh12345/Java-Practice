package com.emr.service;




import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.emr.model.CptCategoryModel;
import com.emr.model.CptModel;

@Service
public interface CptService {
	
	//add&versining state
	public CptModel createCptModel(CptModel cptReq);   
	
	
	//list
	public List<CptModel> getCptModels();   
	
	
	//search by id
	CptModel getCptModelById(int id);         
	
	//update&versining state
	public CptModel updateCptModel(int id,CptModel cptReq);
	
	//delete particular record
	void deleteCptModelById(int id);

	 //with out headers pagination
	public Page<CptModel> getCptByPagination(org.springframework.data.domain.Pageable pageable);

   

	//search with string pagination
	List<CptModel> getSearchPagination(String ShortName,Pageable pageable);

	//cpt category with search shortname,code

	public Page<CptCategoryModel> getCptSearch(String codeOrDescription, Pageable pageable);

	//with headers pagination
   public Page<CptModel> findCptPagenation(Pageable pageable);

   //pagination sorting
  public List<CptModel> getSorting(Integer pageNumber, Integer pageSize);

//cpt search with string sort pagination shortName,code
public Page<CptModel> getCptPaginationSearchwithSort(String code, Integer pageSize, Integer pageNumber, String sortBy);









}
