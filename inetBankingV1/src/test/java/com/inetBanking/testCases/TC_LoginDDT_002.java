package com.inetBanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws InterruptedException {

		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("Username is provided");
		lp.setPassword(pwd);
		logger.info("Password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);

		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept(); // This will close the alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		} else {
			Assert.assertTrue(true);
			logger.info("Login Passed");
			lp.clickLogout();
			logger.info("Logged Out");
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); // This is Logout Alert
			driver.switchTo().defaultContent();
		}

	}

	public boolean isAlertPresent() // User defined method to check the presence of alert
	{
		try {
			driver.switchTo().alert();
			return true;
		}

		catch (NoAlertPresentException e) {
			return false;
		}

	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";

		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colnum = XLUtils.getCellCount(path, "Sheet1", 1);

		String logindata[][] = new String[rownum][colnum];

		// Need to write a for loop to traverse within rows

		// Outer For loop is for rows
		for (int i = 1; i <= rownum; i++) {
			// Inner for loop is for columns
			for (int j = 0; j < colnum; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j); // Sending 1,0 from excel to array
			}
		}
		return logindata;
	}

}
