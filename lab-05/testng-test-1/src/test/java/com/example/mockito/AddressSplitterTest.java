package com.example.mockito;


import com.example.MyService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.mockito.Mockito.when;

//@SpringBootTest
@DirtiesContext
public class AddressSplitterTest  extends AbstractTestNGSpringContextTests {

    @InjectMocks private AddressSplitter subject;

    @Mock private AddressInputQueue addressInputQueue;

    @InjectMocks private MockitoInjectClass mockitoInjectClass;

    @Mock private MyService myService;
//    @Spy private MyService myService;

    @BeforeMethod(alwaysRun=true)
    public void injectDoubles() {
        MockitoAnnotations.initMocks(this); //This could be pulled up into a shared base class
    }

    @Test
    public void splitsAddressesByComma() {
        when(addressInputQueue.next()).thenReturn("jim@weirich.com,kent@beck.com");

        List<String> result = subject.split();

        Assert.assertEquals(result.get(0), "jim@weirich.com");
//        assertThat(result,hasItems(,"kent@beck.com"));
    }

    @Test
    public void splitsAddressesByComma2() {
        when(myService.getMessage()).thenReturn("Hello from mocked service::: ");

        //notice different Mockito syntax for spy
//        Mockito.doReturn(TEST_SHIRT_PRICE).when(priceService).getActualPrice(Item.SHIRT);
//        Mockito.doReturn(TEST_SHOES_PRICE).when(priceService).getActualPrice(Item.SHOES);

        String str = mockitoInjectClass.getStr();

        Assert.assertEquals(str, "Hello from mocked service::: ::::");
    }

}
