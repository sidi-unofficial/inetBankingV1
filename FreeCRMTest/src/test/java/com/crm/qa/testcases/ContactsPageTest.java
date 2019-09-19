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
import com.crm.qa.utils.TestUtil;



public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	String sheetname = "contacts";

	public ContactsPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage = new LoginPage();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test (priority = 1)
	public void verifyContactsPageLabel()
	{
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts Label is not present in the page");
	}
	
	@Test (priority = 2)
	public void selectContactsTest()
	{
		contactsPage.selectContactsByName("Test 2 Test 2");
	}
	
	
	@DataProvider
	public Object[][] getCRMTestData() 
	{
		Object data[][] = TestUtil.getTestData(sheetname);
		return data;
		
		
	}
	
	@Test (priority = 3, dataProvider = "getCRMTestData")
	public void validateCreateNewContactTest(String title, String firstName, String lastName, String company) //This is using dataProvider
	{
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Miss", "Divya", "Sharma", "Mastek"); //This is hardcoded way
		contactsPage.createNewContact(title, firstName, lastName, company);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
