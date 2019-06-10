package com.whirlpool.ppta.qa.base;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;

public class Controller extends DriverInitialization

{

	
	
	public Controller() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public static String createxpath(String xpath,Object ...args)
	{
		for (int i=0; i<args.length;i++)
		{
			xpath=xpath.replace("{"+i+"}", (CharSequence) args[i]);
		}
		
		return xpath;
		
	}
	
	public void selectDropDownValues(String dropdownid, String dropdonvalue ) throws InterruptedException
	{
		
		//WebDriver driver;
		Logger log = Logger.getLogger(Controller.class);
		log.info("hi");
		
//		String s1=createxpath("//input[@id='{0}]", "test");
//		System.out.println(s1);
//		
//		
//        String s2=createxpath("//input[@id='{0}] and @name='{1}']", "test","userid");
//		System.out.println(s2);
//		
//		String s3=createxpath("//input[@id='{0}] ]", dropdownid);
//		System.out.println(s2);
		String xpathfordropdown=createxpath("//select[@id='{0}']/option[text()='{1}']",dropdownid,dropdonvalue);
		System.out.println(xpathfordropdown);
		Thread.sleep(5000);
		driver.findElement(By.xpath(xpathfordropdown)).click();
		Thread.sleep(5000);
		
	}
	
	

	
}
