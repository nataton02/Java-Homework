package de.telran.dogs_owners.repository;

import de.telran.dogs_owners.dto.DogResponseDTO;
import de.telran.dogs_owners.entity.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface DogRepository extends JpaRepository<Dog, Integer> {
    List<Dog> findAllByOwnerId(Integer integer);

}
