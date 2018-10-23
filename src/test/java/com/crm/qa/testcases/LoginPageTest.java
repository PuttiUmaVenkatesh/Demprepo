package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		BrowserInvocation();
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginpageTitleTest() {
		String title = loginpage.validateloginPageTitle();
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");		
	}
	
	@Test(priority=2)
	public void crmlogoTest() {
		boolean flag = loginpage.validatecrmLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest() {
	homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void  teardown() {
		driver.quit();
	}

}
