package com.vTiger.ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.vTiger.genricLib.Base;
import com.vTiger.genricLib.Utility;

public class CreateVendorTest extends Base
{
	@Test
	public void cretaeVendrTest()
	{
		String vendorName="lenovo";
		WebElement el=driver.findElement(By.linkText("More"));
		Utility.moveToElement(driver, el);
		Reporter.log("clicked on more",true);
		
		Assert.assertTrue(false);
		
		driver.findElement(By.xpath("//a[@name='Vendors']")).click();
		Reporter.log("clicked on vendor", true);
		
		driver.findElement(By.xpath("//img[@title='Create Vendor...']")).click();
		Reporter.log("clicked on creater vendor",true);
		
		driver.findElement(By.name("vendorname")).sendKeys(vendorName);
		Reporter.log("entered vendor name",true);
		
		driver.findElement(By.xpath("//input[@value='  Save  ']")).click();
		Reporter.log("cliked on save button",true);
		String actul=driver.findElement(By.xpath("//span[contains(.,'Vendor Information')]")).getText();
		Assert.assertTrue(actul.contains(vendorName));
		Reporter.log("vendor is created successfully",true);
		driver.findElement(By.linkText("Vendors")).click();
		Reporter.log("clicked on vendors link",true);
	}
}
