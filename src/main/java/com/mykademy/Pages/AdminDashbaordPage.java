package com.mykademy.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mykademy.helper.Utility;


public class AdminDashbaordPage
{
	protected WebDriver driver;
	
	public AdminDashbaordPage(WebDriver driver)
	{
		this.driver = driver;
	}

	private By dashBoardText = By.xpath("//span[text()='Dashboard']");
	private By userProfile = By.xpath("//a[@class='user-profile']");
	private By logoutBtn = By.id("mykademyLogoutButton");
	
	public boolean isDBdisplayed()
	{
		boolean dbStatus = Utility.waitForWebElement(driver, dashBoardText).isDisplayed();
		return dbStatus;
		//boolean dbStatus =driver.findElement(dashBoardText).isDisplayed();
		//System.out.println("DB Status is :"+dbStatus);
		
	}
	
	public void logoutFrmApp()
	{
		Utility.waitForWebElement(driver, userProfile).click();
		Utility.waitForWebElement(driver, logoutBtn).click();
		//driver.findElement(userProfile).click();
		//Thread.sleep(2000);
		//driver.findElement(logoutBtn).click();;
	}
}
