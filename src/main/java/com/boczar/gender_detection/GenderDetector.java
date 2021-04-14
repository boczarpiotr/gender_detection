package com.boczar.gender_detection;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class GenderDetector {

    public String readFromTxt(String fileName, String gender, String[] names) {
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


    public String detectGenderByFistName(String[] names) {
        if (names == null) {
            throw new NullPointerException("Please provide list of names");
        }
        if ((readFromTxt("male_names.txt", "Male", names)).length() == 0) {
            return readFromTxt("female_names.txt", "Female", names);
        } else {
            return readFromTxt("male_names.txt", "Male", names);
        }

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

    public String[] convertStringToArray(String string) {
        if (string == null) {
            throw new NullPointerException("Please provide list of names");
        }
        String s = string.replaceAll("\\s", "");
        return s.split(",");

    }

}