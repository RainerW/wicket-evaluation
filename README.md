wicket-evaluation
=================

Apache Wicket evaluation app

Requirements
-----------

 * Java JDK
 * Maven

Clone the repository and download and install Java and Maven. Then just run `mvn jetty:run` now the application should be accessible at http://localhost:8080

3dParty
-------------

Integration of Mockito, Spring and Apache Wicket based on ( http://www.petrikainulainen.net/programming/tips-and-tricks/mocking-spring-beans-with-apache-wicket-and-mockito/). AbstractWicketTester does an autmagic adding of all @Mock field into the Mocked Application Context.