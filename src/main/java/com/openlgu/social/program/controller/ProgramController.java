package com.openlgu.social.program.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.openlgu.social.program.dto.ProgramCreateRequest;
import com.openlgu.social.program.dto.ProgramResponse;
import com.openlgu.social.program.dto.ProgramUpdateRequest;
import com.openlgu.social.program.service.ProgramService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/programs")
public class ProgramController {
    private static final Logger log = LoggerFactory.getLogger(ProgramController.class);
    private ProgramService service;
    
    public ProgramController(ProgramService service) {
    	this.service = service;
    }
    
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ProgramResponse> register(@RequestBody ProgramCreateRequest request) {
        log.info("Register Request:{}", request);
        return service.create(request);
    }
    
    @GetMapping("/{id}")
    public Mono<ProgramResponse> findById(@PathVariable UUID id) {
    	log.info("Find By Id {}", id);
        return service.findById(id);
    }

    @GetMapping
    public Flux<ProgramResponse> findAll() {
    	log.info("Find All");
        return service.findAll();
    }
    
    @PutMapping("/{id}")
    public Mono<ProgramResponse> update(@PathVariable UUID id, @RequestBody ProgramUpdateRequest request) {
        log.info("Update Request:{} {}", id, request);
        return service.update(id, request);
    }


}
