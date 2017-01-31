package com.example;

/**
 * Created by serdar on 29.01.2017.
 */
//@Component
public class MyActualService implements MyService{
    @Override
    public String getMessage() {
        return "Message From My Actual Service";
    }
}
