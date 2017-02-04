//package com.example.test;
//
//import com.example.AgentOperations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.core.env.Environment;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
//import org.testng.SkipException;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.lang.reflect.Method;
//import java.util.stream.Stream;
//
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@DirtiesContext
//public class SampleTestNGApplicationTests2 extends AbstractTestNGSpringContextTests {
//
//    @Autowired
//    private Environment environment;
//
//    @Autowired
//    AgentOperations agentOperations;
//
//    @BeforeMethod
//    public void handleTestMethodName(Method method)
//    {
//        SAJAnnotation agentAnnotations = method.getAnnotation(SAJAnnotation.class);
//        String[] activeProfiles = environment.getActiveProfiles();
//
//        if("SAJ".equals(activeProfiles[0])) {
//            Stream.of(agentAnnotations)
//                    .map(SAJAnnotation::agentType)
//                    .filter(SAJAnnotation.AgentType.SAJ::equals)
//                    .findFirst().orElseThrow(()-> new SkipException("skip test"));
//
//        } else if("SAL".equals(activeProfiles[0])) {
//            Stream.of(agentAnnotations)
//                    .map(SAJAnnotation::agentType)
//                    .filter(SAJAnnotation.AgentType.SAL::equals)
//                    .findFirst().orElseThrow(()-> new SkipException("skip test"));
//        } else {
//            throw new SkipException(" skip test");
//        }
//    }
//
//    @Test
//    @SAJAnnotation(firmwareVersion = "1.0.0")
//    public void testForSAJ() {
//        System.out.println(">>>>>>>>>>>>>>>>Test Executed for SAJ ");
//        System.out.println(" but, Agent Type: " + agentOperations.getAgentType());
//    }
//
//    @Test
//    @SALAnnotation(firmwareVersion = "2.0.0")
//    public void testForSAL() {
//        System.out.println(">>>>>>>>>>>>>>>>>>>Test Executed for SAL");
//        System.out.println(" but, Agent Type: " + agentOperations.getAgentType());
//    }
//
//    @Test
//    @SAJAnnotation(firmwareVersion = "1.0.0")
//    @SALAnnotation(firmwareVersion = "2.0.0")
//    public void testForSALandSAJ() {
//        System.out.println(">>>>>>>>>>>>>>>>Test Executed for SAL and SAJ");
//        System.out.println(" but, Agent Type: " + agentOperations.getAgentType());
//    }
//
//
//}
