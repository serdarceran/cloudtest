package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by serdar on 25.02.2017.
 */
@Service
@Profile({"!custom", "service3"})
public class RealService4_3 implements IService4 {

    @Value("${message}")
    private String message;

    @Override
    public String getMessage() {
        return "Message From " + message;
    }
}
