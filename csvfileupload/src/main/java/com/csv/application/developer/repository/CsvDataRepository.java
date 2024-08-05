package com.csv.application.developer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.csv.application.entity.CsvDataEntity;

public interface CsvDataRepository extends JpaRepository<CsvDataEntity, Long>{

	  CsvDataEntity findByName(String name);

}
