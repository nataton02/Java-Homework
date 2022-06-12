package de.telran.persons_rest.repo;

import de.telran.persons_rest.model.Person;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PersonRepo {
    private int currentId = 0;
    private final Map<Integer, Person> source;

    private Person createPerson(int id, String name, String lastname, int age) {
        Person person = new Person(name, lastname, age);
        person.setId(id);
        return person;
    }

    {
        source = new HashMap<>();
        source.put(++currentId, createPerson(currentId, "Vasily", "Vasilevich", 30));
        source.put(++currentId, createPerson(currentId, "Petr", "Petrovich", 35));
        source.put(++currentId, createPerson(currentId, "Maria", "Ivanova", 20));
    }


    /**
     * saves a new person or edits the old person
     * @param person new person or existing person
     * @return saved person with assigned id
     */
    public Person save(Person person) {
        if(person.getId() == null) {
            person.setId(++currentId);
        }
        source.put(person.getId(), person);
        return person;
    }

    /**
     * removes the person with this id and returns it
     * @param id
     * @return
     */
    public Person delete(int id) {
        return source.remove(id);
    }

    /**
     * finds the person with this id and returns if exists. Otherwise returns empty optional.
     * @param id
     * @return
     */
    public Optional<Person> find(int id) {
        return Optional.ofNullable(source.get(id));
    }

    /**
     *
     * @return all persons
     */
    public List<Person> findAll() {
        //Todo return persons sorted by id
        List<Person> persons = new ArrayList<>(source.values());
        persons.sort(Comparator.comparing(Person::getId));
        return persons;
    }
}
