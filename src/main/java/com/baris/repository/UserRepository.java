package com.baris.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.baris.domain.User;

// http://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findByLastNameIgnoreCase(String lastName);
}
