package com.mm.test;

import com.example.EmailGenerator;
import org.springframework.stereotype.Service;

/**
 * Created by serdar on 29.01.2017.
 */
@Service
public class RandomEmailGenerator implements EmailGenerator {
    @Override
    public String generate() {
        return "random2.email@ddd.com";
    }
}
