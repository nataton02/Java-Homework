package de.telran.dogs_owners.dto;

import de.telran.dogs_owners.entity.Dog;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
public class OwnerRequestDTO {

    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private List<Dog> dogs;
}
