package Suites_Staging_Production;
//YOU'LL NEED TO UPDATE THE [##] OF THE CLEAR AD!!!

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MarketingTests {
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
  public void testDynamicSignalValueJUnit4() throws Exception {
    
	//INQUIRY TEST//
      
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
	  
      
      
      //Dynamic//
     
	  
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
      
  
    //Filtering Breadcrumb//
        
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
    driver.findElement(By.xpath("(//a[contains(text(),'300 x 250')])[84]")).click();
    
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

          
    driver.get(baseUrl + "/gallery");
    
    //Pause//
      Thread.sleep(3000);
      
      assertTrue(isElementPresent(By.id("square-search")));
      
    //Pause//
      Thread.sleep(3000);
      
      
      
      //Search_Positive_Negative//
      
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
        
      
      ////Social - FB_Email_Twitter//
          
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
          
        //Pause//
          Thread.sleep(3000);
          
          assertEquals("Air New Zealand - 300x250", driver.findElement(By.cssSelector("li.active")).getText());
          driver.findElement(By.cssSelector("img[alt=\"Share_email\"]")).click();
          assertTrue(isElementPresent(By.cssSelector("img[alt=\"Share_email\"]")));
          assertTrue(isElementPresent(By.cssSelector("img[alt=\"Share_facebook\"]")));
          driver.findElement(By.cssSelector("img[alt=\"Share_facebook\"]")).click();
          assertTrue(isElementPresent(By.cssSelector("img[alt=\"Share_twitter\"]")));
          driver.findElement(By.cssSelector("img[alt=\"Share_twitter\"]")).click();
          assertEquals("Check out this interactive @Spongecell ad for Air New Zealand! http://bit.ly/1h77mXE See more at spongecell.com/gallery", driver.findElement(By.id("status")).getText());
          // SIGN IN TO TWITTER AND RUN THIS LINE: driver.findElement(By.xpath("//input[@value='Tweet']")).click(); UNLESS YOU ARE SIGNED IN TO TWITTER ADDING THIS LINE WILL FAIL THIS SCRIPT HERE!!!
          

          //Filter Reset Isolated//
          
          driver.get(baseUrl + "/gallery");
          driver.findElement(By.cssSelector("button.btn.dropdown-toggle")).click();
          driver.findElement(By.linkText("Display")).click();
          
          //Pause//
          Thread.sleep(3000);
          
          assertEquals("DISPLAY", driver.findElement(By.cssSelector("div.filter-text")).getText());
          assertTrue(isElementPresent(By.cssSelector("div.filter-text")));
          
          //Pause//
          Thread.sleep(3000);
          
          driver.findElement(By.xpath("//div[@id='search']/div/div/div/div[3]/div/button[2]")).click();
          driver.findElement(By.linkText("CPG")).click();
          
          //Pause//
          Thread.sleep(3000);
          
          assertEquals("CPG", driver.findElement(By.xpath("//div[@id='filter-tags']/div[2]/div")).getText());
          assertTrue(isElementPresent(By.xpath("//div[@id='filter-tags']/div[2]/div")));
          
          //Pause//
          Thread.sleep(3000);
          
          driver.findElement(By.xpath("//div[@id='search']/div/div/div/div[4]/div/button[2]")).click();
          driver.findElement(By.linkText("Video")).click();
          
          //Pause//
          Thread.sleep(3000);
          
          assertEquals("VIDEO", driver.findElement(By.xpath("//div[@id='filter-tags']/div[3]/div")).getText());
          assertTrue(isElementPresent(By.xpath("//div[@id='filter-tags']/div[3]/div")));
          
          //Pause//
          Thread.sleep(3000);
          
          driver.findElement(By.xpath("//div[@id='search']/div/div/div/div[5]/div/button[2]")).click();
          driver.findElement(By.linkText("300x250")).click();
          
          //Pause//
          Thread.sleep(3000);
          
          assertEquals("300X250", driver.findElement(By.xpath("//div[@id='filter-tags']/div[4]/div")).getText());
          assertTrue(isElementPresent(By.xpath("//div[@id='filter-tags']/div[4]/div")));
          
          //Pause//
          Thread.sleep(3000);
          
          driver.findElement(By.xpath("//div[@id='search']/div/div/div/div[6]/div/button[2]")).click();
          driver.findElement(By.linkText("United Arab Emirates")).click();
          
          //Pause//
          Thread.sleep(3000);
          
          assertEquals("UNITED ARAB EMIRATES", driver.findElement(By.xpath("//div[@id='filter-tags']/div[5]/div")).getText());
          assertTrue(isElementPresent(By.xpath("//div[@id='filter-tags']/div[5]/div")));
          assertEquals("Sorry, we don't have any ads that match your search criteria. Clear a filter above or clear all filters to start a new search >>", driver.findElement(By.cssSelector("div.span12")).getText());
          
          //Pause//
          Thread.sleep(3000);
          
          driver.findElement(By.linkText("clear all filters to start a new search >>")).click();
          driver.findElement(By.cssSelector("button.btn.dropdown-toggle")).click();
          driver.findElement(By.linkText("Display")).click();
          
          //Pause//
          Thread.sleep(3000);
          
          driver.findElement(By.xpath("//div[@id='search']/div/div/div/div[3]/div/button[2]")).click();
          driver.findElement(By.linkText("CPG")).click();
          
          //Pause//
          Thread.sleep(3000);
          
          driver.findElement(By.xpath("//div[@id='search']/div/div/div/div[4]/div/button[2]")).click();
          driver.findElement(By.linkText("Video")).click();
          
          //Pause//
          Thread.sleep(3000);
          
          driver.findElement(By.xpath("//div[@id='search']/div/div/div/div[5]/div/button[2]")).click();
          driver.findElement(By.linkText("300x250")).click();
          
          //Pause//
          Thread.sleep(3000);
          
          driver.findElement(By.xpath("//div[@id='search']/div/div/div/div[6]/div/button[2]")).click();
          driver.findElement(By.linkText("United States")).click();
          
          //Pause//
          Thread.sleep(3000);
          
          assertEquals("UNITED STATES", driver.findElement(By.xpath("//div[@id='filter-tags']/div[5]/div")).getText());
          assertTrue(isElementPresent(By.xpath("//div[@id='filter-tags']/div[5]/div")));
          
          //Pause//
          Thread.sleep(3000);
          
          driver.findElement(By.xpath("//div[@id='filter-tags']/div[5]/div[2]")).click();
          assertTrue(isElementPresent(By.xpath("//div[@id='gallery-container']/div[133]/div/div/div")));
          driver.findElement(By.xpath("//div[@id='filter-tags']/div[4]/div[2]")).click();
          assertTrue(isElementPresent(By.xpath("//div[@id='gallery-container']/div[133]/div/div/div")));
          driver.findElement(By.xpath("//div[@id='filter-tags']/div[3]/div[2]")).click();
          assertTrue(isElementPresent(By.xpath("//div[@id='gallery-container']/div[323]/div/div/div")));
          driver.findElement(By.xpath("//div[@id='filter-tags']/div[2]/div[2]")).click();
          assertTrue(isElementPresent(By.xpath("//div[@id='gallery-container']/div[327]/div/div/div")));
          driver.findElement(By.cssSelector("div.remove-filter")).click();
          
		//Toggle//
          
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