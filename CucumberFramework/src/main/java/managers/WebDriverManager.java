package managers;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import enums.DriverType;
import enums.EnvironmentType;

public class WebDriverManager {
	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	private static final String GECKO_DRIVER_PROPERTY = "webdriver.gecko.driver";

	public WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigFileReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigFileReader().getEnvironment();
	}

	public WebDriver getDriver() {
		if (driver == null)
			driver = createDriver();
		return driver;
	}

	private WebDriver createDriver() {
		switch (environmentType) {
		case LOCAL:
			driver = createLocalDriver();
			break;
		case REMOTE:
			driver = createRemoteDriver();
			break;
		}
		return driver;
	}

	private WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}

	private WebDriver createLocalDriver() {
		switch (driverType) {
		case CHROME:
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			System.setProperty(GECKO_DRIVER_PROPERTY,
					FileReaderManager.getInstance().getConfigFileReader().getDriverPath());
			driver = new FirefoxDriver();
			break;
		case INTERNETEXPLORER:
			driver = new InternetExplorerDriver();
			break;
		}

		if (FileReaderManager.getInstance().getConfigFileReader().getBrowserWindowSize())
			driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigFileReader().getImplicitlyWait(),
				TimeUnit.SECONDS);
		return driver;
	}

	public void closeDriver() {
		driver.close();
		
	}

	public void quitDriver() {
		// TODO Auto-generated method stub
		driver.quit();
		
	}
}
