package com.emr.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.emr.model.IcdCategoryModel;
import com.emr.model.IcdModel;

@Service
public interface IcdService {

	List<IcdModel> getIcd();

	IcdModel getById(Integer id);

	IcdModel createIcd(IcdModel icdModel);

	IcdModel updateIcd(Integer id, IcdModel icdUpdateReq);

	void deltById(Integer id);

	Page<IcdModel> getPagination(Pageable pageable);

	List<IcdModel> getIcdPagSearch(String Descorcode, Pageable pageable);

	
	//List<IcdModel> getIcdSorting(Integer pageNumber, Integer pageSize);

	Page<IcdModel> getIcdSearchWithString(String search, Integer pageNumber, Integer pageSize, String sortBy);

	Page<IcdCategoryModel> getIcdSearchName(String icdNameCode, Pageable pageable);

	

	
	

	





	

	

}
