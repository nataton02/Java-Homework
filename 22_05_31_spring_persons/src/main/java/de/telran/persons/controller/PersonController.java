package de.telran.persons.controller;

import de.telran.persons.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PersonController {

    List<Person> personList = List.of(
            new Person("Ivan", "Ivanov"),
            new Person("Vasiliy", "Vasiliev"),
            new Person("Maria", "Petrova")
    );


    @GetMapping("/persons")
    public String persons(Model model) {
        model.addAttribute("persons", personList);
        return "persons";
    }
}
