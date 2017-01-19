package nl.palmapps.myawesomeproject.controller;

import java.security.Principal;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nl.palmapps.myawesomeproject.model.Greeting;
import nl.palmapps.myawesomeproject.model.LoginResult;

/**
 * Example controller to test security calls
 */
@RestController
public class MainController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @Autowired
    private GreetingService greetingService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public LoginResult greeting(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        return greetingService.getToken(username, password);
    }
    
    @RequestMapping(value = "/secure/hello", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

        return greetingService.getHello();
    }
    
    @RequestMapping(value = "/secure/hi", method = RequestMethod.GET)
    public Greeting hi(@RequestParam(value = "name", defaultValue = "World") String name) {

        return greetingService.getHi(name);
    }
    
    @RequestMapping(value = "/secure/hi2", method = RequestMethod.GET)
    public Greeting hi2(@RequestParam(value = "name", defaultValue = "World") String name) {

        return greetingService.getHi2(name);
    }

    @RequestMapping(value = "/secure/hello/message", method = RequestMethod.POST)
    public Greeting message(@RequestBody Message input) {
        return new Greeting(counter.incrementAndGet(),input.getMessage().toUpperCase());
    }

    @RequestMapping(value = {"/secure/user", "/secure/me"}, method = RequestMethod.POST)
    public ResponseEntity<?> user(Principal principal) {
        return ResponseEntity.ok(principal);
    }
}