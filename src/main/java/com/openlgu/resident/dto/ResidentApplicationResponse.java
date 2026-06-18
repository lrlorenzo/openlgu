package com.openlgu.resident.dto;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public class ResidentApplicationResponse {

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
	
	private String status;
	
	private Instant createdAt;
	private UUID actedBy;
	private Instant actedAt;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public UUID getActedBy() {
		return actedBy;
	}

	public void setActedBy(UUID actedBy) {
		this.actedBy = actedBy;
	}

	public Instant getActedAt() {
		return actedAt;
	}

	public void setActedAt(Instant actedAt) {
		this.actedAt = actedAt;
	}

	@Override
	public String toString() {
		return "ResidentApplicationResponse [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", middleName=" + middleName + ", birthDate=" + birthDate + ", address=" + address + ", region="
				+ region + ", provinceHuc=" + provinceHuc + ", municipalCity=" + municipalCity + ", barangay="
				+ barangay + ", status=" + status + ", createdAt=" + createdAt + ", actedBy=" + actedBy + ", actedAt="
				+ actedAt + "]";
	}

}
