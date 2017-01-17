package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Player {
	
	@Id @GeneratedValue
	Long id;
	
	String name;
	String position;
	
//	@ManyToOne
//	Team team;

	public Player(String name, String position) {
		super();
		this.name = name;
		this.position = position;
	}
	public Player() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	
	
}
