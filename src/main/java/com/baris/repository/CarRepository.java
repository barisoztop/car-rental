package com.baris.repository;

import org.springframework.data.repository.CrudRepository;

import com.baris.domain.Car;

public interface CarRepository extends CrudRepository<Car, Long> { }

