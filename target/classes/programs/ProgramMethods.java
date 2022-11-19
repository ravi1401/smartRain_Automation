package smrtRain.programs;

import com.lib.TestBase;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import smrtRain.activityLogs.ActivityMethods;
import smrtRain.sites.SiteMethods;

public class ProgramMethods extends ActivityMethods{
	
	public void selectLargeButtonInProgram(String btnName) throws Exception {
		logInfo("Entered into selectLargeButtonInProgram() method.");
		waitTilldisableOfElement(6);
		threadSleep(4000);
		wdWait(css, progBtns);
		scrollDown(css, progBtns);
		boolean ispresent=false;
		List<WebElement> btn = driver.findElements(By.cssSelector(progBtns));		
		for(WebElement btns :btn) {
			String name=btns.getText().trim();			
			if(name.equalsIgnoreCase(btnName)) {
				ispresent=true;
				btns.click();				
				threadSleep(4000);
				break;			
			}
		}if(!ispresent) {
			clickOnButton(css, prog1stButton);
			Assert.assertTrue(ispresent,btnName+ " is not found");
		}		
	}
	
	public void createNewProgram(String expprogramName) throws Exception {
		logInfo("Entered into createNewProgram() method.");
		threadSleep(4000);
		wdWait("xpath", progName);
//		WebElement btn = driver.findElement(By.xpath(progName));
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("arguments[0].value= 'test123'", btn);
//		
		
		clearText("xpath", progName);
		clearText("xpath", progName);		
		submitObject("xpath", progName);
		enterText("xpath", progName, expprogramName);
		clearText("xpath", progName);
		enterText("xpath", progName, expprogramName);
		
	}
	
	//Select dropdown for zones for indiviual site
	public void selectZonesDD(String dropDownLabel) throws Exception {
		logInfo("Entered into clickOnDropDown() method.");			
		boolean isPresent=false;
		List<WebElement> dp= driver.findElements(By.xpath(zoneDp));		
		for(WebElement dropDown:dp) {
			String dpName=dropDown.getText().trim();			
			if(dpName.contains(dropDownLabel)) {
				isPresent=true;
				dropDown.click();
				waitTilldisableOfElement(4);
				break;
			}
		}if(!isPresent) {
			Assert.assertTrue(isPresent, dropDownLabel);
		}		
	}
	
	//Select dropdown for Repeats
		public void clickOnRepeatsDP(String repeatsDP) throws Exception {
			logInfo("Entered into clickOnRepeatsDP() method.");			
			boolean isPresent=false;
			List<WebElement> dp= driver.findElements(By.xpath(zoneDp));		
			for(WebElement dropDown:dp) {
				String dpName=dropDown.getText().trim();				
				if(dpName.contains(labelSelectDays)) {
					isPresent=true;
					dropDown.click();
					 wdWait("xpath", irrManuList);
					   List<WebElement> dpList=driver.findElements(By.cssSelector(irrManuList));
					   boolean isListPresent=false;
						for(WebElement options:dpList) {
							String optName=options.getText().trim();							
							if(optName.contains(repeatsDP)) {
								isListPresent=true;
								options.click();
								break;
							}
						}if(isListPresent==false) {
							Assert.assertTrue(isListPresent, repeatsDP);
						}	
					break;
				}
			}if(!isPresent) {
				Assert.assertTrue(isPresent, labelSelectRepeat);
			}		
		}
	
	public void selectOptionFromDropDown(String expOptions) throws Exception {
		logInfo("Entered into selectOption() method.");
		clickOnObject(xpath, zoneDp);		
		wdWait("cssSelector", zoneOptions);
		boolean isOptionPresent=false;
		List<WebElement> opt = driver.findElements(By.cssSelector(zoneOptions));
		for(WebElement options:opt) {
			String optLabel=options.getText().trim();				
			if(optLabel.equalsIgnoreCase(expOptions)) {
				isOptionPresent=true;
				options.click();
				break;
			}
		}if(!isOptionPresent) {
			clickOnObject("cssSelector", zoneOptionsBfr+2+zoneOptionsAft);
			//typeOfWatering(labRegWater);			
			Assert.assertTrue(isOptionPresent,expOptions+" is not present.");
		}		
	}
	
	public void selectDays(int range2To8) throws Exception {
		logInfo("Entered into selectDays() method.");
		threadSleep(3000);
		wdWait("xpath", allDay);
		List<WebElement> all= driver.findElements(By.xpath(allDay));
		for(WebElement allDays:all) {
			allDays.click();
			Thread.sleep(3000);
			break;
		}	
		wdWait("xpath", allDay);
		clickOnObject("xpath", eachDayBfr+range2To8+eachDayAfr);	
		
	}
	
	public void selectDaysForSmartStack(int range2To8) throws Exception {
		logInfo("Entered into selectDays() method.");
		sleep(3000);
		wdWait("xpath", allDay);
		List<WebElement> all= driver.findElements(By.xpath(allDay));
		for(WebElement allDays:all) {
			allDays.click();
			Thread.sleep(3000);
			break;
		}	
		wdWait("xpath", allDay);
		clickOnObject("xpath", eachDayBfr+range2To8+eachDayAftSmartStack);	
		
	}
	
	public void dynamicSelectionFromDropdown() throws Exception {
		logInfo("Entered into dynamicSelectionFromDropdown() method.");
		wdWait("cssSelector", zoneOptions);		
		int opt = driver.findElements(By.cssSelector(zoneOptions)).size();
		if(opt<=1) {
			System.err.println("options are not available");
			
		}else if(opt==2) {
			WebElement option =driver.findElement(By.cssSelector(zoneOptionsBfr+2+zoneOptionsAft));
			option.click();
		
		}else {
			int i=TestBase.generateRandomNumberInRange(3, opt);
			WebElement option =driver.findElement(By.cssSelector(zoneOptionsBfr+i+zoneOptionsAft));
			option.click();
		}
	}
	
	
	public void programButtons(String btnName) throws Exception {
		logInfo("Entered into programButtons() method.");
		sleep(2000);
		wdWait("xpath", progmsBtns);
		boolean isPresent=false;
		List<WebElement> btns = driver.findElements(By.xpath(progmsBtns));
		for(WebElement buttons:btns) {
			String actBtnName=buttons.getText().trim();					
			if(actBtnName.equalsIgnoreCase(btnName)) {
				isPresent=true;
				buttons.click();				
				break;
			}
			
		}if(!isPresent) {
			Assert.assertTrue(isPresent,btnName);
		}
	}
	
	
	
