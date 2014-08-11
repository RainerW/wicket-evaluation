package com.example.pages.fussball;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxFallbackLink;
import org.apache.wicket.model.Model;

import com.example.component.player.PlayerTable;
import com.example.model.Player;
import com.example.pages.BasePage;
import com.example.pages.spieler.EditSpieler;

public class Fussball extends BasePage {
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new PlayerTable("debug"));
		add(new AjaxFallbackLink<Player>("neuerSpieler") {

			@Override
			public void onClick(AjaxRequestTarget target) {
				setResponsePage(new EditSpieler() {
					@Override
					protected void onBack() {
						setResponsePage(Fussball.this);
					}

					@Override
					protected void afterSave() {
						setResponsePage(Fussball.this);
					}
				});
			}
		});
	}
}
