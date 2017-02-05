package com.example.test;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by serdar on 5.02.2017.
 */
public class AgentTestInterceptor implements  IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        List<IMethodInstance> retval = new ArrayList<>();
        methods.stream().forEach(m-> {
            if(m.getInstance() instanceof  SampleTestNGApplicationTests4) {
                SampleTestNGApplicationTests4 s = (SampleTestNGApplicationTests4) m.getInstance();
                if(s.getAgentType().equals("SAJ")) {
                    IgnoreSAJ annotation = m.getMethod().getConstructorOrMethod().getMethod().getAnnotation(IgnoreSAJ.class);
                    if(annotation == null || !isFirmwareMatch(annotation.firmware(), s.getFirmware())) retval.add(m);

                } else if(s.getAgentType().equals("SAL")) {
                    IgnoreSAL annotation = m.getMethod().getConstructorOrMethod().getMethod().getAnnotation(IgnoreSAL.class);
                    if (annotation == null || !isFirmwareMatch(annotation.firmware(), s.getFirmware())) retval.add(m);
                }
            }
        });
        return retval;
    }

    private boolean isFirmwareMatch(String[] firmwares, String testedFirmware) {
        if(Stream.of(firmwares).anyMatch("*"::equals)) return true;
        if(Stream.of(firmwares).anyMatch(testedFirmware::equals)) return true;
        return false;
    }
}
