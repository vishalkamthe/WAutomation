package com.whirlpool.windchillautomation.qa.pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.whirlpool.windchillautomation.qa.base.DriverInitialization;
import com.whirlpool.windchillautomation.qa.objects.WCHomePageObjects;
/**
 * 
 * @author shinda1
 *
 */
public class WCHomePage extends WCHomePageObjects {


	public WCHomePage() throws IOException {
		super();

	}

	public String ValidateHomePageTitile()
	{
		return driver.getTitle();

	}

	public  WCFoldersPage navigateToWCFoldersPage() throws IOException
	{
		System.out.println("test");
		navigateButton.click();
		browseButton.click();
		productButton.click();
		viewAll.click();
		searchBoxProduct.sendKeys("Small Appliances");
		searchBoxProduct.sendKeys(Keys.ENTER);
		smallAppliance.click();

		return new WCFoldersPage();

	}
}
