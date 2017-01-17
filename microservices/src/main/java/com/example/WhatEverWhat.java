package com.example;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WhatEverWhat {

	@Autowired
	private TeamDao teamDao;
	
	@RequestMapping("/hi/{name}")
	public Team hiThere(@PathVariable String name) {
		List<Team> teams = teamDao.findByName(name);
		Optional<Team> team = teams.stream().findFirst();
		return team.orElse(null);
	}
}
