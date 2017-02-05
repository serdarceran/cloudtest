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

    private static  final String GROUP_SAJ = "SAJ";
    private static  final String GROUP_SAL = "SAL";

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

        if (GROUP_SAJ.equals(agentType)) {
            agentOperations = beanFactory.getBean(SAJAgentOperations.class, firmware);
        }
        else if (GROUP_SAL.equals(agentType)) {
            agentOperations = beanFactory.getBean(SALAgentOperations.class, firmware);
        }
    }

    @Test
    @IgnoreSAJ(firmware={"*"})
    public void testForSAL() {
        System.out.println(">>>>>>>>>>>>>>>>>>>Test Executed for SAL");
        System.out.println(" but, Agent Type: " + agentOperations.getAgentType());
    }

    @Test
    @IgnoreSAL(firmware={"2.1.0"})
    @IgnoreSAJ(firmware = {"*"})
    public void testForSAL_2_0_0() {
        System.out.println(">>>>>>>>>>>>>>>>>>>Test Executed for SAL");
        System.out.println(" but, Agent Type: " + agentOperations.getAgentType());
    }

    @Test
    @IgnoreSAL(firmware={"*"})
    public void testForSAJ() {
        System.out.println(">>>>>>>>>>>>>>>>Test Executed for SAJ");
        System.out.println(" but, Agent Type: " + agentOperations.getAgentType());
    }

    @Test
    public void testForSALandSAJ() {
        System.out.println(">>>>>>>>>>>>>>>>Test Executed for SAL and SAJ");
        System.out.println(" but, Agent Type: " + agentOperations.getAgentType());
    }






}
