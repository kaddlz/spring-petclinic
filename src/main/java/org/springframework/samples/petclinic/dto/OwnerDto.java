package org.springframework.samples.petclinic.dto;

import java.util.List;

public record OwnerDto(
	int id,
	String fullName,
	ContactInfoDto contactInfo,
	List<PetDto> pets
) {
	public record ContactInfoDto(
		String address,
		String city,
		String telephone
	) {

	}
}
