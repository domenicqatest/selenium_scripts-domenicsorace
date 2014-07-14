import org.junit.Test;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

import org.sikuli.script.App;

import org.sikuli.script.FindFailed;

import org.sikuli.script.Pattern;

import org.sikuli.script.Screen;



public class SikuliTry {



@Test

public void functionName() throws FindFailed {

  

// Create a new instance of the Firefox driver

WebDriver driver = new FirefoxDriver();



// And now use this to visit Google

driver.get("http://spongetest.heroku.com/users/sign_in");



//Create and initialize an instance of Screen object   

Screen screen = new Screen();



//Add image path  

Pattern image = new Pattern("file:///Users/domenicsorace/Desktop/Screen%20Shot%202014-05-14%20at%204.53.49%20PM.png");

   

//Wait 10ms for image 

screen.wait(image, 10);

   

//Click on the image

screen.click(image);

  }

}