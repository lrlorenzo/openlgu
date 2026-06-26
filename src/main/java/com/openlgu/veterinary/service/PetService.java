package com.openlgu.veterinary.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.openlgu.veterinary.dto.PetOwnerResponse;
import com.openlgu.veterinary.dto.PetRegisterRequest;
import com.openlgu.veterinary.entity.Pet;
import com.openlgu.veterinary.readmodel.PetOwnerReadModel;
import com.openlgu.veterinary.repository.PetRepository;

import reactor.core.publisher.Mono;

@Service
public class PetService {
	private static final Logger log = LoggerFactory.getLogger(PetService.class);
	private PetRepository repository;

	public PetService(PetRepository repository) {
		this.repository = repository;
	}

	public Mono<PetOwnerResponse> register(PetRegisterRequest request) {
		log.info("Register Request: {}", request);
		Pet pet = toEntity(request);

//		return repository.findPetOwner(UUID.randomUUID()).map(this::toPetOwnerResponse);
		return repository.save(pet).flatMap(savedPet -> repository.findPetOwner(savedPet.getId()))
				.map(this::toPetOwnerResponse);

	}

	public Mono<PetOwnerResponse> findPetOwner(UUID petId) {
		log.info("Pet Id:{}", petId);

		return repository.findPetOwner(petId).map(this::toPetOwnerResponse);

	}

	private Pet toEntity(PetRegisterRequest request) {
		Pet pet = new Pet();
		pet.setName(request.getName());
		pet.setResidentId(request.getResidentId());
		return pet;
	}

	private PetOwnerResponse toPetOwnerResponse(PetOwnerReadModel petOwner) {
		PetOwnerResponse response = new PetOwnerResponse();
		response.setId(petOwner.getId());
		response.setName(petOwner.getName());
		response.setOwnerId(petOwner.getOwnerId());
		response.setLastName(petOwner.getLastName());
		response.setFirstName(petOwner.getFirstName());
		return response;
	}
}
