package com.bt.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.bt.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(id="LogOnModel_UserName")
	WebElement libraryCard;
	
	@FindBy(css="[class*='btn-Popuplogin']")
	WebElement loginBtn;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void login(String userName){
		libraryCard.sendKeys(userName);
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
	
}
