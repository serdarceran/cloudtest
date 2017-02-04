package com.example.test;

import com.example.SAJAgentOperations;
import com.example.SALAgentOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * Created by serdar on 4.02.2017.
 */
@Configuration
public class AgentConfig {

    @Bean
    @Scope(value = "prototype")
    @Lazy(value = true)
    public SAJAgentOperations getSAJ(String firmwareVersion) {
        return new SAJAgentOperations(firmwareVersion);
    }

    @Bean
    @Scope(value = "prototype")
    @Lazy(value = true)
    public SALAgentOperations getSAL(String firmwareVersion) {
        return new SALAgentOperations(firmwareVersion);
    }
}
