package com.icd.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.icd.microservice.model.Icd;
import com.icd.microservice.service.IcdService;

import jakarta.validation.constraints.Size;

@RestController
public class IcdController {
	
	@Autowired
	IcdService icdService;
	

	@PostMapping("/icd/add")
	public ResponseEntity<Icd> createIcd(@RequestBody Icd IcdReq){
		Icd icd = icdService.createIcd(IcdReq);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Icd>(icd,headers,HttpStatus.CREATED);
	}
	
	@GetMapping("/icd/list")
	public ResponseEntity<List<Icd>> getIcd(){
		List<Icd> icdlist = icdService.getIcd();
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<List<Icd>>(icdlist,headers,HttpStatus.OK);
	}
	
	@GetMapping("/icd/list/{id}")
	public ResponseEntity<Icd> getIcdCode(@RequestParam int id){
		Icd icd = icdService.getIcdCode(id);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Icd>(icd ,headers,HttpStatus.OK);
	}
	
	
	@PutMapping("/icd/edit/{id}")
	public ResponseEntity<Icd> updateIcd(@RequestBody Icd icdReq){
		Icd icd = icdService.updateIcd(icdReq);
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<Icd>(icd,headers,HttpStatus.OK);
	}
	
	@DeleteMapping("/icd/delete/{id}")
	public ResponseEntity<String> deleteIcd(@PathVariable int id){
		icdService.deleteIcd(id);
		return ResponseEntity.status(201).body("Id deleted sucessfully");
		
	}
	
	@GetMapping("/icd/pagination/searchsorting")
	
	public Page<Icd> getIcdSearchSorting(@RequestParam @Size(min = 3) String icdcode , @RequestParam(defaultValue = "20") Integer pageSize,
			@RequestParam(defaultValue ="0") Integer pageNumber,@RequestParam(value = "sortBy",required = false,defaultValue = "Newest First") String sortBy ){
		return icdService.getIcdSearchSorting(icdcode,pageNumber,pageSize,sortBy);
	}
	
	
	

}
