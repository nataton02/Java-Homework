package de.telran.dogs_owners.service;

import de.telran.dogs_owners.dto.DogRequestDTO;
import de.telran.dogs_owners.dto.DogResponseDTO;
import de.telran.dogs_owners.dto.OwnerRequestDTO;
import de.telran.dogs_owners.dto.OwnerResponseDTO;

import java.util.List;

public interface IOwnerService {

    void createOwner(OwnerRequestDTO request);

    List<OwnerResponseDTO> getAllOwners();

    OwnerResponseDTO getOwnerById(Integer id);



}
