package com.example;

import org.springframework.stereotype.Component;

/**
 * Created by serdar on 4.02.2017.
 */
@Component
public class InjectMe {

    public String getValue() {
        return "My Value";
    }
}
