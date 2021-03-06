package com.example.pages;

import org.apache.wicket.Page;
import org.apache.wicket.devutils.debugbar.DebugBar;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;

import com.example.component.langchoose.LanguageChooser;
import com.example.pages.fussball.Fussball;
import com.example.pages.tennis.Tennis;

/**
 * Basisklasse f�r alle Seiten der Anwendung.
 * Stellt das Basislayout der Seite inkl. Men� und der Fu�zeile mit der Wicketversion bereit.
 */
public abstract class BasePage extends WebPage
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
    add(new LanguageChooser("langChooser"));
    
  
    add(new Label("version", getApplication().getFrameworkSettings().getVersion()));
    add(new DebugBar("debug"));
    
  }
  
  void addMenu(RepeatingView item, String key, Class<? extends Page> clazz)
  {
    WebMarkupContainer w = new WebMarkupContainer(item.newChildId());
    item.add(w.add(new ActivateOnPage(clazz)));
    w.add(new BookmarkablePageLink<Tennis>("link", clazz).setBody(new ResourceModel("menu." + key)));
  }
}
