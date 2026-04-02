package org.springframework.samples.petclinic.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.samples.petclinic.dto.PetDto;
import org.springframework.samples.petclinic.dto.PetShortDto;
import org.springframework.samples.petclinic.owner.Pet;

import java.time.LocalDate;
import java.time.Period;

@Mapper(componentModel = "spring", uses = VisitMapper.class)
public interface PetMapper {
	@Mapping(target = "ageInYears", source = "pet", qualifiedByName = "birthdayToAge")
	@Mapping(target = "typeName", source = "type.name")
	PetDto toDto(Pet pet);

	@Mapping(target = "typeName", source = "type.name")
	PetShortDto toShortDto(Pet pet);

	@Named(value = "typeName")
	default String getTypeName(Pet pet) {
		return pet.getType().getName();
	}

	@Named(value = "birthdayToAge")
	default int birthdayToAge(Pet pet) {
		return Period.between(pet.getBirthDate(), LocalDate.now()).getYears();
	}
}
