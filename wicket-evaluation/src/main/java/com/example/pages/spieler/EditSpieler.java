package com.example.pages.spieler;

import javax.inject.Inject;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.flow.RedirectToUrlException;
import org.apache.wicket.validation.validator.StringValidator;

import com.example.bootstrap.BootstrapFormFeedback;
import com.example.java8.Button8;
import com.example.java8.Form8;
import com.example.java8.IOnBack;
import com.example.java8.IOnSaved;
import com.example.model.Player;
import com.example.pages.BasePage;
import com.example.repository.PlayerRepository;

public class EditSpieler extends BasePage implements IOnBack<EditSpieler>,IOnSaved<EditSpieler>
{
  public static final String ID_PARAM = "id";

  Player player;

  @Inject
  PlayerRepository repo;

  public EditSpieler(Player toEdit)
  {
    player = toEdit;
  }

  public EditSpieler(Long id)
  {
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
    Form8<Player> form = new Form8<>("form", player, this::onSubmit);

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

    Button cancel = new Button8("cancel",this::actionBack)
                          .setDefaultFormProcessing(false);
    form.add(cancel);
  }

  void onSubmit()
  {
    setResponsePage(new ConfirmSave(player)
        .onBack(responsePage(EditSpieler.this))
        .onCancel(EditSpieler.this::actionBack)
        .onSaved(EditSpieler.this::actionSaved));
  }

  class PlayerEditLabelModel extends Model<String>
  {
    @Override
    public String getObject()
    {
      if (player != null && player.getId() != null)
      {
        return "Spieler editieren";
      }
      else
      {
        return "Spieler neu anlegen";
      }
    }
  }

}
