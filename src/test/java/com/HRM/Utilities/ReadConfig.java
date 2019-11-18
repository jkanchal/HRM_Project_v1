package com.HRM.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		
		File src= new File("./Configurations/config.properties");
		
		try 
		{
			FileInputStream fls= new FileInputStream(src);
			pro=new Properties();
			pro.load(fls);
			
		}catch (Exception e)
		{
			System.out.println("Exception is "+e.getMessage());
		}
		
	}
	
	public String getApplicationUrl()
	{
		String AppURL=pro.getProperty("AppURL");
		return AppURL;
	}
	
	public String getUserName()
	{
		String username=pro.getProperty("username");
		return username;
	}
	
	public String getPassWord()
	{
		String password=pro.getProperty("password");
		return password;
	}
	
	public String getChromePath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getFireFoxPath()
	{
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	
}

