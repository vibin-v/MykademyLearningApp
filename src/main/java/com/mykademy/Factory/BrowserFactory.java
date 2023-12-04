package com.mykademy.Factory;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v115.log.model.ViolationSetting.Name;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import com.mykademy.dataProvider.ConfigReader;

public class BrowserFactory 
{
	public static WebDriver driver;
	
	public static WebDriver getDriver()
	{
		
		return driver;
	}
	
	public static WebDriver getBrowser(String browserName,String appUrl)
	{
		
		
		if(browserName.equalsIgnoreCase("Chrome") || browserName.equalsIgnoreCase("CH"))
		{
			ChromeOptions options=new ChromeOptions();
			
			if (ConfigReader.getProperty("headless").equalsIgnoreCase("true")) 
			{
				options.addArguments("--headless=new");
				
				Reporter.log("LOG:INFO - Running Test In Headless Mode",true);

			}
			driver = new ChromeDriver(options);
		}
		else if (browserName.equalsIgnoreCase("Firefox") || browserName.equalsIgnoreCase("FF"))
		{
			driver = new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge") || browserName.equalsIgnoreCase("ED"))
		{
			driver = new EdgeDriver();
		}
		else {
			Reporter.log("LOG:INFO - Incorrect Browser name. Please check!!", true);
		}
		
		driver.manage().window().maximize();
		
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("pageLoadTimeoutTime"))));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("scriptTimeoutTime"))));
		
		driver.get(appUrl);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicitlyWaitTime"))));
		return driver;
		
	}
	
	public static void closeBrowser(WebDriver driver)
	{
		driver.quit();
	}

}
