package com.example.component.player;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.repeater.data.ListDataProvider;

import com.example.model.Player;
import com.example.services.PlayerService;

public class PlayerListDataProvider extends ListDataProvider<Player> {
	@Inject
	PlayerService playerService;

	public PlayerListDataProvider() {
		Injector.get().inject(this);
	}

	@Override
	protected List<Player> getData() {
		return playerService.getAllPlayers();
	}
}
