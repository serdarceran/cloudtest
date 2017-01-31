package com.example2;

import com.example.EmailGenerator;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by serdar on 29.01.2017.
 */
@Service
@Component
public class RandomEmailGenerator implements EmailGenerator {
    @Override
    public String generate() {
        return "random.email@ddd.com";
    }
}
