package com.example.test;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * A Custom Annotation to inject additional information into a TestNG Test
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreSAL {
    String[] firmware() default {};
}
