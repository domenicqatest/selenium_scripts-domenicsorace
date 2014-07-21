import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Inquiry {
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
  public void testInquiryJUnit4() throws Exception {
    driver.get(baseUrl + "/inquiries/new");
    
    //Pause//
    Thread.sleep(3000);
    
    driver.findElement(By.id("submit")).click();
    try {
      assertEquals("can't be blank", driver.findElement(By.cssSelector("span.help-inline")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("can't be blank", driver.findElement(By.xpath("//form[@id='new_inquiry']/div[3]/div/span")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("can't be blank", driver.findElement(By.xpath("//form[@id='new_inquiry']/div[6]/div/span")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("", driver.findElement(By.id("inquiry_name")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    
    //Pause//
    Thread.sleep(3000);
    
    driver.findElement(By.id("inquiry_name")).clear();
    driver.findElement(By.id("inquiry_name")).sendKeys("Domenic Sorace");
    driver.findElement(By.id("submit")).click();
    try {
      assertEquals("can't be blank", driver.findElement(By.cssSelector("span.help-inline")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("can't be blank", driver.findElement(By.xpath("//form[@id='new_inquiry']/div[6]/div/span")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("", driver.findElement(By.id("inquiry_email")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    
    //Pause//
    Thread.sleep(3000);
    
    driver.findElement(By.id("inquiry_email")).clear();
    driver.findElement(By.id("inquiry_email")).sendKeys("domenic.sorace@spongecell.com");
    driver.findElement(By.id("submit")).click();
    try {
      assertEquals("can't be blank", driver.findElement(By.cssSelector("span.help-inline")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("", driver.findElement(By.id("inquiry_content")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    
    //Pause//
    Thread.sleep(3000);
    
    driver.findElement(By.id("inquiry_content")).clear();
    driver.findElement(By.id("inquiry_content")).sendKeys("Test");
    driver.findElement(By.id("submit")).click();
    try {
      assertEquals("The email was sent successfully.", driver.findElement(By.id("flash_notice")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.linkText("×")).click();
    try {
      assertEquals("", driver.findElement(By.id("inquiry_name")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    
    //Pause//
    Thread.sleep(3000);
    
    driver.findElement(By.id("inquiry_name")).clear();
    driver.findElement(By.id("inquiry_name")).sendKeys("Domenic Sorace");
    try {    	
      assertEquals("", driver.findElement(By.id("inquiry_content")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    
    //Pause//
    Thread.sleep(3000);
    
    driver.findElement(By.id("inquiry_content")).clear();
    driver.findElement(By.id("inquiry_content")).sendKeys("Test");
    try {
      assertEquals("", driver.findElement(By.id("inquiry_email")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    
    //Pause//
    Thread.sleep(3000);
    
    driver.findElement(By.id("inquiry_email")).clear();
    driver.findElement(By.id("inquiry_email")).sendKeys("domenic.sorace#spongecell.com");
    driver.findElement(By.id("submit")).click();
    try { 	
      assertEquals("is invalid", driver.findElement(By.cssSelector("span.help-inline")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("", driver.findElement(By.id("inquiry_email")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    
    //Pause//
    Thread.sleep(3000);
    
    driver.findElement(By.id("inquiry_email")).clear();
    driver.findElement(By.id("inquiry_email")).sendKeys("domenic.sorace@spongecell.com");
    try {
      assertEquals("", driver.findElement(By.id("inquiry_phone")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    
    //Pause//
    Thread.sleep(3000);
    
    driver.findElement(By.id("inquiry_phone")).clear();
    driver.findElement(By.id("inquiry_phone")).sendKeys("212222555A");
    driver.findElement(By.id("submit")).click();
    try {
      assertEquals("is invalid", driver.findElement(By.cssSelector("span.help-inline")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("", driver.findElement(By.id("inquiry_phone")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    
    //Pause//
    Thread.sleep(3000);
    
    driver.findElement(By.id("inquiry_phone")).clear();
    driver.findElement(By.id("inquiry_phone")).sendKeys("2122225555");
    try {
      assertEquals("", driver.findElement(By.id("inquiry_company")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    
    //Pause//
    Thread.sleep(3000);
    
    driver.findElement(By.id("inquiry_company")).clear();
    driver.findElement(By.id("inquiry_company")).sendKeys("Tester");
    driver.findElement(By.id("submit")).click();
    try {
      assertEquals("The email was sent successfully.", driver.findElement(By.id("flash_notice")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    
    //Pause//
    Thread.sleep(3000);
    
    driver.findElement(By.linkText("×")).click();
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
