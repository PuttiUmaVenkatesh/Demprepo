package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	// Page Factory - Object Repository.
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbutton;
	
	@FindBy(xpath="//a//font[@color='red']")
	WebElement signup;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmlogo;
	
	// Login page constructor. 
	// Page factory method, will initialize page factory with 'driver'.
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Test Methods.
	public String validateloginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validatecrmLogo() {
		return crmlogo.isDisplayed();
	}

	// Login method which return HomePage object.
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click()", loginbutton);
		
		return new HomePage();
	}
}
