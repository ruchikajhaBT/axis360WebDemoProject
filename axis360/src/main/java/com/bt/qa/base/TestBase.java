package com.bt.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeOptions;
import io.percy.selenium.Percy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import io.percy.examplepercyjavaselenium.Percy;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	private static Percy percy;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/bt" + "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/Users/jhar/Desktop/workspace/axis360/lib/drivers/chromedriver.exe");
			
/*			ChromeOptions options = new ChromeOptions();
	        options.addArguments("--headless");
	        driver = new ChromeDriver(options);*/
			driver = new ChromeDriver();
			percy = new Percy(driver);
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:/Users/jhar/Desktop/workspace/axis360/lib/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			percy = new Percy(driver);
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

	}
	
	public WebElement elementClickable(WebElement element) {
		WebElement clickableElement = new WebDriverWait(driver,
				Duration.ofSeconds(10))
				.until(ExpectedConditions.elementToBeClickable(element));		
		return clickableElement;
		
	}
	
	public void scrollToWebElement(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
		
/*		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();*/
	}

}
