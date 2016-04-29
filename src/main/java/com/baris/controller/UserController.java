package com.baris.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.baris.domain.User;
import com.baris.exception.ResourceNotFoundException;
import com.baris.repository.UserRepository;

@RestController
@RequestMapping("/")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/users", method=RequestMethod.POST)
	public ResponseEntity<Void> createUser(@Valid @RequestBody User user) {
		user = userRepository.save(user);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		URI newUserUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		responseHeaders.setLocation(newUserUri);
		
		return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public ResponseEntity<Iterable<User>> getAllUsers() {
		Iterable<User> allUsers = userRepository.findAll();
		return new ResponseEntity<>(allUsers, HttpStatus.OK); 
	}
	
	@RequestMapping(value="/users/{userId}", method=RequestMethod.GET)
	public ResponseEntity<?> getUser(@PathVariable Long userId) {
		verifyUser(userId);
		User user = userRepository.findOne(userId);
		return new ResponseEntity<>(user, HttpStatus.OK); 
	}
	
	@RequestMapping(value="/users/filter", method=RequestMethod.GET)
	public ResponseEntity<Iterable<User>> getUserByLastName(@RequestParam("lastName") String lastName) {
		
		List<User> users = userRepository.findByLastNameIgnoreCase(lastName);
		return new ResponseEntity<>(users, HttpStatus.OK); 
	}
	
	@RequestMapping(value="/users/{userId}", method=RequestMethod.PUT)
	public ResponseEntity<Void> updateUser(@RequestBody User user, @PathVariable Long userId) {
		verifyUser(userId);
		userRepository.save(user);
		return new ResponseEntity<>(HttpStatus.OK); 
	}
	
	@RequestMapping(value="/users/{userId}", method=RequestMethod.DELETE)
	public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
		verifyUser(userId);
		userRepository.delete(userId);
		return new ResponseEntity<>(HttpStatus.OK); 
	}
	
	protected void verifyUser(Long userId) throws ResourceNotFoundException {
		User user = userRepository.findOne(userId);
		if (user == null) {
			throw new ResourceNotFoundException("No user found with id " + userId);
		}
	}

}
