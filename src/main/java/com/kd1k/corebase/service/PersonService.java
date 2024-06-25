package com.kd1k.corebase.service;

import com.kd1k.corebase.dto.PersonRegisterDTO;
import com.kd1k.corebase.model.Person;

import java.sql.Date;
import java.util.List;

public interface PersonService {

    public List<Person> getAllPerson();

    public List<Person> getAllPersonByName(String name);

    public Person getPersonByCpf(String cpf);

    public List<Person> getAllPersonByBirthdate(String birthdate);

    public Person getPersonById(String id);

    public Person getPersonByCPF(String cpf);

    public Person createPerson(PersonRegisterDTO personRegisterDTO);

    public Person savePerson(Person person);

    public Person updatePerson(Person person);

    public void deletePerson(String id);

    public boolean ifExists(String id);

}
