package smrtRain.advanceConfig;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.lib.TestBase;

import smrtRain.sites.SiteMethods;

public class AdvanceConfigMethods extends SiteMethods{
	private static DecimalFormat decFormat = new DecimalFormat("#.##");
	
	public void createAdvanceZone(String zoneName) throws Exception {
		logInfo("Entered into createAdvanceZone() method.");		
		String leamedFlow= TestBase.generateRandomNumberInRange(-4, 9)+"";		
//		wdWait("cssSelector", addZone);
//		clickOnButton("cssSelector", addZone);
//		sleep(7000);	
		selectZoneButton(zoneHeaderTile);
		waitTilldisableOfElement(5);
		clearText("xpath", zoneNameField);
		//clickOnObject("xpath", zoneNameField);
		enterText("xpath", zoneNameField,zoneName);
//		clearText("name", zoneCurrentFlow);
//		clearText("name", zoneLeamedFlow);
//		clearText("name", zonePercntFlow);
		enterText("name", zoneCurrentFlow, FlowRate);
		
		enterText("name", zoneLeamedFlow,leamedFlow);		
		
		enterText("name", zonePercntFlow, "20");		
	}
	
	
	
	/**********All label validations
	 * @throws Exception **********/
	public void validateLabels() throws Exception {
		logInfo("Entered into validateLabels() method.");
		SoftAssert sa= new SoftAssert();
		wdWait("cssSelector", advTitle);
		String title= getText("cssSelector", advTitle);
		sa.assertEquals(title, advConfText);
		String actHelpText= getText("cssSelector", infoHelp);
		sa.assertEquals(actHelpText, helptext);		
		sa.assertAll();
		
	}
	
	public void handleRunTimeAlert(String okOrCancel) throws Exception {
		logInfo("Entered into handleRunTimeAlert() method.");
		SoftAssert sa= new SoftAssert();
		wdWait("xpath", advConfigPopupTitle);
		String title= getText("xpath", advConfigPopupTitle);
		sa.assertEquals(title, advRunTimeAlert);
		String actRTDesc= getText("cssSelector", skipConfMsg);
		sa.assertEquals(actRTDesc, advRuntimeDescb);
		boolean isPresent=false;
		List<WebElement> btns=driver.findElements(By.cssSelector(alOkBtn));
		for(WebElement button:btns) {
			String btnName=button.getText().trim();
			if(btnName.equalsIgnoreCase(okOrCancel)) {
				isPresent=true;
				button.click();
				waitTilldisableOfElement(2);
				break;
			}
		}if(!isPresent) {
			Assert.assertTrue(isPresent, okOrCancel+" is not present");
		}
		
		sa.assertAll();		
	}
	
	public void subHeaders(String expSubHeader) throws Exception {
		logInfo("Entered into subHeaders() method.");
		sleep(10000);
		wdWait("cssSelector", advConfSubtitles);
		List<WebElement> label= driver.findElements(By.cssSelector(advConfSubtitles));
		sleep(5000);
		boolean isHeaderPresent=false;
		for(WebElement subHead:label) {		
			String actSubHeader=subHead.getText().trim();			
			if(actSubHeader.contains(expSubHeader)) {
					isHeaderPresent=true;
					subHead.click();
					break;
				}
			}if(isHeaderPresent==false) {
				closeAdvanceConfigPopup();
				closeZone();					
				Assert.assertEquals(isHeaderPresent, expSubHeader);
			 }			
	}
	
	public void sideHeaders(String expSideHeader) throws Exception {
		logInfo("Entered into sideHeaders() method.");
		wdWait("cssSelector", advSideHeaders);
		List<WebElement> label= driver.findElements(By.cssSelector(advSideHeaders));
		boolean isHeaderPresent=false;
		for(WebElement subHead:label) {		
			String actSubHeader=subHead.getText().trim();
			if(actSubHeader.equals(expSideHeader)) {
					isHeaderPresent=true;
					//subHead.click();
					break;
				}
			}if(isHeaderPresent==false) {
				Assert.assertTrue(isHeaderPresent, expSideHeader+ " is not found");
			 }			
	}

