package com.example.pages;

import java.io.Serializable;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.Component;
import org.apache.wicket.core.util.resource.UrlResourceStream;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.resource.IResourceStream;
import org.apache.wicket.velocity.markup.html.VelocityPanel;

public class MyPanel extends VelocityPanel
{

  public <T extends Serializable> MyPanel(String id, Object modelObject)
  {
    super(id, asMap("model", modelObject));
  }

  private static Model<HashMap<String, Object>> asMap(String key, Object modelObject)
  {
    HashMap<String, Object> map = new HashMap<>();
    map.put(key, modelObject);
    return Model.of(map);
  }

  @Override
  protected IResourceStream getTemplateResource()
  {
    String name = getClass().getSimpleName();
    URL url = getClass().getResource(name + ".vm");
    UrlResourceStream template = new UrlResourceStream(url);
    return template;
  }
  
  @Override
  protected boolean parseGeneratedMarkup()
  {
    return true;
  }

}
