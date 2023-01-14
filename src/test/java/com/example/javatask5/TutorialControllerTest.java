package com.example.javatask5;

import com.example.javatask5.model.Tutorial;
import com.example.javatask5.repository.TutorialRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TutorialControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    @MockBean
    TutorialRepository tutorialRepository;

    Tutorial tutorial1 = new Tutorial("adw","daw",true);
    Tutorial tutorial2 = new Tutorial("adwadw","dagdrw",true);
    Tutorial tutorial3 = new Tutorial("adfsew","dhfaw",true);

    @Test
    public void getAllRecords_success() throws Exception {
        List<Tutorial> records = new ArrayList<>(Arrays.asList(tutorial1, tutorial2, tutorial3));

        Mockito.when(tutorialRepository.findAll()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/tutorials")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(3)))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].title", Matchers.is("adfsew")));
    }
}
