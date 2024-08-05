package com.icd.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.icd.microservice.model.Icd;
import com.icd.microservice.repository.IcdRepository;

@Service
public class IcdService {
	
	
	@Autowired
	IcdRepository icdRepository;

	public Icd createIcd(Icd icdReq) {
		// TODO Auto-generated method stub
		return icdRepository.save(icdReq);
	}

	public List<Icd> getIcd() {
		// TODO Auto-generated method stub
		return icdRepository.findAll();
	}

	public Icd getIcdCode(int id) {
		// TODO Auto-generated method stub
		return icdRepository.findById(id).get();
	}

	public void deleteIcd(int id) {
		// TODO Auto-generated method stub
		icdRepository.deleteById(id);
	}

	public Icd updateIcd(Icd icdReq) {
		// TODO Auto-generated method stub
		java.util.Optional<Icd> icdCode = icdRepository.findById(icdReq.getId());
		icdCode.ifPresent(icdcode -> {
			icdcode.setVersionState("InValid");
			icdcode.setRetired("Y");
			icdRepository.save(icdcode);
			icdReq.setRefId(icdcode.getId());
			icdReq.setOriginalRefId(icdcode.getOriginalRefId());
			icdReq.setVersionState("Valid");
			icdReq.setRetired("N");
			icdReq.setId(0);
			icdRepository.save(icdReq);
		});
		return icdReq;

	}
	
	

	public Page<Icd> getIcdSearchSorting(String icdcode, Integer pageNumber, Integer pageSize, String sortBy) {

		// TODO Auto-generated method stub
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy.equals("Newest First") ? Sort.Direction.DESC : Sort.Direction.ASC, "id"));
		 if (icdcode.length() >= 3) {
	            // Search for exact matches of code or short name
	            return icdRepository.findByCodeOrShortName(icdcode, pageable);
	        } else {
	            // Search for related codes based on code or short name using wildcard search
	            String searchQuery = "*" + icdcode.toLowerCase() + "*";
	            return icdRepository.findByCodeOrShortNameLike(searchQuery, pageable);
	        }
	}
}
	
	//try error message

	

	
