package de.telran.persons.controller;

import de.telran.persons.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

// 1. Создать метод, который будет обрабатывать эндпоинт GET /persons. В этом методе создать
// лист персонов и передать этот лист в шаблон под названием "persons.html"
// 2. Написать шаблон persons.html, используя thymeleaf синтаксис, который берет из модели
// лист персонов и распечатывает их в темплейте, используя таги для списка <ul> и <li>
// (зайти на сайт thymeleaf и посмотреть синтаксис для перебора коллекции)

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
