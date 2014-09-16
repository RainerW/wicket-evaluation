package com.example.pages.fussball;

import com.example.component.player.PlayerTable;
import com.example.java8.Link8;
import com.example.model.Player;
import com.example.model.SportArt;
import com.example.pages.BasePage;
import com.example.pages.spieler.EditSpieler;

public class Fussball extends BasePage
{
  @Override
  protected void onInitialize()
  {
    super.onInitialize();
    add(new PlayerTable("spielerliste", SportArt.FUSSBALL));
    add(new Link8("neuerSpieler",
        responsePage(new EditSpieler(new Player(SportArt.FUSSBALL))
            .onBack(responsePage(Fussball.this))
            .onSaved(responsePage(Fussball.this))
        )));
  }
}
