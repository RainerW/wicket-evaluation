package com.example.pages.fussball;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

import com.example.component.player.PlayerTable;
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
    add(new Link<Player>("neuerSpieler") {
      @Override
      public void onClick()  
      {
        setResponsePage(new EditSpieler(new Player(SportArt.FUSSBALL)) {
          @Override
          protected void onBack()
          {
            setResponsePage(Fussball.this);
          }

          @Override
          protected void afterSave()
          {
            setResponsePage(Fussball.this);
          }
        });
      }
    });
  }
}
