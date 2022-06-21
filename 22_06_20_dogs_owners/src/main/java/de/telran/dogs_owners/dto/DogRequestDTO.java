package de.telran.dogs_owners.dto;

import lombok.AllArgsConstructor;
import lombok.Data;



@AllArgsConstructor
@Data
public class DogRequestDTO {

    private Integer id;
    private String nickname;
    private String breed;
    private String dateOfBirth;
    private String registrationDate;

}
