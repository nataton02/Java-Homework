package de.telran.dogs_owners.controller;

import de.telran.dogs_owners.dto.DogRequestDTO;
import de.telran.dogs_owners.dto.DogResponseDTO;
import de.telran.dogs_owners.dto.OwnerResponseDTO;
import de.telran.dogs_owners.service.IDogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DogController {

    @Autowired
    private IDogService iDogService;


    @PostMapping("/dogs")
    public void createDog(@RequestBody DogRequestDTO request) {
        iDogService.createDog(request);
    }

    @GetMapping("/dogs")
    public List<DogResponseDTO> getAllDogs() {
        return iDogService.getAllDogs();
    }

    @GetMapping("/dogs/unregistered")
    public List<DogResponseDTO> getAllUnregistered() {
        return null;
    }


}
