package com.baris.repository;

import org.springframework.data.repository.CrudRepository;

import com.baris.domain.Booking;

public interface BookingRepository extends CrudRepository<Booking, Long> { }

