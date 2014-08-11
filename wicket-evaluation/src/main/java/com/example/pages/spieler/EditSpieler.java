package com.example.pages.spieler;

import org.apache.wicket.markup.html.form.EmailTextField;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.CompoundPropertyModel;

import com.example.model.Player;
import com.example.pages.BasePage;

public class EditSpieler extends BasePage {
	Player player = new Player();

	@Override
	protected void onInitialize() {
		super.onInitialize();

		Form<Player> form = new Form<Player>("form",new CompoundPropertyModel<Player>(player)) {
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
		form.add(new TextField<String>("vorname"));
		form.add(new TextField<String>("nachname"));
		form.add(new EmailTextField("email"));
	}

	protected void afterSave() {
		onBack();
	}

	protected void onBack() {
		
	}

}
