package com.boczar.gender_detection.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TokenController {

    Logger logger = LoggerFactory.getLogger(TokenController.class);

    public List<String> readAllFromTxt(String fileName) {
        List<String> names = new ArrayList<>();


        try (BufferedReader bf = new BufferedReader(new FileReader(fileName))) {
            while (bf.readLine() != null) {
                names.add(bf.readLine());
            }
        } catch (IOException e) {
            logger.error("Please make sure your input path is correct");

        }
        return names;

    }

    @RequestMapping("/tokens/male")
    public List<String> getMaleTokens() {

        return readAllFromTxt("male_names.txt");
    }

    @RequestMapping("/tokens/female")
    public List<String> getFemaleTokens() {

        return readAllFromTxt("female_names.txt");
    }
}
