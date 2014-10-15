package com.example.services;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.example.model.Player;
import com.example.model.SportArt;
import com.example.repository.PlayerRepository;

@Component
public class SetupTestData {
	@Inject
	PlayerRepository repo;
	
	@PostConstruct
	public void setup() { 
		List<Player> findAll = repo.findAll();
		if(findAll.size() == 0)
		{
			{
				Player spieler = new Player();
				spieler.setEmail("fussball.spieler@example.com");
				spieler.setNachname("Nachname");
				spieler.setVorname("Vorname");
				spieler.setSportart(SportArt.FUSSBALL);
				repo.saveAndFlush(spieler );
			}
			{
				Player spieler = new Player();
				spieler.setEmail("tennis.spieler@example.com");
				spieler.setNachname("lastname");
				spieler.setVorname("firstname");
				spieler.setSportart(SportArt.TENNIS);
				repo.saveAndFlush(spieler );
			}
		}
	}
}
