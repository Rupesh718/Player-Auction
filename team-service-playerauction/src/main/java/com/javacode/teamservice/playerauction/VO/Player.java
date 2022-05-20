package com.javacode.teamservice.playerauction.VO;

public class Player {
	private Long playerId;
	private String playerName;
	private double budget;
	private String teamName;
	
	public Player() {
		
	}

	public Player(String playerName, double budget, String teamName) {
		super();
		this.playerName = playerName;
		this.budget = budget;
		this.teamName = teamName;
	}

	public Long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Long playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	
	
}
