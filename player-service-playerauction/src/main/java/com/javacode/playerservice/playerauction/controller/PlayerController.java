package com.javacode.playerservice.playerauction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacode.playerservice.playerauction.Service.PlayerService;
import com.javacode.playerservice.playerauction.VO.ResponseTemplateVO;
import com.javacode.playerservice.playerauction.model.Player;

@RestController
@RequestMapping("/players")
@CrossOrigin(origins = "http://localhost:4200")
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;
	
	@PostMapping("/addPlayer")
	public Player registerPlayer(@RequestBody Player player) throws Exception {
		if(player.getTeamName() != null) {
			ResponseTemplateVO vo = playerService.getTeamByTeamName(player);
			
			double totalBudget = vo.getTeam().getBudget();
			double sumBudget = 0;
			List<Player> storePlayer = playerService.getPlayerByTeamName(player.getTeamName());
			
			for(int i=0; i<storePlayer.size(); i++) {
				Player player1 = (Player) storePlayer.get(i);
				sumBudget += player1.getBudget();
			}
			sumBudget += player.getBudget();
			if(sumBudget >= totalBudget) {
				throw new Exception("player can’t be tagged to this team as it exceeds team’s budget!");
			}
		}
		
		return playerService.savePlayer(player);
		
	}
	
	@GetMapping("/getplayerbyid/{id}")
	 public Player findPlayerById(@PathVariable long id){
		return playerService.getPlayerById(id); 
	}
	
	@GetMapping("/getplayerbyteamName/{teamName}")
	public List<Player> fetchPlayersByTeamName(@PathVariable String teamName){
		return playerService.getPlayerByTeamName(teamName);
	}
}
