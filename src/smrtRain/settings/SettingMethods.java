package smrtRain.settings;

import smrtRain.programs.ProgramMethods;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.lib.TestBase;

public class SettingMethods extends ProgramMethods {
	
	
	/*********             SITE NOTIFICATIONS            *****************/
	
	public void settingHeader(String expHeader) {
		logInfo("Entered into settingHeader() method.");
		List <WebElement> head=driver.findElements(By.xpath(setHeaders));
		boolean ispresent=false;
		for(WebElement headrs :head) {
			String titles= headrs.getText().trim();			
			if(titles.equalsIgnoreCase(expHeader)) {
				ispresent=true;
				headrs.click();
				break;				
			}
		}if(!ispresent) {
			Assert.assertTrue(ispresent,expHeader+" is not present");
		}
		
	}
	
	public void addNotification() throws Exception {
		logInfo("Entered into addNotification() method.");
		wdWait("xpath", addNotiBtn);
		clickOnButton("xpath", addNotiBtn);
		
		
	}
	public void validateLabelOfAddNotification() throws Exception {
		logInfo("Entered into validateLabelOfAddNotification() method.");
		SoftAssert sa = new SoftAssert();
		wdWait("cssSelector", titleNotication);
		String title =getText("cssSelector", titleNotication);		
		WebElement labSite= driver.findElement(By.xpath(labSites));
		String sitePlaceHolder=labSite.getAttribute("placeholder");
		String siteName=labSite.getAttribute("aria-label");		
		sa.assertEquals(title, addNotificationTitle);
		sa.assertEquals(sitePlaceHolder, siteText);
		sa.assertEquals(siteName, siteText);
		sa.assertAll();
		
		
	}
	
	public void validateSubHeadings(String[] expSubHeaders) {
		logInfo("Entered into validateSubHeadings() method.");
		List<WebElement> subHeads=driver.findElements(By.cssSelector(subHead));
		boolean isSubHeaderPresent =false;
		int expSize=expSubHeaders.length;		
		int actSize=subHeads.size();
		if(expSize==actSize) {
			for(WebElement heads:subHeads) {
				String label=heads.getText().trim();
				for(int i=0; i<expSize;i++) {
					if(expSubHeaders[i].equalsIgnoreCase(label)) {
						isSubHeaderPresent=true;						
						break;
					}
				}if(!isSubHeaderPresent) {
					Assert.assertTrue(isSubHeaderPresent,label+" is not present");
				}
			}
			
		}else {
			Assert.assertEquals(actSize, expSize +" does not match");
		}
		
	}
	
	public void addNotifications() throws Exception {
		logInfo("Entered into addNotifications() method.");		
		wdWait("cssSelector", addBtn);
		clickOnButton("cssSelector", addBtn);		
	}
	
	
	/**********          FIRMWARE Maintenance      **********/
	
	public void firmwareAction(String expVersion, String actionType) throws Exception {
		logInfo("Entered into firmwareAction() method.");
		wdWait("xpath", firmVers);
		boolean isVersionPresent=false;
		int verSize=driver.findElements(By.xpath(firmVers)).size();
		for(int i=1;i<=verSize;i++) {
			String verName=driver.findElement(By.xpath(firmVersBfr+i+firmVersAfr)).getText().trim();
			if(verName.equalsIgnoreCase(expVersion)) {
				isVersionPresent=true;
				boolean isBtnPresent=false;
				List<WebElement> buttons=driver.findElements(By.xpath(firmVersBfr+i+actionBtn));
				for(WebElement btn :buttons) {
					String btnName=btn.getText().trim();
					if(btnName.equalsIgnoreCase(actionType)) {
						isBtnPresent=true;
						btn.click();
						break;
					}if(isBtnPresent) {
						Assert.assertTrue(isBtnPresent, actionType);
					}
							}
				
				break;
			}
			
			
		}if(!isVersionPresent) {
			Assert.assertTrue(isVersionPresent, expVersion+ "is not present.");
		}
		
	}
	
