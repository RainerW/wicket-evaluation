package com.example.java8;

import org.apache.wicket.markup.html.link.Link;

public class Link8 extends Link implements IOnClick<Link8>
{
  public Link8(String id, LWicketAction clickHandler)
  {
    super(id);
    onClick(clickHandler);
  }

  @Override
  public void onClick()
  {
    actionClick();
  }

}
