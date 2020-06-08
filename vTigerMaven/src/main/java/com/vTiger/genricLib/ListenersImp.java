package com.vTiger.genricLib;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class ListenersImp implements ITestListener
{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		
		Date d = new Date();
		String str = d.toString();
		String[] cmpltDate = str.split(" ");
		int day = d.getDay();
		int month = d.getMonth();
		String year = cmpltDate[5];
		String time = cmpltDate[3].replace(":", "-");
		
//		EventFiringWebDriver ef =  new EventFiringWebDriver(Base.staticDriver);
		TakesScreenshot ts = (TakesScreenshot)Base.staticDriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ScreenShots/"+methodName+"-"+day+"-"+month+"-"+year+"-"+time+".PNG");
		
		
		
		
	}

	

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
