package testPack;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowHandletwo {
	
		public static void main(String[] args) throws InterruptedException
		{
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");
			Set<String> parentWindowHandle = driver.getWindowHandles();
			System.out.println("Parent window's handle -> " + parentWindowHandle);
			WebElement clickElement = driver.findElement(By.id("button1")); 
	 
			for(int i = 0; i < 3; i++)
			{
				clickElement.click();
				Thread.sleep(3000);
			}
	 
			Set<String> allWindowHandles = driver.getWindowHandles();
	 
			for(String handle : allWindowHandles)
			{
				System.out.println("Switching to window - > " + handle);
				System.out.println("Navigating to google.com");
				driver.switchTo().window(handle); //Switch to the desired window first and then execute commands using driver
				driver.get("http://google.com");
			}
	 
		}

}
