package com.example;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;

import com.example.pages.About;
import com.example.pages.HomePage;
import com.example.pages.fussball.Fussball;
import com.example.pages.spieler.ConfirmSave;
import com.example.pages.spieler.EditSpieler;
import com.example.pages.tennis.Tennis;

/**
 * Application object for your web application.
 * If you want to run this application without deploying, run the Start class.
 * 
 * @see com.example.Start#main(String[])
 */
public class WicketApplication extends WebApplication
{
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return HomePage.class;
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();

		mountPage("fussball", Fussball.class);
		mountPage("tennis", Tennis.class);
		mountPage("about", About.class);
		mountPage("spieler/createOrEdit", EditSpieler.class);
		mountPage("spieler/confirm", ConfirmSave.class);
	}
}
