package com.example.pages.spieler;

import javax.inject.Inject;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.CompoundPropertyModel;

import com.example.model.Player;
import com.example.pages.BasePage;
import com.example.services.PlayerService;

public class ConfirmSave extends BasePage {

	@Inject
	PlayerService service;


	public ConfirmSave(final Player player) {
		super();
		Form<Player> form = new Form<Player>("form",new CompoundPropertyModel<Player>(player));
		form.add(new AjaxFallbackLink("save") {
			@Override
			public void onClick(AjaxRequestTarget target) {
				onSave(player);
			}
		});
		form.add(new AjaxFallbackLink("cancel") {
			@Override
			public void onClick(AjaxRequestTarget target) {
				onCancel();
			}
		});
		form.add(new AjaxFallbackLink("back") {
			@Override
			public void onClick(AjaxRequestTarget target) {
				onBack();
			}
		});
		form.add(new Label("vorname"));
		form.add(new Label("nachname"));
		form.add(new Label("email"));
		add(form);
	}

	protected void onCancel() {

	}

	protected void onBack() {

	}

	protected void onSave(Player player) {
		service.save(player);
		afterSave();
	}

	protected void afterSave() {

	}

}
