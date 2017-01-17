package com.example;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path="teams", rel="teams")
public interface TeamDao extends CrudRepository<Team, Long> {

	List<Team> findByName(String name);

}
