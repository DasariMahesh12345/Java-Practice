package com.csv.application.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.csv.application.developer.repository.CsvDataHistoricalRepository;
import com.csv.application.developer.repository.CsvDataRepository;
import com.csv.application.entity.CsvDataEntity;
import com.csv.application.entity.CsvDataHistoricalEntity;

import jakarta.persistence.EntityNotFoundException;

//working code
@Service
public class CsvDataImportService {

	private final CsvDataRepository csvDataRepository;
	private final CsvDataHistoricalRepository csvDataHistoricalRepository;

	public CsvDataImportService(CsvDataRepository csvDataRepository,
			CsvDataHistoricalRepository csvDataHistoricalRepository) {
		this.csvDataRepository = csvDataRepository;
		this.csvDataHistoricalRepository = csvDataHistoricalRepository;
	}

	public List<String> importCsvData(MultipartFile file) throws IOException {
		List<String> duplicateNames = new ArrayList<>();
		Set<String> uniqueNames = new HashSet<>();

		try (CSVParser csvParser = CSVFormat.DEFAULT.withHeader("id", "name", "age")
				.parse(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {

			for (CSVRecord record : csvParser) {
				String name = record.get("name"); // Use header name instead of index
				String age = record.get("age"); // Use header name instead of index

				if (uniqueNames.contains(name)) {
					duplicateNames.add(name);
					continue; // Skip saving the duplicate record
				}

				CsvDataEntity existingEntity = csvDataRepository.findByName(name);
				if (existingEntity == null) {
					// If the record with the same name doesn't exist in csvDataRepository,
					// save it to csvDataRepository (updated data table)
					CsvDataEntity entity = new CsvDataEntity();
					entity.setName(name);
					entity.setAge(age);
					entity.setLastUpdated(LocalDateTime.now());

					csvDataRepository.save(entity);
				} else {
					// If the record with the same name exists in csvDataRepository,
					// check if it already exists in csvDataHistoricalRepository
					CsvDataHistoricalEntity historicalEntity = csvDataHistoricalRepository
							.findByNameAndLastUpdated(name, existingEntity.getLastUpdated());
					if (historicalEntity == null) {
						// Save it to csvDataHistoricalRepository (historical data table)
						historicalEntity = new CsvDataHistoricalEntity();
						historicalEntity.setName(name);
						historicalEntity.setAge(age);
						historicalEntity.setLastUpdated(existingEntity.getLastUpdated());

						csvDataHistoricalRepository.save(historicalEntity);
					}

					// Update the existing record in csvDataRepository (updated data table)
					existingEntity.setAge(age);
					existingEntity.setLastUpdated(LocalDateTime.now());

					csvDataRepository.save(existingEntity);
				}

				uniqueNames.add(name);
			}
		}

		return duplicateNames;
	}

	public List<CsvDataEntity> getAllCsvData() {
		return csvDataRepository.findAll();
	}

	public CsvDataEntity getCsvDataById(Long id) {
		return csvDataRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("CsvDataEntity not found with id: " + id));
	}
}
