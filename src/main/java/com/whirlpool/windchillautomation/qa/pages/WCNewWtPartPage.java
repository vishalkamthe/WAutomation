package com.whirlpool.windchillautomation.qa.pages;

import java.io.IOException;
import java.time.LocalDateTime;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.whirlpool.windchillautomation.qa.base.DriverInitialization;
import com.whirlpool.windchillautomation.qa.util.Utilities;
import com.whirlpool.windchillautomation.qa.util.Xls_Reader;

/**
 * 
 * @author shinda1
 *
 */
public class WCNewWtPartPage extends DriverInitialization  {
	Xls_Reader reader = new Xls_Reader("C:\\Users\\shinda1\\git\\WAutomation\\src\\main\\java\\com\\whirlpool\\windchillautomation\\qa\\testdata\\testdata.xlsx");
	Utilities wob;

	@FindBy(xpath="//select[@id='!~objectHandle~partHandle~!createType']")
	WebElement PartType;

	@FindBy(xpath="//td[text()='Name:']/following-sibling::td/input[1]")
	WebElement PartName;

	@FindBy(xpath="//td[text()='View:']/following-sibling::td[1]/select[1]")
	WebElement PartView;

	@FindBy(xpath="//td[text()='Classification:']/following-sibling::td/span//input[2]")
	WebElement PartClassfication;

	@FindBy(xpath="//td[text()='MFG']")
	WebElement MfgClassification;

	@FindBy(xpath="//td[text()='Net Weight:']/following-sibling::td[1]/input[1]")
	WebElement NetWeight;

	@FindBy(id="GrossWt")
	WebElement GrossWeight;

	@FindBy(id="Volume")
	WebElement volume;

	@FindBy(id="GrossWtUoM")
	WebElement WeightUom;

	@FindBy(id="VolumeUoM")
	WebElement Volumeuom;

	@FindBy(id="AltLang1")
	WebElement Altlang;

	@FindBy(id="StandardizationCode")
	WebElement StdCode;

	@FindBy(xpath="//td[text()='Description (35 chars):']/following-sibling::td/input[1]")
	WebElement MfgDescription;

	@FindBy(xpath="//u[text()='N']")
	WebElement NextButton;

	@FindBy(xpath="//u[text()='F']")
	WebElement FinishButton;

	public WCNewWtPartPage() throws Exception
	{
		PageFactory.initElements(driver, this);
	}

	public void SelectAllPartDropDowns()
	{
		String type	=reader.getCellData("WTPart", "PartType", 2);
		Select parttype=new Select(PartType);
		parttype.selectByVisibleText(type);

		String view	=reader.getCellData("WTPart", "View", 2);
		Select partview=new Select(PartView);
		partview.selectByVisibleText(view);

		String wtuom=reader.getCellData("WTPart", "WeightUOM", 2);
		Select weightuom=new Select(WeightUom);
		weightuom.selectByVisibleText(wtuom);

		String voluom=reader.getCellData("WTPart", "VolUOM", 2);
		Select volumeuom=new Select(Volumeuom);
		volumeuom.selectByVisibleText(voluom); 

		String sCode=reader.getCellData("WTPart", "StandardCode", 2);
		Select stdcode= new Select(StdCode);
		stdcode.selectByVisibleText(sCode);
	}




	public void EnterAllPartAttibutes() throws IOException
	{
		LocalDateTime  datetime = LocalDateTime .now();
		String partname= "Part_"+ datetime;
		PartName.sendKeys(partname);

		String classfication=reader.getCellData("WTPart", "Classification", 2);
		PartClassfication.sendKeys(classfication);
		wob = new Utilities();
		wob.waitForElement(MfgClassification,10);
		PartClassfication.sendKeys(Keys.ENTER);

		String netweight=reader.getCellData("WTPart", "NetWeight", 2);
		NetWeight.sendKeys(netweight);


		String grossweight=reader.getCellData("WTPart", "GrossWeight", 2);
		GrossWeight.sendKeys(grossweight);

		String vol=reader.getCellData("WTPart", "Volume", 2);
		volume.sendKeys(vol);

		String altlang=reader.getCellData("WTPart", "Alt_lang", 2);
		Altlang.sendKeys(altlang);			
	}

	public void PartMfgDescription() {

		String MFGAttribute=reader.getCellData("WTPart", "MfgClassAttribute", 2);
		MfgDescription.sendKeys(MFGAttribute);

	}

	/*
	 * public void SelectPartType() {
	 * 
	 * }
	 * 
	 * public void SelectPartView() {
	 * 
	 * }
	 * 
	 * public void EnterPartName() {
	 * 
	 * }
	 * 
	 * public void PartMfgClassification() throws InterruptedException, IOException
	 * {
	 * 
	 * }
	 * 
	 * public void PartNetWeight() {
	 * 
	 * }
	 * 
	 * public void PartGrossWeight() { }
	 * 
	 * public void PartVolume() {
	 * 
	 * }
	 * 
	 * public void PartWeightUOM() {
	 * 
	 * }
	 * 
	 * public void PartVolumeUOM() {
	 * 
	 * }
	 * 
	 * public void PartAltlangauge() {
	 * 
	 * }
	 * 
	 * public void PartStdCode() {
	 * 
	 * 
	 * }
	 */

	public void ClickNextButton()
	{
		NextButton.click();
	}

	public WCFoldersPage ClickFinishButton() throws IOException
	{
		FinishButton.click();
		return new WCFoldersPage();
	}


}
