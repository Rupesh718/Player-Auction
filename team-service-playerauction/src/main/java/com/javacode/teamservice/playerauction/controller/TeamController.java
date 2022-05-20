package com.javacode.teamservice.playerauction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacode.teamservice.playerauction.VO.Player;
import com.javacode.teamservice.playerauction.VO.ResponseTemplateVO;
import com.javacode.teamservice.playerauction.model.Team;
import com.javacode.teamservice.playerauction.service.TeamService;

@RestController
@RequestMapping("/teams")
@CrossOrigin(origins = "http://localhost:4200")
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@PostMapping("/registerteam")
	public Team registerTeam(@RequestBody Team team) throws Exception {
		String tempTeamName = team.getTeamName();
		if(tempTeamName != null && !"".equals(tempTeamName)) {
			Team teamObj = teamService.fetchTeamByTeamName(tempTeamName);
			if(teamObj != null) {
				throw new Exception("Team with "+tempTeamName+" is already exist!");
			}
		}
		Team teamObj = null;
		teamObj = teamService.saveTeam(team);
		return teamObj;
	}
	
	@GetMapping("/getteam/{teamName}")
	public Team getTeam(@PathVariable("teamName") String teamName) {
		return teamService.fetchTeamByTeamName(teamName);
	}

	
	@GetMapping("/getplayers/{teamName}")
	public ResponseEntity<?> getPlayersWithTeamName(@PathVariable("teamName") String teamName) {
		return teamService.fetchPlayer(teamName); 
	}
}
