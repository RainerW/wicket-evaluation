package com.example.pages;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.model.IModel;

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

		add(new Label("version", getApplication().getFrameworkSettings()
				.getVersion()));

	}
}
