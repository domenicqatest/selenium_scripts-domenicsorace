//YOU MUST BE SIGNED IN TO ALL THE SOCIAL MEDIA BEFORE EXECUTING!!!

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Social {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://staging-www.spongecell.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testSocialJUnit4() throws Exception {
    driver.get(baseUrl + "/gallery");
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    try {
      assertEquals("", driver.findElement(By.id("square-search")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.id("square-search")).clear();
    driver.findElement(By.id("square-search")).sendKeys("Air New Zealand");
    
    //Pause//
    Thread.sleep(1000);
    
    driver.findElement(By.linkText("300 x 250")).click();

    assertEquals("Air New Zealand - 300x250", driver.findElement(By.cssSelector("li.active")).getText());

    driver.findElement(By.cssSelector("img[alt=\"Share_email\"]")).click();

    assertTrue(isElementPresent(By.cssSelector("img[alt=\"Share_email\"]")));
    assertTrue(isElementPresent(By.cssSelector("img[alt=\"Share_facebook\"]")));

    driver.findElement(By.cssSelector("img[alt=\"Share_facebook\"]")).click();
    
    assertTrue(isElementPresent(By.cssSelector("img[alt=\"Share_twitter\"]")));

    driver.findElement(By.cssSelector("img[alt=\"Share_twitter\"]")).click();
    assertEquals("Check out this interactive @Spongecell ad for Air New Zealand! http://bit.ly/1h77mXE See more at spongecell.com/gallery", driver.findElement(By.id("status")).getText());
    
    // SIGN IN TO TWITTER AND RUN THIS LINE: driver.findElement(By.xpath("//input[@value='Tweet']")).click(); UNLESS YOU ARE SIGNED IN TO TWITTER ADDING THIS LINE WILL FAIL THIS SCRIPT HERE!!!
    driver.get(baseUrl + "/gallery");
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