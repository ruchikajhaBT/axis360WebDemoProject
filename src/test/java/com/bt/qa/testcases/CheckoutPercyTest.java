package com.bt.qa.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.applitools.eyes.RectangleSize;
import com.bt.qa.base.TestBase;
import com.bt.qa.pages.LandingPage;
import com.bt.qa.pages.LoginPage;


public class CheckoutPercyTest extends TestBase{
	
	LoginPage loginPage;
	LandingPage landingPage;
	public static Properties prop;
	List<Integer> widths=new ArrayList<Integer>();

	
	public CheckoutPercyTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();		
		landingPage = new LandingPage();
		//widths.add(1920);
		//percy.snapshot("homepage", widths, 1920, true, "#footer, #ulMyLibrary");
		percy.snapshot("homepage.jpg", Arrays.asList(1920));
		landingPage.selectLoginBtn();
		loginPage = new LoginPage();
	}
	
	@Test
	public void checkOutBook() throws IOException{
		//percy.snapshot("LoginPopup", widths, 1920, true, "#footer, #ulMyLibrary");  // { display: none; }; #ulMyLibrary { display: none; }; 
		loginPage.login("bttest01");
		percy.snapshot("loginpopup.jpg", Arrays.asList(1920));
		// Load page image and validate.

		//percy.snapshot("Loginpage", widths, 1920, true, "#ulMyLibrary");
		loginPage.clickLoginBtn();
		landingPage.selectAvailabilityFilter();
		//percy.snapshot("AvailabilityFilter", widths, 1920, true, "#ulMyLibrary");
		percy.snapshot("availablenowfilter.jpg", Arrays.asList(1920));
		//percy.snapshot("loginpage", widths, 1920, true, "#footer, #ulMyLibrary");
		landingPage.selectFormatFiltereBook();
/*		landingPage.clickFirstBook();
		percy.snapshot("FirstBook", widths, 1920, true, "#footer, #ulMyLibrary");
		landingPage.clickCheckoutBtn();
		percy.snapshot("Checkoutbuttonclick", widths, 1920, true, "#footer, #ulMyLibrary");
		landingPage.clickLogoutBtn();
		driver.findElement(By.id("btnLogout")).click();
		percy.snapshot("LoginPage", widths, 1920, true, "#footer, #ulMyLibrary");*/
	}
	

	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
}
