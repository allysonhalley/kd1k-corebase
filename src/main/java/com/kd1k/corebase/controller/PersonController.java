package com.kd1k.corebase.controller;

import com.kd1k.corebase.dto.PersonRegisterDTO;
import com.kd1k.corebase.model.Person;
import com.kd1k.corebase.service.PersonService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity getAllPeople() {
        List<Person> people = personService.getAllPerson();
        return ResponseEntity.ok(people);
    }

    @PostMapping
    public ResponseEntity createPerson(@RequestBody @Valid PersonRegisterDTO personDto) {
        Person newPerson = personService.createPerson(personDto);
        return ResponseEntity.ok(newPerson);
    }


}
