package com.emr.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.emr.model.AllergyModel;

@Service
public interface AllergyService {

	List<AllergyModel> getAllergy();

	AllergyModel getById(int id);

	void delateById(int id);

	//AllergyModel addAllergy(AllergyModel allergyModel);

	AllergyModel createAllergyModel(AllergyModel allergyModelRes);

	AllergyModel updateAllergy(int id, AllergyModel allergyReq);

	Page<AllergyModel> getPage(Pageable pageable);

	List<AllergyModel> getPageSearch(String searchString, Pageable pageable);

	List<AllergyModel> getAllergySearchPag(String allergy, Integer pageNumber, Integer pageSize, String soryBy);

	

	


	

	
	
}
