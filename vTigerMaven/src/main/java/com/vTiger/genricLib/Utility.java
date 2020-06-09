package com.vTiger.genricLib;

import java.io.File;

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
		//EventFiringWebDriver ef = new EventFiringWebDriver(driver);
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShots/screeShot1.PNG");
		
		
	}
}
