package com.whirlpool.windchillautomation.qa.testcases;

import java.io.IOException;
import java.util.logging.LogManager;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.whirlpool.windchillautomation.qa.base.DriverInitialization;
import com.whirlpool.windchillautomation.qa.pages.WCFoldersPage;
import com.whirlpool.windchillautomation.qa.pages.WCHomePage;
import com.whirlpool.windchillautomation.qa.pages.WCNewWtPartPage;
import com.whirlpool.windchillautomation.qa.util.Utilities;

public class LoginTest extends DriverInitialization{
	WCHomePage homepage;
	WCFoldersPage FolderPage;
	WCNewWtPartPage PartPage;
	Utilities sw;
	
	
	public LoginTest() throws IOException {
		super();
		System.out.println("Git push working");
		System.out.println(" new Git push working");
		System.out.println(" third Git push working");
		System.out.println(" rutuja Git push working");
		
	}
	
	
	@BeforeTest
	public void setup() throws IOException, InterruptedException 
	{
		driverInitialization();
		homepage= new WCHomePage();
		homepage.ValidateHomePageTitile();
		homepage.navigateToWCFoldersPage();
	}

	@Test
	public void NewPart() throws Exception
	{

		FolderPage= new WCFoldersPage();
		FolderPage.ClickOnNewNewPartButton();

		PartPage= new WCNewWtPartPage();
		sw =new Utilities();
		sw.SwitchToChild();
	
		PartPage.SelectPartType();
		PartPage.EnterPartName();
		PartPage.SelectPartView();
		PartPage.PartNetWeight();
		PartPage.PartGrossWeight();
		PartPage.PartWeightUOM();
		PartPage.PartVolume();
		PartPage.PartVolumeUOM();
		PartPage.PartMfgClassification();
		PartPage.PartAltlangauge();
		PartPage.PartStdCode();
		PartPage.ClickNextButton();
		PartPage.PartMfgDescription();
		PartPage.ClickFinishButton();	
		
		sw.SwitchToParent();
		FolderPage.ClickOnYellowBanner();	
	}

	
	
	@AfterTest
	public void exit()
	{
		driver.quit();
	}
	
	
	
	
	


}

