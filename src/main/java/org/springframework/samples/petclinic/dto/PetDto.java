package org.springframework.samples.petclinic.dto;

import java.util.List;

public record PetDto(
	int id,
	String name,
	int ageInYears,
	String typeName,
	List<VisitDto> visits
) {
}
