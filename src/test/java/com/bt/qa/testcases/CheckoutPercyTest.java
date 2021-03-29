package com.bt.qa.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bt.qa.base.TestBase;
import com.bt.qa.pages.LandingPage;
import com.bt.qa.pages.LoginPage;

import io.percy.selenium.Percy;

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
		widths.add(1920);
		percy.snapshot("homepage", widths, 1920, true, "#footer, #ulMyLibrary");
		landingPage.selectLoginBtn();
		loginPage = new LoginPage();
	}
	
	@Test
	public void checkOutBook(){
		percy.snapshot("LoginPopup", widths, 1920, true, "#footer, #ulMyLibrary");  // { display: none; }; #ulMyLibrary { display: none; }; 
		loginPage.login("bttest01");
		//percy.snapshot("Loginpage", widths, 1920, true, "#ulMyLibrary");
		loginPage.clickLoginBtn();
		landingPage.selectAvailabilityFilter();
		percy.snapshot("AvailabilityFilter", widths, 1920, true, "#ulMyLibrary");
		percy.snapshot("loginpage", widths, 1920, true, "#footer, #ulMyLibrary");
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
