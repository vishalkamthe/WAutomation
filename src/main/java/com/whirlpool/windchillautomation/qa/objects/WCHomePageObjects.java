package com.whirlpool.windchillautomation.qa.objects;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.whirlpool.windchillautomation.qa.base.DriverInitialization;
import com.whirlpool.windchillautomation.qa.pages.WCHomePage;

public class WCHomePageObjects extends DriverInitialization {
	
	public WCHomePageObjects() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	//Navigate to product	     	     
		@FindBy(xpath="//div[@id='navigatorPanel-xcollapsed']")
		protected WebElement navigatebutton;
		//Browse button	     
		@FindBy(xpath="//li[@id='navigatorTabPanel__object_main_navigation']")
		protected WebElement browsebutton;

		//navigate to recent product button	     
		@FindBy(xpath="//span[@class='x-tab-strip-text productNavigation-icon']")
		protected WebElement productbutton;

		@FindBy(linkText="View All")
		protected WebElement viewall;

		//Navigate to small appliance product 
		@FindBy(xpath="//input[@id='netmarkets.product.list.searchInListTextBox']")
		protected WebElement searchboxproduct;

		@FindBy(linkText="Small Appliances")
		protected WebElement smallappliance;

}
