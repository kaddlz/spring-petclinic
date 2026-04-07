package org.springframework.samples.petclinic.system;

import org.springframework.samples.petclinic.dto.OwnerDto;
import org.springframework.samples.petclinic.dto.OwnerShortDto;
import org.springframework.samples.petclinic.dto.mapper.OwnerMapper;
import org.springframework.samples.petclinic.owner.OwnerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {
	private final OwnerRepository ownerRepository;
	private final OwnerMapper ownerMapper;

	public MainController(OwnerRepository ownerRepository, OwnerMapper ownerMapper) {
		this.ownerRepository = ownerRepository;
		this.ownerMapper = ownerMapper;
	}

	@GetMapping("/owners/detailed")
	public List<OwnerDto> getDetailedOwners() {
		return ownerRepository.findAll().stream().map(ownerMapper::toDto).toList();
	}

	@GetMapping("/owners")
	public List<OwnerShortDto> getOwners() {
		return ownerRepository.findAll().stream().map(ownerMapper::toShortDto).toList();
	}
}
