package com.openlgu.social.program.repository;

import java.util.UUID;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.openlgu.social.program.entity.Program;

public interface ProgramRepository extends ReactiveCrudRepository<Program, UUID> {

}
