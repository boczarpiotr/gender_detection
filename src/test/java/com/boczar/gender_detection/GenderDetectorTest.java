package com.boczar.gender_detection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class GenderDetectorTest {

    GenderDetector genderDetector;

    @BeforeEach
    public void setup() {
        genderDetector = new GenderDetector();
    }

    @Test
    public void detectionByAllNamesShouldThrowNullPointer() {
        String[] names = null;
        Assertions.assertThrows(NullPointerException.class, () -> genderDetector.detectGenderByAllNames(names));
    }

    @Test
    public void detectionByFirstNamesShouldThrowNullPointer() {
        String[] names = null;
        Assertions.assertThrows(NullPointerException.class, () -> genderDetector.detectGenderByFistName(names));
    }


    @Test
    public void detectionByAllNamesShouldReturnMale() {
        String[] names = {"Ava", "Leo", "Owen"};
        Assertions.assertEquals("Male", genderDetector.detectGenderByAllNames(names));
    }

    @Test
    public void detectionByFirstNameShouldReturnMale() {
        String[] names = {"Leo", "Ava", "Amelia"};
        Assertions.assertEquals("Male", genderDetector.detectGenderByFistName(names));
    }

    @Test
    public void detectionByAllNamesShouldReturnFemale() {
        String[] names = {"Ava", "Leo", "Aria"};
        Assertions.assertEquals("Female", genderDetector.detectGenderByAllNames(names));
    }

    @Test
    public void detectionByAllNamesShouldReturnInconclusive() {
        String[] names = {"Ava", "Leo", "Aria", "Owen"};
        Assertions.assertEquals("INCONCLUSIVE", genderDetector.detectGenderByAllNames(names));
    }

    @Test
    public void detectionByAllNamesShouldReturnInconclusivePartTwo() {
        String[] names = {"Leo", "Aria"};
        Assertions.assertEquals("INCONCLUSIVE", genderDetector.detectGenderByAllNames(names));
    }

    @Test
    public void convertingStringShouldReturnArray() {
        String string = "Aria ,Owen  , Mark,Ava";
        String[] stringArray = {"Aria", "Owen", "Mark", "Ava"};
        Assertions.assertArrayEquals(stringArray, genderDetector.convertStringToArray(string));
    }

    @Test
    public void convertingNullStringShouldThrowNullPointer() {
        String string = null;
        Assertions.assertThrows(NullPointerException.class, () -> genderDetector.convertStringToArray(string));
    }

    @Test
    public void convertingStringShouldReturnArrayPartTwo() {
        String string = "Liam, Caleb, Ava";
        String[] stringArray = {"Liam", "Caleb", "Ava"};
        Assertions.assertArrayEquals(stringArray, genderDetector.convertStringToArray(string));

    }
}