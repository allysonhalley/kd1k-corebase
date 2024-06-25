package com.kd1k.corebase.dto;

import com.kd1k.corebase.model.Person;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.UniqueElements;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public record PersonRegisterDTO(
        @NotBlank String name,
        @NotBlank String cpf,
        @NotBlank String birthDate
) {

    public Person toPerson() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Date birthDate = Date.valueOf(LocalDate.parse(this.birthDate, formatter));
        return new Person(this.name(), this.cpf(), birthDate);
    }
}
