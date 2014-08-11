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
		return repo.findAll();
	}

	public void save(Player object) {
		repo.save(object);
	}
}
