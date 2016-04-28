package com.baris.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Car {

	@Id
	@GeneratedValue
	@Column(name = "CAR_ID")
	private Long id;

	@Column(name = "LICENSE_PLATE", unique = true)
	@NotEmpty
	private String licensePlate;

	@Column(name = "BRAND")
	@NotEmpty
	private String brand;

	@Column(name = "MODEL")
	@NotEmpty
	private String model;

	@Column(name = "ACTIVE")
	@NotNull
	private Boolean active;

	@Column(name = "COLOR")
	@NotEmpty
	private String color;

	@Future
	@Column(name = "VALID_TILL")
	private Date validTill;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Date getValidTill() {
		return validTill;
	}

	public void setValidTill(Date validTill) {
		this.validTill = validTill;
	}

}
