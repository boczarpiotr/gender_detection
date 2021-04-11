package com.boczar.gender_detection;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TokenScreen {

    @RequestMapping("/tokens/male")
    public List<String> getMaleTokens() {

        List<String> maleNames = new ArrayList<>();


        try (BufferedReader bf = new BufferedReader(new FileReader("male_names.txt"))) {
            while (bf.readLine() != null) {
                maleNames.add(bf.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return maleNames;
    }

    @RequestMapping("/tokens/female")
    public List<String> getFemaleTokens() {

        List<String> femaleNames = new ArrayList<>();


        try (BufferedReader bf = new BufferedReader(new FileReader("female_names.txt"))) {
            while (bf.readLine() != null) {
                femaleNames.add(bf.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return femaleNames;
    }
}
