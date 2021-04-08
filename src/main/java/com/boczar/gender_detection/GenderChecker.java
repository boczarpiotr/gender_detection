package com.boczar.gender_detection;

import java.beans.FeatureDescriptor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GenderChecker {


    public String checkOnlyFirstName(String path, String path2,  String[] names) {
        String output = "";

        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            while (bf.readLine() != null) {
                if (names[0].equals(bf.readLine())) {
                    output = "Male";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }

        try (BufferedReader bf = new BufferedReader(new FileReader(path2))) {
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
    
}