	public void verifyOptionsInOptions(String stepperType,int expNoOfOptions, String[] expOptions) throws Exception {
		logInfo("Entered into verifyOptionsInOptions() method.");
		int j=0;
		if(stepperType=="soilType") {
			j=0;
			
		}else if(stepperType=="plantType") {
			j=1;
		}
		wdWait("xpath", listBfr+j+listAft);
		List<WebElement> radioBtns= driver.findElements(By.xpath(listBfr+j+listAft));		
		int actSize=radioBtns.size();	
		if(actSize==expNoOfOptions) {
			boolean isOptionPresent =false;
			for(WebElement radio:radioBtns) {
				String btnName =radio.getText().trim();
				for(int i=0;i<expNoOfOptions;i++) {
					if(expOptions[i].equalsIgnoreCase(btnName)) {
						isOptionPresent=true;
						break;						
					}					
				}if(!isOptionPresent) {
					Assert.assertEquals(isOptionPresent, btnName+" is not present");
			}				
		}
			
		}else {
			Assert.assertEquals(actSize, expNoOfOptions+" does not match.");
		}
		
	}
	
	public void verifyOptionsInSoilType(int expNoOfOptions, String[] expOptions) throws InterruptedException {
		logInfo("Entered into verifyOptionsInSoilType() method.");
		List<WebElement> radioBtns= driver.findElements(By.xpath(soilTypList));		
		int actSize=radioBtns.size();	
		if(actSize==expNoOfOptions) {			
			boolean isOptionPresent =false;
			for(WebElement radio:radioBtns) {
				String btnName =radio.getText().trim();				
				for(int i=0;i<actSize-1;i++) {					
					if(expOptions[i].equalsIgnoreCase(btnName)) {						
						isOptionPresent=true;
						radio.click();
						break;						
					}					
				}if(!isOptionPresent) {
					Assert.assertEquals(isOptionPresent, btnName+" is not present");
			}				
		}
			
		}else {
			Assert.assertEquals(actSize, expNoOfOptions+" does not match.");
		}
		
	}	
	
	public void verifyOptionsInRootDepth(int expNoOfOptions, String[] expOptions) throws InterruptedException {
		logInfo("Entered into verifyOptionsInRootDepth() method.");
		List<WebElement> radioBtns= driver.findElements(By.xpath(rootList));		
		int actSize=radioBtns.size();			
		if(actSize==expNoOfOptions) {
			boolean isOptionPresent =false;
			for(WebElement radio:radioBtns) {
				String btnName =radio.getText().trim();				
				for(int i=0;i<expNoOfOptions;i++) {
					if(expOptions[i].equalsIgnoreCase(btnName)) {
						isOptionPresent=true;						
						radio.click();						
						break;						
					}					
				}if(!isOptionPresent) {
					Assert.assertEquals(isOptionPresent, btnName+" is not present");
			}				
		}
			
		}else {
			Assert.assertEquals(actSize, expNoOfOptions+" does not match.");
		}
		
	}	
	
	public void verifyOptionsInMicroClimate(int expNoOfOptions, String[] expOptions) throws Exception {
		logInfo("Entered into verifyOptionsInMicroClimate() method.");
		List<WebElement> radioBtns= driver.findElements(By.xpath(microList));		
		int actSize=radioBtns.size();	
		if(actSize==expNoOfOptions) {
			boolean isOptionPresent =false;
			for(WebElement radio:radioBtns) {
				String btnName =radio.getText().trim();
				for(int i=0;i<expNoOfOptions;i++) {
					if(expOptions[i].equalsIgnoreCase(btnName)) {
						isOptionPresent=true;
						radio.click();
						break;						
					}					
				}if(!isOptionPresent) {
					clickOnObject("cssSelector", closeAdvConfig);
					confirmSaveChanges(saveChangesText);
					Assert.assertEquals(isOptionPresent, btnName+" is not present");
			}				
		}
			
		}else {
			clickOnObject("cssSelector", closeAdvConfig);
			confirmSaveChanges(saveChangesText);
			Assert.assertEquals(actSize, expNoOfOptions+" does not match.");
		}
		
	}	
	public void verifyOptionsInSlope(int expNoOfOptions, String[] expOptions) throws InterruptedException {
		logInfo("Entered into verifyOptionsInSlope() method.");
		List<WebElement> radioBtns= driver.findElements(By.xpath(slopeList));		
		int actSize=radioBtns.size();	
		if(actSize==expNoOfOptions) {
			boolean isOptionPresent =false;
			for(WebElement radio:radioBtns) {
				String btnName =radio.getText().trim();
				for(int i=0;i<expNoOfOptions;i++) {
					if(expOptions[i].equalsIgnoreCase(btnName)) {
						isOptionPresent=true;
						radio.click();
						break;						
					}					
				}if(!isOptionPresent) {
					Assert.assertEquals(isOptionPresent, btnName+" is not present");
			}				
		}
			
		}else {
			Assert.assertEquals(actSize, expNoOfOptions+" does not match.");
		}
		
	}	
	
