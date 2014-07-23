//Enter "java -jar Desktop/selenium-server-standalone-2.41.0.jar -port 4444" in the Terminal.//

package RemoteControlProduction;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class ToggleRC {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://www.spongecell.com/gallery");
		selenium.start();
	}

	@Test
	public void testToggleRC() throws Exception {
		selenium.open("/gallery/");
		selenium.click("id=list-view");
		assertEquals("Spongecell", selenium.getTitle());
		selenium.click("id=grid-view");
		selenium.open("/gallery/concept/19/creative/277650");
		
		selenium.waitForPageToLoad("30000");
		selenium.click("link=728x90");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=160x600");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Other");
		selenium.waitForPageToLoad("30000");
		assertEquals("Other", selenium.getText("css=div.filter-text"));
		selenium.click("css=div.remove-filter");
		selenium.click("link=300 x 250");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Tourism & Recreation");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//a[contains(text(),'728 x 90')])[4]");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Gallery");
		selenium.waitForPageToLoad("30000");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
