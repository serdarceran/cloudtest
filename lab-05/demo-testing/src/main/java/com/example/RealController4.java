package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by serdar on 25.02.2017.
 */
@RestController
public class RealController4 {

    @Autowired
    private IService4 service;


    @RequestMapping(path = "/hi4", method = RequestMethod.GET)
    public String getMessage() {
        return service.getMessage();
    }
}
