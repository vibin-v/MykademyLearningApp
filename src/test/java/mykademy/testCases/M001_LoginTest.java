package mykademy.testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mykademy.Pages.AdminDashbaordPage;
import com.mykademy.Pages.LoginPage;
import com.mykademy.base.BaseClass;

public class M001_LoginTest extends BaseClass
{
	
	
	//Testcases
	@Test
	public void loginTest() throws InterruptedException
	{
		Reporter.log("LOG:INFO : Starting test execution!!",true);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
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
		AdminDashbaordPage admPage = login.loginToApp("sumi.scaria@mykademy.com", "Password@123");
		
		
		Thread.sleep(3000);
		
		Assert.assertTrue(admPage.isDBdisplayed());
		
		Thread.sleep(5000);
		
		admPage.logoutFrmApp();
		Thread.sleep(5000);
		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='SIGN UP']")).isDisplayed());
	}
	
	
	
}
