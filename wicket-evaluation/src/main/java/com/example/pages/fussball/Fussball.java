package com.example.pages.fussball;

import com.example.component.player.PlayerTable;
import com.example.java8.Link8;
import com.example.model.Player;
import com.example.model.SportArt;
import com.example.pages.BasePage;
import com.example.pages.spieler.EditSpieler;
import com.example.pages.tennis.Tennis;

public class Fussball extends BasePage
{
  @Override
  protected void onInitialize()
  {
    super.onInitialize();
    add(new PlayerTable("spielerliste", SportArt.FUSSBALL));
    add(new Link8("neuerSpieler", () -> {
      EditSpieler edit = new EditSpieler(new Player(SportArt.FUSSBALL));
      edit.onBack( responsePage(Fussball.this) );
      edit.onSaved( responsePage(Fussball.this) );
      setResponsePage(edit);
    }));

  }
}
