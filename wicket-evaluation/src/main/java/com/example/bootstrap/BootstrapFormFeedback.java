package com.example.bootstrap;

import java.util.List;

import org.apache.wicket.feedback.ContainerFeedbackMessageFilter;
import org.apache.wicket.feedback.FeedbackCollector;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.IFeedback;
import org.apache.wicket.feedback.IFeedbackMessageFilter;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.border.Border;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class BootstrapFormFeedback extends Border implements IFeedback
{

  boolean hasError;
  IModel<String> message = new Model<String>();

  public BootstrapFormFeedback(String id)
  {
    super(id);
    addToBorder(new Label("inputError", message) {
      @Override
      public boolean isVisible()
      {
        return hasError;
      }
    });
  }

  @Override
  protected void onComponentTag(ComponentTag tag)
  {
    super.onComponentTag(tag);
    if (hasError)
    {
      tag.append("class", "has-error", " ");
    }
  }

  @Override
  protected void onBeforeRender()
  {
    super.onBeforeRender();
    List<FeedbackMessage> collect = new FeedbackCollector(getPage())
        .collect(getMessagesFilter());
    hasError = collect.size() > 0;
    if (hasError)
    {
      StringBuilder sb = new StringBuilder();
      for (FeedbackMessage fm : collect)
      {
        sb.append(fm.getMessage());
      }
      message.setObject(sb.toString());
    }
  }

  /**
   * @return Let subclass specify some other filter
   */
  protected IFeedbackMessageFilter getMessagesFilter()
  {
    return new ContainerFeedbackMessageFilter(this);
  }
}
