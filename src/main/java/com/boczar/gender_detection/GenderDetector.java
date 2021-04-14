package com.boczar.gender_detection;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class GenderDetector {

    public String readFromTextAndCheckFirstName(String fileName, String gender, String[] names) {
        String output = "";
        String currentLine;
        try (BufferedReader bf = new BufferedReader(new FileReader(fileName))) {
            while ((currentLine = bf.readLine()) != null) {
                if (names[0].equals(currentLine)) {
                    output = gender;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

    public int readFromTxtAndCheckAllNames(String fileName, String[] names) {
        int occurance = 0;

        try (
                BufferedReader bf = new BufferedReader(new FileReader(fileName))) {
            String currentLine;
            while ((currentLine = bf.readLine()) != null) {
                for (String name : names) {
                    if (name.equals(currentLine)) {
                        occurance++;
                    }
                }
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return occurance;
    }


    public String detectGenderByFistName(String[] names) {
        if (names == null) {
            throw new NullPointerException("Please provide list of names");
        }
        if ((readFromTextAndCheckFirstName("male_names.txt", "Male", names)).length() == 0) {
            return readFromTextAndCheckFirstName("female_names.txt", "Female", names);
        } else {
            return readFromTextAndCheckFirstName("male_names.txt", "Male", names);
        }

    }


    public String detectGenderByAllNames(String[] names) {
        if (names == null) {
            throw new NullPointerException("Please provide list of names");
        }
        int maleOccurance = readFromTxtAndCheckAllNames("male_names.txt", names);
        int femaleOccurance = readFromTxtAndCheckAllNames("female_names.txt", names);

        if (maleOccurance > femaleOccurance) {
            return "Male";
        } else if (femaleOccurance > maleOccurance) {
            return "Female";
        } else {
            return "INCONCLUSIVE";
        }
    }

    public String[] convertStringToArray(String string) {
        if (string == null) {
            throw new NullPointerException("Please provide list of names");
        }
        String s = string.replaceAll("\\s", "");
        return s.split(",");

    }

}