package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
public class ServiceTest {

	@InjectMocks
	private RealService2_2 realService22;

	@Mock
	private IService mockedService;

	@Test
	public void contextLoads() throws Exception {
		Mockito.doReturn("dfasdf").when(mockedService).getMessage();
		Assert.assertEquals("dfasdf", realService22.getMessage());
	}

}
