package com.example;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by serdar on 1.02.2017.
 */
//@Service
//@Profile("SAL")
public class SALAgentOperations implements  AgentOperations{
    @Autowired
    private InjectMe injectMe;

    String firmwareVersion;

    public SALAgentOperations() {
    }

    public SALAgentOperations(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    @Override
    public String getAgentType() {
        return "SAL ::: " + firmwareVersion + " :: " + injectMe.getValue();
    }
}
