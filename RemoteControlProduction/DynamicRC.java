//Enter "java -jar Desktop/selenium-server-standalone-2.41.0.jar -port 4444" in the Terminal.//

package RemoteControlProduction;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class DynamicRC {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://www.spongecell.com/gallery/concept/717/creative/293730");
		selenium.start();
	}

	@Test
	public void testDynamicRC() throws Exception {
		selenium.open("/gallery/concept/717/creative/293730");
		assertEquals("Qatar Airways - 300x250", selenium.getText("css=li.active"));
		assertTrue(selenium.isElementPresent("css=button.btn.dropdown-text"));
		selenium.click("css=button.btn.dropdown-toggle");
		selenium.click("link=Chicago, IL, US");
		selenium.waitForPageToLoad("30000");
		assertEquals("Chicago, IL, US", selenium.getText("css=div.filter-text"));
		assertTrue(selenium.isElementPresent("css=div.filter-text"));
		selenium.click("css=button.btn.dropdown-toggle");
		selenium.click("link=Houston, TX, US");
		selenium.waitForPageToLoad("30000");
		assertEquals("Houston, TX, US", selenium.getText("css=div.filter-text"));
		assertTrue(selenium.isElementPresent("css=div.filter-text"));
		selenium.click("css=button.btn.dropdown-toggle");
		selenium.click("link=New York, NY, US");
		selenium.waitForPageToLoad("30000");
		assertEquals("New York, NY, US", selenium.getText("css=div.filter-text"));
		assertTrue(selenium.isElementPresent("css=div.filter-text"));
		selenium.click("css=button.btn.dropdown-toggle");
		selenium.click("link=Washington, DC, US");
		selenium.waitForPageToLoad("30000");
		assertEquals("Washington, DC, US", selenium.getText("css=div.filter-text"));
		assertTrue(selenium.isElementPresent("css=div.filter-text"));
		selenium.click("id=clear-button");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("css=button.btn.dropdown-text"));
		assertTrue(selenium.isElementPresent("id=demo"));
		selenium.open("/gallery/concept/474/creative/294392");
		assertEquals("King's Hawaiian - 160x600", selenium.getText("css=li.active"));
		selenium.click("css=button.btn.dropdown-text");
		assertTrue(selenium.isElementPresent("css=button.btn.dropdown-text"));
		selenium.click("css=button.btn.dropdown-toggle");
		selenium.click("link=Afternoon");
		selenium.waitForPageToLoad("30000");
		assertEquals("Afternoon", selenium.getText("css=div.filter-text"));
		assertTrue(selenium.isElementPresent("css=div.filter-text"));
		selenium.click("css=button.btn.dropdown-toggle");
		selenium.click("link=Early Morning");
		selenium.waitForPageToLoad("30000");
		assertEquals("Early Morning", selenium.getText("css=div.filter-text"));
		assertTrue(selenium.isElementPresent("css=div.filter-text"));
		selenium.click("css=button.btn.dropdown-toggle");
		selenium.click("link=Evening");
		selenium.waitForPageToLoad("30000");
		assertEquals("Evening", selenium.getText("css=div.filter-text"));
		assertTrue(selenium.isElementPresent("css=div.filter-text"));
		selenium.click("css=button.btn.dropdown-toggle");
		selenium.click("link=Late Night");
		selenium.waitForPageToLoad("30000");
		assertEquals("Late Night", selenium.getText("css=div.filter-text"));
		assertTrue(selenium.isElementPresent("css=div.filter-text"));
		selenium.click("css=button.btn.dropdown-toggle");
		selenium.click("link=Morning");
		selenium.waitForPageToLoad("30000");
		assertEquals("Morning", selenium.getText("css=div.filter-text"));
		assertTrue(selenium.isElementPresent("css=div.filter-text"));
		selenium.click("id=clear-button");
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementPresent("css=button.btn.dropdown-text"));
		assertEquals("King's Hawaiian - 160x600", selenium.getText("css=li.active"));
		
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}