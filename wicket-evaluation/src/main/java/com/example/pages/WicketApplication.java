package com.example.pages;

import java.util.Locale;

import net.ftlines.wicketsource.WicketSource;

import org.apache.wicket.Session;
import org.apache.wicket.application.IComponentInstantiationListener;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.stereotype.Service;
import org.wicketstuff.wicket7.util.watch.Nio2ModificationWatcher;

import com.example.pages.fussball.Fussball;
import com.example.pages.spieler.ConfirmSave;
import com.example.pages.spieler.EditSpieler;
import com.example.pages.tennis.Tennis;

/**
 * Application object for your web application. If you want to run
 * this application without deploying, run the Start class.
 * 
 * @see com.example.Start#main(String[])
 */
@Service
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
    mountPage("spieler/#{id}/createOrEdit", EditSpieler.class);
    mountPage("spieler/confirm", ConfirmSave.class);

    getComponentInstantiationListeners().add(createComponentInstantiationListener());

    if (getDebugSettings().isDevelopmentUtilitiesEnabled())
    {
      initDevelopmentTools();
    }
  }

  void initDevelopmentTools()
  {
    WicketSource.configure(this);
    // getResourceSettings().setResourceWatcher( new
    // Nio2ModificationWatcher(this));
  }

  protected IComponentInstantiationListener createComponentInstantiationListener()
  {
    return new SpringComponentInjector(this);
  }

  @Override
  public Session newSession(Request request, Response response)
  {
    Session session = super.newSession(request, response);
    // ensure default Locale, otherwise would be null
    session.setLocale(Locale.GERMAN);
    return session;
  }

}
