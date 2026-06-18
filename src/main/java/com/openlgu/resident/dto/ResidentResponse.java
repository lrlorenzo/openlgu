package com.openlgu.resident.dto;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public class ResidentResponse {

	private UUID id;
	private String firstName;
	private String lastName;
	private String middleName;
	private LocalDate birthDate;
	private String address;
	private String region;
	private String provinceHuc;
	private String municipalCity;
	private String barangay;
	private UUID approvedBy;
	private Instant approvedAt;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
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

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRegion() {
		return region;
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

	public UUID getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(UUID approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Instant getApprovedAt() {
		return approvedAt;
	}

	public void setApprovedAt(Instant approvedAt) {
		this.approvedAt = approvedAt;
	}

	@Override
	public String toString() {
		return "ResidentResponse [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName="
				+ middleName + ", birthDate=" + birthDate + ", address=" + address + ", region=" + region
				+ ", provinceHuc=" + provinceHuc + ", municipalCity=" + municipalCity + ", barangay=" + barangay
				+ ", approvedBy=" + approvedBy + ", approvedAt=" + approvedAt + "]";
	}

}
