package com.emr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.emr.model.AllergyModel;
import com.emr.service.AllergyService;

import net.bytebuddy.implementation.bytecode.constant.DefaultValue;

@RestController
public class AllergyController {
	
	@Autowired
	AllergyService allergyService;
	
	@GetMapping("/get/allergy")
	public List<AllergyModel> getAllergy(){
		return allergyService.getAllergy();
	}
	
	@GetMapping("/get/allergyby/{id}")
	public AllergyModel getById(@PathVariable int id ){
		return allergyService.getById(id);
		}
	
	@DeleteMapping("/delete/allergy/{id}")
	public ResponseEntity<String> delateById(@PathVariable int id){
		allergyService.delateById(id);
		return ResponseEntity.status(201).body("Allergy Record Deleted Sucessfully");
	}
	
	@PostMapping("/allergy/add")
	public ResponseEntity<String> createAllergyModel(@RequestBody AllergyModel allergyModelRes){
		AllergyModel allergyModel = allergyService.createAllergyModel(allergyModelRes);
		return ResponseEntity.status(201).body("Id is created:"+allergyModel.getId());
	}
	
	@PutMapping("/allergy/update/{id}")
	public ResponseEntity<String> updateAllergy(@PathVariable int id,@RequestBody AllergyModel allergyReq){
		AllergyModel allmodel1 = allergyService.updateAllergy(id,allergyReq);
		return ResponseEntity.status(200).body("Allergy Updated Sucessfully with id:"+allmodel1.getId() );
	}
	
     @GetMapping("/allergy/pagination")
     public Page<AllergyModel> getPage(@RequestParam(defaultValue = "0") Integer pageNumber,@RequestParam(defaultValue = "10") Integer pageSize){
    	 Pageable pageable= PageRequest.of(pageNumber, pageSize);
    	 return allergyService.getPage(pageable);
     }
     
     @GetMapping("/allergy/serch/pagination")
     public List<AllergyModel> getPageSearch(@RequestParam String searchString,@RequestParam Integer pageNumber,@RequestParam Integer pageSize){
    	 Pageable pageable = PageRequest.of(pageNumber, pageSize);
    	 return allergyService.getPageSearch(searchString,pageable);
     }
     
   @GetMapping("/allergy/string/search/sort/pagination")
    public List<AllergyModel> getAllergySearchPag(@RequestParam(value = "SearchAllergy") String allergy,@RequestParam Integer pageNumber,@RequestParam Integer pageSize,
    		@RequestParam(value = "sortBy",required=false,defaultValue="NEW_FIRST")String soryBy){
    	return allergyService.getAllergySearchPag(allergy,pageNumber,pageSize,soryBy);
    }
     
}
