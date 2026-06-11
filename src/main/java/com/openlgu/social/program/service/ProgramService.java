package com.openlgu.social.program.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.openlgu.resident.dto.ResidentRegisterRequest;
import com.openlgu.resident.dto.ResidentResponse;
import com.openlgu.resident.entity.Resident;
import com.openlgu.social.program.dto.ProgramCreateRequest;
import com.openlgu.social.program.dto.ProgramResponse;
import com.openlgu.social.program.dto.ProgramUpdateRequest;
import com.openlgu.social.program.entity.Program;
import com.openlgu.social.program.repository.ProgramRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProgramService {
    private static final Logger log = LoggerFactory.getLogger(ProgramService.class);
    private ProgramRepository repository;
    
    public ProgramService(ProgramRepository repository) {
    	this.repository = repository;
    }
    
    public Mono<ProgramResponse> create(ProgramCreateRequest request) {
    	log.info("Register Request:{}", request);
    	Program program = toEntity(request);
    	return repository.save(program).map(this::toResponse);
    }
    
    public Mono<ProgramResponse> findById(UUID id) {
    	log.info("Find By Id:{}", id);
    	
    	return null;
    	
    }

    public Flux<ProgramResponse> findAll() {
    	log.info("Find All");
    	
    	return repository.findAll().map(this::toResponse);
    	
    }
    
    public Mono<ProgramResponse> update(UUID id, ProgramUpdateRequest request) {
    	log.info("Update:{} {}", id, request);
    	
    	return null;
    	
    }
    
    private Program toEntity(ProgramCreateRequest request) {
    	Program program = new Program();
    	program.setName(request.getName());
        return program;
    }
    
    private ProgramResponse toResponse(Program program) {
    	ProgramResponse response = new ProgramResponse();
    	response.setId(program.getId());
    	response.setName(program.getName());
        return response;
    }
    

}
