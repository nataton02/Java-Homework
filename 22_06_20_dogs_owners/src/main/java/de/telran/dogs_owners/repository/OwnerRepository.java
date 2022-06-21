package de.telran.dogs_owners.repository;

import de.telran.dogs_owners.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Integer> {
}
