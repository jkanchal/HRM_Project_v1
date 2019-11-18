package com.HRM.TestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HRM.Utilities.XLUtils;
import com.HRM.pageObjects.Login_Page;

public class TC_Login_DDT_002 extends BaseClass
{

	@Test(dataProvider="Data_Sheet")
	public void TC_002_Login_DDT(String user, String pwd) throws IOException
	{
		Login_Page lp=new Login_Page(driver);
		lp.setUserName(user);
		lp.setPassWord(pwd);
		lp.clickSubmit();
		
		
		/*
		 if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			driver.switchTo().defaultContent();
		}
		
		
		if(lp.isInvalidPassPreasent()==true)
		{
					Assert.assertTrue(false);
					logger.warn("Login Failed");
					driver.switchTo().defaultContent();
					
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login successfull");
			lp.clickWelcome();
			lp.clickLogout();
			driver.switchTo().defaultContent();
			
		}*/
		
		boolean res=driver.getPageSource().contains("Invalid credentials");
		
		if (res==true)
		{
			logger.info("Login Test is Failed");
			captureScreen(driver,"TC_002_Login_DDT");
			Assert.assertTrue(false);
			
		}
		else
		{
			logger.info("Login Test is Passed");
			lp.clickWelcome();
			lp.clickLogout();
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			
		}
		
		
	}
	
	public boolean isAlertPresent()
	{
		try 
		{
			driver.switchTo().alert();
			return true;
			
		}catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	@DataProvider(name="Data_Sheet")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/HRM/TestData/Data_Sheet.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][]=new String[rownum][colcount];
		for (int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
				
			}
		}
		return logindata;
		
	}
}