	public void timePeriod(String time) throws Exception {
		logInfo("Entered into timePeriod() method.");
		Actions act= new Actions (driver) ;
		clickOnObject("cssSelector", timeControl);
		wdWait("cssSelector", timePeriod);
		boolean isPresent=false;
		List<WebElement> btns = driver.findElements(By.cssSelector(timePeriod));
		for(WebElement buttons:btns) {
			String actBtnName=buttons.getText().trim();					
			if(actBtnName.equalsIgnoreCase(time)) {
				isPresent=true;
				//buttons.click();
				act.doubleClick(buttons).build().perform();
				break;
			}
			
		}if(!isPresent) {
			Assert.assertTrue(isPresent,time);
		}
		
	}
	
	
	//Set Time as per our expected
	
	public void setTime(int time) throws Exception {
		logInfo("Entered into setTime() method.");
		threadSleep(4000);
		wdWait("xpath", timeIcon);
		clickOnObject("xpath", timeIcon);//	
		clickOnObject("xpath", timputDialerHrs+time+navTabsAfr);
		threadSleep(3000);
		WebElement min= driver.findElement(By.xpath(timputDialer50Min));		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", min);
		selectBtnOfTime("OK");
	}
	
	public void setTimeAt05Min(int time) throws Exception {
		logInfo("Entered into setTimeAt05Min() method.");		
		wdWait("xpath", timeIcon);
		clickOnObject("xpath", timeIcon);
		clickOnObject("xpath", timputDialerHrs+time+navTabsAfr);			
		WebElement min= driver.findElement(By.xpath(timputDialer05Min));		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", min);
		selectBtnOfTime("OK");
	}
	
	public void additionalTimeIcon() throws Exception {
		wdWait("xpath", addtionalTimeIcon);
		clickOnObject("xpath", addtionalTimeIcon);
		
	}
	
	public void selectBtnOfTime(String btnName) throws Exception {
		logInfo("Entered into selectBtnOfTime() method.");
		List<WebElement>btn =driver.findElements(By.cssSelector(timePickerBtn));
		boolean isPresent=false;
		for(WebElement btns:btn) {
		String label= btns.getText().trim();		
		if(label.equalsIgnoreCase(btnName)) {
			isPresent=true;
			btns.click();
			break;
			
			}
		}if(!isPresent) {
			Assert.assertTrue(isPresent,btnName+" is not found" );
		}		
	}
	
	
	//selectCycleSoakToOn
	
	public void onCycleSoak() throws Exception {
		logInfo("Entered into onCycleSoak() method.");
		sleep(5000);
		wdWait("xpath", cyclSoak);
		clickOnObject("xpath", cyclSoak);
	}
	
	//selectBoosterPump
	
		public void onBoosterPump() throws Exception {
			logInfo("Entered into onBoosterPump() method.");
			sleep(5000);
			wdWait("xpath", boosterPump);
			clickOnObject("xpath", boosterPump);
		}
		
	
	//select radio of watering 
	public void typeOfWatering(String expWatering) throws Exception {
		logInfo("Entered into typeOfWatering() method.");
		wdWait("xpath", wateringRad);
		boolean isWaterPresent=false;
		List<WebElement> watr = driver.findElements(By.xpath(wateringRad));
		for(WebElement watering :watr) {			
			String wateringType=watering.getText().trim();			
			if(wateringType.equalsIgnoreCase(expWatering)) {
				isWaterPresent=true;
				watering.click();
				break;
			}			
		}if(!isWaterPresent) {
			Assert.assertTrue(isWaterPresent,expWatering+" is not present.");
		}
		
	}
	
	public void handlSmrtWaterET() throws Exception {
		logInfo("Entered into handlSmrtWaterET() method.");
		SoftAssert sa= new SoftAssert();
		String title= getTextInSmallerCase("cssSelector", zonDetSelMinLab);
		sa.assertEquals(title, msgConfm);
		String content= getText("cssSelector", zoneDetContent);
		sa.assertEquals(content, msgContText);
		clickOnButton("cssSelector", zonDelYes);		
		sa.assertAll();
	}
	
	
	public void selectDayinCalendar() throws Exception {			
		int rows= TestBase.generateRandomNumberInRange(1, 5);
		int col=TestBase.generateRandomNumberInRange(1, 7);
		wdWait("xpath", calNext);
		clickOnObject("xpath", calNext);
		wdWait("xpath", calDays);
		clickOnObject("xpath", calenderBfr+rows+calenderMid+col+calenderAfr);
			
	}
	
	public void backToProgram() throws Exception {
		logInfo("Entered into backToProgram() method.");
		waitTilldisableOfElement(2);
		wdWait("cssSelector", skipBack);
		clickOnObject("cssSelector", skipBack);
		Thread.sleep(2000);
		
	}
	
	/**Modal Box- Site Program- selects a program from dropdown*/
	public void selectSiteProgramFromDP(String chooseProgram) throws Exception {
		logInfo("Entered into selectSiteProgramFromDP() method.");
		sleep(2000);
		wdWait(xpath, progListDP);
		clickOnObject(xpath, progListDP);
		sleep(2000);
		boolean isPresent=false;
		List<WebElement> opt= driver.findElements(By.cssSelector(progList));		
		for(WebElement options:opt) {
			String names=options.getText().trim();			
			if(names.equalsIgnoreCase(chooseProgram)) {
				isPresent=true;
				options.click();				
				break;
			}
		}if(!isPresent) {
			Assert.assertTrue(isPresent,chooseProgram+ " is not present");
		}
		
	}
	
	public void fullOrOtherTime(String fullOrOther) throws Exception {
		logInfo("Entered into fullOrOtherTime() method.");			
		if(fullOrOther=="Full Time") {
			clickOnObject(xpath, fullTime);	
			clickOnButton("cssSelector", zonDelYes);
		
		}else if(fullOrOther=="Others") {
			clickOnObject(xpath, otherTime);	
			enterText(css, otherTimeInput, "20");
			clickOnButton(css, zonDelYes);
		}		
	}
	
	public void alertMsg_RunProgram(String expAlertMsg) throws Exception {
		logInfo("Entered into alertMsg_RunProgram() method.");
		String actAlert = getText(css, progAlert);
		Assert.assertEquals(actAlert,expAlertMsg);	
		clickOnButton(css, zonDelNo);
		
	}
	
	//Just tabout from  Input field when Others is selected
	public void handleOther() {
		clickOnObject(xpath, otherTime);	
		clickOnObject(css, otherTimeInput);
	}
	
	
	
	
	public void doNotDisplayProgramToRun(String chooseProgram) throws Exception {
		logInfo("Entered into donotdisplayProgramToRun() method.");
		sleep(2000);
		wdWait(xpath, progListDP);
		clickOnObject(xpath, progListDP);
		sleep(2000);
		boolean isPresent=false;
		List<WebElement> opt= driver.findElements(By.cssSelector(progList));		
		if(opt.size()==0) {			
			clickOnButton(css, zonDelNo);
		}else {
		for(WebElement options:opt) {
			String names=options.getText().trim();			
			if(names.equalsIgnoreCase(chooseProgram)) {
				isPresent=false;
				options.click();
				clickOnButton(css, zonDelNo);
				Assert.assertTrue(isPresent,chooseProgram+ " is still present");
				break;
			}
		}if(isPresent) {
			clickOnButton(css, zonDelNo);
			}
		}
	}
	
