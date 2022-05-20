package com.javacode.playerservice.playerauction.VO;

import com.javacode.playerservice.playerauction.model.Player;

public class ResponseTemplateVO {
	private Team team;
	private Player player;
	
	public ResponseTemplateVO() {
		
	}

	public ResponseTemplateVO(Team team, Player player) {
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

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
	
}
