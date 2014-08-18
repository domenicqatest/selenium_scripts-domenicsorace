package MiscTests;
   import org.openqa.selenium.WebDriver;  
    import org.openqa.selenium.chrome.ChromeDriver;  
    import org.testng.annotations.BeforeTest;  
    import org.testng.annotations.Test;  
      
    public class testGoogleSearch {  
       
    WebDriver  driver;  
      
    @BeforeTest  
     public void setUpDriver(){  
       System.setProperty("webdriver.chrome.driver",  
    "/Users/domenicsorace/Desktop/Selenium IDE");    
       driver = new ChromeDriver();   
         }  
      
     @Test  
     public void start(){  
     driver.get("http://www.google.com/");   
       }  
      
    } 