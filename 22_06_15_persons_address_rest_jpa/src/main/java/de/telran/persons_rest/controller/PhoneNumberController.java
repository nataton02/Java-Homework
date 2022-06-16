package de.telran.persons_rest.controller;
import de.telran.persons_rest.dto.PhoneNumberDto;
import de.telran.persons_rest.service.PhoneNumberService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/phoneNumbers")
public class PhoneNumberController {

    private final PhoneNumberService phoneNumberService;

    public PhoneNumberController(PhoneNumberService phoneNumberService) {
        this.phoneNumberService = phoneNumberService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public PhoneNumberDto get(@PathVariable Integer id) {
        return phoneNumberService.get(id);
    }

    @PostMapping()
    public PhoneNumberDto create(@RequestBody PhoneNumberDto phoneNumberDto) {
        return phoneNumberService.create(phoneNumberDto);
    }

    @PutMapping()
    public void edit(@RequestBody PhoneNumberDto phoneNumberDto) {
        phoneNumberService.edit(phoneNumberDto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        phoneNumberService.remove(id);
    }

    @GetMapping
    public List<PhoneNumberDto> getAll(@RequestParam (required = false) Optional<Integer> personId) {
        return phoneNumberService.getAllByPersonId(personId);
    }
}
