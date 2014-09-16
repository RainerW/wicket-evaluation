package com.example.component.player;

import java.util.List;

import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import com.example.java8.Link8;
import com.example.model.Player;
import com.example.model.SportArt;
import com.example.pages.spieler.EditSpieler;

public class PlayerTable extends GenericPanel<List<Player>>
{

  public PlayerTable(String id, SportArt art)
  {
    super(id);
    // method loadPersons is defined elsewhere
    ListDataProvider<Player> listDataProvider = new PlayerListDataProvider(
        art);

    DataView<Player> dataView = new DataView<Player>("rows",
        listDataProvider) {

      @Override
      protected void populateItem(Item<Player> item)
      {
        Player person = item.getModelObject();

        item.add(new Label("vorname", person.getVorname()));
        item.add(new Label("nachname", person.getNachname()));
        item.add(new Label("email", person.getEmail()));
        item.add(new Link8("aktionEdit",() -> {
            setResponsePage(new EditSpieler(person));
        } ));
      }
    };
    add(dataView);
  }


}
