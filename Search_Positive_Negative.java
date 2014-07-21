import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Search_Positive_Negative {
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
  public void testSearchPostitiveNegative() throws Exception {
    driver.get(baseUrl + "/gallery");
    
  //Pause//
    Thread.sleep(3000);
    
    assertTrue(isElementPresent(By.id("square-search")));
    
  //Pause//
    Thread.sleep(3000);
    
    driver.findElement(By.id("square-search")).clear();
    driver.findElement(By.id("square-search")).sendKeys("Gilte");
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    driver.findElement(By.linkText("clear all filters to start a new search >>")).click();
    driver.findElement(By.id("square-search")).clear();
    driver.findElement(By.id("square-search")).sendKeys("Gillette");
    
  //Pause//
    Thread.sleep(3000);
    
    assertTrue(isElementPresent(By.xpath("//div[@id='gallery-container']/div[22]/div/div/div")));
    assertTrue(isElementPresent(By.xpath("//div[@id='gallery-container']/div[133]/div/div/div")));
    assertTrue(isElementPresent(By.id("square-search")));
    
  //Pause//
    Thread.sleep(3000);
    
    driver.findElement(By.id("square-search")).clear();
    driver.findElement(By.id("square-search")).sendKeys("");
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

