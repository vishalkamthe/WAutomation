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
	Utilities util;


	public LoginTest() throws IOException {
		super();
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
		util =new Utilities();
		util.SwitchToChild();

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

		util.SwitchToParent();
		FolderPage.ClickOnYellowBanner();
		
		util.capturescreenshot(driver, "CreatedPart");

	}



	@AfterTest
	public void exit()
	{
		driver.quit();
	}







}