	public String getFileName(String expVersion) throws Exception {
		logInfo("Entered into getFileName() method.");
		wdWait("xpath", firmVers);
		boolean isVersionPresent=false;
		String file=null;
		int verSize=driver.findElements(By.xpath(firmVers)).size();
		for(int i=1;i<=verSize;i++) {
			String verName=driver.findElement(By.xpath(firmVersBfr+i+firmVersAfr)).getText().trim();
			if(verName.equalsIgnoreCase(expVersion)) {
				isVersionPresent=true;				
			    file=driver.findElement(By.xpath(firmVersBfr+i+firmFileAfr)).getText();
				break;
			}
			
			
		}if(!isVersionPresent) {
			Assert.assertTrue(isVersionPresent, expVersion+ "is not present.");
		}
		
		return file;
	}
	
	public void updateFirmDetails(String enterVersion) throws Exception {
		logInfo("Entered into updateFirmDetails() method.");		
		wdWait("xpath", firmUpdateBtn);
		clearText("xpath", inputFirmware);
		enterText("xpath", inputFirmware,enterVersion );
		
		clickOnButton("xpath", firmUpdateBtn);
		
	}
	
	public void deleteModelBox(String expMsg) throws Exception {
		logInfo("Entered into confirmStatusModelBox() method.");	
		boolean isPresent=false;	
		waitTilldisableOfElement(3);
		wdWait("cssSelector", revokeConfirm);
		String conMsg=getText("cssSelector", revokeConfirm);		
		if(conMsg.contains(expMsg)) {
			isPresent=true;
			clickOnButton("cssSelector", zonDelNo);	
			waitTilldisableOfElement(5);
		}else{
			clickOnButton("cssSelector", zonDelNo);
			sleep(1000);			
			Assert.assertEquals(isPresent,expMsg+ " : is not populated");
		}		
	}
	
	
	public void validateChooseType(int expOptionsSize, String[] options) throws Exception {
		logInfo("Entered into validateChooseType() method.");
		sleep(3000);		
		wdWait("cssSelector", chooseDp);
		scrollDown("cssSelector", chooseDp);
		clickOnObject("cssSelector", chooseDp);
		sleep(3000);
		List<WebElement> opt= driver.findElements(By.cssSelector(chooseOptions));
		int optSize= opt.size();
		if(optSize==expOptionsSize) {
			boolean isOptionPresent=false;
			for(WebElement option:opt ) {
				String optName=option.getText().trim();				
				for(int i=0;i<expOptionsSize;i++) {
					if(optName.contains(options[i])) {
						isOptionPresent=true;						
						break;
					}
				}if(!isOptionPresent) {
					clickOnObject("cssSelector", chooseFirtsOptions);
					Assert.assertEquals(isOptionPresent, optName + " is not present");
				}			
			}	clickOnObject("cssSelector", chooseFirtsOptions);		
		}else {
			clickOnObject("cssSelector", chooseFirtsOptions);
			Assert.assertEquals(optSize, expOptionsSize+" does not match.");
		}		
	}
	
	public String getCustomDetails(String expHeader) throws Exception {
		logInfo("Entered into getDeviceStatus() method.");
		String status=null;
		wdWait("xpath", siteInfoSubHeader);
		int infoSize=driver.findElements(By.xpath(siteInfoSubHeader)).size();
		boolean isPresnt =false;
		for(int i=1;i<=infoSize;i++) {
			String infoHeader=driver.findElement(By.xpath(siteInfoHeaderBfr+i+siteInfoHeaderAfr)).getText().trim();
			if(infoHeader.equalsIgnoreCase(expHeader)) {
				isPresnt=true;
				status=driver.findElement(By.xpath(siteInfoHeaderBfr+i+siteInfoStatusAfr)).getText();
				break;
			}			
		}if(!isPresnt) {
			Assert.assertTrue(isPresnt, expHeader);
		}		
		return status;
	}
	
	public String getSiteHeaderLabels(String expHeader) throws Exception {
		logInfo("Entered into getSiteHeaderLabels() method.");		
		wdWait("xpath", siteInfoSubHeader);
		String infoHeader = null;
		int infoSize=driver.findElements(By.xpath(siteInfoSubHeader)).size();
		boolean isPresnt =false;
		for(int i=1;i<=infoSize;i++) {
			infoHeader=driver.findElement(By.xpath(siteInfoHeaderBfr+i+siteInfoHeaderAfr)).getText().trim();			
			if(infoHeader.equalsIgnoreCase(expHeader)) {
				isPresnt=true;				
				break;
			}			
		}if(!isPresnt) {
			System.out.println(expHeader+ " is expected , but not found.");
			Assert.assertTrue(isPresnt, expHeader);
		}	
		return infoHeader;
	}
	
