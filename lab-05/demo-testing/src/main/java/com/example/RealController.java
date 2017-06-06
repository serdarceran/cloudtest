package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by serdar on 25.02.2017.
 */
@RestController
public class RealController {

    @Autowired
    private IService service;

    @Autowired
    private IService2 realService2;

    @RequestMapping(path = "/hi", method = RequestMethod.GET)
    public String getMessage() {
        return service.getMessage() + "::" + realService2.getMessage();
    }
}
