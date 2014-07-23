//Enter "java -jar Desktop/selenium-server-standalone-2.41.0.jar -port 4444" in the Terminal.//

package RemoteControl;

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
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://staging-www.spongecell.com/gallery");
		selenium.start();
	}

	@Test
	public void testToggleRC() throws Exception {
		selenium.open("/gallery");
		selenium.click("id=list-view");
		//assertEquals("300x250", selenium.getText("xpath=(//a[contains(text(),'300x250')])[8]"));//
		selenium.click("id=grid-view");
		selenium.click("link=300 x 250");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Other");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//a[contains(text(),'300 x 250')])[17]");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=160x600");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=728x90");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//a[contains(text(),'300x250')])[2]");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=CPG");
		selenium.waitForPageToLoad("30000");
		selenium.click("xpath=(//a[contains(text(),'Instream')])[3]");
		selenium.waitForPageToLoad("30000");
		selenium.click("link=Gallery");
		selenium.waitForPageToLoad("30000");
		selenium.open("/gallery");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
