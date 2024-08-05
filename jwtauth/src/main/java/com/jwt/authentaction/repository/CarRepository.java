package com.jwt.authentaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwt.authentaction.service.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
	Car findByCarName(String userName);
}
