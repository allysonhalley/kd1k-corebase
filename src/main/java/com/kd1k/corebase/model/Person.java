package com.kd1k.corebase.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank(message = "Name is Mandatory")
    private String name;

    @NotBlank(message = "CPF is Mandatory")
    @Column(unique = true)
    private String cpf;

    private Date birthdate;

    public Person(String name, String cpf, Date birthdate) {
        this.name = name;
        this.cpf = cpf;
        this.birthdate = birthdate;
    }


}
