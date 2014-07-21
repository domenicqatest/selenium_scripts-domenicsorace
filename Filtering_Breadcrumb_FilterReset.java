
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Filtering_Breadcrumb_FilterReset {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  //YOU'LL NEED TO UPDATE THE [##] OF THE CLEAR AD!!!
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://staging-www.spongecell.com";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @Test
  public void testFilteringBreadcrumbFilterResetJUnit4() throws Exception {
    driver.get(baseUrl + "/gallery");
    driver.findElement(By.cssSelector("button.btn.dropdown-toggle")).click();
    driver.findElement(By.linkText("Display")).click();
    
  //Pause//
    Thread.sleep(3000);
    
    assertEquals("DISPLAY", driver.findElement(By.cssSelector("div.filter-text")).getText());
    driver.findElement(By.xpath("//div[@id='search']/div/div/div/div[3]/div/button[2]")).click();
    driver.findElement(By.linkText("CPG")).click();
    
  //Pause//
    Thread.sleep(3000);

    
    assertEquals("CPG", driver.findElement(By.xpath("//div[@id='filter-tags']/div[2]/div")).getText());
    driver.findElement(By.xpath("//div[@id='search']/div/div/div/div[4]/div/button[2]")).click();
    driver.findElement(By.linkText("Video")).click();

  //Pause//
    Thread.sleep(3000);
    
    assertEquals("VIDEO", driver.findElement(By.xpath("//div[@id='filter-tags']/div[3]/div")).getText());
    driver.findElement(By.xpath("//div[@id='search']/div/div/div/div[5]/div/button[2]")).click();
    driver.findElement(By.linkText("300x250")).click();

  //Pause//
    Thread.sleep(3000);
    
    assertEquals("300X250", driver.findElement(By.xpath("//div[@id='filter-tags']/div[4]/div")).getText());
    driver.findElement(By.xpath("//div[@id='search']/div/div/div/div[6]/div/button[2]")).click();
    
  //Pause to look at Country dropdown//
    Thread.sleep(3000);
    
    driver.findElement(By.linkText("United States")).click();
  
  //Pause//
    Thread.sleep(3000);
    
    assertEquals("UNITED STATES", driver.findElement(By.xpath("//div[@id='filter-tags']/div[5]/div")).getText());
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    driver.findElement(By.xpath("(//a[contains(text(),'300 x 250')])[82]")).click();
    
  //Pause//
    Thread.sleep(3000);
    
    assertEquals("Clear Haircare - 300x250", driver.findElement(By.cssSelector("li.active")).getText());
    driver.findElement(By.linkText("CPG")).click();

  //Pause//
    Thread.sleep(3000);
    
    assertEquals("CPG", driver.findElement(By.cssSelector("div.filter-text")).getText());
    driver.findElement(By.cssSelector("div.remove-filter")).click();
    
  //Pause//
    Thread.sleep(8000);
    
    assertEquals("Spongecell", driver.getTitle());
  }

  private void setTimeout(int i, TimeUnit seconds) {
	// TODO Auto-generated method stub
	
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
