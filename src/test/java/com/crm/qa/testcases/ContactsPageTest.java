package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	String sheetName = "contacts";
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		BrowserInvocation();
		testutil = new TestUtil();
		contactspage = new ContactsPage();
		loginpage = new LoginPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.switchToFrame();
		contactspage = homepage.clickOnContactsLink();
		}
	
	@Test(priority = 1)
	public void verifyContactsLabelTest() {
		Assert.assertTrue(contactspage.verifyContcatsLabel(),"Contact label is missing on the screen");
		
	}
	
	@Test(priority = 2)
	public void selectContactsTest() {
		contactspage.selectContacts("Herald Michelle");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
		
	}
	
	@Test(priority = 3, dataProvider ="getCRMTestData")
	public void validatecreateNewContactTest(String title, String firstName, String lastName, String company) {
		homepage.clickOnNewContactLink();
		// contactspage.createNewContact("Mr.", "Tom", "Michele", "Coupa");
		contactspage.createNewContact(title,firstName,lastName,company);
	}
		
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}
