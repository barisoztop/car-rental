package com.baris.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class User {

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Long id;

	@Column(name = "FIRST_NAME")
	@NotEmpty
	private String firstName;

	@Column(name = "LAST_NAME")
	@NotEmpty
	private String lastName;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "BIRTHDAY")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birthday;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

}
