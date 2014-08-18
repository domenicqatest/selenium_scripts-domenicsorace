//Enter "java -jar Desktop/selenium-server-standalone-2.41.0.jar -port 4444" in the Terminal.//

package MiscTests;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

public class SignalProcessors_RC {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "https://spongecell.com");
		selenium.start();
	}

	@Test
	public void testDynamicRC() throws Exception {
		
		selenium.open("/sign_in");
		
		selenium.type("id=person_session_email", "domenic.sorace@spongecell.com");
		selenium.type("id=person_session_password", "weasel27");
		
		selenium.click("name=commit");
		selenium.waitForPageToLoad("30000");
		
		selenium.click("css=h2");
		assertEquals("Campaigns", selenium.getText("css=h2"));
		selenium.open("/admin/campaigns/dynamic");
		selenium.waitForPageToLoad("30000");
		assertEquals("Dynamic Campaigns", selenium.getText("css=h2"));
		selenium.click("link=JetBlue - Getaways - Q3 2014");
		selenium.waitForPageToLoad("30000");
		selenium.click("css=span.glyphpro.glyphpro-play");
		
		
		
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
