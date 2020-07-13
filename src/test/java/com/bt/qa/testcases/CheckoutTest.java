package com.bt.qa.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.bt.qa.base.TestBase;
import com.bt.qa.pages.LandingPage;
import com.bt.qa.pages.LoginPage;
import io.percy.selenium.Percy;

public class CheckoutTest extends TestBase{
	
	LoginPage loginPage;
	LandingPage landingPage;
	private static Percy percy;
	
	public CheckoutTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		landingPage = new LandingPage();
		loginPage = landingPage.selectLoginBtn();
		percy = new Percy(driver);
	}
	
	@Test
	public void checkOutBook(){
		loginPage.login(prop.getProperty("username"));
		landingPage.selectAvailabilityFilter();
		percy.snapshot("Availability Filter");
		//landingPage.selectFormatFiltereBook();
/*		landingPage.clickFirstBook();
		percy.snapshot("First Book");
		landingPage.clickCheckoutBtn();
		percy.snapshot("Checkout button click");*/
		landingPage.clickLogoutBtn();
		percy.snapshot("LoginPage");
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}

}
