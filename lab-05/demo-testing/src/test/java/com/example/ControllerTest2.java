package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = RealController.class
		,includeFilters =  @ComponentScan.Filter(type= FilterType.REGEX, pattern = "com.example.*")
		,excludeFilters = {
		@ComponentScan.Filter(type= FilterType.ANNOTATION, classes = MockService.class),
		@ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE,
				classes = {RealService.class, RealService2_2.class})
}
)
public class ControllerTest2 {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private IService service;

	@Test
	public void contextLoads() throws Exception {
		given(service.getMessage()).willReturn("Message from Mocked Service");
		mockMvc.perform(get("/hi").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string("Message from Mocked Service::Message From Real Service 2"));
	}

}
