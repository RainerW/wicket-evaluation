package com.example.java8;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.model.IModel;

public class Button8<MY_TYPE> extends Button implements IOnClick<MY_TYPE>
{
  public Button8(String id, LWicketAction action)
  {
    super(id);
    onClick(action);
  }

  public Button8(String id, IModel<String> model)
  {
    super(id, model);
  }

  private static final long serialVersionUID = 1L;

}
