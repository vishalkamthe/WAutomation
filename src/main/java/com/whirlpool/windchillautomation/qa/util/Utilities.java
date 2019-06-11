package com.whirlpool.windchillautomation.qa.util;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.whirlpool.windchillautomation.qa.base.DriverInitialization;

public class Utilities extends DriverInitialization {

	public Utilities() throws IOException {
		super();
	}

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	public String ParentWindow;
	public String ChildWindow;

	public void SwitchToChild()
	{
		ParentWindow= driver.getWindowHandle();
		for( String ChildWindow :driver.getWindowHandles())
		{
			driver.switchTo().window(ChildWindow);
		}
		System.out.println((driver.getTitle()));	
	}

	public void SwitchToParent()
		{
			driver.switchTo().window(ParentWindow);
		}
	
	public WebElement waitForElement(WebElement object, long wait_Time_Seconds) 
	{
	    WebDriverWait wait = new WebDriverWait(driver,wait_Time_Seconds);
	    wait.until(ExpectedConditions.elementToBeClickable(object));
	    return object;
	}	
	
	
	
	
	
	
	
}