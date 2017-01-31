package com.example.test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class SampleTestNGApplicationTests extends AbstractTestNGSpringContextTests {

    @Test(groups = { "GroupSAJ"})
    public void testForSAJ() {
        System.out.println(">>>>>>>>>>>>>>>>Test Executed for SAJ");
    }

    @Test(groups = { "GroupSAL"})
    public void testForSAL() {
        System.out.println(">>>>>>>>>>>>>>>>>>>Test Executed for SAL");
    }

    @Test(groups = { "GroupSAJ", "GroupSAL"})
    public void testForSALandSAJ() {
        System.out.println(">>>>>>>>>>>>>>>>Test Executed for SAL and SAJ");
    }


}
