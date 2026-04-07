package org.springframework.samples.petclinic.dto;

public record VisitDto(
	int id,
	String formattedDate,
	String description,
	int billAmount
) {
}