	public void verifyOptionsInIrrigationType(int expNoOfOptions, String[] expOptions) throws Exception {
		logInfo("Entered into verifyOptionsInIrrigationType() method.");
		Thread.sleep(7000);
		wdWait("xpath", irrigationList);
		List<WebElement> radioBtns= driver.findElements(By.xpath(irrigationList));		
		int actSize=radioBtns.size();	
		if(actSize==expNoOfOptions) {
			boolean isOptionPresent =false;
			for(WebElement radio:radioBtns) {
				String btnName =radio.getText().trim();
				for(int i=0;i<expNoOfOptions;i++) {
					if(expOptions[i].equalsIgnoreCase(btnName)) {
						isOptionPresent=true;
						break;						
					}					
				}if(!isOptionPresent) {
					Assert.assertEquals(isOptionPresent, btnName+" is not present");
			}				
		}
			
		}else {
			Assert.assertEquals(actSize, expNoOfOptions+" does not match.");
		}
		
	}
	
	public void selectOptionUnderStepper(String selectradioBtn) throws Exception {
		logInfo("Entered into selectOptionUnderStepper() method.");
		sleep(2000);
		wdWait("cssSelector", advSoilType);
		List<WebElement> radioBtns= driver.findElements(By.cssSelector(advSoilType));
		boolean isRadioBtnPresent =false;
		for(WebElement radio:radioBtns)	{
			String btnName =radio.getText().trim();		
			if(btnName.equalsIgnoreCase(selectradioBtn)) {
				isRadioBtnPresent=true;
				radio.click();
				Thread.sleep(1000);
				break;
			}			
		}if(isRadioBtnPresent=false) {
			Assert.assertTrue(isRadioBtnPresent, selectradioBtn+" is not present to select");
		}	
		
	}
	
	
	public void isSelectedSoilType(String selectedSoilType) throws Exception {
		logInfo("Entered into isSelectedSoilType() method.");
		wdWait("cssSelector", advTitle);
		clickOnObject("cssSelector", advTitle);
	    boolean isselected =false;
		wdWait("xpath", advSelectedRadio);
		List<WebElement> radioBtns= driver.findElements(By.xpath(advSelectedRadio));
		for(WebElement seletedRadio:radioBtns) {			
			String name= seletedRadio.getText().trim();
			if(name.equalsIgnoreCase(selectedSoilType)) {
				isselected=true;
				break;				
			}
		}if(!isselected) {
			sideHeaders(advSoil);
			Assert.assertTrue(isselected, selectedSoilType+" is not selected");
		}
		
	}
	
	public void validateFollowInstructions1stQuestion(String firstInstructionSub) throws Exception {
		logInfo("Entered into validateFollowInstructions1stQuestion() method.");
			SoftAssert sa= new SoftAssert();
			try {
				wdWait("cssSelector", infoHelpClikHere);
				clickOnObject("cssSelector", infoHelpClikHere);
				String subHeader=getText("cssSelector", followInstrSubheader);
				sa.assertEquals(subHeader,firstInstructionSub);
				Thread.sleep(3000);
				wdWait("cssSelector", instrDescrb);
				String decrib =getText("cssSelector", instrDescrb);				
				sa.assertEquals(decrib, instrDescrbText);				
				clickOnObject("cssSelector", instClose);				
				}catch(Exception ex) {
					clickOnObject("cssSelector", instClose);
					ex.printStackTrace();				
				}			
				sa.assertAll();			
		}
	
	
	
	/****Select Determine SoilType link and continue with 1st questionnaire    ******************/
	public void continueFollowInstructions1stQuestion() throws Exception {
		logInfo("Entered into continueFollowInstructions1stQuestion() method.");			
				wdWait("cssSelector", infoHelpClikHere);
				clickOnObject("cssSelector", infoHelpClikHere);
				waitTilldisableOfElement(5);
				wdWait("cssSelector", instrDescrb);
				actionButton(btnContinue,descSoilRemainBall);

		}
	
