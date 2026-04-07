package org.springframework.samples.petclinic.dto.mapper;

import org.mapstruct.Mapper;
import org.springframework.samples.petclinic.dto.OwnerDto;
import org.springframework.samples.petclinic.owner.OwnerContact;

@Mapper(componentModel = "spring")
public interface OwnerContactInfoMapper {

	OwnerDto.ContactInfoDto toDto(OwnerContact ownerContact);

}
