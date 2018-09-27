package testPack;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Robotclass {
WebDriver driver;
@Test

public void robo() throws Exception{

System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
driver=new FirefoxDriver();
driver.get("https://gmail.com");
driver.manage().window().maximize();


// enter a valid email address
driver.findElement(By.id("identifierId")).sendKeys("TestSelenium1607@gmail.com");

// enter a valid password
driver.findElement(By.id("Passwd")).sendKeys("TestSelenium");

// click on sign in button
driver.findElement(By.id("signIn")).click();
Thread.sleep(30000);

// click on compose button
driver.findElement(By.xpath("//div[@class='z0']//div[contains(text(),'COMPOSE')]")).click();

// click on attach files icon
driver.findElement(By.xpath("//div[contains(@command,'Files')]//div[contains(@class,'aaA')]")).click();

// creating instance of Robot class (A java based utility)
Robot rb =new Robot();

// pressing keys with the help of keyPress and keyRelease events
rb.keyPress(KeyEvent.VK_D);
rb.keyRelease(KeyEvent.VK_D);
Thread.sleep(2000);

rb.keyPress(KeyEvent.VK_SHIFT);
rb.keyPress(KeyEvent.VK_SEMICOLON);
rb.keyRelease(KeyEvent.VK_SEMICOLON);
rb.keyRelease(KeyEvent.VK_SHIFT);

rb.keyPress(KeyEvent.VK_BACK_SLASH);
rb.keyRelease(KeyEvent.VK_BACK_SLASH);
Thread.sleep(2000);

rb.keyPress(KeyEvent.VK_P);
rb.keyRelease(KeyEvent.VK_P);

rb.keyPress(KeyEvent.VK_I);
rb.keyRelease(KeyEvent.VK_I);

rb.keyPress(KeyEvent.VK_C);
rb.keyRelease(KeyEvent.VK_C);
Thread.sleep(2000);

rb.keyPress(KeyEvent.VK_ENTER);
rb.keyRelease(KeyEvent.VK_ENTER);
Thread.sleep(2000);

driver.quit();
}
} 
