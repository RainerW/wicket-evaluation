package com.example.pages.spieler;

import javax.inject.Inject;
import javax.swing.plaf.basic.BasicSliderUI.ActionScroller;

import org.apache.wicket.markup.html.basic.Label;

import com.example.java8.Form8;
import com.example.java8.IOnBack;
import com.example.java8.IOnCancel;
import com.example.java8.IOnSaved;
import com.example.java8.LWicketAction;
import com.example.java8.Link8;
import com.example.model.Player;
import com.example.pages.BasePage;
import com.example.services.PlayerService;

public class ConfirmSave extends BasePage implements IOnBack<ConfirmSave>, IOnCancel<ConfirmSave>, IOnSaved<ConfirmSave>
{
  @Inject
  PlayerService service;

  public ConfirmSave(final Player player)
  {
    super();
    Form8<Player> form = new Form8<>("form", player);

    form.add(new Link8("save", () -> {
      doSave(player);
    }));
    form.add(new Link8("cancel", this::actionCancel));
    form.add(new Link8("back", this::actionBack));

    form.add(new Label("vorname"));
    form.add(new Label("nachname"));
    form.add(new Label("email"));
    add(form);
  }

  protected void doSave(Player player)
  {
    service.save(player);
    getSession().info("Spieler '"+player.getEmail()+"' erfolgreich gespeichert");
    actionSaved();
  }

}
