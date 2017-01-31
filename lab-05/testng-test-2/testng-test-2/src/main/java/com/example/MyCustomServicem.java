package com.example;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by serdar on 31.01.2017.
 */
public class MyCustomServicem implements MyService {

    @Autowired
    private EmailGenerator emailGenerator;

    @Override
    public String getMessage() {
        return emailGenerator.generate() + "My custom servicem";
    }
}
