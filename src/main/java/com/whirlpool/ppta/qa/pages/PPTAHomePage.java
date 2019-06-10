package com.whirlpool.ppta.qa.pages;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.whirlpool.ppta.qa.base.DriverInitialization;

public class PPTAHomePage extends DriverInitialization{
 static int tdnumber;
 public String projectNumber ;
	
//Page Factory
@FindBy(xpath="PPTA Home")
WebElement pptaHomeText;

@FindBy(name="LDAPName")
WebElement captureusername;

@FindBy(xpath="//td[text()='Prj#']/ancestor::tr[2]/following-sibling::tr//table[1]//td[@class=' CQClassReadOnly CQCellBase CQType CQInt CQCell HideCol0A']/div")
WebElement captureprojectnumber;

@FindBy(xpath="//div[text()='671153']/parent::td/following-sibling::td[3]")
WebElement clickonoptionagainstprojectnumber;

@FindBy(xpath="//div[text()='671153']/parent::td/following-sibling::td[3]")
WebElement clickonoptionagainstprojectnumber2;

	public PPTAHomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	public String validateHomePageTitle()
 {
		
		String HomePageTitle= driver.getTitle();
		 Assert.assertEquals(HomePageTitle, "PPTA - Project Part Tracking Application", "Home Page Title not matched");
		return HomePageTitle;
	
	 } 
	public String verifyusername()
	{
		 String str2=captureusername.getText();
		 Assert.assertEquals(str2, "LRUS0001", "Home Page UserName not matched");
		return str2;
	
	}
	public  String captureprojectnumber1()
	{//		
		 projectNumber=captureprojectnumber.getText();
		System.out.println("ProjectNumber = "+projectNumber);
		return projectNumber;
		
	}
	public void selectDropDownValues(String dropdownid, String dropdonvalue ) throws InterruptedException
	{
		
		System.out.println("id="+dropdownid);
		System.out.println(dropdonvalue);
		driver.findElement(By.xpath("//select[@id=\'"+dropdownid+"']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select[@id=\'"+dropdownid+"']/option[text()=\'"+dropdonvalue+"']")).click();
		Thread.sleep(5000);
		String selectedvalue=driver.findElement(By.xpath("//select[@id=\'"+dropdownid+"']")).getText();
		//Assert.assertEquals(selectedvalue, dropdonvalue);
		
		
		
	}


	
	public PPTAProjectHomePage clickOnOptionAgainstProjrctNumber(int tdnum) throws InterruptedException, IOException
	{
		

		Thread.sleep(5000);
		tdnumber=tdnum;
		projectNumber= captureprojectnumber1();
		
		System.out.println(clickonoptionagainstprojectnumber);
		
		driver.findElement(By.xpath("//div[text()='"+projectNumber+"']/parent::td/following-sibling::td[3]")).click();
		Thread.sleep(10000);
		String ParentWindow= driver.getWindowHandle();
		for(String ChildWindow :driver.getWindowHandles())
		{
		driver.switchTo().window(ChildWindow);
		}
		 String title1=driver.getTitle();
		 System.out.println(title1);
		
		return new PPTAProjectHomePage();
		
		
	}
	
	
	}
	

