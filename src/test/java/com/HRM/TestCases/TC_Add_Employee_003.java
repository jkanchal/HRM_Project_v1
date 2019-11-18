package com.HRM.TestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.HRM.pageObjects.Add_New_Employee;
import com.HRM.pageObjects.Login_Page;

public class TC_Add_Employee_003 extends BaseClass
{

	@Test
	public void TC_003_AddNewEmployee() throws IOException
	{
		Login_Page lp=new Login_Page(driver);
		lp.setUserName(username);
		lp.setPassWord(password);
		lp.clickSubmit();
		
		Add_New_Employee newemp= new Add_New_Employee(driver);
		newemp.clickMenu();
		newemp.clickAddEmp();
		newemp.setFirstName("Jayakrishnan");
		newemp.setLastName("Nair");
		newemp.clickSave();
		
		boolean res =driver.getPageSource().contains("Couldn't get last insert identifier");
		
		if(res==true)
		{
			logger.info("Add Employee is Failed");
			captureScreen(driver,"TC_003_AddNewEmployee");
			Assert.assertTrue(false);
		}
		else
		{
			logger.info("New Employee is Added");
			Assert.assertTrue(true);
		}
		
		
		
	}
	
	
}
