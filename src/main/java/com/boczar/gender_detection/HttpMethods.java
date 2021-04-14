package com.boczar.gender_detection;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HttpMethods {

    private final GenderDetector genderDetector;

    public HttpMethods(GenderDetector genderDetector) {
        this.genderDetector = genderDetector;
    }

    @PostMapping("/detect/byone")

    public String chceckGenderByOne(@RequestBody String string) {
        if (string == null) {
            throw new NullPointerException("Please provide list of names");
        }
        String[] strings = genderDetector.convertStringToArray(string);
        return genderDetector.detectGenderByFistName(strings);

    }

    @PostMapping("/detect/byall")

    public String chceckGenderByAll(@RequestBody String string) {
        if (string == null) {
            throw new NullPointerException("Please provide list of names");
        }
        String[] strings = genderDetector.convertStringToArray(string);
        return genderDetector.detectGenderByAllNames(strings);

    }
}

