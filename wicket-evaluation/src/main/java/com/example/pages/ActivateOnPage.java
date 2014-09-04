package com.example.pages;

import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;

/**
 * Markiert eine Menüpunkt als aktiv, d.h. fügt die CSS-Classe "active" hinzu, 
 * wenn die Klasse der aktuellen Seite der Klasse der zuvor übergebenen Klasse entspricht.
 */
public class ActivateOnPage extends Behavior
{

  Class<? extends Page> _activeOn;

  public ActivateOnPage(Class<? extends Page> claazz)
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
