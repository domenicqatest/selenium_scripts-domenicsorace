//Enter "java -jar Desktop/selenium-server-standalone-2.41.0.jar -port 4444" in the Terminal.//

package RemoteControl;

import com.thoughtworks.selenium.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.regex.Pattern;

public class InquiryRC {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://staging-www.spongecell.com/gallery");
		selenium.start();
	}

	@Test
	public void testInquiryRC() throws Exception {
		selenium.open("/inquiries/new");
		selenium.click("id=submit");
		verifyEquals("can't be blank", selenium.getText("css=span.help-inline"));
		verifyEquals("can't be blank", selenium.getText("//form[@id='new_inquiry']/div[3]/div/span"));
		verifyEquals("can't be blank", selenium.getText("//form[@id='new_inquiry']/div[6]/div/span"));
		verifyEquals("", selenium.getText("id=inquiry_name"));
		selenium.type("id=inquiry_name", "Domenic Sorace");
		selenium.click("id=submit");
		verifyEquals("can't be blank", selenium.getText("css=span.help-inline"));
		verifyEquals("can't be blank", selenium.getText("//form[@id='new_inquiry']/div[6]/div/span"));
		verifyEquals("", selenium.getText("id=inquiry_email"));
		selenium.type("id=inquiry_email", "domenic.sorace@spongecell.com");
		selenium.click("id=submit");
		verifyEquals("can't be blank", selenium.getText("css=span.help-inline"));
		verifyEquals("", selenium.getText("id=inquiry_content"));
		selenium.type("id=inquiry_content", "Test");
		selenium.click("id=submit");
		selenium.waitForPageToLoad("30000");
		verifyEquals("The email was sent successfully.", selenium.getText("id=flash_notice"));
		selenium.click("link=×");
		verifyEquals("", selenium.getText("id=inquiry_name"));
		selenium.type("id=inquiry_name", "Domenic Sorace");
		verifyEquals("", selenium.getText("id=inquiry_content"));
		selenium.type("id=inquiry_content", "Test");
		verifyEquals("", selenium.getText("id=inquiry_email"));
		selenium.type("id=inquiry_email", "domenic.sorace#spongecell.com");
		selenium.click("id=submit");
		verifyEquals("is invalid", selenium.getText("css=span.help-inline"));
		verifyEquals("", selenium.getText("id=inquiry_email"));
		selenium.type("id=inquiry_email", "domenic.sorace@spongecell.com");
		verifyEquals("", selenium.getText("id=inquiry_phone"));
		selenium.type("id=inquiry_phone", "212222555A");
		selenium.click("id=submit");
		verifyEquals("is invalid", selenium.getText("css=span.help-inline"));
		verifyEquals("", selenium.getText("id=inquiry_phone"));
		selenium.type("id=inquiry_phone", "2122225555");
		verifyEquals("", selenium.getText("id=inquiry_company"));
		selenium.type("id=inquiry_company", "Tester");
		selenium.click("id=submit");
		selenium.waitForPageToLoad("30000");
		verifyEquals("The email was sent successfully.", selenium.getText("id=flash_notice"));
		selenium.click("link=×");
	}

	private void verifyEquals(String string, String text) {
		// TODO Auto-generated method stub
		
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}