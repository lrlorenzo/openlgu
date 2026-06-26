package com.openlgu.veterinary.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.openlgu.veterinary.dto.PetOwnerResponse;
import com.openlgu.veterinary.dto.PetRegisterRequest;
import com.openlgu.veterinary.entity.Pet;
import com.openlgu.veterinary.service.PetService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/veterinary")
public class PetController {
	private static final Logger log = LoggerFactory.getLogger(PetController.class);
	private PetService service;
	
	public PetController(PetService service) {
		this.service = service;
	}

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<PetOwnerResponse> register(@RequestBody PetRegisterRequest request) {
        log.info("Register Request:{}", request);
        return service.register(request);
    }
	
    @GetMapping("/{id}")
    public Mono<PetOwnerResponse> findPetOwner(@PathVariable UUID id) {
    	log.info("Pet Id: {}", id);
    	return service.findPetOwner(id);
    }


}
