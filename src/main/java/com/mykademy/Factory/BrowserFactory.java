package com.mykademy.Factory;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v115.log.model.ViolationSetting.Name;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import com.mykademy.dataProvider.ConfigReader;

public class BrowserFactory 
{
	
	public static WebDriver getBrowser(String browserName,String appUrl)
	{
		WebDriver driver = null;
		
		if(browserName.equalsIgnoreCase("Chrome") || browserName.equalsIgnoreCase("CH"))
		{
			driver = new ChromeDriver();
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
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicitlyWaitTime"))));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("pageLoadTimeoutTime"))));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("scriptTimeoutTime"))));
		
		driver.get(appUrl);
		
		
		return driver;
		
	}
	
	public static void closeBrowser(WebDriver driver)
	{
		driver.quit();
	}

}
