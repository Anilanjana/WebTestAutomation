package genericlibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtilities {

	static final String BROWSER = "browser";
	Wait<WebDriver> wait;
	public static Properties prop;

	public BrowserUtilities() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("./constant.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author Indrapal Singh, File Contains methods to launch any browser with
	 *         url as per constant properties file
	 */

	public static WebDriver driver;

	public static WebDriver getBrowser() throws IOException, InterruptedException {

		if (prop.getProperty(BROWSER).equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));

		}

		else if (prop.getProperty(BROWSER).equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));

		} else if (prop.getProperty(BROWSER).equalsIgnoreCase("ie")) {

			WebDriverManager.iedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
		}
		return driver;
	}

	public static void closeBrowser() {
		driver.close();
	}

	public WebElement getWhenVisible(By locator, int timeout) {
		WebElement element = null;
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return element;
	}

	public void clickWhenReady(By locator, int timeout) {
		wait = new WebDriverWait(driver, timeout);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}

	public void fluentWait(final By locator) {
		wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		WebElement element = (WebElement) locator;
		element.click();

	}

}
