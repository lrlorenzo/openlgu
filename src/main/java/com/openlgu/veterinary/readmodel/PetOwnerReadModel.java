package com.openlgu.veterinary.readmodel;

import java.util.UUID;

public class PetOwnerReadModel {
	private UUID id;
	private String name;
	private String ownerId;
	private String lastName;
	private String firstName;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return "PetOwnerReadModel [id=" + id + ", name=" + name + ", ownerId=" + ownerId + ", lastName=" + lastName
				+ ", firstName=" + firstName + "]";
	}

}
