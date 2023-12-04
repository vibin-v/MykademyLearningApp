package mykademy.testCases;

import java.time.Duration;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mykademy.Pages.AdminDashbaordPage;
import com.mykademy.Pages.HomePage;
import com.mykademy.Pages.LoginPage;
import com.mykademy.base.BaseClass;
import com.mykademy.dataProvider.DataProviders;
import com.mykademy.dataProvider.ExcelReader;

public class M001_LoginTest extends BaseClass
{
	
	
	//Testcases
	@Test(dataProvider = "TestData",dataProviderClass = DataProviders.class)
	public void loginTest(String uname,String uPass) throws InterruptedException
	{
		Reporter.log("LOG:INFO : Starting test execution!!",true);
		
		driver.findElement(By.xpath("//a[text()='SIGN IN']")).click();
		
//		
//		WebElement username = driver.findElement(By.name("username"));
//		WebElement pass = driver.findElement(By.name("password"));
//		username.sendKeys("sumi.scaria@mykademy.com");
//		pass.sendKeys("Password@123");
//		driver.findElement(By.xpath("//button[text()='Login ']")).click();
//		
//		
		LoginPage login = new LoginPage(driver);
		AdminDashbaordPage admPage = login.loginToApp(uname,uPass);
		
		
		//Thread.sleep(3000);
		
		Assert.assertTrue(admPage.isDBdisplayed());
		
		//Thread.sleep(5000);
		
		admPage.logoutFrmApp();
		//Thread.sleep(5000);
		
		HomePage home = new HomePage(driver);
		home.isSignupDisplayed();
		
		Assert.assertTrue(home.isSignupDisplayed());
		//Assert.assertTrue(driver.findElement(By.xpath("//a[text()='SIGN UP']")).isDisplayed());
	}
	

	
	
}
