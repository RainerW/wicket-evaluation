package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Player;
import com.example.model.SportArt;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long>
{

  List<Player> findBySportart(SportArt filter);

  Player findByEmail(String email);

}
