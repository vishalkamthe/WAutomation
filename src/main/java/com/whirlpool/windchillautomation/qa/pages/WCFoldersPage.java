package com.whirlpool.windchillautomation.qa.pages;

import java.io.IOException;
import com.whirlpool.windchillautomation.qa.objects.WCFoldersPageObjects;

public class WCFoldersPage extends WCFoldersPageObjects {

	public WCFoldersPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public  WCNewWtPartPage ClickOnNewNewPartButton() throws Exception{
		newPart.click();
		return new WCNewWtPartPage();
	}

	public void ClickOnYellowBanner(){
		yellowBannerLink.click();
	}

}
