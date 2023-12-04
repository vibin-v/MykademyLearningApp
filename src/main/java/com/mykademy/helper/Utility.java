package com.mykademy.helper;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.mykademy.dataProvider.ConfigReader;

public class Utility 
{
	
	public static WebElement highlightWebElement(WebDriver driver,WebElement ele)
	{	
		JavascriptExecutor js=(JavascriptExecutor)driver;

		js.executeScript("arguments[0].setAttribute('style','background: yellow; border: solid 2px red')",ele);
		
		sleep(1);

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px black')",ele);

		return ele;
	}

	public static void mouseHover(WebDriver driver,WebElement element) {
		
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
		
	}
		
	public static void sleep(int timeInSeconds)
	{
		try 
		{
			Thread.sleep(timeInSeconds*1000);
		} catch (InterruptedException e) {
			Reporter.log("LOG:ERROR - Thread Interruped "+ e.getMessage(),true);
		}
	}
	
	public static void scrollTillElementPresent(WebDriver driver,By locator) 
	{
			Actions actions=new Actions(driver);
			actions.scrollToElement(driver.findElement(locator)).perform();
	}
	
	public static void scrollTillElementPresent(WebDriver driver,WebElement element) 
	{
			Actions actions=new Actions(driver);
			actions.scrollToElement(element).perform();
	}
	
	
	public static WebElement waitForWebElement(WebDriver driver,By locator) 
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		
		WebElement element= wait.until(ExpectedConditions.elementToBeClickable(locator));
		
		String highLight=ConfigReader.getProperty("highLightElement");
		
		if(highLight.equalsIgnoreCase("true"))
		{
			highlightWebElement(driver, element);
		}
	
		return element;
		
	}
	
	public static WebElement waitForWebElement(WebDriver driver,By locator,int timeInSeconds) 
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
		
		WebElement element= wait.until(ExpectedConditions.elementToBeClickable(locator));
		
		String highLight=ConfigReader.getProperty("highLightElement");
		
		if(highLight.equalsIgnoreCase("true"))
		{
			highlightWebElement(driver, element);
		}
	
		
		return element;
		
	}
	
	
	public static void clickElement(WebDriver driver,WebElement element) 
	{
		try 
		{
			element.click();
			
		} catch (Exception e) 
		{
				Reporter.log("LOG:INFO - WebElement Click Failed - Trying With Actions Class Click "+e.getMessage(), true);
				
				Actions actions=new Actions(driver);
				try 
				{
					actions.click(element).perform();
					
				} catch (Exception e2) 
				{
					Reporter.log("LOG:INFO - Actions Class Click Failed - Trying With JSExecutor Class "+e2.getMessage(), true);
					
					JavascriptExecutor jsExecutor=(JavascriptExecutor)driver;
					
					jsExecutor.executeScript("arguments[0].click()", element);
					
				}
	
				
		}	
		
		
	}
}