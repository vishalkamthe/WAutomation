package com.whirlpool.windchillautomation.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.whirlpool.windchillautomation.qa.util.Utilities;

public class DriverInitialization {

	public static WebDriver driver;
	public static Properties properties;

	public DriverInitialization() throws IOException{
		//C:\\Users\\shinda1\\git\\WAutomation\\src\\main\\java\\com\\whirlpool\\windchillautomation\\qa\\config\\config.properties
		//C:\\Git_Workspaces\\WAutomation\\src\\main\\java\\com\\whirlpool\\windchillautomation\\qa\\config
		properties=new Properties();

		FileInputStream fis = new FileInputStream("E:\\config.properties");
		try {
			properties.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Config.properties file is missing at specified location");
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void driverInitialization(){

		String browserName =properties.getProperty("browserName");
		String chromeDriverPath=properties.getProperty("chromeDriverPath");
		String firefoxDriverPath=properties.getProperty("firefoxDriverPath");
		String ieDriverPath=properties.getProperty("ieDriverPath");
		String url =properties.getProperty("url");


		if(browserName.equalsIgnoreCase("chrome")){

			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver=new ChromeDriver();

		}else if(browserName.equalsIgnoreCase("firefox")){

			System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
			driver=new ChromeDriver();

		}
		else if(browserName.equalsIgnoreCase("ie")){

			System.setProperty("webdriver.ie.driver", ieDriverPath);
			driver=new InternetExplorerDriver();

		}
		System.out.println("test");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utilities.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utilities.IMPLICIT_WAIT, TimeUnit.SECONDS);

		driver.get(url);
		System.out.println(url);

	}

}
