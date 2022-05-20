package com.javacode.playerservice.playerauction.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.javacode.playerservice.playerauction.Repository.PlayerRepository;
import com.javacode.playerservice.playerauction.VO.ResponseTemplateVO;
import com.javacode.playerservice.playerauction.VO.Team;
import com.javacode.playerservice.playerauction.model.Player;

@Service
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public ResponseTemplateVO getTeamByTeamName(Player player) {
		ResponseTemplateVO vo = new ResponseTemplateVO();
		
		String teamName = player.getTeamName();
		
		Team team =
				restTemplate.getForObject("http://TEAM-SERVICE/teams/getteam/" + teamName, Team.class );

		vo.setTeam(team);
		
		return vo;
	}

	public List<Player> getPlayerByTeamName(String teamName) {
		return playerRepository.getPlayerByTeamName(teamName);
	}

	public Player savePlayer(Player player) {
		return playerRepository.save(player);
	}

	public Player getPlayerById(long id) {
		return playerRepository.findById(id).orElse(null);
	}

}
