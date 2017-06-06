package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by serdar on 25.02.2017.
 */
@Service
public class RealService2_2 implements IService2 {

    @Autowired
    private IService service;

    @Override
    public String getMessage() {
        return service.getMessage();
    }
}
