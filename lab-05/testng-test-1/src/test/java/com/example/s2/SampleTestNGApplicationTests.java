package com.example.s2;

import com.example.MyActualService;
import com.example.mockito.MyMockService;
import com.example.MyService;
import com.example.testutil.MyTestNGAnnotation;
import com.example.testutil.MyTestNGAnnotationListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext
@Listeners(value = MyTestNGAnnotationListener.class)
public class SampleTestNGApplicationTests extends AbstractTestNGSpringContextTests {

    @Autowired
    private MyActualService myActualService;

    @Autowired
    private MyMockService myMockService;

    @DataProvider(name = "test1")
    public Object[][] createData1() {
        return new Object[][]{
                {"Cedric", new Integer(36), "mytest1", myActualService},
                {"Anne", new Integer(37), "mytest2", myMockService},
        };
    }

    @Autowired
    private TestRestTemplate restTemplate;

    @Test(dataProvider = "test1")
    @MyTestNGAnnotation(name = "Jack", city = "San Francisco", state = "California")
    public void testMyAnnotation(String s, Integer i, String t, MyService myService) {
        System.out.println("test2:: " + s + " Integer : " + i + " Hello " + t);
        System.out.println(">>> " + myService.getMessage());
        ResponseEntity<String> entity = this.restTemplate.getForEntity("/", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).isEqualTo("Hello World");
    }

    @Test
    @Parameters({"dbconfig", "poolsize"})
    public void createConnection(String dbconfig, int poolsize) {
        System.out.println("dbconfig : " + dbconfig);
        System.out.println("poolsize : " + poolsize);
    }
}