	public void isProgramPresent(String expProgName) throws Exception {
		logInfo("Entered into isProgramPresent() method.");
		expProgName= expProgName.toUpperCase();
		waitTilldisableOfElement(4);
		wdWait("xpath", prognamesList);
		boolean isPresent=false;
		List<WebElement> name= driver.findElements(By.xpath(prognamesList));		
		for (int i=1;i<=name.size();i++){
			String actProgName=driver.findElement(By.xpath(prognamesListBfr+i+prognamesListAfr)).getText().trim();
			if(actProgName.contains(expProgName)) {
				isPresent=true;				
				break;
			}
		}if(!isPresent) {
			Assert.assertTrue(isPresent,expProgName+ " : program is not present");
		}
	}
	
	
	public void selectDotsBasedOnProgram(String expProgName) throws Exception {
		logInfo("Entered into selectDotsBasedOnProgram() method.");
		waitTilldisableOfElement(4);
		expProgName=expProgName.toUpperCase();
		wdWait("xpath", prognamesList);
		boolean isPresent=false;
		List<WebElement> name= driver.findElements(By.xpath(prognamesList));		
		for (int i=1;i<=name.size();i++){
			String actProgName=driver.findElement(By.xpath(prognamesListBfr+i+prognamesListAfr)).getText().trim();
			if(actProgName.contains(expProgName)) {
				isPresent=true;
				driver.findElement(By.xpath(prognamesListBfr+i+prognamesListDotsAft)).click();
				break;
			}
		}if(!isPresent) {
			Assert.assertTrue(isPresent,expProgName+ " : program is not present");
		}
	}
	
	public void deleteAllprograms() throws Exception {
		logInfo("Entered into selectDotsBasedOnProgram() method.");
		waitTilldisableOfElement(4);
		wdWait("xpath", prognamesList);
		boolean isPresent=false;
		List<WebElement> name= driver.findElements(By.xpath(prognamesList));		
		for (int i=name.size();i>=1;i--){
			driver.findElement(By.xpath(prognamesListBfr+i+prognamesListDotsAft)).click();
			selectUpdateOrDelete(zoneDelete);
			confirmStatusModelBox(progDelete);
			deleteConfirmation();
			
		}
	}
	
	public String getZoneName(String expProgName) throws Exception {
		logInfo("Entered into getZoneName() method.");
		wdWait("xpath", prognamesList);
		String zoneName=null;
		boolean isPresent=false;
		List<WebElement> name= driver.findElements(By.xpath(prognamesList));
		for (int i=1;i<=name.size();i++){
			String actProgName=driver.findElement(By.xpath(prognamesListBfr+i+prognamesListAfr)).getText().trim();
			if(actProgName.equalsIgnoreCase(expProgName)) {
				isPresent=true;				
				String getzoneName=driver.findElement(By.cssSelector(proZoneNameBfr+(i+1)+proZoneNameAfr)).getText().trim();
				String[] split= getzoneName.split("\\(");
				zoneName=split[0]+" ("+split[1];			
				break;
			}
		}if(!isPresent) {
			Assert.assertTrue(isPresent,expProgName+ " : program is not present");
		}
		return zoneName;
	}
	
	public int getSeasonalAdjustmentPercentage(String expProgName) throws Exception {
		logInfo("Entered into getSeasonalAdjustmentPercentage() method.");
		waitTilldisableOfElement(4);
		wdWait("xpath", prognamesList);
		int percentage = 0;
		boolean isPresent=false;
		List<WebElement> name= driver.findElements(By.xpath(prognamesList));
		for (int i=1;i<=name.size();i++){
			String actProgName=driver.findElement(By.xpath(prognamesListBfr+i+prognamesListAfr)).getText().trim();
			if(actProgName.contains(expProgName)) {
				isPresent=true;
				System.out.println("sds "+actProgName);
				String percnt = driver.findElement(By.xpath(prognamesListBfr+i+seasonalAdjst)).getText();
				System.out.println("percnt "+percnt);
				String regex="[^\\d]+";
				String cent= percnt.replaceAll(regex, "");				
				percentage=Integer.parseInt(cent);
				break;
			}
		}if(!isPresent) {
			Assert.assertTrue(isPresent,expProgName+ " : program is not present");
		}		
		return percentage;
	}
	
	//get Value of Seasonal Adjusment while program  is creating/updating
	public int  getSeasonalAdjustmentInput() throws Exception {
		logInfo("Entered into scrollToTop() method.");		
		String sa= getAttribute(xpath, seasAdjInput, "value");
		int SAPercent=Integer.parseInt(sa);
		return SAPercent;
	}
	
	//Enter Value in  Seasonal Adjusment while program  is creating/updating
		public void seasonalAdjustmentInput(String expPercent) throws Exception {
			logInfo("Entered into seasonalAdjustmentInput() method.");
			clearText(xpath, seasAdjInput);
			enterText(xpath, seasAdjInput, expPercent);
			
			
		}
		
		//Enter Value in  Seasonal Adjusment while program  is creating/updating
				public void seaAdjustInput(String expPercent) throws Exception {
					logInfo("Entered into seasonalAdjustmentInput() method.");
					clearText(xpath, seasAdjInput);
					enterText(xpath, seasAdjInput, expPercent);				
					
				}
	
	
	public void scrollToTop() throws Exception {
		logInfo("Entered into scrollToTop() method.");
		scrollDown("xpath", progZoneGrpDetails);
	}
	
	public void zoneButtonsToCreateSchedule() throws Exception {
		logInfo("Entered into zoneButtonsToCreateSchedule() method.");
		List<WebElement> btns= driver.findElements(By.cssSelector(smartBtns));
		int size= btns.size();
		int i =TestBase.generateRandomNumberInRange(1, size-1),j=size-1;
		//clickOnObject("cssSelector", smartBtnsBfr+i+")");
		clickOnObject("cssSelector", smartBtnsBfr+j+")");
		wdWait("cssSelector", createSchd);
		clickOnObject("cssSelector", createSchd);
		
	}
	
	public void confirmMesgOfSync(String expConfMessage) throws Exception {
		logInfo("Entered into confirmationMessage() method.");	
		SoftAssert sa = new SoftAssert();	
		sleep(20000);		
		wdWait("cssSelector", confMsg);
		String conMsg=getText("cssSelector", confMsg);		
		sa.assertEquals(conMsg, expConfMessage);
		clickOnButton("xpath", dialogYes);	
		sa.assertAll();
		}	
	
	
	
