package com.vTiger.ObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateContact 
{
	@FindBy(xpath = "//img[@title='Create Contact...']")
	WebElement createContactLink;

	@FindBy(name = "firstname")
	WebElement firstNameTF;

	@FindBy(name = "lastname")
	WebElement lastNameTF;

	@FindBy(xpath = "//input[@name='account_name']/../img[@title='Select']")
	WebElement orgSelectTF;

	//	@FindBy(linkText = "")

	@FindBy(id = "email")
	WebElement emailTF;

	@FindBy(id = "mobile")
	WebElement mobileTF;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	WebElement saveButton;
	
	@FindBy(xpath = "//span[contains(text(),'Contact Information')]")
	WebElement actualInfo;
	
	//providing getter methods
	public WebElement getCreateContactLink() {
		return createContactLink;
	}

	public WebElement getFirstNameTF() {
		return firstNameTF;
	}

	public WebElement getLastNameTF() {
		return lastNameTF;
	}

	public WebElement getOrgSelectTF() {
		return orgSelectTF;
	}

	public WebElement getEmailTF() {
		return emailTF;
	}

	public WebElement getMobileTF() {
		return mobileTF;
	}
	public WebElement getSaveBuuton() {
		return saveButton;
	}
	public WebElement getActualInfo()
	{
		return actualInfo;
	}

	//business logic
	public void firstName(String fn)
	{
		firstNameTF.sendKeys(fn);
	}
	public void lasttName(String ln)
	{
		lastNameTF.sendKeys(ln);
	}

	public void email(String email)
	{
		emailTF.sendKeys(email);
	}
	public void mobile(String no)
	{
		emailTF.sendKeys(no);
	}
	public boolean conformation(String name)
	{
		return  actualInfo.getText().contains(name);
	}


}
