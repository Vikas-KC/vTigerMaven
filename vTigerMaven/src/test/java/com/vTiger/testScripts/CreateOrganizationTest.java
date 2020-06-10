package com.vTiger.testScripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vTiger.ObjectRepo.CreateOrg;
import com.vTiger.genricLib.Base;
import com.vTiger.genricLib.FileLib;

public class CreateOrganizationTest extends Base
{
	CreateOrg org;
	
	FileLib fl = new FileLib();
	@DataProvider
	public Object[][] readData()
	{
		return fl.readAllDataFromExcel("Org");
	}
	
	@Test(dataProvider = "readData")
	public void createOrgTest(String Org_name,String Org_website,String	Org_emp,String Industry,String	Type,
			String	Assigned_to,String Phone_no,String Email,String	Annual_revenu,String Billing_address)
	{
		org = PageFactory.initElements(driver, CreateOrg.class);
		
		org.getOrganizationsLink().click();
		Reporter.log("cliked on organization link",true);

		org.getCreateOrgLink().click();;
		Reporter.log("clicked on create organization link",true);
		
		org.getAccountnameTF().sendKeys(Org_name);
		Reporter.log("organization name is entered",true);

		org.getWebsiteTF().sendKeys(Org_website);
		Reporter.log("Organization website entered",true);
		
		org.getEmployeesTF().sendKeys(Org_emp);
		Reporter.log("Entered Employees",true);
		
		org.getSaveButton().click();;
		Reporter.log("clicked on save button",true);
		
		//verifying the organization created
		
		Assert.assertTrue(org.actualOrgName(Org_name));
		Reporter.log("organization created successfully",true);
		
		org.getOrganizationsLink().click();;
		Reporter.log("clicked on organization link link->home page displayed",true);
	}
}
