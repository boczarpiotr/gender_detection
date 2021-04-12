package com.boczar.gender_detection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class GenderChecker {


    public String detectGenderByFistName(String[] names) {
        if (names == null) {
            throw new NullPointerException("Please provide list of names");
        }
        String output = "This name is not present in our database";
        String currentLine;
        try (BufferedReader bf = new BufferedReader(new FileReader("male_names.txt"))) {
            while ((currentLine = bf.readLine()) != null) {
                if (names[0].equals(currentLine)) {
                    output = "Male";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }

        try (BufferedReader bf = new BufferedReader(new FileReader("female_names.txt"))) {
            while ((currentLine = bf.readLine()) != null) {
                if (names[0].equals(currentLine)) {
                    output = "Female";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return output;
    }

    public String detectGenderByAllNames(String[] names) {
        if (names == null) {
            throw new NullPointerException("Please provide list of names");
        }

        int maleOccurance = 0;
        int femaleOccurance = 0;

        try (BufferedReader bf = new BufferedReader(new FileReader("male_names.txt"))) {
            String currentLine;
            while ((currentLine = bf.readLine()) != null) {
                for (String name : names) {
                    if (name.equals(currentLine)) {
                        maleOccurance++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader bf = new BufferedReader(new FileReader("female_names.txt"))) {
            String currentLine;
            while ((currentLine = bf.readLine()) != null) {
                for (String name : names) {
                    if (name.equals(currentLine)) {
                        femaleOccurance++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (maleOccurance > femaleOccurance) {
            return "Male";
        } else if (femaleOccurance > maleOccurance) {
            return "Female";
        } else {
            return "INCONCLUSIVE";
        }
    }
    public String[] convertStringToArray(String string){
        if (string == null){
            throw new NullPointerException("Please provide list of names");
        }
        String s = string.replaceAll("\\s", "");
        return s.split(",");

    }

}