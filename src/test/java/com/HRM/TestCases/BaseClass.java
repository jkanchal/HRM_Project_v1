package com.HRM.TestCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.HRM.Utilities.ReadConfig;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

public class BaseClass {
	
	ReadConfig readconfig=new ReadConfig();
	public String AppURL=readconfig.getApplicationUrl();
	public String username=readconfig.getUserName();
	public String password=readconfig.getPassWord();
	public static WebDriver driver;
	public static Logger logger=Logger.getLogger(BaseClass.class);
		
	@org.testng.annotations.Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		PropertyConfigurator.configure("log4j.properties");
		
			if(br.equals("chrome"))
			{
				System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
				driver=new ChromeDriver();
			}
			else if(br.equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver",readconfig.getFireFoxPath());
				driver=new FirefoxDriver();
			}
			
			driver.get(AppURL);	
	}
	
	
	@AfterClass
	public void TearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File target= new File(System.getProperty("user.dir")+"/ScreenShots/"+tname+ ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Scrennshot is taken ");
				
	}

}
