package com.whirlpool.windchillautomation.qa.objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.whirlpool.windchillautomation.qa.base.DriverInitialization;

public class WCNewWtPartPageObjects extends DriverInitialization {
	
	@FindBy(xpath="//select[@id='!~objectHandle~partHandle~!createType']")
	protected WebElement partType;

	@FindBy(xpath="//td[text()='Name:']/following-sibling::td/input[1]")
	protected WebElement partName;

	@FindBy(xpath="//td[text()='View:']/following-sibling::td[1]/select[1]")
	protected WebElement partView;

	@FindBy(xpath="//td[text()='Classification:']/following-sibling::td/span//input[2]")
	protected WebElement partClassfication;

	@FindBy(xpath="//td[text()='MFG']")
	protected WebElement mfgClassification;

	@FindBy(xpath="//td[text()='Net Weight:']/following-sibling::td[1]/input[1]")
	protected WebElement netWeight;

	@FindBy(id="GrossWt")
	protected WebElement grossWeight;

	@FindBy(id="Volume")
	protected WebElement volume;

	@FindBy(id="GrossWtUoM")
	protected WebElement weightUom;

	@FindBy(id="VolumeUoM")
	protected WebElement volumeUom;

	@FindBy(id="AltLang1")
	protected WebElement altLang;

	@FindBy(id="StandardizationCode")
	protected WebElement stdCode;

	@FindBy(xpath="//td[text()='Description (35 chars):']/following-sibling::td/input[1]")
	protected WebElement mfgDescription;

	@FindBy(xpath="//u[text()='N']")
	protected WebElement nextButton;

	@FindBy(xpath="//u[text()='F']")
	protected WebElement finishButton;

	public WCNewWtPartPageObjects() throws Exception{
		PageFactory.initElements(driver, this);
	}

}
