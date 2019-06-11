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

/**
 * 
 * @author shinda1
 *
 */
public class WCNewWtPartPage extends DriverInitialization  {
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

	public void SelectPartType()
	{
		Select parttype=new Select(PartType);
		parttype.selectByVisibleText("Part");		
	}

	public void SelectPartView()
	{
		Select partview=new Select(PartView);
		partview.selectByVisibleText("Manufacturing");
	}

	public void EnterPartName()
	{
		LocalDateTime  datetime = LocalDateTime .now();
		String partname= "Part_"+ datetime;
		PartName.sendKeys(partname);	
	}

	public void PartMfgClassification() throws InterruptedException, IOException
	{
		PartClassfication.sendKeys("MFG");
		wob = new Utilities();
		wob.waitForElement(MfgClassification,10);
		PartClassfication.sendKeys(Keys.ENTER);
	}

	public void PartNetWeight()
	{
		NetWeight.sendKeys("10001");
	}

	public void PartGrossWeight()
	{
		GrossWeight.sendKeys("1205");
	}

	public void PartVolume()
	{
		volume.sendKeys("100");
	}

	public void PartWeightUOM()
	{
		Select weightuom=new Select(WeightUom);
		weightuom.selectByVisibleText("G");
	}

	public void PartVolumeUOM()
	{
		Select volumeuom=new Select(Volumeuom);
		volumeuom.selectByVisibleText("L"); 
	}

	public void PartAltlangauge()
	{

		Altlang.sendKeys("Portuguese_01");
	}

	public void PartMfgDescription()
	{
		MfgDescription.sendKeys("MFG Test Part");
	}

	public void PartStdCode()
	{
		Select stdcode= new Select(StdCode);
		stdcode.selectByIndex(1);
	}

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
