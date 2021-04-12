package com.boczar.gender_detection;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HttpMethods {

    private final GenderChecker genderChecker;

    public HttpMethods(GenderChecker genderChecker) {
        this.genderChecker = genderChecker;
    }

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
