package com.emr.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
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

import com.emr.model.CptCategoryModel;
import com.emr.model.CptModel;
import com.emr.service.CptService;
@RestController
public class CptController {
	
	@Autowired
	CptService cptService;
	
	//version state change
	@PostMapping("/cpt/add")
	public ResponseEntity<String> createCptModel(@RequestBody CptModel cptReq){
	  CptModel cp=cptService.createCptModel(cptReq);
		return ResponseEntity.status(200).body("cpt created sucessfully with id:"+cp.getId());
	}
	

	
	//search list
	@GetMapping("/cpt/list")                    
	  public List<CptModel> getCptModels(){
		return cptService.getCptModels();
	}
	
	//search by ID
	@GetMapping("/cpt/search/{id}")               
	public CptModel getCptModelById(@PathVariable int id) {
		return cptService.getCptModelById(id);
	}
	
	//update with id
	   @PutMapping("/cpt/edit/{id}")
	    public ResponseEntity<String> updateCptModel(@PathVariable int id,@RequestBody CptModel cptReq) {
		   CptModel cpt =  cptService.updateCptModel(id,cptReq);
	          return ResponseEntity.status(201).body("Cpt Updated Successfully with Id "+cpt.getId());
			
	       }
	
	 //delete particular id 
	@DeleteMapping("/cpt/delete/{id}")
	
	 public ResponseEntity<String> deleteCptModelById(@PathVariable int id)                               
    {
		cptService.deleteCptModelById(id);
        return ResponseEntity.status(200).body("cpt record Deleted Successfully");
    }
	
       //with out headers pagination
	@GetMapping("/cpt/pagination")
	public Page<CptModel> getCptByPagination(@RequestParam(defaultValue="10") Integer pageSize,
			@RequestParam(defaultValue="0") Integer pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		return cptService.getCptByPagination(pageable);
		}
	
	
	//with headers pagination
	@GetMapping("/cpt/pagination/with/headers")
	public ResponseEntity<List<CptModel>> findCptPagenation(@RequestParam Integer pageSize,
			@RequestParam Integer pageNumber) 
{
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<CptModel> cptmodel = cptService.findCptPagenation(pageable);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<List<CptModel>>(cptmodel.getContent(), headers, HttpStatus.OK);
	}
	
	//search with string pagination
	@GetMapping("/cpt/search/pagination")
	public ResponseEntity<List<CptModel>> getSearchPagination(@RequestParam String ShortName,@RequestParam Integer pageSize,
			@RequestParam Integer pageNumber) 
	{
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		List<CptModel> cpt = cptService.getSearchPagination(ShortName,pageable);
		HttpHeaders headers = new HttpHeaders();
		
		return new ResponseEntity<List<CptModel>>(cpt, headers, HttpStatus.OK);
	}
	
	
	
	//cpt category with search shortname,code
	@GetMapping("/cpt/category")
	public ResponseEntity<Page<CptCategoryModel>> getCptSearch(@RequestParam String codeOrDescription  ,Pageable pageable ){
		
	
	Page<CptCategoryModel> cptcatg = cptService.getCptSearch(codeOrDescription,pageable);
	HttpHeaders headers = new HttpHeaders();
	return new  ResponseEntity<Page<CptCategoryModel>>(cptcatg, headers, HttpStatus.OK);
	}
	

	
	
	//cpt pagination sorting
	@GetMapping("/paginationsorting")
	public ResponseEntity<List<CptModel>> getSorting(@RequestParam Integer pageSize,@RequestParam Integer pageNumber) {
	 
		List<CptModel> item = cptService.getSorting(pageNumber,pageSize);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<List<CptModel>>(item, headers, HttpStatus.OK);
 }
	
	//cpt search with string sort pagination shortName,code
	@GetMapping("/pagination/searchsort/name")
	public Page<CptModel> getCptPaginationSearchwithSort(@RequestParam(value ="serchString")String code,@RequestParam(defaultValue = "10") Integer pageSize,@RequestParam(defaultValue = "0") Integer pageNumber,
			@RequestParam(value = "sortBy",required =false,defaultValue = "Newest First")String sortBy){
		return cptService.getCptPaginationSearchwithSort(code,pageSize,pageNumber,sortBy);
		
	}
	
	
	
}
	
	
	

