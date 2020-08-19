package com.SS.genricLib;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;

public class Utility 
{
	public static void takeScreenshot(WebDriver driver,ITestResult result)
	{
		
		
		
		
//		String methodname = result.getMethod().getMethodName();
//		System.out.println(methodname);
//		Date d = new Date();
//		String[] dary = d.toString().split(" ");
//		String date= dary[2];
//		String Mon = dary[1];
//		String year = dary[5];
//		String time = dary[3];
//		String t = time.replace(":", "-");
//		
//		TakesScreenshot img = (TakesScreenshot)Base.staticdriver;
//		File src = img.getScreenshotAs(OutputType.FILE);
//		File dest = new File("./screenshot/"+methodname+"_"+date+"_"+Mon+"_"+year+"_"+t+".PNG");
//		System.out.println("Screenshot taken");
//		try 
//		{
//			FileUtils.copyFile(src, dest);
//		} 
//		catch (Exception e) 
//		{
//			e.printStackTrace();
//		}
	}
	
	public static void mouseAction(WebDriver driver, WebElement ele)
	{
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}

	public static void dropDown(WebElement ele, String value)
	{
		Select sel = new Select(ele);
		sel.selectByValue(value);
	}
}
