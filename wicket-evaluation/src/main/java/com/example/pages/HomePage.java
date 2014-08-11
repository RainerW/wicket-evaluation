package com.example.pages;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;

import com.example.component.player.PlayerTable;
import com.example.model.Player;
import com.example.services.PlayerService;

public class HomePage extends BasePage {
	private static final long serialVersionUID = 1L;

	@Inject
	PlayerService s;

	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		add(new PlayerTable("players"));
	}
}
