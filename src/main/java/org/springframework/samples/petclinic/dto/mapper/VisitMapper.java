package org.springframework.samples.petclinic.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.samples.petclinic.dto.VisitDto;
import org.springframework.samples.petclinic.dto.VisitShortDto;
import org.springframework.samples.petclinic.owner.Visit;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface VisitMapper {
	@Mapping(target = "formattedDate", source = "visit", qualifiedByName = "formattedDate")
	VisitDto toDto(Visit visit);

	@Mapping(target = "formattedDate", source = "visit", qualifiedByName = "formattedDate")
	VisitShortDto toShortDto(Visit visit);

	@Named(value = "formattedDate")
	default String formatDate(Visit visit) {
		String pattern = "dd.MM.yyyy";
		DateTimeFormatter simpleDateFormat = DateTimeFormatter.ofPattern(pattern);
		LocalDate unformattedDateTime = visit.getDate();
		return unformattedDateTime.format(simpleDateFormat);
	}
}
