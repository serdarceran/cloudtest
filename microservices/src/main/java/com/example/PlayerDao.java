package com.example;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path="players", rel="players")
public interface PlayerDao extends CrudRepository<Player, Long> {

	List<Team> findByName(String name);

}
