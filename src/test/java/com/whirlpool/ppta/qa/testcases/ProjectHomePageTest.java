package com.whirlpool.ppta.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.whirlpool.ppta.qa.base.DriverInitialization;
import com.whirlpool.ppta.qa.pages.PPTAHomePage;
import com.whirlpool.ppta.qa.pages.PPTALoginPage;
import com.whirlpool.ppta.qa.pages.PPTAProjectHomePage;
import com.whirlpool.ppta.qa.util.Utilities;

public class ProjectHomePageTest extends DriverInitialization{

	PPTALoginPage loginPage;
	PPTAHomePage homepage;
	String projecthomepage1;
	
	PPTAProjectHomePage projecthomepage; 
	Utilities testUtil;
	 int tdnumber;
		
	
	public ProjectHomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@BeforeTest
	public void setup() throws IOException, InterruptedException
	{
		initilization();
		loginPage= new PPTALoginPage();
		testUtil = new Utilities();
		testUtil.switchtoFrame();
		homepage=loginPage.login(prop.getProperty("username"), prop.getProperty("password")); //login method returning home page object so use homepage
		
		String String2=homepage.captureprojectnumber1();
		projecthomepage1=String2;
		homepage.clickOnOptionAgainstProjrctNumber(3);
		
		System.out.println("**********************************");
		

		System.out.println("**********************************");
	}
	
	
	@Test(priority=1)
	public void getTitle() throws InterruptedException
	{
		projecthomepage.selectGridView();
		//String projectpagetitle=driver.getTitle();
		//System.out.println(projectpagetitle);
			}
	
	


	
}
