package de.telran.dogs_owners.controller;

import de.telran.dogs_owners.dto.DogResponseDTO;
import de.telran.dogs_owners.dto.OwnerRequestDTO;
import de.telran.dogs_owners.dto.OwnerResponseDTO;
import de.telran.dogs_owners.service.IDogService;
import de.telran.dogs_owners.service.IOwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OwnerController {

    @Autowired
    private IOwnerService iOwnerService;
    private IDogService iDogService;

    @GetMapping("/owners")
    public List<OwnerResponseDTO> getAllOwners() {
        return iOwnerService.getAllOwners();
    }

    @GetMapping("/owners/{id}")
    public OwnerResponseDTO getOwnerById(@PathVariable("id") Integer id) {
        return iOwnerService.getOwnerById(id);
    }

    @PostMapping("/owners")
    public void createOwner(@RequestBody OwnerRequestDTO request) {
        iOwnerService.createOwner(request);
    }

    //@PutMapping("/owners/{id}/dogs/{dogId}")
    //public DogResponseDTO getOwnerById(@PathVariable("id") Integer id, Integer dogId) {
    //    return iDogService.toggleDog(id, dogId);
    //}


}