	public void selectChooseType(String expOption) throws Exception {
		logInfo("Entered into selectChooseType() method.");		
		wdWait("cssSelector", chooseDp);
		clickOnObject("cssSelector", chooseDp);
		boolean isPresnt =false;
		sleep(2000);
		wdWait("cssSelector", chooseOptions);
		List<WebElement> opt= driver.findElements(By.cssSelector(chooseOptions));
		for(WebElement option:opt) {
			String optName=option.getText().trim();			
			if(optName.contains(expOption)) {
				isPresnt=true;
				option.click();
				wdWait("xpath", chooseBtn);
				clickOnButton("xpath", chooseBtn);				
				break;
				
			}
		}if(!isPresnt) {
			Assert.assertTrue(isPresnt, expOption +" is not present.");
		}			
	}
	
	
	public void actionButton(String message , String actionBtnName) throws Exception {
		logInfo("Entered into actionButton() method.");
		wdWait("cssSelector", instContBtn);
		String titleMsg =getText("cssSelector", firmPopup);		
		Assert.assertEquals(titleMsg, message);	
		
		boolean isBtnPresent=false;
		List<WebElement> btn = driver.findElements(By.cssSelector(instContBtn));
		for(WebElement button:btn) {
			String name = button.getText().trim();			
			if(name.equalsIgnoreCase(actionBtnName.trim())) {
				isBtnPresent=true;
				button.click();
				break;
			}
	}if(!isBtnPresent) {		
		Assert.assertTrue(isBtnPresent, actionBtnName+" is not present." );
		
	}
		
	}
	
	public void confirmTypeOfDeviceStatus(String status) throws Exception {
		logInfo("Entered into confirmTypeOfDeviceStatus() method.");
		selectChooseType(forceDeviceBfr);
		if(status.equalsIgnoreCase("Active")) {
			actionButton(firmPopupInactMsg,btnYes);
			confirmModalBox(deviceStatusInActive);
			
		}else if(status.equalsIgnoreCase("Inactive")) {			
			actionButton(firmPopupActMsg,btnYes);
			confirmModalBox(deviceStatusActive);
			
		}
		
	}
	
	public void updateFirmwareVersion(String expVersion) throws Exception {
		logInfo("Entered into updateFirmwareVersion() method.");
		sleep(2000);
		wdWait("xpath", fwVersions);
		List<WebElement> ver= driver.findElements(By.xpath(fwVersions));
		int sizeVer=ver.size();
		boolean isPresent=true;
		for(int i=1;i<=sizeVer;i++) {
			String verName=driver.findElement(By.xpath(fwVersionsBfr+i+fwVersionsAfr)).getText();
			if(verName.equalsIgnoreCase(expVersion)) {
				isPresent=false;				
				WebElement radio=driver.findElement(By.xpath(fwVersionsBfr+i+fwRadioAft));
				radio.click();
				clickOnButton("xpath", fwCancelBtn);	
				Assert.assertTrue(isPresent, expVersion);
				break;
			}			
			
		}if(isPresent) {
			clickOnButton("xpath", fwCancelBtn);	
			
		}
		
	}
	
	public void handle2ndPopupUpdateFW(String expMsg) throws Exception {
		logInfo("Entered into handle2ndPopupUpdateFW() method.");
		String popup2Text=getText("cssSelector", fwConfirm);
		if(popup2Text.equalsIgnoreCase(expMsg)) {
			clickOnButton("cssSelector", alOkBtn);
			sleep(5000);
			
		}else {			
			clickOnButton("cssSelector", cancelBtn);
			clickOnButton("xpath", fwCancelBtn);	
			Assert.assertEquals(popup2Text, expMsg);
		}
		
		
		
	}
	
	
	
	
	public void siteHomeCardsDisabled(String expCardName) throws Exception {
		logInfo("Entered into siteHomeCardsDisabled() method.");		
		wdWait("xpath", disableCards);
		scrollDown("xpath", disableCards);
		boolean isCardPrsnt=false;
		List<WebElement> card= driver.findElements(By.xpath(disableCards));
		for(WebElement cards :card) {
			String cardName=cards.getText().trim();			
			if(cardName.equalsIgnoreCase(expCardName)) {
				isCardPrsnt=true;
				break;
			}
		}if(!isCardPrsnt) {
			Assert.assertTrue(isCardPrsnt,expCardName+ " - card is not present");
		}
	}
	public void verifyZones() throws Exception {
		logInfo("Entered into verifyZones() method.");		
		wdWait("xpath", fwAddzone);
		String zone= getText("xpath", fwAddzone);
		Assert.assertEquals(zone, labAddZone);
		
	}
	
	
	
