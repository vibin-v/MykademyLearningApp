package com.mykademy.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mykademy.helper.Utility;

public class CourseListingPage_Admin 
{
	protected WebDriver driver;
	
	public CourseListingPage_Admin(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private By createNewCourseBtn = By.id("course_create");
	private By courseTitle = By.id("course_name");
	private By createCourseOK = By.id("create_box_ok");
	
	public void createCourseTitle(String CourseName)
	{
		Utility.waitForWebElement(driver, createNewCourseBtn).click();
		Utility.sleep(2);
		Utility.waitForWebElement(driver, courseTitle).sendKeys(CourseName);
		Utility.sleep(2);
		Utility.waitForWebElement(driver, createCourseOK).click();;
	}
	
	public void verifyCourseCreatedorNot()
	{
		Utility.waitForWebElement(driver, courseTitle);
	}
	
	
	
	
	
	
}
