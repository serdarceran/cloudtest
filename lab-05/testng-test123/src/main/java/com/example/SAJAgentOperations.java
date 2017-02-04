package com.example;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by serdar on 1.02.2017.
 */
//@Service
//@Profile("SAJ")
public class SAJAgentOperations implements  AgentOperations{
    @Autowired
    private InjectMe injectMe;

    String firmwareVersion;
    public SAJAgentOperations() {
    }
    public SAJAgentOperations(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    @Override
    public String getAgentType() {
        return "SAJ :: " + firmwareVersion + " :: " + injectMe.getValue();
    }
}
