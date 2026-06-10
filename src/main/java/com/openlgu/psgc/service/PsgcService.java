package com.openlgu.psgc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.openlgu.psgc.dto.PsgcRegisterRequest;
import com.openlgu.psgc.dto.PsgcResponse;
import com.openlgu.psgc.entity.Psgc;
import com.openlgu.psgc.repository.PsgcRepository;

import reactor.core.publisher.Mono;

@Service
public class PsgcService {
    private static final Logger log = LoggerFactory.getLogger(PsgcService.class);

    private final PsgcRepository repository;
    
    public PsgcService(PsgcRepository repository) {
    	this.repository = repository;    	
    }
    
    public Mono<PsgcResponse> register(PsgcRegisterRequest request) {
        log.info("Register Request:{}", request);
        Psgc psgc = toEntity(request);

        return repository.save(psgc).map(this::toResponse);
        
    }

    private Psgc toEntity(PsgcRegisterRequest request) {
        Psgc psgc = new Psgc();
        //TODO:
        return psgc;
    }
    
    private PsgcResponse toResponse(Psgc psgc) {
    	PsgcResponse response = new PsgcResponse();
        //TODO:
        return response;
    }
}
