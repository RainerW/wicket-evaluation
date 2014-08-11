package com.example.pages;

import javax.inject.Inject;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.pages.services.PlayerService;

public class HomePage extends BasePage {
	private static final long serialVersionUID = 1L;
	
	 @Inject
	 PlayerService s;
	 
	 @Override
	protected void onInitialize() {
		super.onInitialize();
		System.out.println("-----------------------");
		System.out.println(s);
//		 s.hi();
		System.out.println("-----------------------");
	}
}
