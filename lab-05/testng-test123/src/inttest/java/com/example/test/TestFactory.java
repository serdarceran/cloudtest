package com.example.test;

import org.testng.annotations.Factory;

/**
 * Created by serdar on 4.02.2017.
 */

public class TestFactory {
    protected static  final String GROUP_SAJ = "SAJ";
    protected static  final String GROUP_SAL = "SAL";

    @Factory
    public Object[] createInstances() {
        Object[] result = new Object[6];

        result[0] = new SampleTestNGApplicationTests4(GROUP_SAJ, "1.0.0");
        result[1] = new SampleTestNGApplicationTests4(GROUP_SAJ, "1.1.0");
        result[2] = new SampleTestNGApplicationTests4(GROUP_SAJ, "1.4.5");
        result[3] = new SampleTestNGApplicationTests4(GROUP_SAL, "2.0.0");
        result[4] = new SampleTestNGApplicationTests4(GROUP_SAL, "2.1.0");
        result[5] = new SampleTestNGApplicationTests4(GROUP_SAL, "3.4.8");
        return result;
    }
}
