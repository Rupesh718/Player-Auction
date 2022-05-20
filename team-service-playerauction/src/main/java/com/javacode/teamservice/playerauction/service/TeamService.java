package com.javacode.teamservice.playerauction.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.javacode.teamservice.playerauction.VO.Player;
import com.javacode.teamservice.playerauction.VO.ResponseTemplateVO;
import com.javacode.teamservice.playerauction.model.Team;
import com.javacode.teamservice.playerauction.repository.TeamRepository;

@Service
public class TeamService {
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public Team fetchTeamByTeamName(String tempTeamName) {
		return teamRepository.findByTeamName(tempTeamName);
	}

	public Team saveTeam(Team team) {
		return teamRepository.save(team);
	}
	
	public ResponseEntity<?> fetchPlayer(String teamName) {
	
		ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity("http://PLAYER-SERVICE/players/getplayerbyteamName/" + teamName, Object[].class);
				
		return responseEntity;
	}	
}
