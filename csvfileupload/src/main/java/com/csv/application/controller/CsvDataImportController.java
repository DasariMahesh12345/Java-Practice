package com.csv.application.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.csv.application.entity.CsvDataEntity;
import com.csv.application.service.CsvDataImportService;

@RestController
@RequestMapping("/upload/csv")
public class CsvDataImportController {

	@Autowired
	private final CsvDataImportService csvDataImportService;

	@Autowired
	public CsvDataImportController(CsvDataImportService csvDataImportService) {
		this.csvDataImportService = csvDataImportService;
	}

	@PostMapping("/import")
	@ResponseBody
	public ResponseEntity<String> importCsvData(@RequestParam("file") MultipartFile file) {
		try {
			List<String> duplicateNames = csvDataImportService.importCsvData(file);

			if (duplicateNames.isEmpty()) {
				return new ResponseEntity<>("CSV data imported successfully!", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("Duplicate names found: " + duplicateNames, HttpStatus.CONFLICT);
			}
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>("Error importing CSV data.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/get/all/data")
	public List<CsvDataEntity> getAllCsvData() {
		return csvDataImportService.getAllCsvData();
	}

	@GetMapping("/getby/{id}")
	public ResponseEntity<CsvDataEntity> getCsvDataById(@PathVariable Long id) {
		CsvDataEntity csvDataEntity = csvDataImportService.getCsvDataById(id);
		return ResponseEntity.ok(csvDataEntity);
	}
}
