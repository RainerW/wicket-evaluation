package com.example.pages;

import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.wicket.application.IComponentInstantiationListener;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.configuration.InjectingAnnotationEngine;
import org.xml.sax.SAXException;

import com.example.component.player.PlayerTable;
import com.example.model.Player;
import com.example.model.SportArt;
import com.example.pages.fussball.Fussball;
import com.example.pages.tennis.Tennis;
import com.example.services.PlayerService;

import fiftyfive.wicket.test.WicketTestUtils;

/**
 * Simple test using the WicketTester
 */
public class HomePageTest extends AbstractWicketTest
{

  @Mock
  PlayerService playerService;

  @Override
  protected void setupTest()
  {
    ArrayList<Player> value = new ArrayList<Player>();
    value.add(new Player());
    when(playerService.getAllPlayers(SportArt.FUSSBALL)).thenReturn(value);
    when(playerService.getAllPlayers(SportArt.TENNIS)).thenReturn(value);
  }

  @Test
  public void homepageRendersSuccessfully1() throws Exception
  {
    WicketTester tester = getTester();

    // start and render the test page
    tester.startPage(HomePage.class);

    // assert rendered page class
    tester.assertRenderedPage(HomePage.class);

    // * Main Menu : "fussball"
    tester.clickLink("fussball");

    tester.assertRenderedPage(Fussball.class);
    WicketTestUtils.assertXPath(2, tester,
        "//table[@class='table']/tbody/tr");

    // * Main Menu : "fussball"
    tester.clickLink("tennis");

    tester.assertRenderedPage(Tennis.class);
    WicketTestUtils.assertXPath(2, tester,
        "//table[@class='table']/tbody/tr");

    // * Main Menu : "home"
    tester.clickLink("homeActive:home");

    tester.assertRenderedPage(HomePage.class);

    // * Main Menu : "about"
    tester.clickLink("about");

    tester.assertRenderedPage(About.class);
  }

}
