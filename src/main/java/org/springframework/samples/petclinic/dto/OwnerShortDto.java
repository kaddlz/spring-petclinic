package org.springframework.samples.petclinic.dto;

import java.util.List;

public record OwnerShortDto(
	int id,
	String fullName,
	List<PetShortDto> pets
) {
}
