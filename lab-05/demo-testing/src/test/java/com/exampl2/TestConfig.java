package com.exampl2;

import com.example.DemoTestingApplication;
import com.example.RealService;
import com.example.RealService2_2;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * Created by serdar on 25.02.2017.
 */

//@Profile("integration")
@Configuration
@SpringBootApplication
@ComponentScan(basePackages = "com.example" ,excludeFilters =
        @ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE,
                classes={DemoTestingApplication.class, RealService.class, RealService2_2.class})

)
public class TestConfig {
}
