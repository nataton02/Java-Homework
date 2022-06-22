package de.telran.dogs_owners.service;

import de.telran.dogs_owners.dto.DogRequestDTO;
import de.telran.dogs_owners.dto.DogResponseDTO;

import java.util.List;

public interface IDogService {


    void createDog(DogRequestDTO request);

    List<DogResponseDTO> getAllByOwnerId(Integer ownerId);

    DogResponseDTO getDogById(Integer id);

    List<DogResponseDTO> getAllUnregistered();
}
