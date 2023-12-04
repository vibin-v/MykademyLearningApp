package com.mykademy.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mykademy.helper.Utility;

public class SignupPage
{

	protected WebDriver driver;
	
	public SignupPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By fullName = By.id("us_name");
	private By emailid = By.id("floatingEmail");
	private By pwd1 = By.id("floatingPasswordEye");
	private By confPwd = By.id("floatingConfirmPassword");
	private By phone = By.id("floatingPhone");
	private By termsAndCond = By.id("flexCheckPercentage");
	private By signUPbtn = By.xpath("//button[@type='submit']");
	
	public void isUserableToSignup(String fulname,String email,String pwd,String conPwd,String phonenum)
	{
		Utility.waitForWebElement(driver, fullName).sendKeys(fulname);
		Utility.waitForWebElement(driver, emailid).sendKeys(email);
		Utility.waitForWebElement(driver,pwd1).sendKeys(pwd);
		Utility.waitForWebElement(driver, confPwd).sendKeys(conPwd);
		Utility.waitForWebElement(driver, phone).sendKeys(phonenum);
		Utility.waitForWebElement(driver, termsAndCond).click();
		Utility.waitForWebElement(driver, signUPbtn).click();
	}
}
