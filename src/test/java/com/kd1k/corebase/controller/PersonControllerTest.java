package com.kd1k.corebase.controller;

import com.kd1k.corebase.service.impl.PersonServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PersonController.class)
class PersonControllerTest {

    @Autowired
    private PersonServiceImpl personServiceImpl;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAllPeople() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/people/")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.people").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.people[*].id").isNotEmpty());


    }

    @Test
    void createPerson() {
    }
}