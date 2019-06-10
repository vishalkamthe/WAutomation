package com.whirlpool.ppta.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.whirlpool.ppta.qa.base.Controller;
import com.whirlpool.ppta.qa.base.DriverInitialization;
import com.whirlpool.ppta.qa.pages.PPTAHomePage;
import com.whirlpool.ppta.qa.pages.PPTALoginPage;
import com.whirlpool.ppta.qa.pages.PPTAProjectHomePage;
import com.whirlpool.ppta.qa.util.Utilities;

public class PPTAProjectHomePageTest extends DriverInitialization{

	PPTALoginPage loginPage;
	PPTAHomePage homepage;
	String projecthomepage1;

	PPTAProjectHomePage projecthomepage; 
	Utilities testUtil;
	Controller controller;
	int tdnumber;


	public PPTAProjectHomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	@BeforeTest
	public void setup() throws IOException, InterruptedException
	{
		initilization();
		loginPage= new PPTALoginPage();
		testUtil = new Utilities();
		controller= new  Controller();
		testUtil.switchtoFrame();
		homepage=loginPage.login(prop.getProperty("username"), prop.getProperty("password")); //login method returning home page object so use homepage

		String String2=homepage.captureprojectnumber1();
		projecthomepage1=String2;
		homepage.clickOnOptionAgainstProjrctNumber(3);

		System.out.println("**********************************");


		System.out.println("**********************************");
	}


	@Test(priority=1)
	public void getTitle() throws InterruptedException //validate title
	{

		String projectpagetitle=driver.getTitle();
		System.out.println(projectpagetitle);
	}

	@Test(priority=2)
	public void DropDownPageTest() throws InterruptedException, IOException
	{

		System.out.println("**************########################********************");
		controller.selectDropDownValues("BOMControlDialog_viewId", "EES-0002-BOM View - Master BOM");

		System.out.println("****************########################******************");

		controller.selectDropDownValues("BOMControlDialog_viewId", "ENG-01-CAD Plan SA - MPL");


	}



}
