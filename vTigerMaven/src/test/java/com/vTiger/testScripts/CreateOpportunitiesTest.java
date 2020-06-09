package com.vTiger.testScripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vTiger.ObjectRepo.CreateOpportunities;
import com.vTiger.genricLib.Base;
import com.vTiger.genricLib.FileLib;

public class CreateOpportunitiesTest extends Base
{
	CreateOpportunities opprt;
	FileLib fl = new FileLib();
	
	@DataProvider
	public Object[][] readData()
	{
		return fl.readAllDataFromExcel("Opportunities");
	}
	
	@Test(dataProvider = "readData")
	public void createOpportuninyTest(String opprtName,String selectOrg,String type,String leadSource,
			String salesStage,String expectedCloseDate)
	{
		opprt = PageFactory.initElements(driver, CreateOpportunities.class);
		opprt.getOpportunitiesLink().click();
		Reporter.log("Cliked on Opportunites link",true);
		
		opprt.getCreateOpportunityLink().click();
		Reporter.log("cliked on create opportunity link",true);
		
		opprt.getOpportunityNameTF().sendKeys(opprtName);
		Reporter.log("entered opportunity name",true);
		
		opprt.selectOrg(driver, selectOrg);
		Reporter.log("selected Organization name",true);
		
		opprt.dropDownSelectType(type);
		Reporter.log(type+" selected from sigle Select drop down",true);
		
		opprt.getSaveButton().click();
		Reporter.log("clicked the saved button",true);
	}
}
