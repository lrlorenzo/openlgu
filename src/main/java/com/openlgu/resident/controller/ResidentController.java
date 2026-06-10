package com.openlgu.resident.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.openlgu.resident.dto.ResidentRegisterRequest;
import com.openlgu.resident.dto.ResidentResponse;
import com.openlgu.resident.dto.ResidentPatchRequest;
import com.openlgu.resident.service.ResidentService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/residents")
public class ResidentController {
    private static final Logger log = LoggerFactory.getLogger(ResidentController.class);
    
    private final ResidentService service;
    
    public ResidentController(ResidentService service) {
        this.service = service;
    }

    @GetMapping("/ping")
    public Mono<String> ping() {
        return Mono.just("OpenLGU Reactive API is running");
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ResidentResponse> register(@RequestBody ResidentRegisterRequest request) {
        log.info("Register Request:{}", request);
        return service.register(request);
    }
    
    @GetMapping("/{id}")
    public Mono<ResidentResponse> findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @PatchMapping("/{id}")
    public Mono<ResidentResponse> update(@PathVariable UUID id, @RequestBody ResidentPatchRequest request) {
        log.info("Update Request:{}", request);
        return service.update(request);
    }

}
