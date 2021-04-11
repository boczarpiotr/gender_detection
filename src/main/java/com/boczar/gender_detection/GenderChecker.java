package com.boczar.gender_detection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GenderChecker {


    public String checkOnlyFirstName(String[] names) {
        if (names == null){
            throw new NullPointerException("Please provide list of names");
        }
        String output = "This name is not present in our database";

        try (BufferedReader bf = new BufferedReader(new FileReader("male_names.txt"))) {
            while (bf.readLine() != null) {
                if (names[0].equals(bf.readLine())) {
                    output = "Male";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }

        try (BufferedReader bf = new BufferedReader(new FileReader("female_names.txt"))) {
            while (bf.readLine() != null) {
                if (names[0].equals(bf.readLine())) {
                    output = "Female";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return output;
    }

    public static void main(String[] args) {
        GenderChecker genderChecker = new GenderChecker();
        String[] names = null;
        System.out.println(genderChecker.checkOnlyFirstName(names));
    }

}