	public void selectSiteUpdateBtn() throws Exception {
		logInfo("Entered into selectSiteUpdateBtn() method.");
		wdWait(xpath, updateBtn);	
		scrollDown(xpath, updateBtn);		
		clickOnButton("xpath", updateBtn);
		confirmModalBox(succssUpdateMsg);	
		
	}
	
	
	public void confirmInProgram(String expConfMessage) throws Exception {
		logInfo("Entered into confirmationMessage() method.");	
		SoftAssert sa = new SoftAssert();
		threadSleep(10000);
		waitTilldisableOfElement(20);
		int conSize=driver.findElements(By.cssSelector(confMsg)).size();
		if(conSize==1) {
			wdWait("cssSelector", confMsg);			
			String conMsg=getText(css, confMsg);			
			if(conMsg.equalsIgnoreCase(expConfMessage)) {
				clickOnButton("xpath", dialogYes);	
				
			}else {					
				threadSleep(5000);
				System.out.println("Not matched");
				clickOnButton("xpath", dialogYes);	
				sa.assertEquals(conMsg, expConfMessage);
			}			
			
		}else {
			int expSize=driver.findElements(By.cssSelector(skipConfMsg)).size();
			if(expSize==1) {
				
				wdWait("cssSelector", skipConfMsg);
				String expDesc= getText("cssSelector", skipConfMsg);				
				if(expDesc.equalsIgnoreCase(boosterPumpMsg)) {
					clickOnButton("cssSelector", zonDelYes);
					reConfirmInProgram(expConfMessage);
					System.out.println("reconfirm");
				}else if(!(expDesc.equalsIgnoreCase(boosterPumpMsg))) {					
					clickOnButton("cssSelector", zonDelYes);
					Assert.assertEquals(expDesc, expConfMessage);
				}
					
			}else {
				clickOnButton("cssSelector", zonDelNo);
			}
		}		
			sa.assertAll();
		}
	
	
	public void reConfirmInProgram(String expConfMessage) throws Exception {
		logInfo("Entered into confirmationMessage() method.");	
		SoftAssert sa = new SoftAssert();
		sleep(7000);	
		wdWait("cssSelector", confMsg);	
		String conMsg=getText("cssSelector", confMsg);				
		if(conMsg.equalsIgnoreCase(expConfMessage)) {
			clickOnButton("xpath", dialogYes);	
		}else {			
			clickOnButton("xpath", zonDelYes);	
			sa.assertEquals(conMsg, expConfMessage);			
		}		
		sa.assertAll();
		}
	
	
	public void cancelButton() throws Exception {
		logInfo("Entered into cancelButton() method.");		
		wdWait("cssSelector", progCancel);
		clickOnButton("cssSelector", progCancel);
		
	}
	
	
	
	public void confirmMessToHandleinProgram(String expConfMessage) throws Exception {
		logInfo("Entered into confirmationMessage() method.");	
		SoftAssert sa = new SoftAssert();
		sleep(7000);
		waitTilldisableOfElement(20);
		int descp= driver.findElements(By.cssSelector(confMsg)).size();
		if(descp==1) {
		wdWait("cssSelector", confMsg);
		String conMsg=getText("cssSelector", confMsg);			
		//sa.assertEquals(conMsg, expConfMessage);
		clickOnButton("xpath", dialogYes);	
		sa.assertAll();
		}else {
			wdWait("cssSelector", confirmLabel);				
			String alertMsg= getText("cssSelector", confirmLabel);				
			clickOnButton("xpath", zonDetFlowOk);	
			sleep(4000);
			waitTilldisableOfElement(5);
		}
		
	}
	
	public String getProgramDate(String expProgName) throws Exception {
		logInfo("Entered into getProgramID() method.");
		waitTilldisableOfElement(4);
		String date=null;
		expProgName=expProgName.toUpperCase();
		wdWait("xpath", prognamesList);
		boolean isPresent=false;
		List<WebElement> name= driver.findElements(By.xpath(prognamesList));		
		for (int i=1;i<=name.size();i++){
			String actProgName=driver.findElement(By.xpath(prognamesListBfr+i+prognamesListAfr)).getText().trim();			
			if(actProgName.contains(expProgName)) {
				isPresent=true;
				 date= driver.findElement(By.xpath(prognamesListBfr+i+progrmaDate)).getText();
				 String [] split = date.split(" ");
				 DateFormat format = new SimpleDateFormat("m/d/yyyy", Locale.ENGLISH);
				 Date getDate= format.parse(split[0]);				 		 
				break;
			}
		}if(!isPresent) {
			Assert.assertTrue(isPresent,expProgName+ " : program is not present");
		}
		
		return date;
	}
	
	public String getProgramID(String expProgName) throws Exception {
		logInfo("Entered into getProgramID() method.");
		waitTilldisableOfElement(4);
		String programId=null;
		expProgName=expProgName.toUpperCase();
		wdWait("xpath", prognamesList);
		boolean isPresent=false;
		List<WebElement> name= driver.findElements(By.xpath(prognamesList));		
		for (int i=1;i<=name.size();i++){
			String actProgName=driver.findElement(By.xpath(prognamesListBfr+i+prognamesListAfr)).getText().trim();			
			if(actProgName.contains(expProgName)) {
				isPresent=true;
				programId= actProgName.substring(actProgName.indexOf("(")+1,actProgName.indexOf(")"));
				break;
			}
		}if(!isPresent) {
			Assert.assertTrue(isPresent,expProgName+ " : program is not present");
		}
		
		return programId;
	}	
	public ArrayList<String> retirveSelectedDays(String expProgName) throws Exception {
		logInfo("Entered into getSelectDays() method.");		
		ArrayList<String> zonesDays = new ArrayList<String>();	
		String eachDay = null;
		waitTilldisableOfElement(4);
		expProgName=expProgName.toUpperCase();
		wdWait("xpath", prognamesList);
		boolean isPresent=false;
		List<WebElement> name= driver.findElements(By.xpath(prognamesList));			
		for (int i=1;i<=name.size();i++){
			String actProgName=driver.findElement(By.xpath(prognamesListBfr+i+prognamesListAfr)).getText().trim();		
				if(actProgName.contains(expProgName)) {
				isPresent=true;
				WebElement repeated=driver.findElement(By.xpath(prognamesListBfr+i+repeats));
				String repeatType=repeated.getText();				
				if((repeatType.equalsIgnoreCase("Even"))||(repeatType.equalsIgnoreCase("Odd"))) {				
					repeatType =repeatType.toUpperCase().trim();
					repeatType="\""+repeatType+"\"";					
					zonesDays.add(repeatType);
					
				}else {
				
				List <WebElement> days =driver.findElements(By.xpath(prognamesListBfr+i+repeats));
				System.out.println("days cont :"+days.size());
				
				for(WebElement day : days){					
					String actData=day.getText().trim().substring(0,2).toUpperCase();					
					String mod ="\""+actData+"\"";
					eachDay=mod.toString();										
					zonesDays.add(eachDay);
					
					}				
			}break;	}	
		}if(!isPresent) {
			Assert.assertTrue(isPresent,expProgName+ " : program is not present");
			}	
		System.out.print(zonesDays);
		return zonesDays;
	}
	
