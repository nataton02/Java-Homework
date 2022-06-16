package de.telran.persons_rest.service;
import de.telran.persons_rest.dto.PhoneNumberDto;
import de.telran.persons_rest.model.Person;
import de.telran.persons_rest.model.PhoneNumber;
import de.telran.persons_rest.repo.PersonRepo;
import de.telran.persons_rest.repo.PhoneNumberRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PhoneNumberService {

    private final PhoneNumberRepo phoneNumberRepo;
    private final PersonRepo personRepo;

    public PhoneNumberService(PhoneNumberRepo phoneNumberRepo, PersonRepo personRepo) {
        this.phoneNumberRepo = phoneNumberRepo;
        this.personRepo = personRepo;
    }


    public PhoneNumberDto get(Integer id) {
        return phoneNumberRepo.findById(id)
                .map(this::mapPhoneNumberToDto)
                .orElseThrow();
    }


    private PhoneNumberDto mapPhoneNumberToDto(PhoneNumber phoneNumber) {
        return new PhoneNumberDto(
                phoneNumber.getId(),
                phoneNumber.getCodeNumber(),
                phoneNumber.getPhoneNumber(),
                phoneNumber.getPerson().getId()
        );
    }


    public PhoneNumberDto create(PhoneNumberDto phoneNumberDto) {
        Person person = personRepo.findById(phoneNumberDto.getPersonId()).orElseThrow();
        PhoneNumber phoneNumber = new PhoneNumber(
                phoneNumberDto.getCodeNumber(),
                phoneNumberDto.getPhoneNumber(),
                person
        );
        return mapPhoneNumberToDto(phoneNumberRepo.save(phoneNumber));
    }


    public void edit(PhoneNumberDto phoneNumberDto) {
        PhoneNumber phoneNumber = phoneNumberRepo.findById(phoneNumberDto.id).orElseThrow();

        phoneNumber.setCodeNumber(phoneNumberDto.getCodeNumber());
        phoneNumber.setPhoneNumber(phoneNumberDto.getPhoneNumber());

        phoneNumberRepo.save(phoneNumber);
    }


    public void remove(Integer id) {
        phoneNumberRepo.deleteById(id);
    }


    public List<PhoneNumberDto> getAll() {
        return phoneNumberRepo.findAll().stream()
                .map(this::mapPhoneNumberToDto)
                .collect(Collectors.toList());
    }


    public List<PhoneNumberDto> getAllByPersonId(Optional<Integer> personId) {
        List<PhoneNumber> phoneNumbers;
        if(personId.isPresent())
            phoneNumbers = phoneNumberRepo.findAllByPersonId(personId.get());
        else
            phoneNumbers = phoneNumberRepo.findAll();

        return phoneNumbers.stream()
                .map(this::mapPhoneNumberToDto)
                .collect(Collectors.toList());
    }
}
