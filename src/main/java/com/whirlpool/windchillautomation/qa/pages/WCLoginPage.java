package com.whirlpool.windchillautomation.qa.pages;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import com.whirlpool.windchillautomation.qa.base.DriverInitialization;

public class WCLoginPage extends DriverInitialization{

	public WCLoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public void loginToWindchill(){
		
		driver.get("http://ENG001:ENG001@plmtraining.whirlpool.com/Windchill/app");
	}
}