	public String getSelectedDays(String expProgName) throws Exception {
		StringBuilder sb = new StringBuilder();		
		ArrayList<String> days =retirveSelectedDays(expProgName);
		for (String week :days ) {
			sb.append(week).append(",");			
		}
		sb.setLength(sb.length()-1);		
		return sb.toString();		
		
	}
	
	//to handle sliders of Multiple Run Times , Cycle Soak, Moisture Sensor
	public void slideToggle(String expToggle) throws Exception {
		logInfo("Entered into slideToggle() method.");	
		threadSleep(8000);
		wdWait("xpath", toggles);
		int togSize=driver.findElements(By.xpath(toggles)).size();			
		boolean isTooglePresent=false;
		for(int i=1;i<=togSize;i++) {
			WebElement togName=driver.findElement(By.xpath(toggleNameBfr+i+toggleNameAft));	
			if(togName.getText().equalsIgnoreCase(expToggle)) {
				isTooglePresent=true;				
				clickOnObject("xpath", toggleNameBfr+i+togSlideAft);				
				break;
			}
		}if(!isTooglePresent) {
			Assert.assertTrue(isTooglePresent, expToggle+" is not present");
		}	
	}
	
	//to handle smart stack for temporary
	public void handleSmartStackToggle() throws Exception {
		
		String smartStackLabel =getText(xpath, toggleNameBfr+1+toggleNameAft);
		if(smartStackLabel.equalsIgnoreCase("PROGRAM.SMART_STACK")) {
			slideToggle("PROGRAM.SMART_STACK");
		}else if (smartStackLabel.equalsIgnoreCase(smartStackSlide)) {
			slideToggle(smartStackSlide);
		}
		
		
		
		
	}
	
	//to handle sliders RAIN OVERDIE  and Booster 
		public void slidersRain(String expToggle) throws Exception {
			logInfo("Entered into slidersRain() method.");		
			wdWait("xpath", togRainBooster);
			int tog1Size=driver.findElements(By.xpath(togRainBooster)).size();			
			boolean isTooglePresent=false;
			for (int i=tog1Size;i>=1;i--) {				
				String togName=driver.findElement(By.xpath(togRainBfr+i+togRainAft)).getText();
				if(togName.equalsIgnoreCase(expToggle)) {			
					isTooglePresent=true;					
					clickOnObject(xpath, toggleNameBfr+i+togSlideAft);		
					break;
				}
			}if(!isTooglePresent) {
				Assert.assertTrue(isTooglePresent, expToggle+" is not present");
			}	
			}
			
			
			
			

	
	//to select Smart Stack toggle 	  (Not working -09092022)
	public void smartStackToggle() throws Exception {
		logInfo("Entered into smartStackToggle() method.");	
		wdWait(xpath, togSmartStack);
		List<WebElement> smartTog=driver.findElements(By.xpath(togSmartStack));		
		for(WebElement toggs : smartTog) {
			toggs.click();
			break;
		}
		
	}
	
	//to select program On or Off toggle 	
		public void programToggleSlider() throws Exception {
			logInfo("Entered into programToggleSlider() method.");	
			wdWait(xpath, togProgSlider);
			List<WebElement> smartTog=driver.findElements(By.xpath(togProgSlider));		
			for(WebElement toggs : smartTog) {
				toggs.click();
				break;
			}
			
		}
	
	
	
	
	public void selectZoneButton() throws InterruptedException {
		logInfo("Entered into selectZoneButton() method.");	
		int zones=driver.findElements(By.xpath(zonebutton)).size();
		if((zones>=2)) {
			int random= TestBase.generateRandomNumberInRange(1, zones);			
			WebElement zone=driver.findElement(By.xpath(zonebutton+zonebuttonBfr+random+alRowsAft));
			zone.click();			
		}else if(zones==1) {
			WebElement zone=driver.findElement(By.xpath(zonebutton+zonebuttonBfr+1+alRowsAft));
			zone.click();			
		}else {
			System.out.println("size is zero");
		}		
	}
	
	/******Selects expected Zone while creating stacking program   *****/
	public void selectExactZoneInStack(String expZoneNumber) throws InterruptedException {
		logInfo("Entered into selectExactZoneInStack() method.");	
		int zones=driver.findElements(By.xpath(zonebutton)).size();
		boolean isPresent = false;
		for(int i=1;i<=zones;i++) {
			WebElement zone=driver.findElement(By.xpath(zonebutton+zonebuttonBfr+i+alRowsAft));
			String zoneNumber=zone.getText().trim();
			if(zoneNumber.equalsIgnoreCase(expZoneNumber)) {
				isPresent=true;
				zone.click(); 
				break;
			}
			
		}if(!isPresent) {
			Assert.assertTrue(isPresent, expZoneNumber+" is not present in program");
		}
		
	}		
	
	
	public void createSchedule() throws Exception {
		logInfo("Entered into createSchedule() method.");
		wdWait("xpath", creatSched);
		clickOnButton("xpath", creatSched);	
		waitOnLoadingSpinner(8000);
		
	}
	
