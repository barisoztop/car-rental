package com.baris.repository;

import org.springframework.data.repository.CrudRepository;

import com.baris.domain.User;

public interface UserRepository extends CrudRepository<User, Long> { }

