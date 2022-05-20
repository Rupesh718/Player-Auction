package com.javacode.teamservice.playerauction.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teams")
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teamId;
	private String teamName;
	private double budget;
	
	public Team() {
		
	}

	public Team(String teamName, double budget) {
		super();
		this.teamName = teamName;
		this.budget = budget;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}
	
	
	
}
