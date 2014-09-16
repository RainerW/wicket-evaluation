package com.example.pages;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;

import org.apache.wicket.IPageFactory;
import org.apache.wicket.request.component.IRequestablePage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.session.DefaultPageFactory;
import org.apache.wicket.util.string.StringValue;

public class ParameterPageFactory implements IPageFactory
{
  DefaultPageFactory d = new DefaultPageFactory();

  @Override
  public <C extends IRequestablePage> C newPage(Class<C> pageClass)
  {
    return d.newPage(pageClass);
  }

  @Override
  public <C extends IRequestablePage> C newPage(Class<C> pageClass, PageParameters parameters)
  {
    Constructor<?>[] all = pageClass.getConstructors();
    loopConstructors: for (Constructor<?> c : all)
    {
      Parameter[] params = c.getParameters();
      if (params.length > 0)
      {
        Object[] init = new Object[params.length];
        for (int i = 0; i < params.length; i++)
        {
          Parameter p = params[i];
          if (p.getType() == PageParameters.class)
          {
            continue loopConstructors;
          }
          if(!p.isNamePresent()) 
          {
            continue loopConstructors;
          }
          String pn = p.getName();
          System.out.println("parameter name = " + pn);
          if( !parameters.getNamedKeys().contains(pn) ) {
            continue loopConstructors;
          }
          StringValue v = parameters.get(pn);
          Object o  = v;
          if (p.getType() == Long.class)
          {
            o = v.toOptionalLong();
          }
          init[i] = o;
        }
        Object page;
        try
        {
          page = c.newInstance(init);
          return (C) page;
        }
        catch (InstantiationException | IllegalAccessException | IllegalArgumentException
            | InvocationTargetException e)
        {
          e.printStackTrace();
          continue loopConstructors;
        }
      }
    }
    return d.newPage(pageClass, parameters);
  }

  @Override
  public <C extends IRequestablePage> boolean isBookmarkable(Class<C> pageClass)
  {
    return d.isBookmarkable(pageClass);
  }
}