	/*************   BULK OPERATIONS   ***********/
	
	
	public void bo_validateLabels() throws Exception {
		logInfo("Entered into bo_validateLabels() method.");
		sleep(3000);
		wdWait("cssSelector", siteList);
		String listObj=getText("cssSelector", siteList);		
		String searchOb = getAttribute("xpath", boSearch, attrPlaceHolder);		
		String siteObject=getText("cssSelector", siteFilter);		
		
	}
	
	 public void selectSiteStatus(String expStatus) throws InterruptedException {
		 logInfo("Entered into selectSiteStatus() method."); 
		 clickOnObject("cssSelector", filterDp);
		 sleep(6000);
		 boolean isPresent=false;
		 List<WebElement> opt= driver.findElements(By.xpath(fliterOptions));
		 for(WebElement options :opt) {
			 String optName=options.getText().trim();			
			 if(optName.equalsIgnoreCase(expStatus)) {
				 isPresent=true;
				 options.click();
				 sleep(3000);
				 break;
			 }
		 }if(!isPresent) {
			 Assert.assertTrue(isPresent, expStatus+" is not present");
		 }
		 
		 
	 }
	 
	 public void selectSite(String expSite) throws Exception {
		 logInfo("Entered into gridHeaders() method."); 
		 wdWait("xpath", tabHeaders);
		 boolean isPresent=false;
		 List<WebElement> head= driver.findElements(By.xpath(sitesName));
		 for(int i=1;i<=head.size();i++) {
			 String headerName=driver.findElement(By.xpath(sitesNameBfr+i+sitesNameAft)).getText().trim();
			 if(headerName.equalsIgnoreCase(expSite)) {
				 isPresent=true;
				 List<WebElement> chkBox=driver.findElements(By.xpath(sitesNameBfr+i+sitesChkAft));
				 for(WebElement chkboxes:chkBox) {
					 chkboxes.click();
				 	}
				 break;
			 }
		 }if(!isPresent) {
			 Assert.assertTrue(isPresent, expSite + " site is not found");
			 
		 }
		 
	 }
	 
	 public String retrieveSelectedSite() throws Exception {
		 logInfo("Entered into retrieveSelectedSite() method."); 
		 wdWait("xpath", tabHeaders);		
		 String siteName;
		 int i=1;
		 List<WebElement> sites= driver.findElements(By.xpath(sitesName));		 
		 if(sites.size()==1) {
			 siteName=driver.findElement(By.xpath(sitesNameBfr+i+sitesNameAft)).getText().trim();			 
		 }else {
			 i=TestBase.generateRandomNumberInRange(1, sites.size());				 
			 siteName=driver.findElement(By.xpath(sitesNameBfr+i+sitesNameAft)).getText().trim();			 
		 }		
		 List<WebElement> chkBox=driver.findElements(By.xpath(sitesNameBfr+i+sitesChkAft));
		 for(WebElement chkboxes:chkBox) {
			 chkboxes.click();
				 	} 
		 return siteName;
		 
	 }
	 
	 
	 // verifies is site selected, if checkbox is selected under List of Site Grid 
	 public void isSelectedSite() throws Exception {
		 logInfo("Entered into isSelectedSite() method."); 
		 sleep(5000);
		 wdWait("cssSelector", selectedCount);	
		 int selected = driver.findElements(By.cssSelector(selectedCount)).size();
		 if(selected>=1) {			 
			 String text = driver.findElement(By.cssSelector(selectedCount)).getText().toLowerCase();			
			 Assert.assertTrue(text.contains("site selected"));
		 }else {
			 Assert.assertEquals(selected, 1);
		 }		 
	 }
	 
