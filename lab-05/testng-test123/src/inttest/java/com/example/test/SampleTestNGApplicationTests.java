//package com.example.test;
//
//import com.example.AgentOperations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.test.annotation.DirtiesContext;
//import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
//import org.testng.annotations.Test;
//
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@DirtiesContext
//@Test(enabled=false)
//public class SampleTestNGApplicationTests extends AbstractTestNGSpringContextTests {
//
//    @Autowired
//    AgentOperations agentOperations;
//
//    @Test(groups = { "GroupSAJ"})
//    public void testForSAJ() {
//        System.out.println(">>>>>>>>>>>>>>>>Test Executed for SAJ");
//        System.out.println(" but, Agent Type: " + agentOperations.getAgentType());
//    }
//
//    @Test(groups = { "GroupSAL"})
//    public void testForSAL() {
//        System.out.println(">>>>>>>>>>>>>>>>>>>Test Executed for SAL");
//        System.out.println(" but, Agent Type: " + agentOperations.getAgentType());
//    }
//
//    @Test(groups = { "GroupSAJ", "GroupSAL"})
//    public void testForSALandSAJ() {
//        System.out.println(">>>>>>>>>>>>>>>>Test Executed for SAL and SAJ");
//        System.out.println(" but, Agent Type: " + agentOperations.getAgentType());
//    }
//
//
//}
