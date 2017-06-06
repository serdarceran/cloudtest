package com.exampl2;

import com.example.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;

import static org.mockito.Mockito.mock;

/**
 * Created by serdar on 25.02.2017.
 */

@Configuration
@ComponentScan(basePackages = "com.example" ,useDefaultFilters = false, includeFilters =
@ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE, classes={RealService3.class, RealService2.class})
)
public class TestConfig3 {
        @Bean
        @Primary
        public IService myMock() { return mock(IService.class); }

}
