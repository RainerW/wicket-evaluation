package com.example.pages.tennis;

import com.example.component.player.PlayerTable;
import com.example.java8.Link8;
import com.example.model.Player;
import com.example.model.SportArt;
import com.example.pages.BasePage;
import com.example.pages.spieler.EditSpieler;

public class Tennis extends BasePage
{
  protected void onInitialize()
  {
    super.onInitialize();
    add(new PlayerTable("spielerliste", SportArt.TENNIS));
    add(new Link8("neuerSpieler", () -> {
      EditSpieler edit = new EditSpieler(new Player(SportArt.TENNIS));
      edit.onBack( responsePage(Tennis.this) );
      edit.onSaved( responsePage(Tennis.this) );
      setResponsePage(edit);
    }));
  };

}
