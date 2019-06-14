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

/**
 * 
 * @author kamthvs
 *
 */
public class LoginTest extends DriverInitialization{
	WCHomePage homepage;
	WCFoldersPage FolderPage;
	WCNewWtPartPage PartPage;
	Utilities util;

	public LoginTest() throws IOException{
		super();
	}

	@BeforeTest
	public void setup() throws IOException, InterruptedException{
		driverInitialization();
		homepage= new WCHomePage();
		homepage.ValidateHomePageTitile();
		homepage.navigateToWCFoldersPage();
	}

	@Test
	public void NewPart1() throws Exception{

		PartPage= new WCNewWtPartPage();
		PartPage.createNewPart();
	}

	@AfterTest 
	public void exit(){
		driver.quit();
	}

}

