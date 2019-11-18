package com.HRM.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Add_New_Employee {
	
	WebDriver ldriver;
	
	public Add_New_Employee(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath="//a[@id='menu_pim_viewPimModule']")
	WebElement pimMenu;
	
	@FindBy(how=How.XPATH,using="//a[@id='menu_pim_addEmployee']")
	WebElement AddEmp;
	
	@FindBy(how=How.XPATH,using="//input[@name='firstName']")
	WebElement firstname;
	
	@FindBy(how=How.XPATH,using="//input[@name='lastName']")
	WebElement lastname;
	
	@FindBy(how=How.XPATH,using="//input[@id='btnSave']")
	WebElement btnSave;
	
	public void clickMenu()
	{
		pimMenu.click();
		
	}
	
	public void clickAddEmp()
	{
		AddEmp.click();
	}
	
	public void setFirstName(String Firstname)
	{
		firstname.sendKeys(Firstname);
	}
	
	public void setLastName(String Lastname)
	{
		lastname.sendKeys(Lastname);
	}
	
	public void clickSave()
	{
		btnSave.click();
	}
	

}
