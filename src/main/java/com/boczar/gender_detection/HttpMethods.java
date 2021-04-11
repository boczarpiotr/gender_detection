package com.boczar.gender_detection;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HttpMethods {

    List<String> listOfStrings = new ArrayList<>();

    @PostMapping("/post")
    public boolean chceckGender (String string){

        return listOfStrings.add(string);

    }
    @RequestMapping("/word")
    public List<String> getList(){
        return listOfStrings;
    }


}
