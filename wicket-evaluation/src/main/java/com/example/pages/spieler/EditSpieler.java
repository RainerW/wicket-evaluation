package com.example.pages.spieler;

import javax.inject.Inject;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.validation.FormComponentFeedbackBorder;
import org.apache.wicket.markup.html.pages.RedirectPage;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.flow.RedirectToUrlException;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.StringValue;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.validator.StringValidator;

import com.example.bootstrap.BootstrapFormFeedback;
import com.example.model.Player;
import com.example.pages.BasePage;
import com.example.pages.HomePage;
import com.example.repository.PlayerRepository;

public class EditSpieler extends BasePage
{
  Player player;

  public EditSpieler(Player toEdit)
  {
    player = toEdit;
  }

  @Inject
  PlayerRepository repo;

  public EditSpieler(PageParameters param)
  {
    Long id = param.get("id").toOptionalLong();
    if (id == null)
    {
      throw new RedirectToUrlException("404");
    }
    player = repo.findOne(id);
    if (player == null)
    {
      throw new RedirectToUrlException("404");
    }
  }

  @Override
  protected void onInitialize()
  {
    super.onInitialize();
    add(new Label("editType", new PlayerEditLabelModel()));
    Form<Player> form = new Form<Player>("form",
        new CompoundPropertyModel<Player>(player)) {
      @Override
      protected void onSubmit()
      {
        setResponsePage(new ConfirmSave(player) {
          @Override
          protected void onBack()
          {
            setResponsePage(EditSpieler.this);
          }

          @Override
          protected void onCancel()
          {
            EditSpieler.this.onBack();
          }

          @Override
          protected void afterSave()
          {
            EditSpieler.this.afterSave();
          }
        });
      }
    };
    add(form);
    form.add(new FeedbackPanel("feedback"));

    BootstrapFormFeedback feedbackVorname = new BootstrapFormFeedback(
        "vornameFeedback");
    form.add(feedbackVorname);
    feedbackVorname.add(new TextField<String>("vorname")
        .add(StringValidator.maximumLength(10)));

    BootstrapFormFeedback feedbackNachname = new BootstrapFormFeedback(
        "nachnameFeedback");
    form.add(feedbackNachname);
    feedbackNachname.add(new TextField<String>("nachname")
        .setRequired(true));

    BootstrapFormFeedback feedbackEMail = new BootstrapFormFeedback(
        "nachnameEMail");
    form.add(feedbackEMail);
    feedbackEMail.add(new EmailTextField("email").add(
        new UniqueAddressValidator(player)).setRequired(true));

    Button cancel = new Button("cancel") {
      @Override
      public void onSubmit()
      {
        EditSpieler.this.onBack();
      }
    }.setDefaultFormProcessing(false);
    form.add(cancel);
  }

  protected void afterSave()
  {
    onBack();
  }

  protected void onBack()
  {
    setResponsePage(HomePage.class);
  }

  class PlayerEditLabelModel extends Model<String>
  {
    @Override
    public String getObject()
    {
      if (player != null && player.getId() != null)
      {
        return "Spieler editieren";
      } else
      {
        return "Spieler neu anlegen";
      }
    }
  }
}
