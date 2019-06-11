package com.whirlpool.windchillautomation.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.whirlpool.windchillautomation.qa.base.DriverInitialization;
import com.whirlpool.windchillautomation.qa.util.Utilities;

public class WCFoldersPage extends DriverInitialization {

	public WCFoldersPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	public static  Utilities sw;

	@FindBy(xpath="//button[text()='New Part']")
	WebElement newpart;

	@FindBy(xpath="//a[@class='msgIdentityText']")
	WebElement YellowBannerLink;
	
	public WCNewWtPartPage ClickOnNewNewPartButton() throws Exception
	{
		newpart.click();
		return new WCNewWtPartPage();
	}
	
	public void ClickOnYellowBanner()
	{
		YellowBannerLink.click();
	}
	
}
