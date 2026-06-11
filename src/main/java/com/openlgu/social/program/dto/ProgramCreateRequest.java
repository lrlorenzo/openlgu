package com.openlgu.social.program.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProgramCreateRequest {
	@NotBlank
	@Size(max = 100)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ProgramCreateRequest [name=" + name + "]";
	}

}
