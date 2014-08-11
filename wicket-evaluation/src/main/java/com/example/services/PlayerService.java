package com.example.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.model.Player;
import com.example.repository.PlayerRepository;

@Service
public class PlayerService {

	@Inject
	PlayerRepository repo;

	public List<Player> getAllPlayers() {
		Player p = new Player();
		p.setEmail("x");
		p.setVorname("y");
		repo.save(p);
		return repo.findAll();
	}
}
