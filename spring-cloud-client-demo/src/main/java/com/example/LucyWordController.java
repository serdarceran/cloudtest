package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;

@RestController
public class LucyWordController {

	
	@Value("${lucky-word}") String luckyWord;
	
	@Value("${neighbour}") String neighbour;
	
	@RequestMapping("/lucky-word")
	public String sayLuckWord() {
		return "This is my luck word:" + luckyWord + ":: " + client2Url();
	}
	
	@Autowired DiscoveryClient client;
	
	private String client2Url() {
		return client.getInstancesById(neighbour).stream()
				.findFirst()
				.map(InstanceInfo::getHomePageUrl)
				.orElse(null);
		
	}
}