	 public void verifyOperationTypeOptions(String[] typeOptions) throws Exception {
		 logInfo("Entered into verifyOperationTypeOptions() method."); 
		 sleep(6000);
		 wdWait("xpath", opTypeDp);
		 clickOnObject("xpath", opTypeDp);
		 int expLength=typeOptions.length;	
		 int i=0;
		 boolean isPresent=false;
		 List <WebElement> opt=driver.findElements(By.cssSelector(timeZoneOption));
		 int actLength=opt.size();		 
		 if(expLength==actLength-1) {
			 for(WebElement options:opt) {
				 String opTypeOpt=options.getText().trim();
				 for(;i<expLength;i++) {
					 if(typeOptions[i].equalsIgnoreCase(opTypeOpt)) {						 
						 isPresent=true;						 
						 break;
					 }
				 }if(!isPresent) {					 
					 clickOnObject("cssSelector", firstOption);
					 Assert.assertTrue(isPresent, typeOptions[i]+ " is persent");
				 }
			 }clickOnObject("cssSelector", firstOption);
		 }else {
			 clickOnObject("cssSelector", firstOption);
			 Assert.assertEquals(actLength,expLength);
		 }
		 
		 
	 }
	 
	 
	 public void selectOperationType(String typeOption) throws Exception {
		 logInfo("Entered into selectOperationType() method."); 
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 sleep(7000);		 
		 wdWait("xpath", opTypeDp);
		 WebElement dp= driver.findElement(By.xpath(opTypeDp));
		 //jse.executeScript("arguments[0].click();", dp);
		 clickOnObject("xpath", opTypeDp);		 	 
		 sleep(1000);
		 boolean isPresent=false;
		 wdWait("cssSelector", timeZoneOption);
		 List <WebElement> opt=driver.findElements(By.cssSelector(timeZoneOption));
		 int size=opt.size();		 
			 for(int i=1;i<=size;i++) {				 
				 WebElement opTypeOpt=driver.findElement(By.cssSelector(opTypeBfr+i+opTypeAfr));
				 String opName = opTypeOpt.getText().trim();				 
				 if(opName.equalsIgnoreCase(typeOption)) {
						 isPresent=true;
						 opTypeOpt.click();
						 sleep(3000);
						 clickOnButton("xpath", boSubmit);						 
						 break;
					 }
				 }if(!isPresent) {
					 clickOnObject("cssSelector", firstOption);
					 //clickOnButton("xpath", boSubmit);	
					 Assert.assertTrue(isPresent, typeOption+ " is persent");
				 }
			 }
	 
	 
	 public void wildSearch(String expectedSiteName) throws Exception {
			logInfo("Entered into selectExistingSite() method.");
			String expSiteToLower=expectedSiteName.toLowerCase();
			sleep(6000);
			wdWait("xpath", boSearch);
			clearText("xpath", boSearch);
			enterText("xpath", boSearch,expSiteToLower);
			wdWait("xpath", sitesName);
			List<WebElement> sites= driver.findElements(By.xpath(sitesName));
			sleep(4000);			
			if(sites.size()==0) {
				wdWait("cssSelector", boNoSites);
				String noSiteText=getText("cssSelector", boNoSites);
				if((noSiteText.contains(boNoSitesTextBfr))&& (noSiteText.contains(boNoSitesTextAfr))){
					
				}else {
					Assert.assertEquals(noSiteText, boNoSitesTextBfr+boNoSitesTextAfr);
				}
			}else {			 
			 for(int  i=1;i<=sites.size();i++) {
			 boolean isPresent=false;
			 String siteName=driver.findElement(By.xpath(sitesNameBfr+i+sitesNameAft)).getText().trim().toLowerCase();
			 if(siteName.contains(expSiteToLower)) {
				 isPresent=true;
			 }else{				 
				 Assert.assertTrue(isPresent, expSiteToLower+" does not match");
			 }			
			 }
		
	 }}
	 
	 public void refreshSearch() throws Exception {
		 logInfo("Entered into refreshSearch() method.");
		 wdWait("cssSelector", boCurser);
		 clickOnObject("cssSelector", boCurser);
		 clickOnObject("cssSelector", boCurser);
	 }
	 
	 public double getFWVersion() throws Exception{
			logInfo("Entered into getFWVersion() method.");
			String [] fullVersionDetails=getCustomDetails(devFWVer).split("\\.");	
			String versionOrg= fullVersionDetails[0];
			double version=Double.parseDouble(versionOrg);
			return version;
		}
	 
	 public String getTimeZone() throws Exception {
		 logInfo("Entered into getTimeZone() method.");
		 String country = null;
		 String time =getCustomDetails(siteTimeZone);		 
		 String[] split = time.split("/");			 
		 if(split[0].length()>2) {
			 country=split[0].substring(0,1).toUpperCase()+split[0].substring(1).toLowerCase();
			 }else if(split[0].length()==2){
				 country=split[0].substring(0,2).toUpperCase();
			 }
		 String zone = split[1].substring(0,1).toUpperCase()+split[1].substring(1).toLowerCase();		
		 time = country+"/"+zone;		 
		 return time;
	 }
	 
