package de.telran.dogs_owners.service.impl;

import de.telran.dogs_owners.dto.DogRequestDTO;
import de.telran.dogs_owners.dto.DogResponseDTO;
import de.telran.dogs_owners.dto.OwnerResponseDTO;
import de.telran.dogs_owners.entity.Dog;
import de.telran.dogs_owners.entity.Owner;
import de.telran.dogs_owners.repository.DogRepository;
import de.telran.dogs_owners.service.IDogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DogServiceImpl implements IDogService {

    @Autowired
    private DogRepository dogRepository;


    @Override
    public void createDog(DogRequestDTO request) {
        dogRepository.save(mapDogRequestToDog(request));

    }

    @Override
    public List<DogResponseDTO> getAllDogs() {
        return dogRepository.findAll().stream()
                .map(this::mapDogToDogResponse)
                .collect(Collectors.toList());
    }

    @Override
    public DogResponseDTO getDogById(Integer id) {
        Dog dog = dogRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return mapDogToDogResponse(dog);
    }

    @Override
    public List<DogResponseDTO> getAllUnregistered() {
        return null;
    }

    private Dog mapDogRequestToDog(DogRequestDTO request) {
        return Dog.builder()
                .id(request.getId())
                .nickname(request.getNickname())
                .breed(request.getBreed())
                .dateOfBirth(request.getDateOfBirth())
                .registrationDate(null)
                .owner(null)
                .build();
    }

    private DogResponseDTO mapDogToDogResponse(Dog dog) {
        return DogResponseDTO.builder()
                .id(dog.getId())
                .nickname(dog.getNickname())
                .breed(dog.getBreed())
                .build();
    }

}
