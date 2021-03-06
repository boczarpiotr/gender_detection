package com.boczar.gender_detection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class DetectionControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void checkByOneNameShouldReturnMale() throws Exception {

        this.mockMvc
                .perform(post("/detect/byone")
                        .contentType(MediaType.ALL_VALUE)
                        .content("Leo , Ava"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Male")));
    }

    @Test
    public void checkByOneNameShouldReturnFemale() throws Exception {

        this.mockMvc
                .perform(post("/detect/byone")
                        .contentType(MediaType.ALL_VALUE)
                        .content("Ava , Owen, Leo  "))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Female")));
    }

    @Test
    public void checkByAllShouldReturnFemale() throws Exception {

        this.mockMvc
                .perform(post("/detect/byall")
                        .contentType(MediaType.ALL_VALUE)
                        .content("Ava, Aria, Leo  "))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Female")));
    }

    @Test
    public void checkByAllShouldReturnMale() throws Exception {

        this.mockMvc
                .perform(post("/detect/byall")
                        .contentType(MediaType.ALL_VALUE)
                        .content("Ava , Leo , Owen  "))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Male")));
    }

    @Test
    public void checkByAllShouldReturnInconclusive() throws Exception {

        this.mockMvc
                .perform(post("/detect/byall")
                        .contentType(MediaType.ALL_VALUE)
                        .content("Ava , Leo , Owen  , Aria"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("INCONCLUSIVE")));
    }

    @Test
    public void emptyStringShouldReturnBadRequestInDetectByAll() throws Exception {

        this.mockMvc
                .perform(post("/detect/byall")
                        .contentType(MediaType.ALL_VALUE)
                        .content(""))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void emptyStringShouldReturnBadRequestInDetectByOne() throws Exception {

        this.mockMvc
                .perform(post("/detect/byone")
                        .contentType(MediaType.ALL_VALUE)
                        .content(""))
                .andExpect(status().isBadRequest());

    }
}