package com.example.component.player;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.Component;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.Player;
import com.example.services.PlayerService;

public class PlayerTable extends GenericPanel<List<Player>>{

	
	public PlayerTable(String id) {
		super(id);
		
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		// method loadPersons is defined elsewhere
		ListDataProvider<Player> listDataProvider = new PlayerListDataProvider();

		DataView<Player> dataView = new DataView<Player>("rows",listDataProvider) {

			@Override
			protected void populateItem(Item<Player> item) {
				Player person = item.getModelObject();
				RepeatingView repeatingView = new RepeatingView("dataRow");

				repeatingView.add(new Label(repeatingView.newChildId(), person
						.getVorname()));
//						repeatingView.add(new Label(repeatingView.newChildId(), person
//								.getSurename()));
//						repeatingView.add(new Label(repeatingView.newChildId(), person
//								.getAddress()));
//						repeatingView.add(new Label(repeatingView.newChildId(), person
//								.getEmail()));
				item.add(repeatingView);
			}
		};
		add(dataView);
	}

}
