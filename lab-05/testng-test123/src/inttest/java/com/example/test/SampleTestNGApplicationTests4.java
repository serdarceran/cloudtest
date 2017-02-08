package com.example.test;

import com.example.AgentOperations;
import com.example.SAJAgentOperations;
import com.example.SALAgentOperations;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class SampleTestNGApplicationTests4 extends AbstractTestNGSpringContextTests  {

    @Autowired
    private BeanFactory beanFactory;

    private AgentOperations agentOperations;

    private String agentType;
    private String firmware;

    public String getFirmware() {
        return firmware;
    }

    public String getAgentType() {
        return agentType;
    }

    public SampleTestNGApplicationTests4(String agentType, String firmware) {
        this.agentType = agentType;
        this.firmware = firmware;
    }

    @BeforeMethod(alwaysRun = true)
    public void handleTestMethodName(Method method, ITestContext testContext) {

        if (TestFactory.GROUP_SAJ.equals(agentType)) {
            agentOperations = beanFactory.getBean(SAJAgentOperations.class, firmware);
        }
        else if (TestFactory.GROUP_SAL.equals(agentType)) {
            agentOperations = beanFactory.getBean(SALAgentOperations.class, firmware);
        }
    }

    @Test
    @ExcludeSAJ(firmware={"*"})
    public void testForSAL() {
        System.out.println(">>>>>>>>>>>>>>>>>>>Test Executed for only SAL");
        System.out.println(" but, Agent Type: " + agentOperations.getAgentType());
    }

    @Test
    @ExcludeSAL(firmware={"*"})
    public void testForOnlySAJ() {
        System.out.println(">>>>>>>>>>>>>>>>Test Executed for only SAJ");
        System.out.println(" but, Agent Type: " + agentOperations.getAgentType());
    }

    @Test
    public void testForAll() {
        System.out.println(">>>>>>>>>>>>>>>>Test Executed for All");
        System.out.println(" but, Agent Type: " + agentOperations.getAgentType());
    }

    @Test
    @ExcludeSAL(firmware={"2.1.0"})
    @ExcludeSAJ(firmware = {"*"})
    @IncludeSAJ(firmware = {"1.4.5"})
    public void testFor_SpecificSAL_AND_SpecificSAJ() {
        System.out.println(">>>>>>>>>>>>>>>>>>>Test Executed for SAL (NOT 2.1.0) or SAJ (1.4.5)");
        System.out.println(" but, Agent Type: " + agentOperations.getAgentType());
    }

    @Test
    @ExcludeSAL(firmware={"*"})
    @IncludeSAL(firmware={"3.4.8"})
    public void testForSAJAndSpecificSAL() {
        System.out.println(">>>>>>>>>>>>>>>>Test Executed for SAJ or SAL (3.4.8)");
        System.out.println(" but, Agent Type: " + agentOperations.getAgentType());
    }
}
