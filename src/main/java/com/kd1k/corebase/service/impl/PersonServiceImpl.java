package com.kd1k.corebase.service.impl;

import com.kd1k.corebase.dto.PersonRegisterDTO;
import com.kd1k.corebase.model.Person;
import com.kd1k.corebase.repository.PersonRepository;
import com.kd1k.corebase.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(String id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent()) {
            return person.get();
        }
        return null;
    }

    @Override
    public Person getPersonByCPF(String cpf) {
        Optional<Person> person = personRepository.findPersonByCpf(cpf);
        if (person.isPresent()) {
            return person.get();
        }
        return null;
    }

    @Override
    public Person createPerson(PersonRegisterDTO personRegisterDTO) {
        Person person = personRegisterDTO.toPerson();
        if (validatePerson(person)) {
            Person savedPerson = personRepository.save(person);
            return savedPerson;
        }
        return null;
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Person person) {

        if (validatePerson(person) && personRepository.existsById(person.getId())) {
            Person updatedPerson = personRepository.save(person);
            return updatedPerson;
        }
        return null;
    }

    @Override
    public void deletePerson(String id) {
        personRepository.deleteById(id);
    }

    private boolean validatePerson(Person person) {
        if (person != null){
            if(validateAttributes(person.getName())
                    && validateAttributes(person.getCpf())
                    && validateAttributes(person.getBirthdate().toString())){
                return true;
            }
        }
        return false;
    }

    private boolean validateAttributes(String attributes) {
        if (attributes.isEmpty() || attributes.isBlank()){
            return false;
        }
        return true;
    }
}
