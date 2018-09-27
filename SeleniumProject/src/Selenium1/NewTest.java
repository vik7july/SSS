package Selenium1;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;

public class NewTest {
	private static WebDriver driver;

	@DataProvider
	public Object[][] Authentication() {
		return new Object[][] { { "testuser_1", "Test@123" }, { "testuser_1", "Test@123" } };
	}

	@Test(dataProvider = "Authentication")

	public void test(String sUsername, String sPassword) {
		
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.store.demoqa.com");

		driver.findElement(By.xpath(".//*[@id='account']/a")).click();

		// Argument passed will be used here as String Variable

		driver.findElement(By.id("log")).sendKeys(sUsername);

		driver.findElement(By.id("pwd")).sendKeys(sPassword);

		driver.findElement(By.id("login")).click();

		driver.findElement(By.xpath(".//*[@id='account_logout']/a")).click();

		driver.quit();

	}

}
