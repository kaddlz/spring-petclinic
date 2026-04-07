package org.springframework.samples.petclinic.dto;

import java.util.List;

public record PetShortDto(
	String typeName,
	List<VisitShortDto> visits
) {
}
