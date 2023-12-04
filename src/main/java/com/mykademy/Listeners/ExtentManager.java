package com.mykademy.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mykademy.helper.Utility;

public class ExtentManager 
{
private static ExtentReports extent;
	
	public static ExtentReports getInstance() 
	{
    	if (extent == null)
    		createInstance();
    	
        return extent;
    }
    
    public static ExtentReports createInstance() 
    {
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("./Reports/Automation_"+Utility.getCurrentDate()+".html");
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle("Mykademy Learning App - Automation Report");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Mykademy Learning App 2.0");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        return extent;
    }

}
