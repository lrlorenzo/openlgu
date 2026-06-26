package com.openlgu.veterinary.entity;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("pet")
public class Pet {
	@Id
	private UUID id;
	private String name;
	private UUID residentId;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

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
		return "Pet [id=" + id + ", name=" + name + ", residentId=" + residentId + "]";
	}

}
