package com.example.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.tools.ant.taskdefs.condition.HasMethod;
import org.apache.wicket.core.util.resource.UrlResourceStream;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.resource.IResourceStream;
import org.apache.wicket.velocity.markup.html.VelocityPanel;

import com.example.model.Player;
import com.example.pages.fussball.Fussball;
import com.example.services.PlayerService;


/**
 * Startseite der Anwendung.
 */
public class HomePage extends BasePage
{
  private static final long serialVersionUID = 1L;
  
  @Inject
  PlayerService ps;
  
  @Override
  protected void onInitialize()
  {
    MyPanel panel = new MyPanel("content", ps.getAllPlayers(null) );
    add(panel);
     
     super.onInitialize();
  }
}
