package de.telran.dogs_owners.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class DogResponseDTO {
    private Integer id;
    private String nickname;
    private String breed;
    private Integer ownerId;
}
