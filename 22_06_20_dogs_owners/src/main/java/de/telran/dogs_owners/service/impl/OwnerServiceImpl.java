package de.telran.dogs_owners.service.impl;

import de.telran.dogs_owners.dto.DogRequestDTO;
import de.telran.dogs_owners.dto.DogResponseDTO;
import de.telran.dogs_owners.dto.OwnerRequestDTO;
import de.telran.dogs_owners.dto.OwnerResponseDTO;
import de.telran.dogs_owners.entity.Dog;
import de.telran.dogs_owners.entity.Owner;
import de.telran.dogs_owners.repository.DogRepository;
import de.telran.dogs_owners.repository.OwnerRepository;
import de.telran.dogs_owners.service.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerServiceImpl implements IOwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public void createOwner(OwnerRequestDTO request) {
        ownerRepository.save(mapOwnerRequestToOwner(request));
    }

    @Override
    public List<OwnerResponseDTO> getAllOwners() {
        return ownerRepository.findAll().stream()
                .map(this::mapOwnerToOwnerResponse)
                .collect(Collectors.toList());
    }

    @Override
    public OwnerResponseDTO getOwnerById(Integer id) {
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return mapOwnerToOwnerResponse(owner);
    }


    private Owner mapOwnerRequestToOwner(OwnerRequestDTO request) {
        return Owner.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .dateOfBirth(request.getDateOfBirth())
                .build();
    }

    private OwnerResponseDTO mapOwnerToOwnerResponse(Owner owner) {
        return OwnerResponseDTO.builder()
                .id(owner.getId())
                .firstName(owner.getFirstName())
                .lastName(owner.getLastName())
                .build();
    }






}
