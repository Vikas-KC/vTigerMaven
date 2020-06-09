package com.vTiger.genricLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.vTiger.ObjectRepo.Home;
import com.vTiger.ObjectRepo.Login;

public class Base 
{
	public FileLib fl = new FileLib();
	
	public WebDriver driver;
	public static WebDriver staticDriver;
	
//	@Parameters("browser")
	@BeforeClass
	public void configBC()
	{
		String br=fl.getPropertyKeyValue("browser");
		System.out.println(br);
		if(br.equals("chrome"))
		{
			driver = new ChromeDriver();
			staticDriver = driver;
		}
		else if(br.equals("firefox"))
		{
			driver = new FirefoxDriver();
			staticDriver=driver;
		}
		
		driver.get(fl.getPropertyKeyValue("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void configBM()
	{
//		driver.findElement(By.name("user_name")).sendKeys(fl.getPropertyKeyValue("username"));
//		driver.findElement(By.name("user_password")).sendKeys(fl.getPropertyKeyValue("password"),Keys.ENTER);
		
		Login login = PageFactory.initElements(driver, Login.class);
		login.login(fl.getPropertyKeyValue("username"), fl.getPropertyKeyValue("password"));
	}
	
	@AfterMethod
	public void configAM()
	{
//		WebElement el=driver.findElement(By.xpath("//img[contains(@src,'user.PNG')]"));
//		Utility.moveToElement(driver, el);
//		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
		Home home = PageFactory.initElements(driver, Home.class);
		home.signOut(driver);
	}
	
	@AfterClass
	public void configAC()
	{
		driver.quit();
	}
	
}
