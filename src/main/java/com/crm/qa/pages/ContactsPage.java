package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(id = "first_name")
	WebElement newContactFirstName;
	
	@FindBy(id = "surname")
	WebElement newContactLastName;
	
	@FindBy(name = "client_lookup")
	WebElement clientName;
	
	@FindBy(xpath="//form//input[@type='submit' and @value='Save']")
	WebElement newContactSave;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContcatsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContacts(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();;
	}
	
	public void createNewContact(String title, String ftName, String LtName, String CName) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		newContactFirstName.sendKeys(ftName);
		newContactLastName.sendKeys(LtName);
		clientName.sendKeys(CName);
		newContactSave.click();
	}

}
