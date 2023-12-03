package com.mykademy.dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Reporter;

public class ConfigReader 
{
	public static String getProperty(String key)
	{
		Properties prop = new Properties();
		
	//	File srcFile = new File("./ConfigFiles/Config.properties");
		
	//	FileInputStream fileIPStream = new FileInputStream(new File("./ConfigFiles/Config.properties"));
	
	//	prop.load(fileIPStream);
		
		try 
		{
			prop.load(new FileInputStream(new File("./ConfigFiles/Config.properties")));
		} 
		catch (IOException e)
		{
			Reporter.log("LOG:FAIL - Unable to load Config File!!"+e.getMessage());
		}
		
		String value = prop.getProperty(key);
		
		return value;
		
	}
}
