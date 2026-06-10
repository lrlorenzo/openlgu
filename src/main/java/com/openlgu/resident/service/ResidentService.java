package com.openlgu.resident.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.openlgu.resident.dto.ResidentPatchRequest;
import com.openlgu.resident.dto.ResidentRegisterRequest;
import com.openlgu.resident.dto.ResidentResponse;
import com.openlgu.resident.entity.Resident;
import com.openlgu.resident.exception.ResidentNotFoundException;
import com.openlgu.resident.repository.ResidentRepository;

import reactor.core.publisher.Mono;

@Service
public class ResidentService {
    private static final Logger log = LoggerFactory.getLogger(ResidentService.class);
    private final ResidentRepository repository;

    public ResidentService(ResidentRepository repository) {
        this.repository = repository;
    }

    public Mono<ResidentResponse> register(ResidentRegisterRequest request) {
        log.info("Register Request:{}", request);

        Resident resident = toEntity(request);

        return repository.save(resident).map(this::toResponse);

    }

    public Mono<ResidentResponse> findById(UUID id) {
        return repository.findById(id).map(this::toResponse)
                .switchIfEmpty(Mono.error(new ResidentNotFoundException(id)));
    }

    public Mono<ResidentResponse> update(ResidentPatchRequest request) {

        return repository.findById(request.getId()).flatMap(existing -> {
            applyPatch(existing, request);
            return repository.save(existing);
        }).map(this::toResponse);

    }

    private Resident applyPatch(Resident entity, ResidentPatchRequest request) {
        if (request.getFirstName() != null) {
            entity.setFirstName(request.getFirstName());
        }
        if (request.getLastName() != null) {
            entity.setLastName(request.getLastName());
        }
        if (request.getMiddleName() != null) {
            entity.setMiddleName(request.getMiddleName());
        }
        if (request.getBirthDate() != null) {
            entity.setBirthDate(request.getBirthDate());
        }
        if (request.getAddress() != null) {
            entity.setAddress(request.getAddress());
        }

        return entity;
    }

    private Resident toEntity(ResidentRegisterRequest request) {
        Resident resident = new Resident();
        resident.setFirstName(request.getFirstName());
        resident.setLastName(request.getLastName());
        resident.setMiddleName(request.getMiddleName());
        resident.setBirthDate(request.getBirthDate());
        resident.setAddress(request.getAddress());
        return resident;
    }

    private ResidentResponse toResponse(Resident resident) {
        ResidentResponse response = new ResidentResponse();
        response.setFirstName(resident.getFirstName());
        response.setLastName(resident.getLastName());
        response.setMiddleName(resident.getMiddleName());
        response.setBirthDate(resident.getBirthDate());
        return response;
    }

}
