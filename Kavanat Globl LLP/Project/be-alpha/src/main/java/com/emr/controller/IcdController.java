
































































































































































































































package com.emr.controller;



import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
import org.springframework.web.bind.annotation.RestController;

import com.emr.model.CptCategoryModel;
import com.emr.model.IcdCategoryModel;
import com.emr.model.IcdModel;
import com.emr.service.IcdService;

@RestController
public class IcdController {
	
	@Autowired
	IcdService icdService;
	
	// get all records
	@GetMapping("/icd/getcode")
	public List<IcdModel> getIcd(){
		return icdService.getIcd();
		
	}
	
	//get by id
	@GetMapping("/icd/searchby/{id}")
	public IcdModel getById(@PathVariable Integer id){
		return icdService.getById(id);
		}
	
    //create&add
	@PostMapping("/icd/add")
	
	public ResponseEntity<String> createIcd(@RequestBody IcdModel icdModel) {
		IcdModel icd =	icdService.createIcd(icdModel);
		return ResponseEntity.status(201).body("Icd Created Sucessfully with id:"+icd.getId());
	}
	
	//update
	@PutMapping("/icd/update/{id}")
	public ResponseEntity<String> updateIcd(@PathVariable Integer id, @RequestBody IcdModel icdUpdateReq){
		IcdModel icdUp=	icdService.updateIcd(id,icdUpdateReq);
		return ResponseEntity.status(201).body("icd  Updated Sucessfully with id:"+icdUp.getId());
	}
	
	// delete
	@DeleteMapping("/icd/delete/{id}")
	public ResponseEntity<String> deltById(@PathVariable Integer id){
		icdService.deltById(id);
		return ResponseEntity.status(201).body("Icd Id Sucessfully Deleted");
	}
	
	// icd pagination 
	@GetMapping("/icd/pagination")
    public Page<IcdModel> getPagination(@RequestParam Integer pageNumber,@RequestParam Integer pageSize){
    	Pageable pageable=PageRequest.of(pageNumber,pageSize);
    	return icdService.getPagination(pageable);
    }
	
	//  Icd Search with pagination
	@GetMapping("/icd/search/with/pagination")
	
	public  List<IcdModel> getIcdPagSearch(@RequestParam String Descorcode,@RequestParam Integer pageNumber,
		@RequestParam Integer pageSize){
		Pageable pageable =PageRequest.of(pageNumber,pageSize);
		return icdService.getIcdPagSearch(Descorcode,pageable);
		}
	
		/*
		 * //icd pagination sorting
		 * 
		 * @GetMapping("pagination/sorting/asc/desc") public
		 * ResponseEntity<List<IcdModel>> getIcdSorting(@RequestParam Integer
		 * pageNumber,@RequestParam Integer pageSize){
		 * 
		 * List<IcdModel> icdSort=icdService.getIcdSorting(pageNumber,pageSize); return
		 * ResponseEntity.status(200).body(icdSort); }
		 */
	
	//icd pagination  search string with sorting order
	@GetMapping("/search/withstring/sort/pagination")
	public Page<IcdModel> getIcdSearchWithString(@RequestParam(value = "searchString") String search,@RequestParam Integer pageNumber,@RequestParam Integer pageSize,
			@RequestParam(value = "sortBy",required =false,defaultValue = "Newest_First")String sortBy){
		return icdService.getIcdSearchWithString(search,pageNumber,pageSize,sortBy);
		}
	
	// icd category search
	@GetMapping("/icd/category/search")
	
	public ResponseEntity<Page<IcdCategoryModel>> getIcdSearchName(@RequestParam String icdNameCode ,Pageable pageable ){
		
		
		Page<IcdCategoryModel> icdCatg = icdService.getIcdSearchName(icdNameCode,pageable);
		HttpHeaders headers = new HttpHeaders();
		return new  ResponseEntity<Page<IcdCategoryModel>>(icdCatg, headers, HttpStatus.OK);
		}
}
