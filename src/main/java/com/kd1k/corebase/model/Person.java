package com.kd1k.corebase.model;

import com.kd1k.corebase.dto.PersonRegisterDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jdk.jfr.DataAmount;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

    public Person(PersonRegisterDTO dto){
        this.name = dto.name();
        this.cpf = dto.cpf();
        this.birthdate = dto.toPerson().getBirthdate();
    }

    public void plusOneDay(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.setBirthdate(
                Date.valueOf(LocalDate.parse(
                        this.birthdate.toString(),
                        formatter).plusDays(1)));
    }


}
