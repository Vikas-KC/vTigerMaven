package com.vTiger.genricLib;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;

public class Utility 
{
	public static  void moveToElement(WebDriver driver, WebElement el)
	{
		Actions act = new Actions(driver);
		act.moveToElement(el).perform();
	}
	
	public static void singleSelectDD(WebElement el, String val)
	{
		Select sl = new Select(el);
		sl.selectByValue(val);
	}
	
	public static void takeScreenShot(WebDriver driver,ITestResult result)
	{
		String methodNeme = result.getMethod().getMethodName();
		
		Date date = new Date();
		String sDate = date.toString();
		String[] st = sDate.split(" ");
		
		int dateNew = date.getDate();
		String month = st[1];
		String year = st[5];
		String time = st[3].replace(":", "-");
		
		//EventFiringWebDriver ef = new EventFiringWebDriver(driver);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShots/"+methodNeme+"-"+dateNew+"-"+month+"-"+year+"-"+time+".PNG");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
