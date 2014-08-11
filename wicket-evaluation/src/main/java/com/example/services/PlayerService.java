package com.example.services;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.example.model.Player;
import com.example.model.SportArt;
import com.example.repository.PlayerRepository;

@Service
public class PlayerService {

	@Inject
	PlayerRepository repo;

	public List<Player> getAllPlayers(SportArt filter) {
		if (filter != null) {
			return repo.findBySportart(filter);
		} else {
			return repo.findAll();
		}
	}

	public void save(Player object) {
		repo.save(object);
	}

	public Player findByEmail(String email) {
		return repo.findByEmail(email);
	}
}
