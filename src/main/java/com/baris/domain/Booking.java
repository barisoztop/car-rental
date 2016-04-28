package com.baris.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Booking {

	public enum Status {
		OPEN, ACTIVE, CANCELLED
	}

	@Id
	@GeneratedValue
	@Column(name = "BOOKING_ID")
	private Long id;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID")
	private User user;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CAR_ID")
	private Car Car;

	@Enumerated(EnumType.STRING)
	private Status status;

	private Date startDate;

	private Date endDate;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Car getCar() {
		return Car;
	}

	public void setCar(Car car) {
		Car = car;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
