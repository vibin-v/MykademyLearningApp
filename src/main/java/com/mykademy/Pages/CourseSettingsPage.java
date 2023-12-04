package com.mykademy.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mykademy.helper.Utility;

public class CourseSettingsPage
{

protected WebDriver driver;
	
	public CourseSettingsPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By overview = By.xpath("//a[text()=' OVERVIEW']");
	
	public boolean isCourseviewDisplayed()
	{
		boolean overviewStatus = Utility.waitForWebElement(driver, overview).isDisplayed();
		return overviewStatus;
	}
}
