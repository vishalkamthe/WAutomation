package com.whirlpool.windchillautomation.qa.pages;

import java.io.IOException;
import java.time.LocalDateTime;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import com.whirlpool.windchillautomation.qa.objects.WCNewWtPartPageObjects;
import com.whirlpool.windchillautomation.qa.util.Utilities;
import com.whirlpool.windchillautomation.qa.util.Xls_Reader;

/**
 * 
 * @author shinda1
 *
 */
public class WCNewWtPartPage extends WCNewWtPartPageObjects{
	
	String testDataFilePath =properties.getProperty("testdatafilepath");
	Xls_Reader reader = new Xls_Reader(testDataFilePath);
	Utilities wob;
	WCFoldersPage FolderPage;
	Utilities util;
	WCNewWtPartPage PartPage;
	
	public WCNewWtPartPage() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public WCNewWtPartPage selectAllPartDropDowns(){
		String type	=reader.getCellData("WTPart", "PartType", 2);
		Select parttype=new Select(partType);
		parttype.selectByVisibleText(type);

		String view	=reader.getCellData("WTPart", "View", 2);
		Select partview=new Select(partView);
		partview.selectByVisibleText(view);

		String wtuom=reader.getCellData("WTPart", "WeightUOM", 2);
		Select weightuom=new Select(weightUom);
		weightuom.selectByVisibleText(wtuom);

		String voluom=reader.getCellData("WTPart", "VolUOM", 2);
		Select volumeuom=new Select(volumeUom);
		volumeuom.selectByVisibleText(voluom); 

		String sCode=reader.getCellData("WTPart", "StandardCode", 2);
		Select stdcode= new Select(stdCode);
		stdcode.selectByVisibleText(sCode);
		
		return this;
	}

	public void enterAllPartAttibutes() throws IOException{
		LocalDateTime  datetime = LocalDateTime .now();
		String partname= "Part_"+ datetime;
		partName.sendKeys(partname);

		String classfication=reader.getCellData("WTPart", "Classification", 2);
		partClassfication.sendKeys(classfication);
		wob = new Utilities();
		wob.waitForElement(mfgClassification,10);
		partClassfication.sendKeys(Keys.ENTER);

		String netweight=reader.getCellData("WTPart", "NetWeight", 2);
		netWeight.sendKeys(netweight);

		String grossweight=reader.getCellData("WTPart", "GrossWeight", 2);
		grossWeight.sendKeys(grossweight);

		String vol=reader.getCellData("WTPart", "Volume", 2);
		volume.sendKeys(vol);

		String altlang=reader.getCellData("WTPart", "Alt_lang", 2);
		altLang.sendKeys(altlang);			
	}

	public void partMfgDescription(){
		
		String MFGAttribute=reader.getCellData("WTPart", "MfgClassAttribute", 2);
		mfgDescription.sendKeys(MFGAttribute);
	}
	
	public void clickNextButton(){
		nextButton.click();
	}

	public WCFoldersPage clickFinishButton() throws IOException{
		finishButton.click();
		return new WCFoldersPage();
	}

	public void createNewPart () throws Exception{

		FolderPage= new WCFoldersPage();
		FolderPage.ClickOnNewNewPartButton();

		PartPage= new WCNewWtPartPage();
		util =new Utilities();
		util.SwitchToChild();

		selectAllPartDropDowns();
		enterAllPartAttibutes();
		clickNextButton();
		partMfgDescription();
		clickFinishButton();	

		util.SwitchToParent();
		FolderPage.ClickOnYellowBanner();

		util.capturescreenshot(driver, "CreatedPart");

	}

}
