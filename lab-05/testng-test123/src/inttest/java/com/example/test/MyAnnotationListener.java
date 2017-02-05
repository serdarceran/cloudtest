package com.example.test;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.stream.Stream;

/**
 * Created by serdar on 5.02.2017.
 */
public class MyAnnotationListener implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

        Class<?> declaringClass = testMethod.getDeclaringClass();
        Parameter[] parameters = testMethod.getParameters();
    }

    private boolean isFirmwareMatch(String[] firmwares, String testedFirmware) {
        if(Stream.of(firmwares).anyMatch("*"::equals)) return true;
        if(Stream.of(firmwares).anyMatch(testedFirmware::equals)) return true;
        return false;
    }


}