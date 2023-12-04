package mykademy.testCases;

import java.util.Random;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.mykademy.Pages.AdminDashbaordPage;
import com.mykademy.Pages.CourseListingPage_Admin;
import com.mykademy.Pages.CourseSettingsPage;
import com.mykademy.Pages.LoginPage;
import com.mykademy.base.BaseClass;
import com.mykademy.dataProvider.DataProviders;
import com.mykademy.helper.Utility;

public class M002_VerifyCourseCreation extends BaseClass
{
	
	@Test(dataProvider = "TestData",dataProviderClass = DataProviders.class)
	public void courseCreationTest(String admUname,String admPwd)
	{
	
		Reporter.log("LOG:INFO : Starting M002_VerifyCourseCreation Test execution!!",true);
		driver.findElement(By.xpath("//a[text()='SIGN IN']")).click();
		LoginPage login = new LoginPage(driver);
		login.loginToApp(admUname, admPwd);
		
		
		
		AdminDashbaordPage admDB = new AdminDashbaordPage(driver);
		admDB.navigateToCourseCreationModule();
		
		CourseListingPage_Admin cozListing = new CourseListingPage_Admin(driver);
		
		cozListing.createCourseTitle("Python "+Utility.getRandomnumber());
		
		CourseSettingsPage cozSettings = new CourseSettingsPage(driver);
		
		Assert.assertTrue(cozSettings.isCourseviewDisplayed());
		
		
	}
}
