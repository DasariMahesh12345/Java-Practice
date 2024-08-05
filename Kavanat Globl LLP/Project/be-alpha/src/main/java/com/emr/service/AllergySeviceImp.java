package com.emr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.emr.model.AllergyModel;
import com.emr.repository.AllergyRepository;

@Service
public class AllergySeviceImp implements AllergyService{

	@Autowired
	AllergyRepository allergyRepository;

	@Override
	public List<AllergyModel> getAllergy() {
		// TODO Auto-generated method stub
		return allergyRepository.findAll() ;
	}

	@Override
	public AllergyModel getById(int id) {
		// TODO Auto-generated method stub
		return allergyRepository.findById(id).get();
	}

	@Override
	public void delateById(int id) {
		// TODO Auto-generated method stub
		allergyRepository.deleteById(id);
	}

	@Override
	public AllergyModel createAllergyModel(AllergyModel allergyModelRes) {
		// TODO Auto-generated method stub
		Optional<AllergyModel> Allergy = allergyRepository.createAllergyModel(allergyModelRes.getId());
		if(Allergy.isPresent()) {
		 return Allergy.get();
		}else {
			AllergyModel allergyModel = allergyRepository.save(allergyModelRes);
			allergyModel.setRefId(allergyModel.getId());
			allergyModel.setOrgRefId(allergyModel.getId());
			
		}
		return allergyRepository.save(allergyModelRes) ;
	}

	@Override
	public AllergyModel updateAllergy(int id, AllergyModel allergyReq) {
		// TODO Auto-generated method stub
		Optional<AllergyModel> existingCode = allergyRepository.findById(allergyReq.getId());
		existingCode.ifPresent(existingcode ->{
			//updating existing code
			existingcode.setVersionState("InValid");
			existingcode.setStatus("Y");
			allergyRepository.save(existingcode);
			// Inserting Modified Code As New One
			allergyReq.setRefId(existingcode.getId());
			allergyReq.setOrgRefId(existingcode.getOrgRefId());
			allergyReq.setVersionState("Valid");
			allergyReq.setId(0);
			allergyRepository.save(allergyReq);
		});
			return allergyReq ;
	}

	@Override
	public Page<AllergyModel> getPage(Pageable pageable) {
		// TODO Auto-generated method stub
		return allergyRepository.findAll(pageable);
	}

	@Override
	public List<AllergyModel> getPageSearch(String searchString, Pageable pageable) {
		// TODO Auto-generated method stub
		return allergyRepository.getPageSearch(searchString,pageable);
	}

	@Override
	public List<AllergyModel> getAllergySearchPag(String allergy, Integer pageNumber, Integer pageSize, String soryBy) {
		// TODO Auto-generated method stub
		Pageable pageable;
		if(soryBy.equals("OLDEST_FIRST")) {
			pageable=PageRequest.of(pageNumber,pageSize,Sort.by(Sort.Direction.ASC,"id"));
		}
			else {
				pageable=PageRequest.of(pageNumber,pageSize,Sort.by(Sort.Direction.DESC,"id"));
			}
		return allergyRepository.getAllergySearchPag(allergy,pageable);
	}

}
