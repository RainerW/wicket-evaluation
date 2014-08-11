package com.example.pages;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.IModel;

import com.example.pages.fussball.Fussball;
import com.example.pages.tennis.Tennis;

public class BasePage extends WebPage {
	private static final long serialVersionUID = 1L;

	public BasePage() {
	}

	public BasePage(IModel<?> model) {
		super(model);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		WebMarkupContainer w = new WebMarkupContainer("homeActive");
		add(w.add(new ActivateOnPage(HomePage.class)));
		w.add(new BookmarkablePageLink<Tennis>("home", HomePage.class));
		add(new BookmarkablePageLink<Fussball>("fussball", Fussball.class));
		add(new BookmarkablePageLink<Tennis>("tennis", Tennis.class));
		add(new BookmarkablePageLink<Tennis>("about", About.class));
		
		add(new Label("version", getApplication().getFrameworkSettings()
				.getVersion()));

	}
}
