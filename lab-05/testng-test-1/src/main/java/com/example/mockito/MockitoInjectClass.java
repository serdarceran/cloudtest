package com.example.mockito;

import com.example.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by serdar on 30.01.2017.
 */
@Component
public class MockitoInjectClass {

    @Autowired
    @Qualifier("test")
    private MyService myService;

    public String getStr(){
        return myService.getMessage() + "::::";
    }

}
