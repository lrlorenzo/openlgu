package com.openlgu.resident.repository;

import java.util.UUID;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.openlgu.resident.entity.Resident;

public interface ResidentRepository extends ReactiveCrudRepository<Resident, UUID> {
    

}
