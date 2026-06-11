package com.openlgu.social.program.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProgramUpdateRequest {

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
		return "ProgramUpdateRequest [name=" + name + "]";
	}

}
