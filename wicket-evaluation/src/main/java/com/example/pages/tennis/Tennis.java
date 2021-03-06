package com.example.pages.tennis;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.link.Link;

import com.example.component.player.PlayerTable;
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
    add(new Link<Player>("neuerSpieler") {
      @Override
      public void onClick()  
      {
        setResponsePage(new EditSpieler(new Player(SportArt.TENNIS)) {
          @Override
          protected void onBack()
          {
            setResponsePage(Tennis.this);
          }

          @Override
          protected void afterSave()
          {
            setResponsePage(Tennis.this);
          }
        });
      }
    });
  };
}
