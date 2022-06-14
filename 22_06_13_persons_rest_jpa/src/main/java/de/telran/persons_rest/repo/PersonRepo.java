package de.telran.persons_rest.repo;

import de.telran.persons_rest.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;


public interface PersonRepo extends JpaRepository<Person, Integer> {
    public List<Person> findAllByNameAndLastname(String name, String lastname);
    public List<Person> findAllByName(String name);
    public List<Person> findAllByLastname(String lastname);

    public List<Person> findAllByAgeGreaterThan(int age);

}
