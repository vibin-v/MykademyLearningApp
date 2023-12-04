package com.mykademy.dataProvider;

import org.testng.annotations.DataProvider;

public class DataProviders
{

	@DataProvider(name = "TestData")
	public static Object [][] getData()
	{
		Object[][]arr=ExcelReader.getDataFromExcel("LoginData");
		
		return arr;
	}
}
