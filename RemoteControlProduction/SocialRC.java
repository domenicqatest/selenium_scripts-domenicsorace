//Enter "java -jar Desktop/selenium-server-standalone-2.41.0.jar -port 4444" in the Terminal.//

package RemoteControlProduction;

//Must be signed into Twitter//

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

public class SocialRC {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://www.spongecell.com/gallery");
		selenium.start();
	}

	@Test
	public void testSocialRC() throws Exception {
		selenium.open("/gallery/concept/626/creative/282411");
		
		selenium.waitForPageToLoad("30000");
		selenium.click("css=img[alt=\"Share_email\"]");
		assertTrue(selenium.isElementPresent("css=img[alt=\"Share_email\"]"));
		assertTrue(selenium.isElementPresent("css=img[alt=\"Share_facebook\"]"));
		selenium.click("css=img[alt=\"Share_facebook\"]");
		assertTrue(selenium.isElementPresent("css=img[alt=\"Share_twitter\"]"));
		selenium.click("css=img[alt=\"Share_twitter\"]");
		selenium.waitForPageToLoad("30000");
		assertEquals("Check out this interactive @Spongecell ad for Air New Zealand! http://bit.ly/1omgvjl See more at spongecell.com/gallery", selenium.getText("id=status"));
		//selenium.click("//input[@value='Tweet']");//
		selenium.open("/gallery");
	}

	private void verifyEquals(String string, String text) {
		// TODO Auto-generated method stub
		
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
