package com.openlgu.resident.service;

import java.time.Instant;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.openlgu.resident.dto.ResidentApplicationPatchRequest;
import com.openlgu.resident.dto.ResidentApplicationRequest;
import com.openlgu.resident.dto.ResidentApplicationResponse;
import com.openlgu.resident.entity.ResidentApplication;
import com.openlgu.resident.exception.ResidentNotFoundException;
import com.openlgu.resident.repository.ResidentApplicationRepository;

import reactor.core.publisher.Mono;

@Service
public class ResidentApplicationService {
	private static final Logger log = LoggerFactory.getLogger(ResidentApplicationService.class);
	private final ResidentApplicationRepository repository;

	public ResidentApplicationService(ResidentApplicationRepository repository) {
		this.repository = repository;
	}

	public Mono<ResidentApplicationResponse> apply(ResidentApplicationRequest request) {
		log.info("Apply Request:{}", request);

		ResidentApplication residentApplication = toEntity(request);

		return repository.save(residentApplication).map(this::toResponse);

	}

	public Mono<ResidentApplicationResponse> findById(UUID id) {
		return repository.findById(id).map(this::toResponse)
				.switchIfEmpty(Mono.error(new ResidentNotFoundException(id)));
	}

	public Mono<ResidentApplicationResponse> update(UUID id, ResidentApplicationPatchRequest request, UUID userId) {

		return repository.findById(id).flatMap(existing -> {
			applyPatch(existing, request, userId);
			return repository.save(existing);
		}).map(this::toResponse);

	}

	private ResidentApplication applyPatch(ResidentApplication entity, ResidentApplicationPatchRequest request,
			UUID userId) {
		entity.setStatus(ResidentApplication.Status.valueOf(request.getStatus()));
		entity.setActedAt(Instant.now());
		entity.setActedBy(userId);

		return entity;
	}

	private ResidentApplication toEntity(ResidentApplicationRequest request) {
		ResidentApplication residentApplication = new ResidentApplication();
		residentApplication.setFirstName(request.getFirstName());
		residentApplication.setLastName(request.getLastName());
		residentApplication.setMiddleName(request.getMiddleName());
		residentApplication.setBirthDate(request.getBirthDate());
		residentApplication.setAddress(request.getAddress());
		residentApplication.setRegion(request.getRegion());
		residentApplication.setProvinceHuc(request.getProvinceHuc());
		residentApplication.setMunicipalCity(request.getMunicipalCity());
		residentApplication.setBarangay(request.getBarangay());
		residentApplication.setCreatedAt(Instant.now());
		residentApplication.setActedAt(Instant.now());

		return residentApplication;
	}

	private ResidentApplicationResponse toResponse(ResidentApplication resident) {
		ResidentApplicationResponse response = new ResidentApplicationResponse();
		response.setId(resident.getId());
		response.setFirstName(resident.getFirstName());
		response.setLastName(resident.getLastName());
		response.setMiddleName(resident.getMiddleName());
		response.setBirthDate(resident.getBirthDate());
		response.setRegion(resident.getRegion());
		response.setProvinceHuc(resident.getProvinceHuc());
		response.setMunicipalCity(resident.getMunicipalCity());
		response.setBarangay(resident.getBarangay());
		response.setAddress(resident.getAddress());
		response.setStatus(resident.getStatus().name());
		response.setCreatedAt(resident.getCreatedAt());
		response.setActedBy(resident.getActedBy());
		response.setActedAt(resident.getActedAt());

		return response;
	}

}
