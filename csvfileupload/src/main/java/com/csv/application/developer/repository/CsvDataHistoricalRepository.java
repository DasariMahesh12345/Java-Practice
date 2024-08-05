package com.csv.application.developer.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csv.application.entity.CsvDataHistoricalEntity;
@Repository
public interface CsvDataHistoricalRepository extends JpaRepository<CsvDataHistoricalEntity, Long> {

	CsvDataHistoricalEntity findByNameAndLastUpdated(String name, LocalDateTime lastUpdated);

	

}
