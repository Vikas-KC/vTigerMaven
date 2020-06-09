package com.vTiger.testScripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vTiger.ObjectRepo.CreateProduct;
import com.vTiger.genricLib.Base;
import com.vTiger.genricLib.FileLib;

public class CreateProductsTest extends Base
{
	FileLib fl = new FileLib();
	CreateProduct prod;
	
	@DataProvider
	public Object[][] readData()
	{
		return fl.readAllDataFromExcel("Products");
	}
	@Test(dataProvider = "readData")
	public void createProductTest(String productName,String	productCategory,String vendorName,String glAccount)
	{
		prod = PageFactory.initElements(driver, CreateProduct.class);
		prod.getProductsLink().click();
		Reporter.log("clicked on products link",true);
		
		prod.getCreateProdcutLink().click();
		Reporter.log("clicked on create products link",true);
		
		prod.getProductnameTF().sendKeys(productName);
		Reporter.log(productName+" <--product is entered into the text field",true );
		
		prod.selectProdcutCategery(productCategory);
		Reporter.log(productCategory+" is selected ",true);
		
		prod.selectVendor(driver, vendorName);
		Reporter.log("selected vendor name-->"+vendorName,true);
		
		prod.glAccountSelect(glAccount);
		Reporter.log("selected gl Account",true);
		
		prod.getSaveButton().click();
		Reporter.log("clicked on save button",true);
	}
}
