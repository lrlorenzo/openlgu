package com.openlgu.social.program.entity;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("program")
public class Program {
	@Id
	private UUID id;
	private String name;

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
		this.name = name.toUpperCase();
	}

	@Override
	public String toString() {
		return "Program [id=" + id + ", name=" + name + "]";
	}

}
