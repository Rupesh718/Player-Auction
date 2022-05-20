package com.javacode.playerservice.playerauction.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javacode.playerservice.playerauction.model.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>{

	List<Player> getPlayerByTeamName(String teamName);

	List<Player> getTopPlayerByTeamName(String teamName);

}
