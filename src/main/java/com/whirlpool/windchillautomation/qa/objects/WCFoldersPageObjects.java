package com.whirlpool.windchillautomation.qa.objects;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.whirlpool.windchillautomation.qa.base.DriverInitialization;

public class WCFoldersPageObjects extends DriverInitialization {
		
	@FindBy(xpath="//button[text()='New Part']")
	protected WebElement newPart;

	@FindBy(xpath="//a[@class='msgIdentityText']")
	protected WebElement yellowBannerLink;
	
	
	public WCFoldersPageObjects() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

}
