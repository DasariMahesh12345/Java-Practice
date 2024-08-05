package com.icd.microservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.icd.microservice.model.Icd;
import com.icd.microservice.repository.IcdRepository;

@Service
public class icdService {
	@Autowired
	IcdRepository icdRepository;
	//@Autowired
	//IcdGroupingRepository icdGroupingRepository;

	public Icd createIcd(Icd icdReq) {
		// TODO Auto-generated method stub
		Optional<Icd> existingIcd = icdRepository.createIcd(icdReq.getIcdCode());
		if (existingIcd.isPresent()) {
			return existingIcd.get();
		} else {
			Icd icd = icdRepository.save(icdReq);
			icd.setRefId(icd.getId());
			icd.setOriginalRefId(icd.getId());

		}
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

	public Icd updateIcd(Icd icdReq) {
		// TODO Auto-generated method stub
		Optional<Icd> icdCode = icdRepository.findById(icdReq.getId());
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

	public void deleteIcd(int id) {
		// TODO Auto-generated method stub
		icdRepository.deleteById(id);
	}

//page pagination
	public Page<Icd> getIcdPagination(Pageable pageable) {
		// TODO Auto-generated method stub
		return icdRepository.findAll(pageable);
	}
	



}