	 public String getSelectedTimeZone() throws Exception {
		 logInfo("Entered into getSelectedTimeZone() method.");
		 wdWait("xpath", selectedTimeZone);
		 String time=getText("xpath", selectedTimeZone);
		 return time;
		 
	 }
		
	 public String getFirmwareHeaders(String expTableHeader) throws Exception {
			logInfo("Entered into getFirmwareHeaders() method.");		
			wdWait("xpath", sp_FirmwareTableData);
			
			int infoSize=driver.findElements(By.xpath(sp_FirmwareTableData)).size();
			String infoHeader = null;
			sleep(5000);
			boolean isPresnt =false;
			for(int i=1;i<=infoSize;i++) {
				 infoHeader=driver.findElement(By.xpath(sp_FirmwareFirst+i+sp_FirmwareLast)).getText().trim();
				if(infoHeader.equalsIgnoreCase(expTableHeader)) {
					isPresnt=true;				
					break;
				}			
			}if(!isPresnt) {
				Assert.assertTrue(isPresnt, expTableHeader);
			}
			
			return infoHeader;
		}
		 
	 public String getDeviceDetailsHeader(String expTableHeader) throws Exception {
			logInfo("Entered into getDeviceDetailsHeader() method.");		
			wdWait("xpath", sp_deviceDetailsTable);
			
			int infoSize=driver.findElements(By.xpath(sp_deviceDetailsTable)).size();
			String infoHeader = null;
			sleep(5000);
			boolean isPresnt =false;
			for(int i=1;i<=infoSize;i++) {
				 infoHeader=driver.findElement(By.xpath(sp_deviceDetailsdataBefore+i+sp_deviceDetailsdataAfter)).getText().trim();
				if(infoHeader.equalsIgnoreCase(expTableHeader)) {
					isPresnt=true;				
					break;
				}			
			}if(!isPresnt) {
				Assert.assertTrue(isPresnt, expTableHeader);
			}
			
			return infoHeader;
		}
		 
	 public String getAddNotificationTableHeaders(String expNotificationHeader) throws Exception {
			logInfo("Entered into getAddNotificationTableHeaders() method.");		
			wdWait("xpath", sp_AddNoticationTableData);
			
			int infoSize=driver.findElements(By.xpath(sp_AddNoticationTableData)).size();
			String infoHeader = null;
			sleep(5000);
			boolean isPresnt =false;
			for(int i=1;i<=infoSize;i++) {
				 infoHeader=driver.findElement(By.xpath(sp_AddNotificationStart+i+sp_AddNotificationEnd)).getText().trim();
				if(infoHeader.equalsIgnoreCase(expNotificationHeader.trim())) {
					isPresnt=true;				
					break;
				}			
			}if(!isPresnt) {
				Assert.assertTrue(isPresnt, expNotificationHeader);
			}
			
			return infoHeader;
		}
		 
	 public String getMoistureDetails(String expmoistureHeader) throws Exception {
			logInfo("Entered into getMoistureDetails() method.");		
			wdWait("xpath", sp_moistureProbeTableHeaders);			
			int infoSize=driver.findElements(By.xpath(sp_moistureProbeTableHeaders)).size();
			String infoHeader = null;
			sleep(5000);
			boolean isPresnt =false;
			for(int i=1;i<=infoSize;i++) {
				 infoHeader=driver.findElement(By.xpath(sp_MoistureProbeStart+i+sp_MoistureProbEnd)).getText().trim();
				if(infoHeader.equalsIgnoreCase(expmoistureHeader.trim())) {
					isPresnt=true;				
					break;
				}			
			}if(!isPresnt) {
				Assert.assertTrue(isPresnt, expmoistureHeader);
			}
			
			return infoHeader;
		}
		 
