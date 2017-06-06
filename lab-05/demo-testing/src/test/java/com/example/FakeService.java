package com.example;

import org.springframework.stereotype.Service;

/**
 * Created by serdar on 25.02.2017.
 */
@Service
@MockService
public class FakeService implements IService {
    @Override
    public String getMessage() {
        return "Message From Fake Service";
    }
}
