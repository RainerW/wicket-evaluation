package com.example.java8;

import java.util.function.Predicate;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;

public class Form8<T> extends Form<T>
{
  public LWicketSubmit lambdaOnSubmit;

  public Form8(String id)
  {
    super(id);
  }

  public Form8(String id, IModel<T> model)
  {
    super(id, model);
  }

  public Form8(String id, T object)
  {
    super(id, new CompoundPropertyModel<>( object));
  }

  public Form8(String id, T object, LWicketSubmit onSubmit)
  {
    super(id, new CompoundPropertyModel<>( object));
    lambdaOnSubmit = onSubmit;
  }

  @Override
  protected void onSubmit()
  {
    if (lambdaOnSubmit != null)
    {
      lambdaOnSubmit.doAction();
    }
  }

}
