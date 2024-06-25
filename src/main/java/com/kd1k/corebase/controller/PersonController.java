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
@RequestMapping("/people")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity getAllPeople() {
        return ResponseEntity.ok(personService.getAllPerson());
    }

    @GetMapping("/name/{name}")
    public ResponseEntity getPersonName(@RequestParam String name) {
        return ResponseEntity.ok(personService.getAllPersonByName(name));
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity getPersonCPF(@RequestParam String cpf) {
        return ResponseEntity.ok(personService.getPersonByCPF(cpf));
    }



    @PostMapping
    public ResponseEntity createPerson(@RequestBody @Valid PersonRegisterDTO personDto){
        return ResponseEntity.ok(personService.createPerson(personDto));

    }

    @GetMapping("/id/{id}")
    public ResponseEntity getPersonById(@PathVariable String id) {
        return ResponseEntity.ok(personService.getPersonById(id));
    }

    @PutMapping
    public ResponseEntity updatePerson(@RequestBody @Valid Person person) {
        return ResponseEntity.ok(personService.updatePerson(person));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePerson(@PathVariable String id) throws Exception {
        try {
            personService.deletePerson(id);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Person with id " + id + " could not be deleted.");
        }
    }

}
