package com.boczar.gender_detection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.session.NonUniqueSessionRepositoryException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class GenderDetector {

    private static final String male = "Male";
    private static final String female = "Female";

    Logger logger = LoggerFactory.getLogger(GenderDetector.class);

    public String readFromTextAndCheckFirstName(String fileName, String gender, String[] names) {

        if (fileName == null) {
            throw new NullPointerException("Please provide file name");
        }
        if (names == null) {
            throw new NullPointerException("Please provide names");
        }
        if (gender.equals("")) {
            throw new RuntimeException("Please provide name of gender that will be checked");
        }

        String output = "";
        String currentLine;
        try (BufferedReader bf = new BufferedReader(new FileReader(fileName))) {
            while ((currentLine = bf.readLine()) != null) {
                if (names[0].equals(currentLine)) {
                    output = gender;
                }
            }
        } catch (IOException e) {
            logger.error("Please make sure your input path is correct");
        }
        return output;
    }

    public int readFromTxtAndCheckAllNames(String fileName, String[] names) {

        if (fileName == null) {
            throw new NullPointerException("Please provide path to file with names");
        }
        if (names == null) {
            throw new NullPointerException("Please provide names");
        }

        int occurrence = 0;

        try (
                BufferedReader bf = new BufferedReader(new FileReader(fileName))) {
            String currentLine;
            while ((currentLine = bf.readLine()) != null) {
                for (String name : names) {
                    if (name.equals(currentLine)) {
                        occurrence++;
                    }
                }
            }
        } catch (
                IOException e) {
            logger.error("Please make sure your input path is correct");
        }
        return occurrence;
    }


    public String detectGenderByFistName(String[] names) throws NullPointerException {
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
            return male;
        } else if (femaleOccurance > maleOccurance) {
            return female;
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