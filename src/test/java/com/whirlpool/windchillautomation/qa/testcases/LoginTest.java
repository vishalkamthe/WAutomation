package com.whirlpool.windchillautomation.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import windchillPages.HomePage;

public class LoginTest extends Base{
	HomePage homepage;
	
	public LoginTest() {
		super();
		System.out.println("Git push working");
		System.out.println(" new Git push working");
		System.out.println(" third Git push working");
		System.out.println(" rutuja Git push working");
		
	}
	
	
	@BeforeClass
	public void setup() throws IOException 
	{
		
		InitializeDriver();
		homepage= new HomePage();
		homepage.ValidateHomePageTitile();
		homepage.NavigateProduct();
	}
	
	
	@AfterClass
	public void tearDown()
	{
		
		driver.quit();
	}
	
	

	
	
	
	
	


}

