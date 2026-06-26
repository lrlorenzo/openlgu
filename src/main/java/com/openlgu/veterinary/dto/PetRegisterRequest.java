package com.openlgu.veterinary.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PetRegisterRequest {

	@NotBlank
	@Size(max = 100)
	private String name;

	@NotBlank
	private UUID residentId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UUID getResidentId() {
		return residentId;
	}

	public void setResidentId(UUID residentId) {
		this.residentId = residentId;
	}

	@Override
	public String toString() {
		return "PetRegisterRequest [name=" + name + ", residentId=" + residentId + "]";
	}

}
