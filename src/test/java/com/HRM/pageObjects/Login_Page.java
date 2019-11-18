package com.HRM.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	
	WebDriver ldriver;
	
	public Login_Page(WebDriver rdriver)
	{
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(name="txtUsername")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(name="txtPassword")
	@CacheLookup
	WebElement txtPassWord;
	
	@FindBy(name="Submit")
	@CacheLookup
	WebElement btnSubmit;
	
	@FindBy(xpath="//span[@id ='spanMessage']")
	@CacheLookup
	WebElement inldpass;
	
	@FindBy(xpath="//a[@id='welcome']")
	@CacheLookup
	WebElement welcome;
	
	@FindBy(xpath="//a[@href='/index.php/auth/logout']")
	@CacheLookup
	WebElement logout;
	
	public void setUserName (String username)
	{
		txtUserName.sendKeys(username);
	}
	
	
	public void setPassWord (String pwd)
	{
		txtPassWord.sendKeys(pwd);
	}
	
	public void clickSubmit()
	{
		btnSubmit.click();
	}
	
	public void clickWelcome() 
	{
		welcome.click();
	}
	public void clickLogout()
	{
		logout.click();
	}
	
	public boolean isInvalidPassPresent()
	{
		if(inldpass.isEnabled())
		{
			return true;
		}else
		{
			return false;
		}
			
	}
}
