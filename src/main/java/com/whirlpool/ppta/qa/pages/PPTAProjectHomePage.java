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


import com.whirlpool.ppta.qa.pages.PPTAHomePage;
import com.whirlpool.ppta.qa.pages.PPTALoginPage;
import com.whirlpool.ppta.qa.base.DriverInitialization;

public class PPTAProjectHomePage extends DriverInitialization {

	
	  int tdnumber;
		
	

	  @FindBy(name="LDAPName")
	  WebElement captureusername;


	public PPTAProjectHomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	public String validateProjectPageTitle()
	 {
		
		//String ProjectPageTitle= driver.getTitle();
		 //Assert.assertEquals(ProjectPageTitle, "PPTA - Project Part Tracking Application", "Home Page Title not matched");
		 return driver.getTitle();
	
	 }
	public   void selectGridView() throws InterruptedException
	{
		
//		Set<String> winHandle = driver.getWindowHandles();
//		Iterator<String> it =winHandle.iterator();
//		
//		String ParentwindowId=it.next();
//		System.out.println("Parent window id: " + ParentwindowId);
//		
//		String ChildwindowId=it.next();
//		System.out.println("Child window id: " +ChildwindowId);
//   
//		driver.switchTo().window(ChildwindowId);
//		
//		
//        String title1=driver.getTitle();
//		System.out.println("ChildwindowTitle= "+title1);
//		
//		 String newpagetitle=driver.getTitle();
//		System.out.println(newpagetitle);
//		String verifylabelonviewpage=driver.findElement(By.xpath("//label[text()=\"PPTA Project Home/View Scope\"]")).getText();
//		//System.out.println(verifylabelonviewpage);
		Thread.sleep(5000);
		String verifylabelonviewpage=driver.findElement(By.xpath("//label[text()=\"PPTA View BOM \"]")).getText();
		//Select GridViewdropdown = new Select(driver.findElement(By.id("BOMControlDialog_viewId")));
		
		//GridViewdropdown.selectByIndex(2);
		
		Thread.sleep(5000);
		 //String title1=driver.getTitle();
	
        }
	
}
