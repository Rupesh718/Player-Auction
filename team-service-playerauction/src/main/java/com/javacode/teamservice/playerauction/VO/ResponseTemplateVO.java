package com.javacode.teamservice.playerauction.VO;

import java.util.List;

import com.javacode.teamservice.playerauction.model.Team;

public class ResponseTemplateVO {
	private Team team;
	private List<Player> player;
	
	public ResponseTemplateVO() {
		
	}

	public ResponseTemplateVO(Team team, List<Player> player) {
		super();
		this.team = team;
		this.player = player;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public List<Player> getPlayer() {
		return player;
	}

	public void setPlayer(List<Player> player2) {
		this.player = player2;
	}
}
