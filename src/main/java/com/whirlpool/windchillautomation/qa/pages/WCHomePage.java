package com.whirlpool.windchillautomation.qa.pages;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.whirlpool.windchillautomation.qa.base.DriverInitialization;

public class WCHomePage extends DriverInitialization {

	//Navigate to product	     	     
	@FindBy(xpath="//div[@id='navigatorPanel-xcollapsed']")
	WebElement navigatebutton;
	//Browse button	     
	@FindBy(xpath="//li[@id='navigatorTabPanel__object_main_navigation']")
	WebElement browsebutton;

	//navigate to recent product button	     
	@FindBy(xpath="//span[@class='x-tab-strip-text productNavigation-icon']")
	WebElement productbutton;

	@FindBy(linkText="View All")
	WebElement viewall;

	//Navigate to small appliance product 
	@FindBy(xpath="//input[@id='netmarkets.product.list.searchInListTextBox']")
	WebElement searchboxproduct;

	@FindBy(linkText="Small Appliances")
	WebElement smallappliance;

	public WCHomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public  WCFoldersPage navigateToWCFoldersPage() throws IOException
	{
		System.out.println("test");
		navigatebutton.click();
		browsebutton.click();
		productbutton.click();
		viewall.click();
		searchboxproduct.sendKeys("Small Appliances");
		searchboxproduct.sendKeys(Keys.ENTER);
		smallappliance.click();

		return new WCFoldersPage();

	}
}
