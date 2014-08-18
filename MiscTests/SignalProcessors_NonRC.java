package MiscTests;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SignalProcessors_NonRC {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://spongecell.com/sign_in";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
  
  @Test
  public void testSignalProcessorJUnit4() throws Exception {
	  driver.get(baseUrl);  
	  
	    driver.findElement(By.id("person_session_email")).clear();
	    driver.findElement(By.id("person_session_email")).sendKeys("domenic.sorace@spongecell.com");
	    
	  //Pause//
	    Thread.sleep(1000);
	    
	    driver.findElement(By.id("person_session_password")).clear();
	    driver.findElement(By.id("person_session_password")).sendKeys("weasel27");
	    
	  //Pause//
	    Thread.sleep(1000);
	    
	    driver.findElement(By.name("commit")).click();
	    
	  //Pause//
	    Thread.sleep(3000);
	  
        driver.get("https://spongecell.com/admin/campaigns/dynamic");
    
  //Pause//
    Thread.sleep(3000);
    
    assertEquals("Dynamic Campaigns", driver.findElement(By.cssSelector("h2")).getText());
    
    
    driver.findElement(By.linkText("JetBlue - Getaways - Q3 2014")).click();
    driver.findElement(By.cssSelector("span.glyphpro.glyphpro-play")).click();
  
  //Pause//
    Thread.sleep(1000);
    
    //assertEquals("Q3 (300x600)", driver.findElement(By.cssSelector("div.subheader")).getText());//
    
    //OPTIONS//
    //driver.findElement(By.cssSelector("select2-input select2-focused")).clear();
    //driver.findElement(By.cssSelector("select2-input select2-focused")).sendKeys("Save 20% Off");
    
    //OR//
    
    //driver.findElement(By.cssSelector("b")).click();   
    //driver.findElement(By.linkText("Save 20% Off")).click();
        
  //Pause//
    Thread.sleep(1000);
    
    driver.findElement(By.id("select2-result-label-48")).click();
    
  //Pause//
    Thread.sleep(3000);
    
    assertEquals("Q3 (160x600)", driver.findElement(By.cssSelector("h2")).getText());
    
  //Pause//
    Thread.sleep(3000);

    
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
}
