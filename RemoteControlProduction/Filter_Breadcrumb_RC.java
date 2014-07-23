package RemoteControlProduction;
//Enter "java -jar Desktop/selenium-server-standalone-2.41.0.jar -port 4444" in the Terminal.//

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class Filter_Breadcrumb_RC {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://www.spongecell.com/gallery");
		selenium.start();
	}

	@Test
	public void testFilter_Breadcrumb_FilterReset_JUnit4RC() throws Exception {
		selenium.open("/gallery");
		selenium.click("css=button.btn.dropdown-toggle");
		selenium.click("link=Display");
		assertEquals("Display", selenium.getText("css=div.filter-text"));
		selenium.click("//div[@id='search']/div/div/div/div[3]/div/button[2]");
		selenium.click("link=CPG");
		assertEquals("CPG", selenium.getText("//div[@id='filter-tags']/div[2]/div"));
		selenium.click("//div[@id='search']/div/div/div/div[4]/div/button[2]");
		selenium.click("link=Video");
		assertEquals("Video", selenium.getText("//div[@id='filter-tags']/div[3]/div"));
		selenium.click("//div[@id='search']/div/div/div/div[5]/div/button[2]");
		selenium.click("link=300x250");
		assertEquals("300x250", selenium.getText("//div[@id='filter-tags']/div[4]/div"));
		selenium.click("//div[@id='search']/div/div/div/div[6]/div/button[2]");
		selenium.click("link=United States");
		assertEquals("United States", selenium.getText("//div[@id='filter-tags']/div[5]/div"));
		selenium.selectWindow("null");
		selenium.click("xpath=(//a[contains(text(),'300 x 250')])[82]");
		selenium.waitForPageToLoad("30000");
		assertEquals("Clear Haircare - 300x250", selenium.getText("css=li.active"));
		selenium.click("link=CPG");
		selenium.waitForPageToLoad("30000");
		assertEquals("CPG", selenium.getText("css=div.filter-text"));
		selenium.click("css=div.remove-filter");
		assertEquals("Spongecell", selenium.getTitle());
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
