package com.openlgu.resident.dto;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class ResidentApplicationRequest {

	@NotBlank
	@Size(max = 100)
	private String firstName;

	@NotBlank
	@Size(max = 100)
	private String lastName;

	@Size(max = 100)
	private String middleName;

	@NotNull
	@Past
	private LocalDate birthDate;

	@NotBlank
	@Size(max = 500)
	private String address;

	@NotBlank
	@Size(max = 10)
	private String region;

	@NotBlank
	@Size(max = 10)
	private String provinceHuc;

	@NotBlank
	@Size(max = 10)
	private String municipalCity;

	@NotBlank
	@Size(max = 10)
	private String barangay;

	@NotBlank
	private UUID actedBy;

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

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getProvinceHuc() {
		return provinceHuc;
	}

	public void setProvinceHuc(String provinceHuc) {
		this.provinceHuc = provinceHuc;
	}

	public String getMunicipalCity() {
		return municipalCity;
	}

	public void setMunicipalCity(String municipalCity) {
		this.municipalCity = municipalCity;
	}

	public String getBarangay() {
		return barangay;
	}

	public void setBarangay(String barangay) {
		this.barangay = barangay;
	}


	public UUID getActedBy() {
		return actedBy;
	}

	public void setActedBy(UUID actedBy) {
		this.actedBy = actedBy;
	}

	@Override
	public String toString() {
		return "ResidentApplicationRequest [firstName=" + firstName + ", lastName=" + lastName + ", middleName="
				+ middleName + ", birthDate=" + birthDate + ", address=" + address + ", region=" + region
				+ ", provinceHuc=" + provinceHuc + ", municipalCity=" + municipalCity + ", barangay=" + barangay
				+ ", actedBy=" + actedBy + "]";
	}

}
