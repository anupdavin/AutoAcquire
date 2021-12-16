package com.code.mvcapp.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "autoacquire")
public class AutoAcquire {

private static final long serialVersionUID = 1L;
	

@Id
@Column(name = "msisdn", nullable = false)
private Long msisdn;

@Column(name = "simType", nullable = false)
private String simType;

public Long getMsisdn() {
	return msisdn;
}

public void setMsisdn(Long msisdn) {
	this.msisdn = msisdn;
}

@Column(name = "name", nullable = false)
private String name;

@Column(name = "dateOfBirth", nullable = false)
	private String dateOfBirth;

@Column(name = "gender", nullable = false)
	private String gender;

@Column(name = "address", nullable = false)
	private String address;

@Column(name = "idNumber", nullable = false)
	private String idNumber;

@Column(name = "status", nullable = false)
private String status;

@Column(name = "updateddate", nullable = false)
private Date updateddate;

public Date getUpdateddate() {
	return updateddate;
}

public void setUpdateddate(Date updateddate) {
	this.updateddate = updateddate;
}

public String getSimType() {
	return simType;
}

public void setSimType(String simType) {
	this.simType = simType;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getDateOfBirth() {
	return dateOfBirth;
}

public void setDateOfBirth(String dateOfBirth) {
	this.dateOfBirth = dateOfBirth;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getIdNumber() {
	return idNumber;
}

public void setIdNumber(String idNumber) {
	this.idNumber = idNumber;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

}