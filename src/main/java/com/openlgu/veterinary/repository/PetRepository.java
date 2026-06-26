package com.openlgu.veterinary.repository;

import java.util.UUID;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.openlgu.veterinary.entity.Pet;
import com.openlgu.veterinary.readmodel.PetOwnerReadModel;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PetRepository extends ReactiveCrudRepository<Pet, UUID> {
	
	@Query("""
			SELECT p.id, p.name, r.id owner_id, r.first_name, r.last_name
			FROM pet p
			JOIN resident r
			  ON p.resident_id = r.id
			WHERE p.id = :petId
			""")
	Mono<PetOwnerReadModel> findPetOwner(UUID petId);

	Flux<Pet> findByResidentId(UUID residentId);

}
