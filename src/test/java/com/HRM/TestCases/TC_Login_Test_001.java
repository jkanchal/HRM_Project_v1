package com.HRM.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.HRM.pageObjects.Login_Page;

import junit.framework.Assert;

public class TC_Login_Test_001 extends BaseClass {

	@Test
	public void TC_001_Login_Test() throws IOException
	{
		logger.info("URL is Opened");
		Login_Page lp= new Login_Page(driver);
		lp.setUserName(username);
		logger.info("Username is Entered");
		lp.setPassWord(password);
		logger.info("Password is Entered");
		lp.clickSubmit();
		logger.info("Submit button is Clicked");
		
		if (driver.getTitle().equals("OrangeHRM"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test is Passed");
		}
		else
		{
			captureScreen(driver,"TC_001_Login_Test");
			Assert.assertTrue(false);
			logger.info("Login Test is Failed");
		}
		
	}
}
