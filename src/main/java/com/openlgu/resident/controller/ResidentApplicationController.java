package com.openlgu.resident.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.openlgu.resident.dto.ResidentApplicationPatchRequest;
import com.openlgu.resident.dto.ResidentApplicationRequest;
import com.openlgu.resident.dto.ResidentApplicationResponse;
import com.openlgu.resident.service.ResidentApplicationService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/resident-applications")
public class ResidentApplicationController {
	private static final Logger log = LoggerFactory.getLogger(ResidentApplicationController.class);

	private final ResidentApplicationService service;

	public ResidentApplicationController(ResidentApplicationService service) {
		this.service = service;
	}

	@PostMapping("/apply")
	@ResponseStatus(HttpStatus.CREATED)
	public Mono<ResidentApplicationResponse> apply(@RequestBody ResidentApplicationRequest request) {
		log.info("Appy Request:{}", request);
		return service.apply(request);
	}

	@PatchMapping("/{id}/status")
	public Mono<ResidentApplicationResponse> update(@PathVariable UUID id,
			@RequestBody ResidentApplicationPatchRequest request) {
		log.info("Update Request:{}", request);
		UUID userId = UUID.fromString("e95ddae6-e4f7-4c32-8176-c6d803434459"); // TODO: get from user session later
		return service.update(id, request, userId);
	}

}
