package com.example.component.langchoose;

import java.util.Locale;

import org.apache.wicket.Application;
import org.apache.wicket.Session;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.PropertyModel;

import com.example.component.player.BasePanel;

public class LanguageChooser extends BasePanel<Locale>
{

  public LanguageChooser(String id)
  {
    super(id);
    setRenderBodyOnly(true);
    setOutputMarkupPlaceholderTag(false);
//    add(new Label("current",new PropertyModel<Locale>(Session.get(), "locale")));
    add(new Link("german")
    {
      @Override
      public void onClick()
      {
        Session.get().setLocale(Locale.GERMAN);
      }
    });
    add(new Link("english")
    {
      @Override
      public void onClick()
      {
        Session.get().setLocale(Locale.ENGLISH);
      }
    });
  }

  // ***** allways strip tags because Bootstral css selector will not
  // work with wicket: tags in dev mode
  boolean stripTags = Application.get().getMarkupSettings().getStripWicketTags();

  @Override
  protected void onBeforeRender()
  {
    Application.get().getMarkupSettings().setStripWicketTags(true);
    super.onBeforeRender();
  }

  @Override
  protected void onAfterRender()
  {
    super.onAfterRender();
    Application.get().getMarkupSettings().setStripWicketTags(stripTags);
  }
}
