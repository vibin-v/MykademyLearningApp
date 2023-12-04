package com.mykademy.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mykademy.helper.Utility;

public class LoginPage
{
	protected WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By userName = By.name("username");
	private By pass = By.name("password");
	private By logIn = By.xpath("//button[text()='Login ']");
	
	public AdminDashbaordPage loginToApp(String cred_username,String cred_pass)
	{
	
		Utility.waitForWebElement(driver, userName).sendKeys(cred_username);;
		Utility.waitForWebElement(driver, pass).sendKeys(cred_pass);
		Utility.sleep(2);
		Utility.waitForWebElement(driver, logIn).click();
		//driver.findElement(userName).sendKeys(cred_username);
		//driver.findElement(pass).sendKeys(cred_pass);
		//driver.findElement(logIn).click();
		
		
		
		AdminDashbaordPage admPage = new AdminDashbaordPage(driver);
		return admPage;
		
	}
}
