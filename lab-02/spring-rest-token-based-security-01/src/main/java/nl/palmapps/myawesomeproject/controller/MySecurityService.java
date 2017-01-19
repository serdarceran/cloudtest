package nl.palmapps.myawesomeproject.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component("mySecurityService")
public class MySecurityService {
    public boolean hasPermission(Authentication authentication, String foo) { 
    	System.err.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    	return foo.startsWith("s");
    }
}