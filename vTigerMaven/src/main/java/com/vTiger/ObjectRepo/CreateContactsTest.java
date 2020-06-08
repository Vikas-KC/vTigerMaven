package com.vTiger.ObjectRepo;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vTiger.genricLib.Base;
import com.vTiger.genricLib.FileLib;

public class CreateContactsTest extends Base {

	FileLib fl = new FileLib();
	CreateContact con;
	Home home;


	@DataProvider
	public Object[][] readData()
	{
		return fl.readAllDataFromExcel("Contact");
	}

	@Test(dataProvider = "readData")
	public void createContTest(String firstName,String	lstName,String	org_name,String	email,String mobileNo)
	{
		home = PageFactory.initElements(driver, Home.class);
		home.getContactsLink().click();
		Reporter.log("clicked on Contact link",true);

		con = PageFactory.initElements(driver, CreateContact.class);
		con.getCreateContactLink().click();
		Reporter.log("clicked on create contact link",true);

		con.firstName(firstName);
		Reporter.log("entered first name",true);

		con.lasttName(lstName);
		Reporter.log("entered last name",true);

		con.getOrgSelectTF();
		Reporter.log("clicked on select Organization button",true);

		Set<String> setStr = driver.getWindowHandles();
		Iterator<String> itr = setStr.iterator();
		String pid = itr.next();
		String cid = itr.next();

		driver.switchTo().window(cid);
		Reporter.log("switched to childe browser",true);
		driver.findElement(By.linkText(org_name)).click();
		Reporter.log("selected Organization name",true);
		driver.switchTo().window(pid);
		Reporter.log("switched back to parent browser",true);

		con.getSaveBuuton().click();
		Reporter.log("clicked on save button",true);

		Assert.assertTrue(con.conformation(lstName));
		Reporter.log("contact created successfully",true);

		home.getContactsLink();
		Reporter.log("Entered on contacts link-->home page displayed",true);
	}

}
