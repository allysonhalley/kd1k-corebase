package com.kd1k.corebase.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Table(name = "people")
@Entity(name = "people")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String fullName;
    private String cpf;
    private Date birthdate;

    public Person(String fullName, String cpf, Date birthdate) {

        this.fullName = fullName;
        this.cpf = cpf;
        this.birthdate = birthdate;
    }
}
