

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class FilterResetIsolated {
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
  public void testFilterResetIsolatedJUnit4() throws Exception {
    driver.get(baseUrl + "/gallery");
    driver.findElement(By.cssSelector("button.btn.dropdown-toggle")).click();
    driver.findElement(By.linkText("Display")).click();
    assertEquals("DISPLAY", driver.findElement(By.cssSelector("div.filter-text")).getText());
    assertTrue(isElementPresent(By.cssSelector("div.filter-text")));
    driver.findElement(By.xpath("//div[@id='search']/div/div/div/div[3]/div/button[2]")).click();
    driver.findElement(By.linkText("CPG")).click();
    assertEquals("CPG", driver.findElement(By.xpath("//div[@id='filter-tags']/div[2]/div")).getText());
    assertTrue(isElementPresent(By.xpath("//div[@id='filter-tags']/div[2]/div")));
    driver.findElement(By.xpath("//div[@id='search']/div/div/div/div[4]/div/button[2]")).click();
    driver.findElement(By.linkText("Video")).click();
    assertEquals("VIDEO", driver.findElement(By.xpath("//div[@id='filter-tags']/div[3]/div")).getText());
    assertTrue(isElementPresent(By.xpath("//div[@id='filter-tags']/div[3]/div")));
    driver.findElement(By.xpath("//div[@id='search']/div/div/div/div[5]/div/button[2]")).click();
    driver.findElement(By.linkText("300x250")).click();
    assertEquals("300X250", driver.findElement(By.xpath("//div[@id='filter-tags']/div[4]/div")).getText());
    assertTrue(isElementPresent(By.xpath("//div[@id='filter-tags']/div[4]/div")));
    driver.findElement(By.xpath("//div[@id='search']/div/div/div/div[6]/div/button[2]")).click();
    driver.findElement(By.linkText("United Arab Emirates")).click();
    assertEquals("UNITED ARAB EMIRATES", driver.findElement(By.xpath("//div[@id='filter-tags']/div[5]/div")).getText());
    assertTrue(isElementPresent(By.xpath("//div[@id='filter-tags']/div[5]/div")));
    assertEquals("Sorry, we don't have any ads that match your search criteria. Clear a filter above or clear all filters to start a new search >>", driver.findElement(By.cssSelector("div.span12")).getText());
    driver.findElement(By.linkText("clear all filters to start a new search >>")).click();
    driver.findElement(By.cssSelector("button.btn.dropdown-toggle")).click();
    driver.findElement(By.linkText("Display")).click();
    driver.findElement(By.xpath("//div[@id='search']/div/div/div/div[3]/div/button[2]")).click();
    driver.findElement(By.linkText("CPG")).click();
    driver.findElement(By.xpath("//div[@id='search']/div/div/div/div[4]/div/button[2]")).click();
    driver.findElement(By.linkText("Video")).click();
    driver.findElement(By.xpath("//div[@id='search']/div/div/div/div[5]/div/button[2]")).click();
    driver.findElement(By.linkText("300x250")).click();
    driver.findElement(By.xpath("//div[@id='search']/div/div/div/div[6]/div/button[2]")).click();
    driver.findElement(By.linkText("United States")).click();
    assertEquals("UNITED STATES", driver.findElement(By.xpath("//div[@id='filter-tags']/div[5]/div")).getText());
    assertTrue(isElementPresent(By.xpath("//div[@id='filter-tags']/div[5]/div")));
    driver.findElement(By.xpath("//div[@id='filter-tags']/div[5]/div[2]")).click();
    assertTrue(isElementPresent(By.xpath("//div[@id='gallery-container']/div[133]/div/div/div")));
    driver.findElement(By.xpath("//div[@id='filter-tags']/div[4]/div[2]")).click();
    assertTrue(isElementPresent(By.xpath("//div[@id='gallery-container']/div[133]/div/div/div")));
    driver.findElement(By.xpath("//div[@id='filter-tags']/div[3]/div[2]")).click();
    assertTrue(isElementPresent(By.xpath("//div[@id='gallery-container']/div[323]/div/div/div")));
    driver.findElement(By.xpath("//div[@id='filter-tags']/div[2]/div[2]")).click();
    assertTrue(isElementPresent(By.xpath("//div[@id='gallery-container']/div[327]/div/div/div")));
    driver.findElement(By.cssSelector("div.remove-filter")).click();
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
