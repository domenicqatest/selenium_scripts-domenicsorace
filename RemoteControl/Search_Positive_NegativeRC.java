//Enter "java -jar Desktop/selenium-server-standalone-2.41.0.jar -port 4444" in the Terminal.//

package RemoteControl;

	import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

	public class Search_Positive_NegativeRC {
		private Selenium selenium;

		@Before
		public void setUp() throws Exception {
			selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://staging-www.spongecell.com/gallery");
			selenium.start();
		}

		@Test
		public void testSearch_Positive_NegativeRC() throws Exception {
			selenium.open("/gallery");
			assertTrue(selenium.isElementPresent("id=square-search"));
			selenium.type("id=square-search", "Gilte");
			selenium.selectWindow("null");
			selenium.click("link=clear all filters to start a new search >>");
			selenium.type("id=square-search", "Gillette");
			assertTrue(selenium.isElementPresent("//div[@id='gallery-container']/div[22]/div/div/div"));
			assertTrue(selenium.isElementPresent("//div[@id='gallery-container']/div[133]/div/div/div"));
			assertTrue(selenium.isElementPresent("id=square-search"));
			selenium.type("id=square-search", "");
			
			//Put Here//
			selenium.open("/gallery");
			assertTrue(selenium.isElementPresent("id=square-search"));
			verifyEquals("", selenium.getText("id=square-search"));
			selenium.type("id=square-search", "Gilte");
			verifyEquals("Sorry, we don't have any ads that match your search criteria. Clear a filter above or clear all filters to start a new search >>", selenium.getText("css=div.span12"));
			selenium.type("id=square-search", "");
			selenium.click("link=clear all filters to start a new search >>");
			verifyEquals("", selenium.getText("id=square-search"));
			selenium.type("id=square-search", "Gillette");
			assertTrue(selenium.isElementPresent("//div[@id='gallery-container']/div[22]/div/div/div"));
			assertTrue(selenium.isElementPresent("//div[@id='gallery-container']/div[133]/div/div/div"));
			assertTrue(selenium.isElementPresent("id=square-search"));
			selenium.type("id=square-search", "");
		}

		private void verifyEquals(String string, String text) {
			// TODO Auto-generated method stub
			
		}

		@After
		public void tearDown() throws Exception {
			selenium.stop();
		}
	}
