package com.bt.qa.testcases;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nullable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.*;  
import com.bt.qa.pages.LandingPage;
import com.bt.qa.pages.LoginPage;

import io.percy.selenium.Percy;

public class CheckoutPercyTest {
	
	LoginPage loginPage;
	LandingPage landingPage;
	public static WebDriver driver;
	public static Properties prop;
	public Percy percy;
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		/*File file = new File("C://Users//jhar//Desktop//workspace//axis360//src//main//java//com//bt//qa//config//config.properties");
		System.out.println(file.getAbsolutePath());
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		System.setProperty("webdriver.chrome.driver", "C:/Users/jhar/Desktop/workspace/axis360/lib/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		percy = new Percy(driver);
		//driver.get(prop.getProperty("url"));
		driver.get("https://demo.axis360qa.baker-taylor.com");
		driver.manage().window().maximize();
		landingPage = new LandingPage();
		percy.snapshot("homepage.jpg");
//		System.out.println("before method");
//		landingPage.selectLoginBtn();
//		loginPage = new LoginPage();
		driver.findElement(By.id("loginBtn")).click();
	}
	
	@Test
	public void checkOutBook(){
		//loginPage.login("bttest01");
		/**
	     * Take a snapshot and upload it to Percy.
	     *
	     * @param name      The human-readable name of the snapshot. Should be unique.
	     * @param widths    The browser widths at which you want to take the snapshot.
	     *                  In pixels.
	     * @param minHeight The minimum height of the resulting snapshot. In pixels.
	     * @param enableJavaScript Enable JavaScript in the Percy rendering environment
	     * @param percyCSS Percy specific CSS that is only applied in Percy's browsers
	     */
		
		List<Integer> widths=new ArrayList<Integer>();
		widths.add(1920);
		
		percy.snapshot("LoginPopup.jpg", widths, 1920, true, "id=ulMyLibrary");
		
		driver.findElement(By.id("LogOnModel_UserName")).sendKeys("bttest01");
		percy.snapshot("Loginpage.jpg");
		driver.findElement(By.cssSelector("[class*='btn-Popuplogin']")).click();
/*		landingPage.selectAvailabilityFilter();
		percy.snapshot("Availability Filter");
		percy.snapshot("loginpage");
		landingPage.selectFormatFiltereBook();
		landingPage.clickFirstBook();
		percy.snapshot("FirstBook");
		landingPage.clickCheckoutBtn();
		percy.snapshot("Checkoutbuttonclick");
		landingPage.clickLogoutBtn();
		driver.findElement(By.id("btnLogout")).click();
		percy.snapshot("LoginPage");*/
	}
	

	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
//	public static void main (String args[]) throws InterruptedException {
//		CheckoutTestPercy testPercy = new CheckoutTestPercy();
//		testPercy.setUp();
//		testPercy.checkoutTest();
//		testPercy.tearDown();
//	}

}
