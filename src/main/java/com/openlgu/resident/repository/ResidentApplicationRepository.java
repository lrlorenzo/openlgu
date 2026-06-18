package com.openlgu.resident.repository;

import java.util.UUID;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.openlgu.resident.entity.ResidentApplication;

public interface ResidentApplicationRepository extends ReactiveCrudRepository<ResidentApplication, UUID> {
    

}
