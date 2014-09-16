package com.example.java8;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.model.IModel;

public class Button8 extends Button implements IOnClick<Button8>
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
  
  @Override
  public void onSubmit()
  {
    actionClick();
  }

  private static final long serialVersionUID = 1L;

}