	 public String getMoisturegatewayDetails(String expMoistureGatwayHeader) throws Exception {
			logInfo("Entered into getMoisturegatewayDetails() method.");		
			wdWait("xpath", sp_moistureGatewayTableHeaders);			
			int infoSize=driver.findElements(By.xpath(sp_moistureGatewayTableHeaders)).size();
			String infoHeader = null;
			sleep(5000);
			boolean isPresnt =false;
			for(int i=1;i<=infoSize;i++) {
				 infoHeader=driver.findElement(By.xpath(sp_MoistureDataStarting+i+sp_MoistureDataEnding)).getText().trim();
				if(infoHeader.equalsIgnoreCase(expMoistureGatwayHeader.trim())) {
					isPresnt=true;				
					break;
				}			
			}if(!isPresnt) {
				Assert.assertTrue(isPresnt, expMoistureGatwayHeader);
			}
			
			return infoHeader;
		}
	 
	 public double rainChanceOfSiteConfig() throws Exception {
		 logInfo("Entered into rainChanceOfSiteConfig() method.");	
		 double expRain =0.00;		
		 String getrain = null;
		 String weather=getCustomDetails(weatherSource);
		 System.out.println("weather : "+weather);
		 if((weather.equalsIgnoreCase(weatherIBM))|| (weather.equalsIgnoreCase(weatherHyb)) ) {
			 getrain =getCustomDetails(chanceOfRain);	
			 System.out.println("rain :"+getrain);		
			
		 }else if(weather.equalsIgnoreCase(weatCSI)) {	
			 getrain =getCustomDetails(rainInches);	
			 System.out.println("rain :"+getrain);	
			 
		 } 
		 expRain = Double.parseDouble(getrain);
		  
		 return expRain;
	 }
	 
	 public int windSpeedOfSiteConfig() throws Exception {
		 logInfo("Entered into windSpeedOfSiteConfig() method.");	
		 String wind =getCustomDetails(windSpeed);		 
		 int expWind=Integer.parseInt(wind);
		 return expWind;
	 }
	 
	 public void BO_WateringDelay() throws Exception{
		 logInfo("Entered into BO_WateringDelay() method.");
		 sleep(2000);
			selectHours(select_6);
			sleep(2000);
			clickOnButton("xpath", zonDetFlowOk);
	 }
	 public void viewAllRecentActivities() throws Exception{
		 logInfo("Entered into viewAllRecentActivities() method.");
		 sleep(1000);
		 wdWait("xpath", viewAllRecentActivities);
		 clickOnObject("xpath" , viewAllRecentActivities);
	 }
	 
	 public int verifyDataFromMatcard(int cards,String expData) throws Exception {
		 logInfo("Entered into verifyDataFromMatcard() method.");
		 sleep(1000);
		 int i=0;
		 boolean isPresent=false;
		 for( i=1;i<=cards;i++) {
			 WebElement data=driver.findElement(By.xpath(recentActivityReasonStart+i+reasonEnd));
			 String getData=data.getText().trim();
			 System.out.println(getData);
			 if(getData.contains(expData)) {
				 isPresent=true;
				 break;
			 }
			 if(!isPresent) {
				 Assert.assertTrue(isPresent,expData+ ": is not found");
			 }
		 }
		 return i; 	 
	 }
	 public void selectExactPacket(int i,String expVal)throws Exception{
		 logInfo("Entered into selectExactPacket() method.");
		 sleep(1000);
		 boolean isPacketPresent=false;
		 WebElement packet=driver.findElement(By.xpath(recentActivityReasonStart+i+packetEnd));
		 String ActPacket=packet.getText().trim();
		 if(ActPacket.equalsIgnoreCase(expVal)) {
			 packet.click();
			 isPacketPresent=true;
		 }
		 if(!isPacketPresent) {
			 Assert.assertTrue(isPacketPresent,expVal+ ": is not found");
		 }
		 
	 }
	 public void selectDateToSkip() throws Exception{
		 logInfo("Entered into selectDateToSkip() method.");
		 sleep(1000);
		 wdWait("xpath", datepicker);
		 clickOnObject("xpath", datepicker);
		 sleep(1000);
		 wdWait("xpath",skipDate);
		 clickOnObject("xpath", skipDate);
		 sleep(1000);
		String date=driver.findElement(By.xpath(skipInputDate)).getText();
		 
	 }		 

	 public void closeRecentActivities() throws Exception{
		 logInfo("Entered into selectDateToSkip() method.");
		 sleep(1000);
		 clickOnObject("xpath", closeIcon);
		  
	 }
	 public void clickOnSubmit() throws Exception{
		 logInfo("Entered into clickOnSubmit() method.");
		 sleep(1000);
		 clickOnButton("xpath", boSubmit);
		  
	 }

}
