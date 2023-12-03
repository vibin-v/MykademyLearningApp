package com.mykademy.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage 
{

	protected WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By signUpBtn = By.xpath("//a[text()='SIGN UP']");
	
	public boolean isSignupDisplayed()
	{
		boolean signUbtnStatus=driver.findElement(signUpBtn).isDisplayed();
		return signUbtnStatus;
	}
}
