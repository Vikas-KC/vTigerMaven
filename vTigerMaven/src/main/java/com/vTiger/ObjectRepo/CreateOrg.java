package com.vTiger.ObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CreateOrg 
{
	@FindBy(linkText = "Organizations")
	private WebElement organizationsLink;
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrgLink;
	
	@FindBy(name = "accountname")
	private WebElement accountnameTF;
	
	@FindBy(name = "website")
	private WebElement websiteTF;
	
	@FindBy(id = "employees")
	private WebElement employeesTF;
	
	@FindBy(xpath = "//select[@name='industry']//option[@value='\"+Industry+\"']")
	private WebElement industryTF;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(xpath = "//span[contains(.,'Organization Information')]")
	private WebElement actualOrganizationName;

	//providing getter methods
	public boolean actualOrgName(String org_name)
	{
		String actualOrgName = actualOrganizationName.getText();
		return actualOrgName.contains(org_name);
	}

	public WebElement getCreateOrgLink() {
		return createOrgLink;
	}

	public WebElement getAccountnameTF() {
		return accountnameTF;
	}

	public WebElement getWebsiteTF() {
		return websiteTF;
	}

	public WebElement getEmployeesTF() {
		return employeesTF;
	}

	public WebElement getIndustryTF() {
		return industryTF;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getActualOrganizationName() {
		return actualOrganizationName;
	}

	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}
	
	//Business Logic
//	public void clickOrgLink()
//	{
//		createOrgLink.click();
//	}
//	public void clickCreateOrg()
//	{
//		createOrgLink.click();
//	}
//	public void enterOganizationName(String org_name)
//	{
//		accountnameTF.sendKeys(org_name);
//	}
//	public void website(String web)
//	{
//		websiteTF.sendKeys(web);
//	}
//	public void employees(String emp)
//	{
//		employeesTF.sendKeys(emp);
//	}
//	public void industry(String industry)
//	{
//		industryTF.sendKeys(industry);
//	}
//	public void save()
//	{
//		saveButton.click();
//	}
	
}