	public ArrayList<String> getSelectedZonesFromZoneFlow() throws InterruptedException {
		logInfo("Entered into getSelectedZonesFromZoneFlow() method.");
		ArrayList<String> zoneNumber= new ArrayList<String>();	
		String eachZone = null;
		threadSleep(4000);
		int totalZones=driver.findElements(By.xpath(zoneFlowNumbers)).size();
		for(int j=1;j<=totalZones;j++) {
			for(int i=1;i<=6;i++) {
			List<WebElement> rows=driver.findElements(By.xpath(eachRowZoneFlow+i+eachZoneInRowBfr+j+eachZoneInRowAfr));
			int rowSize=rows.size();
			if(rowSize==1) {
				String zoneNumb=driver.findElement(By.xpath(eachRowZoneFlow+i+eachZoneInRowBfr+j+eachZoneInRowAfr)).getText().trim();
				eachZone = zoneNumb.toString();
				zoneNumber.add(eachZone);				
			}else if(rowSize==0){
				//System.out.println(i+" "+j+" ==   No zones at this row ");
			}
		}
	}	
		return zoneNumber;		
	}
	
	
	public ArrayList<String> getSelectedZonesFromZoneFlow_old() throws InterruptedException {
		logInfo("Entered into getSelectedZonesFromZoneFlow() method.");
		ArrayList<String> zoneNumber= new ArrayList<String>();	
		String eachZone = null;
		sleep(4000);		
		for(int i=1;i<=6;i++) {
			List<WebElement> rows=driver.findElements(By.xpath(eachRowZoneFlow+i+eachRowZoneFlowAft));
			int rowSize=rows.size();
			if(rowSize>=2) {
				int rowZoneSize=driver.findElements(By.xpath(eachRowZoneFlow+i+rowZones)).size();
				for(int j=1;j<=rowZoneSize;j++) {
					String zoneNumb=driver.findElement(By.xpath(eachRowZoneFlow+i+eachZoneInRowBfr+1+eachZoneInRowAfr)).getText().trim();
					eachZone = zoneNumb.toString();
					zoneNumber.add(eachZone);
					break;
				}				
			}else if(rowSize==0) {
				//System.out.println(i+"    No zones at this row ");
				
			}else {
				WebElement name=driver.findElement(By.xpath(eachRowZoneFlow+i+eachRowZoneFlowAft));
				zoneNumb=name.getText();
				eachZone = zoneNumb.toString();				
				zoneNumber.add(eachZone);
			}		
		}		
		return zoneNumber;		
	}
	
	public String retrieveZoneNumbersOfSmartStack() throws Exception {
		logInfo("Entered into retrieveZoneNumbersOfSmartStack() method.");
		StringBuilder sb = new StringBuilder();		
		ArrayList<String> numbers=getSelectedZonesFromZoneFlow();
		for(String str:numbers) {
			sb.append(str).append(", ");
		}		
		sb.setLength(sb.length()-1);
		String zonesList= sb.toString().substring(0, sb.length()-1);		
		return zonesList;		
	}
	
//	public void addMultiTimes() throws Exception {
//		logInfo("Entered into addMultiTimes() method.");
//		wdWait("cssSelector", timePlusIcon);
//		clickOnObject("cssSelector", timePlusIcon);		
//	}
	
	public void manualStack(String manualOnOrOff) throws Exception {
		logInfo("Entered into manualStack() method.");
		wdWait(xpath, manualOn);
		String stackStatus=getAttribute(xpath, getManualStack, "aria-checked");		
		if(manualOnOrOff.equalsIgnoreCase("on")) {
			if(stackStatus.equalsIgnoreCase(isFalse)) {				
				clickOnButton(xpath, manualOn);
				}
			}
		else if(manualOnOrOff.equalsIgnoreCase("off")){
			if(stackStatus.equalsIgnoreCase(isTrue)) {				
				clickOnButton(xpath, manualOn);
			}			
		}		
	}
	
	
	 public void dragZoneInStackGraph() throws Exception {
		 logInfo("Entered into dragZoneInStackGraph() method.");
		 Actions act=new Actions(driver);	
		 sleep(4000);
		 wdWait(xpath, manualOn);
		 scrollDown(xpath, manualOn);
		 sleep(6000);
		 int lastSize=driver.findElements(By.xpath(lastRowOfStack)).size();		 
		 WebElement lastZone= driver.findElement(By.xpath(lastZoneBfr+lastSize+lastZoneAft));
		 WebElement destLocation= driver.findElement(By.xpath(firstZoneLocation));
		 act.clickAndHold(lastZone).dragAndDrop(lastZone, destLocation).build().perform();;
		 
	 }
	 
	 
	 public void validateETLabels(String [] expLabels) throws Exception {
		 logInfo("Entered into validateETLabels() method.");
		 wdWait(xpath, etLabels);
		 int expLabSize= expLabels.length;		 	
		 List<WebElement> labsCount = driver.findElements(By.xpath(etLabels));		 
		 if(labsCount.size()==expLabSize) {			
			 boolean isLabelPresent=false;
			 for(WebElement labels:labsCount) {				 
				 String actLabel=labels.getText().trim();				
				 for(int i=0;i<=expLabSize-1;i++) {
					 if(actLabel.contains(expLabels[i])) {
						 isLabelPresent=true;						 
						 break;
					 }
					 
				 }if(!isLabelPresent){
					 Assert.assertTrue(isLabelPresent, actLabel+" is present ");
				 }				 
			 }			 
		 }		 
	 }
	 
	 public void handleRedEye() throws Exception {
		 logInfo("Entered into handleRedEye() method.");
		 threadSleep(6000);
		 String eyeText = getText(xpath, eyeIcon);
		 int eyeSize=driver.findElements(By.xpath(eyeIcon)).size();		 
		 if(eyeText.equalsIgnoreCase(redEyeStatus)) {
			 clickOnObject(xpath, eyeIcon);
			 
		 }
		 
		 	
		 
	 }
	 
	 public double getETValue(String expLabel) throws Exception {
		 logInfo("Entered into getDefaultValue() method.");
		 wdWait(xpath, etLabels);
		 String inputValues = null;
		 double conToArthmetic =0.00;
		 int labSize=driver.findElements(By.xpath(etLabels)).size();
		 boolean isPresent= false;
		 for(int i=1;i<=labSize;i++) {
			 String labelName=driver.findElement(By.xpath(etLabBfr+i+zonesEnd)).getText().trim();
			 if(labelName.startsWith(expLabel)) {
				 isPresent=true;
				 sleep(2000);
				 WebElement input =driver.findElement(By.xpath(etInputField+i+etInputFieldEnd));
				 inputValues=input.getAttribute("value");
				 if(inputValues=="0") {
					 inputValues="0.00";					 
					 double val = Double.parseDouble(new DecimalFormat("##.##").format(inputValues));
				
				 }
				 conToArthmetic = Float.parseFloat(inputValues);				
				 break;
			 }
		 }if(!isPresent) {
			 Assert.assertTrue(isPresent,expLabel+" is not present.");
		 }		 
		 return conToArthmetic;		 
	 }
	 
