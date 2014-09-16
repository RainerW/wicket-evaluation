package com.example.bootstrap;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.visit.IVisit;
import org.apache.wicket.util.visit.IVisitor;

@SuppressWarnings("serial")
public class FormErrorBehavior extends Behavior
{
  @Override
  public void onConfigure(Component component)
  {
    super.onConfigure(component);
    if (component instanceof MarkupContainer)
    {
      MarkupContainer mc = (MarkupContainer) component;
      mc.visitChildren(new IVisitor<Component, Void>() {
        @Override
        public void component(Component object, IVisit<Void> visit)
        {
          if (object instanceof FormComponent)
          {
            FormComponent<?> fc = (FormComponent<?>) object;
            if (!fc.isValid())
            {
              fc.add(new AttributeAppender("class",Model.of("error")," "));
            }
            else
            {
              fc.add(new AttributeRemover("class","error"));
            }
          }
        }
      });
    }
  }
}