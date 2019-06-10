package com.whirlpool.ppta.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.log4testng.Logger;

import com.whirlpool.ppta.qa.testcases.PPTALoginPageTest;
import com.whirlpool.ppta.qa.util.Utilities;
import com.whirlpool.ppta.qa.util.WebEventListener;

public class DriverInitialization {

	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	
	public DriverInitialization() throws IOException
	{
		try{
			prop= new Properties();
		
		FileInputStream fs= new FileInputStream("C:\\AppiumWorkspace1\\POM_TestProject\\src\\main\\java\\com\\TestProject\\qa\\config\\config.properties");
		prop.load(fs);
	}
	catch(FileNotFoundException e)
		{
		e.printStackTrace();
		}
		catch(IOException e)
		{
		e.printStackTrace();
		}
	}
	
	public static void initilization() throws IOException
	{
		String browsername=prop.getProperty("browser");
       
		
		if(browsername.equals("firefox"))
		{
			
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\patilr8\\AppData\\Local\\QualitiaWDClient\\app-5.5.0\\WebDriver\\Selenium\\geckodriver.exe");
			 driver =	new FirefoxDriver();
			
		}
		
		else if(browsername.equals("chrome"))
		{
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\patilr8\\AppData\\Local\\QualitiaWDClient\\app-5.5.0\\WebDriver\\Selenium\\chromedriver.exe");
			    driver =	new ChromeDriver();
			
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		Logger log = Logger.getLogger(DriverInitialization.class);
		
		   driver.manage().window().maximize();
		   driver.manage().deleteAllCookies();
		   driver.manage().timeouts().pageLoadTimeout(Utilities.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		   driver.manage().timeouts().implicitlyWait(Utilities.IMPLICITWAIT, TimeUnit.SECONDS);
		   driver.get(prop.getProperty("url"));
		   log.info("Entering url");
		
		
		
	}
}
