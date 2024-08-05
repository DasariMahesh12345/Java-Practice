package com.emr.service;

import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.emr.cpt.codesystem.util.ListUtils;
import com.emr.model.CptCategoryModel;
import com.emr.model.CptModel;
import com.emr.repository.CptCategoryRepository;
import com.emr.repository.CptRepository;
@Service
public class CptServiceImp implements CptService {
	
	@Autowired
	CptRepository cptRepository;
	
	@Autowired
	CptCategoryRepository cptCategoryRepository;

	private String Properties;

	//changing version state imp logic
	@Override
	public CptModel createCptModel(CptModel cptReq) {
		// TODO Auto-generated method stub 
		Optional<CptModel> existingCode = cptRepository.getByCptModelCodeAndVersionState(cptReq.getCode());
		if (existingCode.isPresent()) {
			return existingCode.get();
		} else {
			CptModel savedCpt = cptRepository.save(cptReq);
			savedCpt.setRefId(savedCpt.getId());
			savedCpt.setOrgRefId(savedCpt.getId());
			 savedCpt.setVersionState("VALID");
			 
		}
		return cptRepository.save(cptReq);
	}

	@Override
	public List<CptModel> getCptModels() {
		// TODO Auto-generated method stub
		return cptRepository.findAll() ;
	}

	

	
	/*
	 * @Override public CptModel updateCptModel(int id, CptModel cptReq) { // TODO
	 * Auto-generated method stub CptModel cptmdl=cptRepository.getById(id);
	 * cptmdl.setId(cptReq.getId()); cptmdl.setCode(cptReq.getCode());
	 * cptmdl.setShortName(cptReq.getShortName());
	 * cptmdl.setDescription(cptReq.getDescription());
	 * cptmdl.setIsHCPCS(cptReq.getIsHCPCS());
	 * cptmdl.setModifiedBy(cptReq.getModifiedBy());
	 * cptmdl.setCreatedBy(cptReq.getCreatedBy());
	 * cptmdl.setModifiedDate(cptReq.getModifiedDate());
	 * cptmdl.setCreatedDate(cptReq.getCreatedDate()); return
	 * cptRepository.save(cptmdl); }
	 */
	 
	
	
	@Override
	public CptModel getCptModelById(int id) {
		// TODO Auto-generated method stub
		return cptRepository.findById(id).get() ;
	}
	
	  @Override public void deleteCptModelById(int id) {
		  // TODO Auto-generated method stub 
	  cptRepository.deleteById(id);
	  
	  }
	  
	  //with out headers pagination
	@Override
	public Page<CptModel> getCptByPagination(org.springframework.data.domain.Pageable pageable) {
		// TODO Auto-generated method stub
		return cptRepository.findAll(pageable);
	}
	//with headers pagination
	@Override
	public Page<CptModel> findCptPagenation(Pageable pageable) {
		// TODO Auto-generated method stub
		
		return cptRepository.findAll(pageable) ;
	}
	
	//search with string pagination
	@Override
	public List<CptModel> getSearchPagination(String ShortName, Pageable pageable) {
		// TODO Auto-generated method stub
		return cptRepository.getSearchPagination(ShortName,pageable).getContent();
	}

	// version 2nd 
	@Override
	public CptModel updateCptModel(int id, CptModel cptReq) {
		// TODO Auto-generated method stub
		Optional<CptModel> existingcode = cptRepository.findById(cptReq.getId());
		existingcode.ifPresent(existingCode -> {
			// Updating Existing Code
			existingCode.setVersionState("InValid");
			existingCode.setRetired("Y");
			cptRepository.save(existingCode);
			// Inserting Modified Code As New One
			cptReq.setRefId(existingCode.getId());
			cptReq.setOrgRefId(existingCode.getOrgRefId());
			cptReq.setVersionState("Valid");
			cptReq.setRetired("N");
			cptReq.setId(0);
			cptRepository.save(cptReq);
		});
		return cptReq;
	}
	
	//cpt category with search shortname,code
	
	
	//pagenation sorting
@Override
public List<CptModel> getSorting(Integer pageNumber, Integer pageSize) {
	// TODO Auto-generated method stub
	Pageable pageable = PageRequest.of(pageNumber, pageSize,Direction.DESC,"id");
	return cptRepository.findAll(pageable).getContent();
}

//cpt search with string sort pagination shortName,code
@Override
public Page<CptModel> getCptPaginationSearchwithSort(String code, Integer pageSize, Integer pageNumber, String sortBy) {
	// TODO Auto-generated method stub
	Pageable pageable;
	if (sortBy.equals("Oldest First")) {
		pageable=PageRequest.of(pageNumber, pageSize,Sort.by(Direction.ASC,"code"));
	}else {
		pageable=PageRequest.of(pageNumber, pageSize,Sort.by(Direction.DESC,"code"));
	}
	return cptRepository.getCptPaginationSearchwithSort(code,pageable);
    }

@Override
public Page<CptCategoryModel> getCptSearch(String codeOrDescription, Pageable pageable) {
	// TODO Auto-generated method stub
	List<CptCategoryModel> cptList = cptCategoryRepository.getCptSearch(codeOrDescription);
	// List<CptCategory> filteredCptList= ListUtils.getPage(cptList,
	// pageable.getPageNumber()+1, pageable.getPageSize());
	// return new PageImpl<CptCategory>(filteredCptList,pageable,cptList.size());
	Sort sort = pageable.getSort();
	List<CptCategoryModel> sortedItems = cptList.stream().sorted((o1, o2) -> {
		for (Order order : sort) {
			int comparisonResult = compareItemsByProperty(o1, o2, order.getProperty());
			if (comparisonResult != 0) {
				return order.isAscending() ? comparisonResult : -comparisonResult;
			}
		}
		return 0;
	}).collect(Collectors.toList());
	int startIndex = pageable.getPageNumber() * pageable.getPageSize();
	int endIndex = Math.min(startIndex + pageable.getPageSize(), sortedItems.size());
	List<CptCategoryModel> pageOfItems = sortedItems.subList(startIndex, endIndex);
	return new PageImpl<>(pageOfItems, pageable, sortedItems.size());
}
private int compareItemsByProperty(CptCategoryModel o1, CptCategoryModel o2, String property) {
	switch (property) {
	case "short_name":
		return o1.getShortName().compareTo(o2.getShortName());
	case "code":
		return o1.getCode().compareTo(o2.getCode());
	// cptMajorCategory
	// ... add more cases for additional properties
	default:
		throw new IllegalArgumentException("Unknown sort property: " + property);
	}
	
}



	
}
	
	
	

	
	

	
	
	
	
	 

