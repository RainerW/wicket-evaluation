package com.example.bootstrap;

import java.io.Serializable;

import org.apache.wicket.behavior.AttributeAppender;

public class AttributeRemover extends AttributeAppender
{

  public AttributeRemover(String attribute, Serializable value)
  {
    super(attribute, value);
  }
  
  @Override
  protected String newValue(String currentValue, String appendValue)
  {
    String neu = currentValue.replace(appendValue,"");
    return neu;
  }

}
