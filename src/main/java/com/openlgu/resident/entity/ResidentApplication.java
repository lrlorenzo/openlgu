package com.openlgu.resident.entity;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("resident_application")
public class ResidentApplication {
    @Id
    private UUID id;	

}
