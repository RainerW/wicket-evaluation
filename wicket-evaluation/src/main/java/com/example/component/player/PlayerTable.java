package com.example.component.player;

import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.Component;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.IModel;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.Player;
import com.example.model.SportArt;
import com.example.pages.spieler.EditSpieler;
import com.example.services.PlayerService;

public class PlayerTable extends GenericPanel<List<Player>> {

	public PlayerTable(String id, SportArt art) {
		super(id);
		// method loadPersons is defined elsewhere
		ListDataProvider<Player> listDataProvider = new PlayerListDataProvider(
				art);

		DataView<Player> dataView = new DataView<Player>("rows",
				listDataProvider) {

			@Override
			protected void populateItem(Item<Player> item) {
				Player person = item.getModelObject();

				item.add(new Label("vorname", person.getVorname()));
				item.add(new Label("nachname", person.getNachname()));
				item.add(new Label("email", person.getEmail()));
				item.add(new EditPlayerLink("aktionEdit", item.getModel()));
			}
		};
		add(dataView);
	}

	class EditPlayerLink extends Link<Player> {

		public EditPlayerLink(String id, IModel<Player> model) {
			super(id, model);
		}

		@Override
		public void onClick() {
			setResponsePage(new EditSpieler(getModelObject()) {

				@Override
				protected void onBack() {
					setResponsePage(PlayerTable.this.getPage());
				}
			});
		}

	}

}
