package de.telran.persons.controller;

import de.telran.persons.model.Person;
import de.telran.persons.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("persons", personService.getAll());
        return "index";
    }

    @GetMapping("/new-person")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "edit-person";
    }

    @PostMapping("/save-person")
    public String savePerson(@ModelAttribute Person person) {
        personService.save(person);
        return "redirect:/";
    }

    @GetMapping("/edit-person/{id}")
    public String editPerson(@PathVariable int id, Model model) {
        model.addAttribute("person", personService.get(id));
        return "edit-person";
    }

    @GetMapping("/delete-person/{id}")
    public String deletePerson(@PathVariable int id) {
        personService.remove(personService.get(id));
        return "redirect:/";
    }

    @GetMapping("/show-person/{id}")
    public String showPerson(@PathVariable int id, Model model) {
        model.addAttribute("person", personService.get(id));
        return "show-person";
    }






}
