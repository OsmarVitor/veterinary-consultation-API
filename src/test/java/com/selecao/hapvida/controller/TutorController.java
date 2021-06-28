package com.selecao.hapvida.controller;

import com.google.gson.Gson;
import com.selecao.hapvida.domain.repository.TutorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@TestPropertySource("classpath:application-test.properties")
@SpringBootTest
@AutoConfigureMockMvc
public class TutorController {

    @Autowired
    private MockMvc mockMvc;

    @Autowired private TutorRepository tutorRepository;

    private static final Gson gson = new Gson();

    @Test
    void findAllTutorsWithoutTutorSaved() throws Exception {
        mockMvc
                .perform(get("/tutor").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalPages").value("0"))
                .andExpect(jsonPath("$.totalElements").value("0"))
                .andExpect(jsonPath("$.last").value(Boolean.TRUE))
                .andExpect(jsonPath("$.first").value(Boolean.TRUE))
                .andExpect(jsonPath("$.numberOfElements").value("0"))
                .andExpect(jsonPath("$.size").value("15"))
                .andExpect(jsonPath("$.number").value("0"))
                .andExpect(jsonPath("$.numberOfElements").value("0"));

        assertEquals(0, tutorRepository.findAll().size());
    }
}
