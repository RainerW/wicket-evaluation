package com.example.pages.spieler;

import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.validation.FormComponentFeedbackBorder;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.validation.IValidator;

import com.example.bootstrap.BootstrapFormFeedback;
import com.example.model.Player;
import com.example.pages.BasePage;

public abstract class EditSpieler extends BasePage {
	Player player;

	public EditSpieler(Player toEdit) {
		player = toEdit;
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();

		Form<Player> form = new Form<Player>("form",
				new CompoundPropertyModel<Player>(player)) {
			@Override
			protected void onSubmit() {
				setResponsePage(new ConfirmSave(player) {
					@Override
					protected void onBack() {
						setResponsePage(EditSpieler.this);
					}

					@Override
					protected void onCancel() {
						EditSpieler.this.onBack();
					}

					@Override
					protected void afterSave() {
						EditSpieler.this.afterSave();
					}
				});
			}
		};
		add(form);
		form.add(new FeedbackPanel("feedback"));
		
		BootstrapFormFeedback feedbackVorname = new BootstrapFormFeedback("vornameFeedback");
		form.add(feedbackVorname);
		feedbackVorname.add(new TextField<String>("vorname"));
		
		BootstrapFormFeedback feedbackNachname = new BootstrapFormFeedback("nachnameFeedback");
		form.add(feedbackNachname);
		feedbackNachname.add(new TextField<String>("nachname").setRequired(true));
		
		BootstrapFormFeedback feedbackEMail = new BootstrapFormFeedback("nachnameEMail");
		form.add(feedbackEMail);
		feedbackEMail.add(new EmailTextField("email").add(new UniqueAddressValidator(player)).setRequired(true));
		
		Button cancel = new Button("cancel"){
			@Override
			public void onSubmit() {
				EditSpieler.this.onBack();
			}
		}.setDefaultFormProcessing(false);
		form.add(cancel);
	}

	protected void afterSave() {
		onBack();
	}

	abstract protected void onBack();

}
