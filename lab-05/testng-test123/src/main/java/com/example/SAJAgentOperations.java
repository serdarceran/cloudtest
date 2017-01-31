package com.example;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * Created by serdar on 1.02.2017.
 */
@Service
@Profile("SAJ")
public class SAJAgentOperations implements  AgentOperations{
    @Override
    public String getAgentType() {
        return "SAJ";
    }
}