	/*****click either Continue or Yes or No buttons and also verify next description too.
	 * @throws Exception *****/
	public void actionButton(String actionBtnName, String expDescription) throws Exception {
		logInfo("Entered into actionButton() method.");	
		wdWait("cssSelector", instContBtn);
		boolean isBtnPresent=false;
		List<WebElement> btn = driver.findElements(By.cssSelector(instContBtn));
		for(WebElement button:btn) {
			String name = button.getText().trim();
			boolean isDescPresent=false;
			if(name.equalsIgnoreCase(actionBtnName.trim())) {
				isBtnPresent=true;
				button.click();
				Thread.sleep(2000);				
				wdWait("cssSelector", instrDescrb);
				String actDescp=getText("cssSelector", instrDescrb);
				if(actDescp.equalsIgnoreCase(expDescription)) {
					isDescPresent=true;
					Assert.assertEquals(actDescp, expDescription);
					break;					
				}if(!isDescPresent) {
					wdWait("cssSelector", instClose);
					clickOnObject("cssSelector", instClose);
//					wdWait("cssSelector", closeAdvConfig);
//					clickOnObject("cssSelector", closeAdvConfig);
//					clickOnObject("xpath", btnCloseZone);
					Assert.assertEquals(actDescp, expDescription);	
				}
							
				break;
			}
		}if(!isBtnPresent) {
			wdWait("cssSelector", instClose);
			clickOnObject("cssSelector", instClose);
//			wdWait("cssSelector", closeAdvConfig);
//			clickOnObject("cssSelector", closeAdvConfig);
//			clickOnObject("xpath", btnCloseZone);			
			Assert.assertTrue(isBtnPresent,actionBtnName+" button is not present" );
		}		
	}
	
