package com.boczar.gender_detection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.context.request.NativeWebRequest;

import java.awt.*;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class HttpMethodsTest{

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

}