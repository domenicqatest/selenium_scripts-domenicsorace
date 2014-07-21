import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Toggle {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://staging-www.spongecell.com";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @Test
  public void testToggleJUnit4() throws Exception {

      driver.get(baseUrl + "/gallery");
      driver.findElement(By.id("list-view")).click();
      
      
      //Pause//
      Thread.sleep(1000);
      
      assertEquals("300x250", driver.findElement(By.xpath("(//a[contains(text(),'300x250')])[8]")).getText());
      
      
      //Pause//
      Thread.sleep(1000);
      
      driver.findElement(By.id("grid-view")).click();
      
      
      //Pause//
      Thread.sleep(1000);
      
      driver.findElement(By.linkText("300 x 250")).click();
      driver.findElement(By.linkText("Other")).click();
      driver.findElement(By.xpath("(//a[contains(text(),'300 x 250')])[17]")).click();
      driver.findElement(By.linkText("160x600")).click();
      driver.findElement(By.linkText("728x90")).click();
      driver.findElement(By.xpath("(//a[contains(text(),'300x250')])[2]")).click();
      driver.findElement(By.linkText("CPG")).click();
      driver.findElement(By.xpath("(//a[contains(text(),'Instream')])[3]")).click();
      driver.findElement(By.linkText("Gallery")).click();
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
