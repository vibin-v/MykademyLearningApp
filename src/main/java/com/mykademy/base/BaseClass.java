package com.mykademy.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.mykademy.Factory.BrowserFactory;
import com.mykademy.dataProvider.ConfigReader;

public class BaseClass
{
	public WebDriver driver;
	//Browser Setup..
	@BeforeClass
	public void setUp()
	{
		
		Reporter.log("LOG:INFO: Running Before class - Setting up browser ", true);
		
		driver = BrowserFactory.getBrowser(ConfigReader.getProperty("browserName"),ConfigReader.getProperty("appUrl"));
		
		
	}
	
	//Browser TearDown
		@AfterClass
		public void tearDown()
		{
			Reporter.log("LOG:INFO: Running After class - Closing up browser ", true);
			BrowserFactory.closeBrowser(driver);
		}
}
