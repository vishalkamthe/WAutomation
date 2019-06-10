package com.whirlpool.ppta.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.IllegalFormatException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.whirlpool.ppta.qa.base.DriverInitialization;
import com.gargoylesoftware.htmlunit.javascript.host.worker.Worker;

public class Utilities extends DriverInitialization{

	


	public static long PAGE_LOAD_TIMEOUT=50;
	public static long IMPLICITWAIT=10;
	public static String TESTDATA_SHEET_PATH = "C:\\AppiumWorkspace1\\AutomationFramework\\src\\main\\java\\com\\AutomationFramework\\qa\\testdata\\AutomationFrameworkTestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;

	public Utilities() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void switchtoFrame()
	{
		driver.switchTo().frame("contentFrame");
	}
	
	

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// System.out.println(sheet.getLastRowNum() + "--------" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png")); ///create screenshots folder into current directory
	}




}