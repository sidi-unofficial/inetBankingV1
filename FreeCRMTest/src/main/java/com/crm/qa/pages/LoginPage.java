package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//Page Factory or Object Repository of Login Page
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath ="//a[@class='navbar-brand']//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	//Initializing the page objects // Created Constructor to do so
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String  validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMimage()
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	

}
