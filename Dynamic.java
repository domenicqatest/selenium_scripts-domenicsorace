
//You must actually watch this script run in order to verify the dropdowns are working accurately.//


import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Dynamic {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://staging-www.spongecell.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testDynamicSignalValueJUnit4() throws Exception {
    driver.get(baseUrl + "/gallery/concept/717/creative/293730");
    assertEquals("Qatar Airways - 300x250", driver.findElement(By.cssSelector("li.active")).getText());
    assertTrue(isElementPresent(By.cssSelector("button.btn.dropdown-text")));
    driver.findElement(By.cssSelector("button.btn.dropdown-toggle")).click();
    driver.findElement(By.linkText("Chicago, IL, US")).click();
    
    //Pause Test//
    Thread.sleep(6000);

    
    assertEquals("CHICAGO, IL, US", driver.findElement(By.cssSelector("div.filter-text")).getText());
    assertTrue(isElementPresent(By.cssSelector("div.filter-text")));
    driver.findElement(By.cssSelector("button.btn.dropdown-toggle")).click();
    driver.findElement(By.linkText("Houston, TX, US")).click();
    
  //Pause Test//
    Thread.sleep(6000);
    
    assertEquals("HOUSTON, TX, US", driver.findElement(By.cssSelector("div.filter-text")).getText());
    assertTrue(isElementPresent(By.cssSelector("div.filter-text")));
    driver.findElement(By.cssSelector("button.btn.dropdown-toggle")).click();
    driver.findElement(By.linkText("New York, NY, US")).click();
    
  //Pause Test//
    Thread.sleep(6000);
    
    assertEquals("NEW YORK, NY, US", driver.findElement(By.cssSelector("div.filter-text")).getText());
    assertTrue(isElementPresent(By.cssSelector("div.filter-text")));
    driver.findElement(By.cssSelector("button.btn.dropdown-toggle")).click();
    driver.findElement(By.linkText("Washington, DC, US")).click();
    
  //Pause Test//
    Thread.sleep(6000);
    
    assertEquals("WASHINGTON, DC, US", driver.findElement(By.cssSelector("div.filter-text")).getText());
    assertTrue(isElementPresent(By.cssSelector("div.filter-text")));
    driver.findElement(By.id("clear-button")).click();
    assertTrue(isElementPresent(By.cssSelector("button.btn.dropdown-text")));
    assertTrue(isElementPresent(By.id("demo")));
    driver.get(baseUrl + "/gallery/concept/474/creative/294392");
    
  //Pause Test//
    Thread.sleep(8000);
    
    assertEquals("King's Hawaiian - 160x600", driver.findElement(By.cssSelector("li.active")).getText());
    driver.findElement(By.cssSelector("button.btn.dropdown-text")).click();
    assertTrue(isElementPresent(By.cssSelector("button.btn.dropdown-text")));
    driver.findElement(By.cssSelector("button.btn.dropdown-toggle")).click();
    driver.findElement(By.linkText("Afternoon")).click();
    
    //Pause Test//
    Thread.sleep(8000);
    
    assertEquals("AFTERNOON", driver.findElement(By.cssSelector("div.filter-text")).getText());
    assertTrue(isElementPresent(By.cssSelector("div.filter-text")));
    driver.findElement(By.cssSelector("button.btn.dropdown-toggle")).click();
    driver.findElement(By.linkText("Early Morning")).click();
    
    //Pause Test//
    Thread.sleep(8000);
    
    assertEquals("EARLY MORNING", driver.findElement(By.cssSelector("div.filter-text")).getText());
    assertTrue(isElementPresent(By.cssSelector("div.filter-text")));
    driver.findElement(By.cssSelector("button.btn.dropdown-toggle")).click();
    driver.findElement(By.linkText("Evening")).click();
    
    //Pause Test//
    Thread.sleep(8000);
    
    assertEquals("EVENING", driver.findElement(By.cssSelector("div.filter-text")).getText());
    assertTrue(isElementPresent(By.cssSelector("div.filter-text")));
    driver.findElement(By.cssSelector("button.btn.dropdown-toggle")).click();
    driver.findElement(By.linkText("Late Night")).click();
    
    //Pause Test//
    Thread.sleep(8000);
    
    assertEquals("LATE NIGHT", driver.findElement(By.cssSelector("div.filter-text")).getText());
    assertTrue(isElementPresent(By.cssSelector("div.filter-text")));
    driver.findElement(By.cssSelector("button.btn.dropdown-toggle")).click();
    driver.findElement(By.linkText("Morning")).click();
    
    //Pause Test//
    Thread.sleep(8000);
    
    assertEquals("MORNING", driver.findElement(By.cssSelector("div.filter-text")).getText());
    assertTrue(isElementPresent(By.cssSelector("div.filter-text")));
    driver.findElement(By.id("clear-button")).click();
    
    //Pause Test//
    Thread.sleep(8000);
    
    assertTrue(isElementPresent(By.cssSelector("button.btn.dropdown-text")));
    assertEquals("King's Hawaiian - 160x600", driver.findElement(By.cssSelector("li.active")).getText());
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