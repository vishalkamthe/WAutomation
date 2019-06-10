package com.whirlpool.ppta.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.whirlpool.ppta.qa.base.DriverInitialization;

public class PPTALoginPage extends DriverInitialization 
{

	
	
	//Page Factory-or
	@FindBy(name="userid")
	WebElement username;
	
	@FindBy(name="passwd")
	WebElement password;

	
	@FindBy(name="submit")
	WebElement submitbutton;
	
	@FindBy(id="contentFrame")
	public static String framename;
	
	@FindBy(xpath="//label[text()='PPTA Home']")
	String verifyPPTAHome;
	
	//initializing page object
	public PPTALoginPage() throws IOException //to initialize above elements with the page factory
	{
		
		PageFactory.initElements(driver, this);//pointing to current class //object all the  variable(username,password,submitbutton) are initialize with its driver
		
		// TODO Auto-generated constructor stub
	}

	 public String validateLoginPageTitle()
	 {
		
		return driver.getTitle();
	
	 }
	 public String verifyPPTAHome()
	 {
		
		 String str2=driver.findElement(By.xpath("//label[text()='PPTA Home']")).getText(); 
		 Assert.assertEquals(str2, "PPTA Home");
		return str2;
	
	 }
	 

	 public PPTAHomePage login(String un, String pwd ) throws InterruptedException, IOException
	 {
		 
		 //System.out.println("hiii");
		 //System.out.println("in switchtoframe = "+ driver.getTitle());
		 //int size = driver.findElements(By.tagName("frame")).size();
		  //System.out.println("Total Frames " + size);
		  //driver.switchTo().frame(0);
		 //driver.switchTo().frame("contentFrame");
		 // driver.switchTo().frame(framename);
		 // System.out.println(framename);
		  Thread.sleep(1000);
		 username.sendKeys(un);
		 System.out.println(un);
		 Thread.sleep(1000);
		 password.sendKeys(pwd);
		 System.out.println("pass -" +pwd);
		 Thread.sleep(1000);
		 submitbutton.click();
		 Thread.sleep(6000);
		 
		 verifyPPTAHome();//label[text()='PPTA Home']
		
		 return new PPTAHomePage();
		 
	 }
	 
}
