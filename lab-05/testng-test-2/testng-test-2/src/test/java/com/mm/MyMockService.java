package com.mm;

import com.example.MyService;
import org.springframework.stereotype.Component;

/**
 * Created by serdar on 29.01.2017.
 */
@Component
public class MyMockService implements MyService {
    @Override
    public String getMessage() {
        return "Message from my mock service";
    }
}
