package com.example.component.player;

import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.IModel;

import com.example.model.Player;
import com.example.model.SportArt;
import com.example.pages.spieler.EditSpieler;
@SuppressWarnings("serial")

public class PlayerTable extends BasePanel<List<Player>>
{

  public PlayerTable(String id, SportArt art)
  {
    super(id);
    ListDataProvider<Player> listDataProvider = new PlayerListDataProvider( art);

    DataView<Player> dataView = new DataView<Player>("rows", listDataProvider) 
    {
	  @Override
      protected void populateItem(Item<Player> item)
      {
        Player person = item.getModelObject();

        item.add(new Label("vorname", person.getVorname()));
        item.add(new Label("nachname", person.getNachname()));
        item.add(new Label("email", person.getEmail()));
        item.add(new EditPlayerLink("aktionEdit", item.getModel()));
      }
    };
    add(dataView);
  }

  class EditPlayerLink extends BookmarkablePageLink<Player>
  {
    public EditPlayerLink(String id, IModel<Player> model)
    {
      super(id, EditSpieler.class);
      getPageParameters().add(EditSpieler.ID_PARAM, model.getObject().getId());
    }
  }

}
