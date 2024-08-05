package com.emr.service;

import java.util.List;
import java.util.Optional;
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

import com.emr.model.IcdCategoryModel;
import com.emr.model.IcdModel;
import com.emr.repository.CptCategoryRepository;
import com.emr.repository.IcdCategoryRepository;
import com.emr.repository.IcdRepository;


@Service
public class IcdServiceImp implements IcdService{

	@Autowired
	IcdRepository icdRepository;
	@Autowired
	IcdCategoryRepository icdCategoryRepository;
	
	@Override
	public List<IcdModel> getIcd() {
		// TODO Auto-generated method stub
		return icdRepository.findAll() ;
	}

	@Override
	public IcdModel getById(Integer id) {
		// TODO Auto-generated method stub
		return icdRepository.findById(id).get();
	}
	
	@Override
	public IcdModel createIcd(IcdModel icdModel) {
		// TODO Auto-generated method stub
		Optional<IcdModel> existingcode=icdRepository.getIcdVersionState(icdModel.getId());
		if(existingcode.isPresent()) {
			return existingcode.get();
		}
		else {
			IcdModel savedIcd = icdRepository.save(icdModel);
			savedIcd.setRefId(savedIcd.getId());
			savedIcd.setOriginalRefId(savedIcd.getId());
			savedIcd.setVersionState("VALID");
		}
		return icdRepository.save(icdModel);
		
	}

	@Override
	public IcdModel updateIcd(Integer id, IcdModel icdUpdateReq) {
		// TODO Auto-generated method stub
		Optional<IcdModel> existingcode = icdRepository.findById(icdUpdateReq.getId());
		existingcode.ifPresent(existingCode -> {
			// Updating Existing Code
			existingCode.setVersionState("InValid");
			existingCode.setRetired("Y");
			icdRepository.save(existingCode);
			// Inserting Modified Code As New One
			icdUpdateReq.setRefId(existingCode.getId());
			icdUpdateReq.setOriginalRefId(existingCode.getOriginalRefId());
			icdUpdateReq.setVersionState("Valid");
			icdUpdateReq.setId(0);
			icdRepository.save(icdUpdateReq);
		});
		return icdUpdateReq;
	}

	@Override
	public void deltById(Integer id) {
		// TODO Auto-generated method stub
		icdRepository.deleteById(id);
	}

	@Override
	public Page<IcdModel> getPagination(Pageable pageable) {
		// TODO Auto-generated method stub
		return icdRepository.findAll(pageable) ;
	}

	@Override
	public List<IcdModel> getIcdPagSearch(String Descorcode, Pageable pageable) {
		// TODO Auto-generated method stub
		return icdRepository.getIcdPagSearch(Descorcode,pageable);
	}

	
	/*
	 * @Override public List<IcdModel> getIcdSorting(Integer pageNumber, Integer
	 * pageSize) { // TODO Auto-generated method stub Pageable pageable
	 * =PageRequest.of(pageNumber, pageSize,Direction.DESC,"id"); // Note:present
	 * working DESC order based on id return
	 * icdRepository.findAll(pageable).getContent(); //DESC replace with ASC it
	 * maintain ASC order }
	 */
	
	@Override
	public Page<IcdModel> getIcdSearchWithString(String search, Integer pageNumber, Integer pageSize, String sortBy) {
		// TODO Auto-generated method stub
		Pageable pageable;
		if (sortBy.equals("oldest_First")) {
			pageable = PageRequest.of(pageNumber, pageSize,Sort.by(Sort.Direction.ASC,"id"));    
		}else {
			pageable = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC,"id"));
		}
		return icdRepository.getIcdSearchWithString(search,pageable);
	}

	@Override
	public Page<IcdCategoryModel> getIcdSearchName(String icdNameCode, Pageable pageable) {
		// TODO Auto-generated method stub
		List<IcdCategoryModel> iCDList = icdCategoryRepository.getIcdSearchName(icdNameCode);
		
		Sort sort = pageable.getSort();
		List<IcdCategoryModel> sortedItems = iCDList.stream().sorted((o1, o2) -> {
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
		List<IcdCategoryModel> pageOfItems = sortedItems.subList(startIndex, endIndex);
		return new PageImpl<>(pageOfItems, pageable, sortedItems.size());
	}
	private int compareItemsByProperty(IcdCategoryModel o1, IcdCategoryModel o2, String property) {
		switch (property) {
		case "short_desc":
			return o1.getShortDesc().compareTo(o2.getShortDesc());
		case "icd_code":
			return o1.getIcdCode().compareTo(o2.getIcdCode());
		// cptMajorCategory
		// ... add more cases for additional properties
		default:
			throw new IllegalArgumentException("Unknown sort property: " + property);
		}
	}

	
	

	

	

	
	
}
