package com.kd1k.corebase.repository;

import com.kd1k.corebase.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {


    Optional<Person> findPersonByNameContaining(String name);
    Optional<Person> findPersonByCpf(String cpf);
    Optional<Person> findPersonByBirthdate(Date birthday);

}
