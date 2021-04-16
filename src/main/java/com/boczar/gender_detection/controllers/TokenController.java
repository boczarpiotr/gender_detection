package com.boczar.gender_detection.controllers;

import com.boczar.gender_detection.GenderDetector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TokenController {

    private final String fileMale;
    private final String fileFemale;

    public TokenController(@Value("${file.male}") String fileMale, @Value("${file.female}") String fileFemale) {
        this.fileMale = fileMale;
        this.fileFemale = fileFemale;
    }


    private Logger logger = LoggerFactory.getLogger(TokenController.class);

    public List<String> readAllFromTxt(String fileName) {
        List<String> names = new ArrayList<>();


        try (BufferedReader bf = new BufferedReader(new InputStreamReader(new ClassPathResource(
                fileName).getInputStream()))) {
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

        return readAllFromTxt(fileMale);
    }

    @RequestMapping("/tokens/female")
    public List<String> getFemaleTokens() {

        return readAllFromTxt(fileFemale);
    }
}
