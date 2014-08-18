package MiscTests;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ChappelleYouTube {
	
	private WebDriver driver;
	  private String baseUrl;
	  private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://youtu.be/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }
	    
@Test
public void testChappelleYouTubeJUnit4() throws Exception { 
FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "movie_player");
 driver.manage().window().maximize(); 
 driver.get(baseUrl + "DAZWbuoncfQ?t=8s");
 Thread.sleep(10000L);
 
 // let the video load
 while (Integer.parseInt(flashApp.callFlashObject("getPlayerState")) == 3)
 Thread.sleep(10000L);
 }

 @After
 public void tearDown() throws Exception {
   driver.quit();
   String verificationErrorString = verificationErrors.toString();
   if (!"".equals(verificationErrorString)) {
     fail(verificationErrorString);
   }
 }

 private boolean isElementPresent(By by) {
   try {
     driver.findElement(by);
     return true;
   } catch (NoSuchElementException e) {
     return false;
   }
 }

 private boolean isAlertPresent() {
   try {
     driver.switchTo().alert();
     return true;
   } catch (NoAlertPresentException e) {
     return false;
   }
 }

 private String closeAlertAndGetItsText() {
   try {
     Alert alert = driver.switchTo().alert();
     String alertText = alert.getText();
     if (acceptNextAlert) {
       alert.accept();
     } else {
       alert.dismiss();
     }
     return alertText;
   } finally {
     acceptNextAlert = true;
   }
 }
 
}