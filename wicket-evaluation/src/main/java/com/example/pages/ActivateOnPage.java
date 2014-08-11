package com.example.pages;

import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;

public class ActivateOnPage extends Behavior
{

  Class<HomePage> _activeOn;

  public ActivateOnPage(Class<HomePage> claazz)
  {
    _activeOn = claazz;
  }

  @Override
  public void onComponentTag(Component component, ComponentTag tag)
  {
    Class<? extends Page> active = component.getPage().getClass();
    if (_activeOn.equals(active))
    {
      tag.append("class", "active", " ");
    }
  }
}
