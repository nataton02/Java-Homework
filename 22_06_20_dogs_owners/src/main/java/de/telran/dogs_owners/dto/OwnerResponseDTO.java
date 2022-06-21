package de.telran.dogs_owners.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class OwnerResponseDTO {

    private Integer id;
    private String firstName;
    private String lastName;

}