	 public int getLAValue(String expLabel) throws Exception {
		 logInfo("Entered into getDefaultValue() method.");
		 wdWait(xpath, etLabels);
		 String inputValues = null;
		 int conToArthmetic = 0;
		 int labSize=driver.findElements(By.xpath(etLabels)).size();
		 boolean isPresent= false;
		 for(int i=1;i<=labSize;i++) {
			 String labelName=driver.findElement(By.xpath(etLabBfr+i+zonesEnd)).getText().trim();
			 if(labelName.startsWith(expLabel)) {
				 isPresent=true;
				 threadSleep(2000);
				 WebElement input =driver.findElement(By.xpath(etInputField+i+etInputFieldEnd));
				 inputValues=input.getAttribute("value");
				 conToArthmetic = Integer.parseInt(inputValues);
				 break;
			 }
		 }if(!isPresent) {
			 Assert.assertTrue(isPresent,expLabel+" is not present.");
		 }		 
		 return conToArthmetic;		 
	 }
	 
	 
	 public double retrieveETValue(String expLabel) throws Exception {
		 logInfo("Entered into getDefaultValue() method.");
		 wdWait(xpath, etLabels);
		 double etValue = 0.0 ;
		 String inputValues = null;
		 int labSize=driver.findElements(By.xpath(etLabels)).size();
		 boolean isPresent= false;
		 for(int i=1;i<=labSize;i++) {
			 String labelName=driver.findElement(By.xpath(etLabBfr+i+zonesEnd)).getText().trim();
			 if(labelName.startsWith(expLabel)) {
				 isPresent=true;
				 sleep(2000);
				 WebElement input =driver.findElement(By.xpath(etInputField+i+etInputFieldEnd));
				 inputValues=input.getAttribute("value");	
				 etValue=Double.parseDouble(inputValues);
				 break;
			 }
		 }if(!isPresent) {
			 Assert.assertTrue(isPresent,expLabel+" is not present.");
		 }		 
		 return etValue;		 
	 }
	 
	 
	 
	 public void compareDefaultETValues() throws Exception {
		 logInfo("Entered into compareDefaultETValues() method.");		
		 	double valSSL =getETValue(etLabSSL);		
			double valLA = getETValue(etLabLA);
			double valIA = getETValue(etLabIrrgAmt);		
			double valIAMul = getETValue(etLabIAMul);
			double valGWL = getETValue(etLabGWL);		
			double valMAD = getETValue(etLabMAD);
			double defSSL=1.0;
			double defLA=100;
			double defIA=0.5;
			double defIAMul=2;
			double defGWL=0;
			double defMAD=0.5;
			Assert.assertEquals(valSSL,defSSL);
			Assert.assertEquals(valLA,defLA);
			Assert.assertEquals(valIA,defIA);
			Assert.assertEquals(valIAMul,defIAMul);
			Assert.assertEquals(valGWL,defGWL);
			Assert.assertEquals(valMAD,defMAD);	
			
	 }
	 
	 public float getETFieldValue(String expLabel) throws Exception {
		 logInfo("Entered into getETFieldValue() method.");
		 wdWait(xpath, etLabels);
		 float getEt = 0;		 
		 int labSize=driver.findElements(By.xpath(etLabels)).size();
		 boolean isPresent= false;
		 for(int i=1;i<=labSize;i++) {
			 String labelName=driver.findElement(By.xpath(etLabBfr+i+zonesEnd)).getText().trim();
			 if(labelName.startsWith(expLabel)) {
				 isPresent=true;
				 sleep(2000);
				 WebElement input =driver.findElement(By.xpath(etInputField+i+etInputFieldEnd));
				 String inputValues=input.getAttribute("value");
				 getEt= Float.parseFloat(inputValues);				 
				 break;
			 }
		 }if(!isPresent) {
			 Assert.assertTrue(isPresent,expLabel+" is not present.");
		 }		 
		 return getEt;		 
	 }
	 
	 public void validateBucketValues() throws Exception {
		 logInfo("Entered into validateBucketValues() method.");	
		 
		 threadSleep(3000);
		 float bucSSL=getBucketSSlValue();
		 float bucMAD =getBucketMADValue();
		 float bucGwl =getBucketGWLValue();		 
		 float fieldSSL =getETFieldValue(etLabSSL);
		 float fieldMad =getETFieldValue(etLabMAD);
		 float fieldGwl =getETFieldValue(etLabGWL);
		 
		 Assert.assertEquals(fieldSSL, bucSSL);
		 Assert.assertEquals(fieldMad, bucMAD);
		 Assert.assertEquals(fieldGwl, bucGwl);		 
	 }
	 
	 //Input expected data into ET fields
	 public void inputETValue(String expLabel, String value) throws Exception {
		 logInfo("Entered into inputETValue() method.");
		 wdWait(xpath, etLabels);		
		 int labSize=driver.findElements(By.xpath(etLabels)).size();
		 boolean isPresent= false;
		 for(int i=1;i<=labSize;i++) {
			 String labelName=driver.findElement(By.xpath(etLabBfr+i+zonesEnd)).getText().trim();
			 if(labelName.startsWith(expLabel)) {
				 isPresent=true;
				 sleep(2000);
				 WebElement input =driver.findElement(By.xpath(etInputField+i+etInputFieldEnd));
				 input.clear();	
				 input.sendKeys(value);	
				 sleep(2000);
				 break;
			 }
		 }if(!isPresent) {
			 Assert.assertTrue(isPresent,expLabel+" is not present.");
		 }		 
		 		 
	 }
	 
	 //Retrieves value of SSL from Bucket
	 public float getBucketSSlValue() throws Exception {
		 logInfo("Entered into validateBucketValues() method.");	
		 wdWait(xpath, buckSSL);
		 String actSSl= getText(xpath, buckSSL);
		 float ssl= Float.parseFloat(actSSl);
		 return ssl;
	 }
	 
	//Retrieves value of MAD from Bucket
		 public float getBucketMADValue() throws Exception {
			 logInfo("Entered into getBucketMADValue() method.");	
			 wdWait(xpath, buckSSL);
			 String actMad= getText(xpath, buckMAD);
			 float mad= Float.parseFloat(actMad);
			 return mad;
		 }
		 
	//Retrieves value of GWL from Bucket
	 public float getBucketGWLValue() throws Exception {
		 logInfo("Entered into getBucketGWLValue() method.");	
		 wdWait(xpath, buckSSL);
		 String actgwl= getText(xpath, buckGWL);
		 float gwl= Float.parseFloat(actgwl);
		 return gwl;
	 }
	 
