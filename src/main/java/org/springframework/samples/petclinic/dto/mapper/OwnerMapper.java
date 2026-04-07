package org.springframework.samples.petclinic.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.samples.petclinic.dto.OwnerDto;
import org.springframework.samples.petclinic.dto.OwnerShortDto;
import org.springframework.samples.petclinic.owner.Owner;

@Mapper(componentModel = "spring", uses = {OwnerContactInfoMapper.class, PetMapper.class})
public interface OwnerMapper {
	@Mapping(target = "fullName", source = "owner", qualifiedByName = "fullName")
	@Mapping(target = "contactInfo", source = "owner")
	@Mapping(target = "pets", source = "pets")
	OwnerDto toDto(Owner owner);

	@Mapping(target = "fullName", source = "owner", qualifiedByName = "fullName")
	OwnerShortDto toShortDto(Owner owner);

	@Named(value = "fullName")
	default String toFullName(Owner owner) {
		return owner.getFirstName() + " " + owner.getLastName();
	}
}
