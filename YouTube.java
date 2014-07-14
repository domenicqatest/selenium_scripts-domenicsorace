import org.openqa.selenium.firefox.FirefoxDriver;

public class YouTube {
 public static void main(String[] args) throws InterruptedException {
 FirefoxDriver driver = new FirefoxDriver();
 
FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "movie_player");
 driver.manage().window().maximize(); 
 driver.get("https://www.youtube.com/watch?v=QNuMwkipz6M");
 Thread.sleep(2000L);
 
 // let the video load
 while (Integer.parseInt(flashApp.callFlashObject("getPlayerState")) == 3){
 Thread.sleep(1000L);
 }
 
 // Play the video for 10 seconds
 Thread.sleep(5000);
 flashApp.callFlashObject("pauseVideo");
 Thread.sleep(5000);
 flashApp.callFlashObject("playVideo");
 Thread.sleep(5000);
 flashApp.callFlashObject("seekTo","140","true");
 Thread.sleep(5000);
 flashApp.callFlashObject("mute");
 Thread.sleep(5000);
 flashApp.callFlashObject("setVolume","75");
 Thread.sleep(5000);
 flashApp.callFlashObject("mute");
 Thread.sleep(5000);
 flashApp.callFlashObject("seekTo","100","true");
 Thread.sleep(5000);
 flashApp.callFlashObject("setVolume","25");
 Thread.sleep(5000);
 flashApp.callFlashObject("seekTo","0","true");
 Thread.sleep(5000);
 flashApp.callFlashObject("playVideo");
 Thread.sleep(5000);
 
}
 
}