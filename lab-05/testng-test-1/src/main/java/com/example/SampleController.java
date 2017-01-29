package com.example;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

    @GetMapping("/")
    @ResponseBody
    public String helloWorld() {
        return "Hello World";
    }

}
