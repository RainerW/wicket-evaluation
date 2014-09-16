package com.example.pages;

import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import com.example.java8.IActionList;
import com.example.java8.LWicketAction;
import com.example.java8.LWicketSubmit;
import com.example.pages.fussball.Fussball;
import com.example.pages.tennis.Tennis;

/**
 * Basisklasse für alle seiten der Anwendung.
 * Stellt das Basislayout der Seite inkl. Menü und der Fußzeile mit der Wicketversion bereit.
 */
public abstract class BasePage extends WebPage implements IActionList
{
  private static final long serialVersionUID = 1L;

  public BasePage()
  {
  }

  public BasePage(IModel<?> model)
  {
    super(model);
  }

  @Override
  protected void onInitialize()
  {
    super.onInitialize();
    RepeatingView view = new RepeatingView("menuItem");
    add(view);
  
    addMenu(view, "Home", HomePage.class);
    addMenu(view, "Fussball", Fussball.class);
    addMenu(view, "Tennis", Tennis.class);
    addMenu(view, "About", About.class);
  
    add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
  
  }
  
  void addMenu(RepeatingView item, String text, Class<? extends Page> clazz)
  {
    WebMarkupContainer w = new WebMarkupContainer(item.newChildId());
    item.add(w.add(new ActivateOnPage(clazz)));
    w.add(new BookmarkablePageLink<Tennis>("link", clazz).setBody(Model.of(text)));
  }
  
  protected LWicketAction responsePage(Page target)
  {
    return () -> {setResponsePage(target);};
  }
  
}
