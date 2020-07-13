package com.bt.qa.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bt.qa.base.TestBase;

public class LandingPage extends TestBase{
	@FindBy(id="loginBtn")
	WebElement loginBtn;
	
	@FindBy(id="LibraryAvailability_button")
	WebElement availabilityFilter;
	
	@FindBy(id="LibraryFormatType_button")
	WebElement formatFilter;
	
	@FindBy(css="[class*='btnCheckoutNow']")
	WebElement checkoutBtn;
	
	@FindBy(css="a[href*='ReadNowClick']")
	WebElement readNowBtn;
	
	@FindBy(id="btnLogout")
	WebElement logoutBtn;

	public LandingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage selectLoginBtn(){
		elementClickable(loginBtn).click();
		return new LoginPage();
	}
	
	public void selectAvailabilityFilter(){
		elementClickable(availabilityFilter).click();
		driver.findElement(By.id("LibraryAvailability_elem_Available")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selectFormatFiltereBook(){
		elementClickable(formatFilter).click();
		driver.findElement(By.id("LibraryFormatType_elem_EBT")).click();
	}
	
	public void clickFirstBook() {
		System.out.println("entered checkoutFirstBook");
		/*List<WebElement> checkoutBtns = new ArrayList<WebElement>();
		checkoutBtns = driver.findElements(By.cssSelector("[class*='btnCheckoutNow']"));*/
		WebElement navigationPageButton = (new WebDriverWait(driver,
				Duration.ofSeconds(10)))
				 .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'btnCheckoutNow')]//ancestor::div[@class='axis360-cover_titlecontainer' and @data-formattype='EBT']")));
		scrollToWebElement(navigationPageButton);
		navigationPageButton.click();
		System.out.println("After elementclickable method");

	}
	
	public void clickLogoutBtn() {
		
		logoutBtn.click();
		
/*		WebElement readNowButton = elementClickable(readNowBtn);
		scrollToWebElement(readNowButton);
		System.out.println("scrolled to reader button");
		readNowButton.click();
		System.out.println("clicked reader button");*/
	}
	
	public void clickCheckoutBtn() {
		checkoutBtn.click();
	}

}
