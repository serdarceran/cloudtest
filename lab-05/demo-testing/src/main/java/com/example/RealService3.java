package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by serdar on 25.02.2017.
 */
@Service
public class RealService3 implements IService3
{

    @Autowired
    private IService service;

    @Autowired
    private IService2 realService2;

    @Override
    public String getMessage() {
        return service.getMessage() + ":::" + realService2.getMessage();
    }
}