	 public void incrementOrDecrementETValue(String expLabel, String incrementOrDecrement) throws Exception {
		 logInfo("Entered into getDefaultValue() method.");
		 wdWait(xpath, etLabels);		
		 int labSize=driver.findElements(By.xpath(etLabels)).size();
		 boolean isPresent= false;
		 for(int i=1;i<=labSize;i++) {
			 String labelName=driver.findElement(By.xpath(etLabBfr+i+zonesEnd)).getText().trim();
			 if(labelName.startsWith(expLabel)) {
				 isPresent=true;
				 sleep(500);
				 switch(incrementOrDecrement) {				 
				 case "increment":
					 WebElement plusIcon =driver.findElement(By.xpath(etInputField+i+etPlusIconEnd));
					 plusIcon.click();
					 break;
				 case "decrement":
					 WebElement minusIcon =driver.findElement(By.xpath(etInputField+i+etMinusIconEnd));
					 minusIcon.click();
					 break;
					 
				default :
					Assert.assertEquals(incrementOrDecrement, "check text of increment or decrment.");
					break;
				 
				 }		 
							
				 break;
			 }
		 }if(!isPresent) {
			 Assert.assertTrue(isPresent,expLabel+" is not present.");
		 }		 
		 	 
	 }
	 
	 
	 public void iterationETValue(String expLabel, String incrementOrDecrement, int iterate ) throws Exception {
		 for(int i=1;i<=iterate;i++) {
			 incrementOrDecrementETValue(expLabel, incrementOrDecrement); 
		 }
	 }
	 


public void verifySubOption(String expReportType, String[] expSubOption ) throws Exception {
		logInfo("Entered into verifySubOption() method.");
		clickOnObject("xpath", "");
		int infoSize=driver.findElements(By.xpath("")).size();
		boolean isPresnt =false;
		for(int i=1;i<=infoSize;i++) {
			WebElement infoHeader=driver.findElement(By.xpath(""+i+""));
			String ActName=infoHeader.getText().trim();			
			if(ActName.equalsIgnoreCase(expReportType)) {	
				isPresnt = true;
				infoHeader.click();
				wdWait("xpath", sp_SitesPlaceHolder);
				clickOnObject("xpath", sp_SitesPlaceHolder);
				int subOpt = driver.findElements(By.xpath("")).size();
				int  exptSUbOPtSize=expSubOption.length;				
				if(subOpt==exptSUbOPtSize) {
					boolean isStatePresent=false;
					for(int j=1;j<=subOpt;j++) {
						WebElement subOptions=driver.findElement(By.xpath(""+j+""));
						String ActSubOPtion=subOptions.getText().trim();
						threadSleep(1000);						
						if(expSubOption[j].equalsIgnoreCase(ActSubOPtion)) {							
							isStatePresent=true;	
							subOptions.click();
							break;		
					}
					if(!isStatePresent) {
							Assert.assertTrue(isStatePresent,ActSubOPtion+" is not present.");
						}						
					}
					
			}else {

					Assert.assertEquals(subOpt, exptSUbOPtSize);					
			}
				break;
			}
		}	
	}
	
public void selectHours(String expData)throws Exception{
	logInfo("Entered into selecthours() method.");
	int infoLength=driver.findElements(By.xpath(selectHoursRadio)).size();
	boolean isPresent=false;
	for(int i=1;i<=infoLength;i++) {
		WebElement infoHeader=driver.findElement(By.xpath(radioBtnStart+i+radioBtnEnd));
		String ActName=infoHeader.getText().trim();			
		if(ActName.equalsIgnoreCase(expData)) {	
			isPresent=true;
			infoHeader.click();
			break;
		}
	}
	if(!isPresent) {
		Assert.assertTrue(isPresent, expData+" is not present");
	}	
}
	public void wateringDelay()throws Exception{
	logInfo("Entered into wateringDelay() method.");
	sleep(5000);
	wdWait("xpath", wateringDelayTog);
	WebElement desp= driver.findElement(By.xpath(wateringDelayTog));		
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", desp);
	sleep(5000);
	selectHours(select_6);
	sleep(3000);
	clickOnButton("xpath", zonDetFlowOk);
	
	}
	public void wateringDelayInputHours()throws Exception{
		logInfo("Entered into wateringDelay() method.");
		SoftAssert sa = new SoftAssert();
		sleep(5000);
		wdWait("xpath", wateringDelayTog);
		WebElement desp= driver.findElement(By.xpath(wateringDelayTog));		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", desp);
		sleep(5000);
		selectHours(other);
		clickOnButton("xpath", zonDetFlowOk);
		sleep(1000);
		String actAlertMsg=getText("xpath",AlertHours);	
		sa.assertEquals(actAlertMsg,AlertMsg);	
		selectOtherInput("2");
		sleep(3000);
		clickOnButton("xpath", zonDetFlowOk);
		
	}
	public void selectOtherInput(String expHour) throws Exception {
		logInfo("Entered into OtherHours() method.");
		sleep(3000);
		wdWait("xpath", otherInput);
		clearText("xpath", otherInput);		
		enterText("xpath", progName, expHour);
		clearText("xpath", progName);
		enterText("xpath", progName, expHour);
	}
	public void waterDelayOff()throws Exception{
		logInfo("Entered into wateringDelayOff() method.");
		sleep(5000);
		wdWait("xpath", wateringDelayTog);
		WebElement desp= driver.findElement(By.xpath(wateringDelayTog));		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", desp);
		sleep(1000);
		clickOnButton("xpath", zonDetFlowOk);
		sleep(5000);
		
		
	}
	public void isTimer(String expTime) throws Exception {
		logInfo("Entered into isTimerSame() method.");
		wdWait("xpath", timer);
		boolean isPresent=false;
		String time= driver.findElement(By.xpath(timer)).getText();			
		if(time.contains(expTime)) {
				isPresent=true;				
			}
		if(!isPresent) {
			Assert.assertTrue(isPresent,expTime+ " : timer is not present");
		}
	}
	
	public void isWarningPresent(String expWarning) throws Exception {
		logInfo("Entered into isWarningPresent() method.");
		wdWait(css,warnSA);
		String actWarning=getText(css,warnSA);
		
		if(actWarning.equalsIgnoreCase(expWarning)) {
			clickOnButton(xpath, dialogYes);
		}else {
			clickOnButton(xpath, dialogYes);
			Assert.assertEquals(actWarning, expWarning);
		}
		
	}
	
	/******This method selects future date on current month,
	 * if current day is end of the month, automatically selects next month.
	 * @throws Exception 
	 */	

	public void handleStartDate() throws InterruptedException {
		logInfo("Entered into handleStartDate() method.");
		clickOnObject(css, startDateIcon);
		threadSleep(3000);
		int futureSize= driver.findElements(By.cssSelector(futureDaysInCalender)).size();			
		int alogritm = 0;		
		if(futureSize>=7) {			
			alogritm=3;	
			System.out.println("alog 3");
		}else if (!(futureSize==0))  {				
			alogritm = 7-futureSize;			
		}else {					
			clickOnObject(xpath, nextMonthArrrow);
			threadSleep(2000);
			alogritm=2;		
		}		
		    int i =2; //TestBase.generateRandomNumberInRange(alogritm, 7);				
			int weekSize= driver.findElements(By.cssSelector(futureDayBfr+i+")")).size();			
			if(weekSize==1){					
				clickOnObject(css, futureDayBfr+i+")");			
			}else {	
				System.out.println("More then one");
				int j =4; //TestBase.generateRandomNumberInRange(2, weekSize);					
				clickOnObject(css,futureDaySelect+j+futureDaySelectEnd+i+")");					
			}			
		threadSleep(3000);
		
	}
	
	
	
}

