package com.boczar.gender_detection;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GenderCheckerTest {

    GenderChecker genderChecker;

    @BeforeEach
    public void setup() {
        genderChecker = new GenderChecker();
    }

    @Test
    public void detectionByAllNamesShouldThrowNullPointer() {
        String[] names = null;
        Assertions.assertThrows(NullPointerException.class, () -> genderChecker.detectGenderByAllNames(names));
    }

    @Test
    public void detectionByFirstNamesShouldThrowNullPointer() {
        String[] names = null;
        Assertions.assertThrows(NullPointerException.class, () -> genderChecker.detectGenderByFistName(names));
    }


    @Test
    public void detectionByAllNamesShouldReturnMale() {
        String[] names = {"Ava", "Leo", "Owen"};
        Assertions.assertEquals("Male", genderChecker.detectGenderByAllNames(names));
    }

    @Test
    public void detectionByFirstNameShouldReturnMale() {
        String[] names = {"Leo", "Ava", "Amelia"};
        Assertions.assertEquals("Male", genderChecker.detectGenderByFistName(names));
    }

    @Test
    public void detectionByAllNamesShouldReturnFemale() {
        String[] names = {"Ava", "Leo", "Aria"};
        Assertions.assertEquals("Female", genderChecker.detectGenderByAllNames(names));
    }

    @Test
    public void detectionByAllNamesShouldReturnInconclusive() {
        String[] names = {"Ava", "Leo", "Aria", "Owen"};
        Assertions.assertEquals("INCONCLUSIVE", genderChecker.detectGenderByAllNames(names));
    }

    @Test
    public void detectionByAllNamesShouldReturnInconclusivePartTwo() {
        String[] names = {"Leo", "Aria"};
        Assertions.assertEquals("INCONCLUSIVE", genderChecker.detectGenderByAllNames(names));
    }

    @Test
    public void convertingStringShouldReturnArray() {
        String string = "Aria ,Owen  , Mark,Ava";
        String[] stringArray = {"Aria", "Owen", "Mark", "Ava"};
        Assertions.assertArrayEquals(stringArray, genderChecker.convertStringToArray(string));
    }

    @Test
    public void convertingNullStringShouldThrowNullPointer() {
        String string = null;
        Assertions.assertThrows(NullPointerException.class, () -> genderChecker.convertStringToArray(string));
    }

}