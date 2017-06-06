package com.example;

import org.springframework.stereotype.Service;

/**
 * Created by serdar on 25.02.2017.
 */
@Service
public class RealService2 implements IService2 {
    @Override
    public String getMessage() {
        return "Message From Real Service 2";
    }
}
