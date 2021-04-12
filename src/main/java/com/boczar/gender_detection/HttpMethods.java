package com.boczar.gender_detection;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class HttpMethods {

    GenderChecker genderChecker = new GenderChecker();

    @PostMapping("/detect/byone")
    public String chceckGenderByOne(@RequestBody String string) {
        String[] strings = genderChecker.convertStringToArray(string);
        return genderChecker.detectGenderByFistName(strings);

    }
    @PostMapping("/detect/byall")
    public String chceckGenderByAll(@RequestBody String string) {
        String[] strings = genderChecker.convertStringToArray(string);
        return genderChecker.detectGenderByAllNames(strings);

    }


}
