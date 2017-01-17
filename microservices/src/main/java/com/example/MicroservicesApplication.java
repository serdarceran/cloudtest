package com.example;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesApplication.class, args);
	}
	
	
	@PostConstruct
	public void initialize() {
		Set<Player> players = new HashSet<>();
		players.add(new Player("serdar", "kanat"));
		players.add(new Player("mahir", "stoper"));
		players.add(new Player("askam", "kaleci"));
		Team team = new Team("GS", "Istanbul", players);
		teamDao.save(team);
	}
	
	@Autowired
	private TeamDao teamDao;
}
