package com.mykademy.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
	
	public void addCourseDetails()
	{
		WebElement courseSettings = driver.findElement(By.xpath("//a[text()='Settings']"));
		courseSettings.click();
		Utility.sleep(3);
		//span[text()='None selected']
		
		Actions act = new Actions(driver);
		WebElement cozImgUpload = driver.findElement(By.xpath("//input[@name='cb_image']"));
		act.moveToElement(cozImgUpload).build().perform();
		Utility.sleep(3);
		//driver.findElement(By.name(""))
		cozImgUpload.sendKeys("C:\\Users\\NETCOM\\eclipse-workspace\\MykademyLearningAPP\\TestData\\SampleImage.png");
		
		Utility.sleep(3);
		WebElement cropAndSave = driver.findElement(By.xpath("//div[@id='crop_image_save']"));
		cropAndSave.click();
		Utility.sleep(3);
		
		WebElement courseCategory = driver.findElement(By.xpath("//span[text()='None selected']"));
		courseCategory.click();
		WebElement selectCategory = driver.findElement(By.xpath("//label[normalize-space()='UPSC']"));
		selectCategory.click();
		
		
		WebElement cozShortDesc = driver.findElement(By.id("cb_short_description"));
		cozShortDesc.sendKeys("Find the right instructor for you with Udemy. Choose from many topics, skill levels here. Shop thousands of");
		WebElement cozDesc = driver.findElement(By.xpath("//a[@href='#long-dscrptn']"));
		cozDesc.click();
		
		WebElement enterCozDesc = driver.findElement(By.xpath("//div[@id='long-dscrptn']/div/div/div[2]"));
		enterCozDesc.sendKeys("Find the right instructor for you with Udemy. Choose from many topics, skill levels here. Shop thousands of");
		
		WebElement freeCoz = driver.findElement(By.xpath("//span[normalize-space()='Free']"));
		freeCoz.click();
		Utility.sleep(3);
		
		Utility.sleep(3);
		WebElement saveAndNext = driver.findElement(By.id("course_savenext_button"));
		saveAndNext.click();
	}
}
