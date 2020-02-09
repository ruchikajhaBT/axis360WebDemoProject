package com.bt.qa.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bt.qa.base.TestBase;
import com.bt.qa.pages.LandingPage;
import com.bt.qa.pages.LoginPage;

public class CheckoutTest extends TestBase{
	
	LoginPage loginPage;
	LandingPage landingPage;

	public CheckoutTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		landingPage = new LandingPage();
		loginPage = landingPage.selectLoginBtn();

	}
	
	@Test
	public void checkOutBook(){
		loginPage.login(prop.getProperty("username"));
		landingPage.selectAvailabilityFilter();
		//landingPage.selectFormatFiltereBook();
		landingPage.clickFirstBook();
		landingPage.clickCheckoutBtn();
		landingPage.clickLogoutBtn();
	}
	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}

}
