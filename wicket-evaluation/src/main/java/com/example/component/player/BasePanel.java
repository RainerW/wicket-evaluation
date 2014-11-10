package com.example.component.player;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

public class BasePanel<T> extends GenericPanel<T>
{
  private static final long serialVersionUID = 1L;

  public BasePanel(String id)
  {
    super(id);
    prepare();
  }

  public BasePanel(String id, IModel<T> model)
  {
    super(id, model);
    prepare();
  }

  protected void prepare()
  {
    Injector.get().inject(this);
  }

}
