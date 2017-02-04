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
public class SampleTestNGApplicationTests3 extends AbstractTestNGSpringContextTests {
    private static  final String GROUP_SAJ = "GroupSAJ";
    private static  final String GROUP_SAL = "GroupSAL";

    @Autowired
    private BeanFactory beanFactory;

    AgentOperations agentOperations;

    @BeforeMethod(alwaysRun = true)
    public void handleTestMethodName(Method method, ITestContext testContext) {
        String group = testContext.getIncludedGroups()[0];
        if (GROUP_SAJ.equals(group)) {
            SAJAnnotation sajAnnotations = method.getAnnotation(SAJAnnotation.class);
            agentOperations = beanFactory.getBean(SAJAgentOperations.class, sajAnnotations.firmwareVersion());

        } else if (GROUP_SAL.equals(group)) {
            SALAnnotation salAnnotations = method.getAnnotation(SALAnnotation.class);
            agentOperations = beanFactory.getBean(SALAgentOperations.class, salAnnotations.firmwareVersion());
        }
    }

    @Test(groups = { GROUP_SAJ })
    @SAJAnnotation(firmwareVersion = "1.0.0")
    public void testForSAJ() {
        System.out.println(">>>>>>>>>>>>>>>>Test Executed for SAJ");
        System.out.println(" but, Agent Type: " + agentOperations.getAgentType());
    }

    @Test(groups = { GROUP_SAL})
    @SALAnnotation(firmwareVersion = "1.1.0")
    public void testForSAL() {
        System.out.println(">>>>>>>>>>>>>>>>>>>Test Executed for SAL");
        System.out.println(" but, Agent Type: " + agentOperations.getAgentType());
    }

    @Test(groups = { GROUP_SAJ, GROUP_SAL})
    @SAJAnnotation(firmwareVersion = "1.4.0")
    @SALAnnotation(firmwareVersion = "1.4.7")
    public void testForSALandSAJ() {
        System.out.println(">>>>>>>>>>>>>>>>Test Executed for SAL and SAJ");
        System.out.println(" but, Agent Type: " + agentOperations.getAgentType());
    }
}
