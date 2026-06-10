package com.openlgu.psgc.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.openlgu.psgc.entity.Psgc;

public interface PsgcRepository extends ReactiveCrudRepository<Psgc, String> {

}
