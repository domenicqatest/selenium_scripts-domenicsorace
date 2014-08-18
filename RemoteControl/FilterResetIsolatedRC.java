//Enter "java -jar Desktop/selenium-server-standalone-2.41.0.jar -port 4444" in the Terminal.//

package RemoteControl;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class FilterResetIsolatedRC {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://staging-www.spongecell.com/gallery");
		selenium.start();
	}

	@Test
	public void testFilterResetIsolatedRC() throws Exception {
		selenium.open("/gallery");
		selenium.click("css=button.btn.dropdown-toggle");
		selenium.click("link=Display");
		assertEquals("Display", selenium.getText("css=div.filter-text"));
		assertTrue(selenium.isElementPresent("css=div.filter-text"));
		selenium.click("//div[@id='search']/div/div/div/div[3]/div/button[2]");
		selenium.click("link=CPG");
		assertEquals("CPG", selenium.getText("//div[@id='filter-tags']/div[2]/div"));
		assertTrue(selenium.isElementPresent("//div[@id='filter-tags']/div[2]/div"));
		selenium.click("//div[@id='search']/div/div/div/div[4]/div/button[2]");
		selenium.click("link=Video");
		assertEquals("Video", selenium.getText("//div[@id='filter-tags']/div[3]/div"));
		assertTrue(selenium.isElementPresent("//div[@id='filter-tags']/div[3]/div"));
		selenium.click("//div[@id='search']/div/div/div/div[5]/div/button[2]");
		selenium.click("link=300x250");
		assertEquals("300x250", selenium.getText("//div[@id='filter-tags']/div[4]/div"));
		assertTrue(selenium.isElementPresent("//div[@id='filter-tags']/div[4]/div"));
		selenium.click("//div[@id='search']/div/div/div/div[6]/div/button[2]");
		selenium.click("link=United Arab Emirates");
		assertEquals("United Arab Emirates", selenium.getText("//div[@id='filter-tags']/div[5]/div"));
		assertTrue(selenium.isElementPresent("//div[@id='filter-tags']/div[5]/div"));
		assertEquals("Sorry, we don't have any ads that match your search criteria. Clear a filter above or clear all filters to start a new search >>", selenium.getText("css=div.span12"));
		selenium.click("link=clear all filters to start a new search >>");
		selenium.click("css=button.btn.dropdown-toggle");
		selenium.click("link=Display");
		selenium.click("//div[@id='search']/div/div/div/div[3]/div/button[2]");
		selenium.click("link=CPG");
		selenium.click("//div[@id='search']/div/div/div/div[4]/div/button[2]");
		selenium.click("link=Video");
		selenium.click("//div[@id='search']/div/div/div/div[5]/div/button[2]");
		selenium.click("link=300x250");
		selenium.click("//div[@id='search']/div/div/div/div[6]/div/button[2]");
		selenium.click("link=United States");
		assertEquals("United States", selenium.getText("//div[@id='filter-tags']/div[5]/div"));
		assertTrue(selenium.isElementPresent("//div[@id='filter-tags']/div[5]/div"));
		selenium.click("//div[@id='filter-tags']/div[5]/div[2]");
		
		
		assertTrue(selenium.isElementPresent("//div[@id='gallery-container']/div[133]/div/div/div"));
		selenium.click("//div[@id='filter-tags']/div[4]/div[2]");
		assertTrue(selenium.isElementPresent("//div[@id='gallery-container']/div[133]/div/div/div"));
		selenium.click("//div[@id='filter-tags']/div[3]/div[2]");
		assertTrue(selenium.isElementPresent("//div[@id='gallery-container']/div[323]/div/div/div"));
		selenium.click("//div[@id='filter-tags']/div[2]/div[2]");
		assertTrue(selenium.isElementPresent("//div[@id='gallery-container']/div[327]/div/div/div"));
		selenium.click("css=div.remove-filter");
		selenium.open("/gallery");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