	public void actionButton(String actionBtnName) throws Exception {
		logInfo("Entered into actionButton() method.");	
		wdWait("cssSelector", instContBtn);
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
			wdWait("cssSelector", instClose);
			clickOnObject("cssSelector", instClose);
			wdWait("cssSelector", closeAdvConfig);
			clickOnObject("cssSelector", closeAdvConfig);
			Assert.assertTrue(isBtnPresent,actionBtnName+" button is not present" );
		}		
	}
	
	public void identifySoilType(String expSoilType) throws Exception {
		logInfo("Entered into identifySoilType() method.");	
		try {
			wdWait("cssSelector", descDetSoilType);
			String actSoilType= getText("cssSelector", descDetSoilType);
			Assert.assertEquals(actSoilType, expSoilType);
			actionButton(btnOk);
		}catch(Exception ex) {
			actionButton(btnOk);
			ex.getStackTrace();
		}
				
	}
	
   public void verifyDefaultValuesOfIrrigationType(String expIrrType) throws Exception {
	   logInfo("Entered into verifyDefaultValuesOfIrrigationType() method.");
	   	wdWait("xpath", irrigationList);
		List<WebElement> radioBtns= driver.findElements(By.xpath(irrigationList));	
		boolean isPresent=false;
		for(WebElement btnLab:radioBtns) {
			String name =btnLab.getText().trim();
			if(name.equalsIgnoreCase(expIrrType)) {
				isPresent=true;
				btnLab.click();
				Thread.sleep(9000);
				waitTilldisableOfElement(10);
				wdWait("name", irrAdvHeads);
				String actHeads=getText("name", irrAdvHeads);
				String actNozzles=getText("name", irrAdvNozzles);				
				switch(expIrrType) {
				case "Drip":
					Assert.assertEquals(actHeads, "1");
					Assert.assertEquals(actNozzles, "10");
					break;
					
				case "Rotor":
					Assert.assertEquals(actHeads, "15");
					Assert.assertEquals(actNozzles, "3");					
					break;
					
				case "Spray":
					Assert.assertEquals(actHeads, "20");
					Assert.assertEquals(actNozzles, "1.75");					
					break;				
				}		
				
				break;				
			}
		}if(!isPresent) {
			Assert.assertTrue(isPresent,expIrrType+ "is not found");
		}
	   
	   
   }   
   
   public void selectManufacturerDetails(String locatorElement,String option) throws Exception {
	   logInfo("Entered into selectManufacturerDetails() method.");
	   Thread.sleep(1000);
	   String element=irrElementArrBfr+locatorElement+irrElementArrAfr;
	   wdWait("xpath", element);
	   clickOnObject("xpath", element);
	   wdWait("xpath", irrManuList);
	   List<WebElement> dpList=driver.findElements(By.cssSelector(irrManuList));
	   boolean isPresent=false;
		for(WebElement options:dpList) {
			String optName=options.getText().trim();
			if(optName.equalsIgnoreCase(option)) {
				isPresent=true;
				options.click();
				break;
			}
		}if(isPresent==false) {
			Assert.assertTrue(isPresent, option);
		}
   }  
   
     public void selectNozzle(String nozzleHeader) throws Exception {
	   logInfo("Entered into selectNozzle() method.");
	   SoftAssert sa = new SoftAssert();	   
	   sleep(5000);
	   wdWait("cssSelector", manufactHeadre);
	   String header=getText("cssSelector", manufactHeadre);	   
	   sa.assertEquals(header, nozzleHeader);
	   
	   List<WebElement> radio=driver.findElements(By.xpath(manuDetails));
	   int radioSize=radio.size();
	   System.out.println("size is "+radioSize);
	   if(!(radioSize==0)) {
		   for(WebElement rad:radio) {
			   System.out.println("select one ");
			   threadSleep(2000);
			   rad.click();
			   break;
		   } 
	   }else {
		   Assert.assertEquals(radioSize,"should not be zero" );
	   }
	   
	   
   }
   
   public String optRunTime() throws Exception {
	   logInfo("Entered into optRunTime() method.");
	   SoftAssert sa = new SoftAssert();
	   wdWait("cssSelector", calTitle);
	   String title= getText("xpath", calTitle);
	   
	   sa.assertEquals(title, optLabel);
	   String calculatedTime= getText("cssSelector", calTime);	
	   
	   clickOnButton("cssSelector", timeApply);
	   wdWait("xpath", appliedTime);
	   String appTime= getText("xpath", appliedTime);
	 
//	   wdWait("cssSelector", adVAdd);
//	   clickOnButton("cssSelector", adVAdd);
	   
	   return calculatedTime;
	   
   }
	
	
	public void irrigationAmount() throws Exception {
	logInfo("Entered into irrigationAmount() method.");
	wdWait("xpath", irrAmtLabel);
	String actLabel = getText("xpath", irrAmtLabel);
	Assert.assertEquals(actLabel, irrAmtText);	
	}
	
	public void baseRunTimeSubTabs(String expTab) throws InterruptedException {
	logInfo("Entered into baseRunTimeSubTabs() method.");
		boolean isPresent=false;
		List<WebElement> subTab=driver.findElements(By.cssSelector(baseRunTabs));
		for(WebElement tabName: subTab) {
			String actName=tabName.getText().trim();			
			if(actName.contains(expTab)) {
				isPresent=true;
				tabName.click();
				Thread.sleep(1000);
				break;
			}
		}if(!isPresent) {
			Assert.assertTrue(isPresent, expTab+ " is not found");
		}
	}
	
	
	public void precipitationRateRadios(String expRadioBtn) {
		logInfo("Entered into precipitationRateRadios() method.");
			boolean isPresent=false;
			List<WebElement> subTab=driver.findElements(By.xpath(precipRadios));
			for(WebElement tabName: subTab) {
				String actName=tabName.getText().trim();			
				if(actName.contains(expRadioBtn)) {
					isPresent=true;
					tabName.click();
					break;
				}
			}if(!isPresent) {
				Assert.assertTrue(isPresent, expRadioBtn+ " is not found");
			}
		}
	
	
	public String getSelectedSoilType() throws Exception {
		logInfo("Entered into getSelectedSoilType() method.");		   
		wdWait("xpath", getSoilTypeItem);
		String soilType= getText("xpath", getSoilTypeItem);		
		return soilType;
	}		
	
	public double calculateTotalIrrigationAmt(int rootDepth) throws Exception {
		logInfo("Entered into calculateTotalIrrigationAmt() method.");
		//Irrigation Amount = (available water * root depth) * (managed allow depletion/100)		
		double irrAmt=(getSoilWater()*rootDepth)*depletionPercentage();		
		String irrigation= decFormat.format(irrAmt);		
		double irrigationAmt=Double.parseDouble(irrigation);
		return irrigationAmt;
		
	}
	
	public double getSoilWater() throws Exception {
	logInfo("Entered into getSoilWater() method.");	
	double watering=0;
	String soilName=getSelectedSoilType();	
	if(soilName.contentEquals("Clay")) {
		watering=0.14;		
	}else if(soilName.equalsIgnoreCase("Clay Loam")) {
		watering=0.16;	
		
	}else if(soilName.equalsIgnoreCase("Fine Sand")) {
		watering=0.05;	
		
	}else if(soilName.equalsIgnoreCase("Loam")) {
		watering=0.16;	
		
	}else if(soilName.equalsIgnoreCase("Loamy Sand")) {
		watering=0.07;	
		
	}else if(soilName.equalsIgnoreCase("Sand")) {
		watering=0.05;	
		
	}else if(soilName.equalsIgnoreCase("Sandy Clay")) {
		watering=0.12;	
		
	}else if(soilName.equalsIgnoreCase("Sandy Clay Loam")) {
		watering=0.15;	
		
	}else if(soilName.equalsIgnoreCase("Sandy Loam")) {
		watering=0.11;	
		
	}else if(soilName.equalsIgnoreCase("Silt")) {
		watering=0.2;	
		
	}else if(soilName.equalsIgnoreCase("Silt Loam")) {
		watering=0.2;	
		
	}else if(soilName.equalsIgnoreCase("Silty Clay")) {
		watering=0.15;	
		
	}else if(soilName.equalsIgnoreCase("Silty Clay Loam")) {
		watering=0.18;	
		
	}
	else {
		Assert.assertNull(soilName);
	}	
	return watering;	
		
	}
	public float depletionPercentage() throws Exception {
	logInfo("Entered into depletionPercentage() method.");	
		String soilName=getSelectedSoilType();
		float expDepValue=0.00f;
		if(soilName.contentEquals("Clay")) {
			expDepValue=(float)30/100;		
		}else if(soilName.equalsIgnoreCase("Silty Clay")) {
			expDepValue=(float)40/100;	
			
		}else if(soilName.equalsIgnoreCase("Sandy Loam")||(soilName.equalsIgnoreCase("Sandy Clay Loam"))
				||(soilName.equalsIgnoreCase("Sandy Clay"))||(soilName.equalsIgnoreCase("Loam"))
				||(soilName.equalsIgnoreCase("Slit"))||(soilName.equalsIgnoreCase("Clay Loam"))		
				||(soilName.equalsIgnoreCase("Silty Clay Loam"))||(soilName.equalsIgnoreCase("Silt Loam"))
				||(soilName.equalsIgnoreCase("Fine Sand")))	
			{
			expDepValue=(float)50/100;				
		}else if(soilName.equalsIgnoreCase("Sand")||(soilName.equalsIgnoreCase("Loamy Sand"))) {
			expDepValue=(float)60/100;			
		}		
		return expDepValue;
		
	}
	
	
	public double getBaseRunTime() throws Exception {
		logInfo("Entered into getBaseRunTime() method.");			
		wdWait("cssSelector", baseValue);
		String getBase=getText("cssSelector", baseValue);		
		String split[]= getBase.split(" ");		
		double runtime=Double.parseDouble(split[0]);
		return runtime;
		
	}
	
	public String getIrrTypeEfficiency() throws Exception {
		logInfo("Entered into getIrrTypeEfficiency() method.");
		wdWait("xpath", irrEffType);
		String irrType=getText("xpath", irrEffType);
		return irrType;
	}
	
	public void efficiencyType(String effDropDown) throws Exception {
	  logInfo("Entered into efficiencyType() method.");
	   wdWait("xpath", irrEfficiencyArrow);
	   clickOnObject("xpath", irrEfficiencyArrow);
	   wdWait("xpath", irrManuList);
	   List<WebElement> dpList=driver.findElements(By.cssSelector(irrManuList));
	   boolean isPresent=false;
		for(WebElement options:dpList) {
			String optName=options.getText().trim();
			if(optName.equalsIgnoreCase(effDropDown)) {
				isPresent=true;
				options.click();
				break;
			}
		}if(isPresent==false) {
			Assert.assertTrue(isPresent, effDropDown);
		}	
	}
	
	
	public double runTimeMultiplier(String irrigationType, String efficiency) {
		logInfo("Entered into runTimeMultiplier() method.");
		double rtMultiplier=0.00;
		if((efficiency.equalsIgnoreCase(effXclent) && irrigationType.equalsIgnoreCase(irrDrip)) ||
		   (efficiency.equalsIgnoreCase(effXclent) && irrigationType.equalsIgnoreCase(irrRotor))){
			rtMultiplier=1.14f;
			
		 }else if(efficiency.equalsIgnoreCase(effXclent) && irrigationType.equalsIgnoreCase(irrSpray)){
			rtMultiplier=1.18f;
			
		}else if((efficiency.equalsIgnoreCase(veryGood) && irrigationType.equalsIgnoreCase(irrDrip)) ||
				(efficiency.equalsIgnoreCase(veryGood) && irrigationType.equalsIgnoreCase(irrRotor))){
			rtMultiplier=1.22f;
			
		}else if((efficiency.equalsIgnoreCase(veryGood) && irrigationType.equalsIgnoreCase(irrSpray))||
				 (efficiency.equalsIgnoreCase(good) && irrigationType.equalsIgnoreCase(irrDrip))||
				 (efficiency.equalsIgnoreCase(good) && irrigationType.equalsIgnoreCase(irrRotor))){
			rtMultiplier=1.27f;
			
		}else if(efficiency.equalsIgnoreCase(fair) && irrigationType.equalsIgnoreCase(irrRotor)){
			rtMultiplier=1.32f;
			
		}else if((efficiency.equalsIgnoreCase(good) && irrigationType.equalsIgnoreCase(irrSpray))||
				 (efficiency.equalsIgnoreCase(fair) && irrigationType.equalsIgnoreCase(irrDrip))){
			rtMultiplier=1.37f;
			
		}else if((efficiency.equalsIgnoreCase(fair) && irrigationType.equalsIgnoreCase(irrSpray))||
				 (efficiency.equalsIgnoreCase(poor) && irrigationType.equalsIgnoreCase(irrDrip))||
				 (efficiency.equalsIgnoreCase(poor) && irrigationType.equalsIgnoreCase(irrRotor))){
			rtMultiplier=1.43f;
			
		}else if(efficiency.equalsIgnoreCase(poor) && irrigationType.equalsIgnoreCase(irrSpray)){
			rtMultiplier=1.56f;
			
		}else {
			rtMultiplier=0.00f;
			Assert.assertNotNull("expected combination is not defined");			
		}		
		
		return rtMultiplier;
		
	}
	
	
	public double calculateEfficiencyAdjustment(double baseRunTime, double rtMultiplier ) {
		logInfo("Entered into calculateEfficiencyAdjustment() method.");		
		double effAdjust= (baseRunTime * rtMultiplier)- baseRunTime;	
		String effAdjustment=decFormat.format(effAdjust);		
		double efficncyAdjustment=Double.parseDouble(effAdjustment);	
		return efficncyAdjustment;
	
	}
	
	public void validateEfficiencyAdjustment(String expEffAdjust) throws Exception {
		logInfo("Entered into validateEfficiencyAdjust() method.");
		sleep(2000);
		wdWait("cssSelector", effAdjValue);
		String actEff= getText("cssSelector", effAdjValue);
		if(!(actEff.equals(expEffAdjust))){
			System.out.println("small minutes");
			closeZonePopupWindow();	
			closeZone();
			Assert.assertEquals(actEff, expEffAdjust);
			
		}else {
			Assert.assertEquals(actEff, expEffAdjust);
		}
	}
	
	public double validateEfficiencyAdjust(double expEfficiency) throws Exception {
		logInfo("Entered into validateEfficiencyAdjust(double expEfficiency) method.");
		String actEff= getText("cssSelector", effAdjValue);
		String[] split = actEff.split(" ");		
		double actualEfficncy=Double.parseDouble(split[0]);	
		if(!(actualEfficncy==expEfficiency)) {
			closeZonePopupWindow();
			closeZone();	
			Assert.assertEquals(actualEfficncy, expEfficiency);			
		}
		Assert.assertEquals(actualEfficncy, expEfficiency);
		subHeaders(advConHeaderEffcyTab+concat1+expEfficiency+concat2);	
		return actualEfficncy;
	}
	
	
	
	public void plantTypeUnderRunTimeAdjust(String expAdjustOrPlant) throws Exception {
		logInfo("Entered into plantTypeUnderRunTimeAdjust() method.");
		wdWait("xpath", radioPlantType);
		boolean isPresent=false;
		List<WebElement> rad= driver.findElements(By.xpath(radioPlantType));
		for(WebElement radio:rad) {
			String adjustOrPlant=radio.getText().trim();
			if(adjustOrPlant.equalsIgnoreCase(expAdjustOrPlant)) {
				isPresent=true;
				radio.click();
				break;
			}
		}if(!isPresent) {
			Assert.assertTrue(isPresent,expAdjustOrPlant+ " is not present." );
		}
	}
	
	public void percentage(double enterPercent) throws Exception {
		logInfo("Entered into percentage() method.");
		String per = Double.toString(enterPercent);
		wdWait("xpath", percntInput);
		clearText("xpath", percntInput);
		enterText("xpath", percntInput, per);
		
	}
	
	/***calucate percentage Adjustment underRuntime Adjustment tab
	Percentage Adjustment In min =  (Base Run Time * Percentage Adjustment) - Base Run Time
	Percentage Adjustment = (percentage * 1)/100  ***/
	public double calculateRuntimePercentage(double baseRuntime, double percent ) {
		logInfo("Entered into calculateRuntimePercenatge() method.");
		double percentage= (percent*1)/100;		
		double perAdjust = (baseRuntime * percentage)-baseRuntime;			
		//DecimalFormat decFormat = new DecimalFormat("#.##");
		//decFormat.setRoundingMode(RoundingMode.CEILING);
		String adj = decFormat.format(perAdjust);			
        double percentAdjustment= Double.parseDouble(adj);	
		return percentAdjustment;
		
	}
	
	public double validateRunTimeAdjust(double expRuntimeAdjust) throws Exception {
		logInfo("Entered into validateRunTimeAdjust() method.");
		
		String actRunTime= getText("cssSelector", runTimeAdjValue);
		String[] split = actRunTime.split(" ");		
		double actualRuntime=Double.parseDouble(split[0]);	
		if(!(actualRuntime==expRuntimeAdjust)) {
			closeZonePopupWindow();
			closeZone();		
			Assert.assertEquals(actualRuntime, expRuntimeAdjust);
		}else {
			Assert.assertEquals(actualRuntime, expRuntimeAdjust);
		}	
		return actualRuntime;
		
	}
	
	public void closeAdvanceConfigPopup() throws Exception {
		logInfo("Entered into closeAdvanceConfigPopup() method.");
		clickOnObject("cssSelector", closeAdvConfig);
		//confirmSaveChanges(saveChangesText);
	}
	
	public void selectApply() throws Exception {
		logInfo("Entered into selectApply() method.");
		wdWait("xpath", totApply);
		clickOnButton("xpath", totApply);		
	}
	
	public void closeZone() throws Exception {
		logInfo("Entered into closeZone() method.");
		wdWait("cssSelector", zoneClose);
		clickOnObject("cssSelector", zoneClose);
		
	}
	
	public void closeZonePopupWindow() throws Exception {
		logInfo("Entered into closeZonePopupWindow() method.");
		wdWait("cssSelector", zoneCloseCross);
		clickOnObject("cssSelector", zoneCloseCross);
		
	}
	
	public void runtimeTotalsEachValue(String fieldName , double expEachTotal) throws Exception {
		logInfo("Entered into runtimeTotalsEachValue() method.");		
		String inputField=rtTotalEachBfr+fieldName+rtTotalEachAfr;
		wdWait("xpath", inputField);
		String each = getText("xpath", inputField);		
		double actEachTotalAmount=Double.parseDouble(each);		
		Assert.assertEquals(actEachTotalAmount, expEachTotal);
		//return actEachTotalAmount;
	}
	
	public int calculateRunTimeTotal(double baseRun,double effncyAdjustment, double runTimeAdjust ) {
		logInfo("Entered into calculateRunTimeTotal() method.");
		DecimalFormat df = new DecimalFormat("#");
		double rtTotal= baseRun+effncyAdjustment+runTimeAdjust;		
		df.setRoundingMode(RoundingMode.UP);
		String adj = df.format(rtTotal);		
		int runtimetotal= Integer.parseInt(adj);
		return runtimetotal;
		
	}
	
	public void validateSRRecommenedRange(double baseRuntime, int maxRunTime ) throws Exception {
		logInfo("Entered into validateSRRecommenedRange() method.");
		DecimalFormat df = new DecimalFormat("#");
		df.setRoundingMode(RoundingMode.UP);
		wdWait("xpath", recRange);
		String  min =  df.format(baseRuntime);
		int minimum =Integer.parseInt(min);
		String  max =  df.format(maxRunTime);
		int maximum=Integer.parseInt(max);			
		String actRan= getText("xpath", recRange);		
		Assert.assertEquals(actRan, minimum+ "   to   "+maximum);	
	}	
	
	public void minutesText() throws Exception {
		String actRanMin= getText("xpath", recMin);
		if(!(actRanMin.equals(minutes))){
			System.out.println("small minutes");
			closeZonePopupWindow();	
			closeZone();
			Assert.assertEquals(actRanMin, minutes);
		}else {
			System.out.println("small minutes");
			Assert.assertEquals(actRanMin, minutes);
		}
		
	}
	
	public void skipEffeciencyAdjust() throws Exception {
		logInfo("Entered into skipEffeciencyAdjust() method.");
		wdWait("cssSelector", skipEffAdjust);
		clickOnButton("cssSelector", skipEffAdjust);
	}
	
	public void skipRunTime() throws Exception {
		logInfo("Entered into skipRunTime() method.");
		wdWait("cssSelector", skipRunTime);
		clickOnButton("cssSelector", skipRunTime);
	}
	
	public void resetAdvanceConfig() throws Exception {
		logInfo("Entered into resetAdvanceConfig() method.");
		wdWait("cssSelector", resetAdvCon);
		clickOnObject("cssSelector", resetAdvCon);
		wdWait("cssSelector", selectedSubHeader);
		String actHeader= getText("cssSelector", selectedSubHeader);
		Assert.assertEquals(actHeader, advConHeaderBaseTab);
		
	}	

}
