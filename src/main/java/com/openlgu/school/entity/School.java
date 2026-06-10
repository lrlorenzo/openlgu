package com.openlgu.school.entity;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("school")
public class School {
	@Id
	private UUID id;


}
