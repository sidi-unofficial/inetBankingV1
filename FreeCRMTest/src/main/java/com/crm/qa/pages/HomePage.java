package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//Page Factory or Object Repository of HomePage
	
	@FindBy(xpath = "//td[contains(text(),'User: Sidhesh Lotlikar')]")
	WebElement usernameLabel;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	//Initialization of page objects //Created Constructor
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public Boolean verifyCorrectUserName()
	{
		return usernameLabel.isDisplayed();
	}
	
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactsLink()
	{
		contactsLink.click();
		return new ContactsPage();		//Didn't understood this Video Part 3 11:32
	}

	public DealsPage clickOnDealsLink()
	{
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink()
	{
		tasksLink.click();
		return new TasksPage();
	}
	
	public void clickOnNewContactLink()
	{
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}
	
	
}
