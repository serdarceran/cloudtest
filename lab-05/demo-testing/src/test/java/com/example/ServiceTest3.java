package com.example;

import com.exampl2.TestConfig3;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig3.class)
public class ServiceTest3 {

	@Autowired
	private RealService3 realService3;

	@Autowired
	private IService mockedService;

	@Test
	public void contextLoads() throws Exception {
		Mockito.doReturn("dfasdf").when(mockedService).getMessage();
		Assert.assertEquals("dfasdf:::Message From Real Service 2", realService3.getMessage());
	}

}
