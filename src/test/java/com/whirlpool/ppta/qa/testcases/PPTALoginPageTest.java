package com.whirlpool.ppta.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.whirlpool.ppta.qa.base.DriverInitialization;
import com.whirlpool.ppta.qa.pages.PPTAHomePage;
import com.whirlpool.ppta.qa.pages.PPTALoginPage;
import com.whirlpool.ppta.qa.util.Utilities;

public class PPTALoginPageTest extends DriverInitialization
{
	PPTALoginPage loginPage;
	PPTAHomePage homepage;
	Utilities testUtil;
	
	public PPTALoginPageTest() throws IOException 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup() throws IOException
	{
		initilization();
		loginPage= new PPTALoginPage();
		testUtil = new Utilities();
		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String tritle= loginPage.validateLoginPageTitle();
		System.out.println(tritle);
		
		//Assert.assertEquals(actual, expected);
	}
	
	@Test(priority=2)
	public void loginTest() throws InterruptedException, IOException
	{
		 int size = driver.findElements(By.tagName("frame")).size();
		  System.out.println("Total Frames " + size);
		testUtil.switchtoFrame();
		
		System.out.println(prop.getProperty("username"));
		
		//loginPage.login(String un, String pwd)
		
		System.out.println(prop.getProperty("password"));
		homepage=
				loginPage.login(prop.getProperty("username"), prop.getProperty("password")); //this is Login method
	//here we are calling Login() from LoginPage.java class and it has two parameters (username and passwod). but we will get this values from properties file and to get this values 
		//use prop.getProperty
		driver.switchTo().defaultContent();
	}
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}
	
}
