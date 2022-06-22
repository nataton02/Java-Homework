package de.telran.dogs_owners.controller;

import de.telran.dogs_owners.dto.DogRequestDTO;
import de.telran.dogs_owners.dto.DogResponseDTO;
import de.telran.dogs_owners.dto.OwnerResponseDTO;
import de.telran.dogs_owners.service.IDogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DogController {

    @Autowired
    private IDogService iDogService;


    @PostMapping("/dogs")
    public void createDog(@RequestBody DogRequestDTO request) {
        iDogService.createDog(request);
    }

    @GetMapping("/dogs")
    public List<DogResponseDTO> getAllByOwnerId(@RequestParam (required = false) Integer ownerId) {
        return iDogService.getAllByOwnerId(ownerId);
    }

    @GetMapping("/dogs/unregistered")
    public List<DogResponseDTO> getAllUnregistered() {
        return null;
    }


}
