package com.baris.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Car {

    @Column(unique = true)
    @NotEmpty
    private String licensePlate;

    @NotEmpty
    private String vin;

    @NotEmpty
    private String model;

    @NotNull
    private Boolean active;

    @NotEmpty
    private String color;

    @Future
    private Date validTill;

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getVin() {
        return vin;
    }

    public String getModel() {
        return model;
    }

    public Boolean getActive() {
        return active;
    }

    public String getColor() {
        return color;
    }

    public Date getValidTill() {
        return validTill;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setValidTill(Date validTill) {
        this.validTill = validTill;
    }
}
