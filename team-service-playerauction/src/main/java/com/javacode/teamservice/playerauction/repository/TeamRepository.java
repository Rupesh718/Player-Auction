package com.javacode.teamservice.playerauction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javacode.teamservice.playerauction.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

	Team findByTeamName(String tempTeamName);

}
