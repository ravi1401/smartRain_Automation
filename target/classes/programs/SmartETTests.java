package smrtRain.programs;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.lib.Priority;

import smrtRain.settings.SettingMethods;

@Priority(6)
public class SmartETTests extends SettingMethods{	
	
	@Test(priority=601)
	public void smartET_CreateNormalProgram() throws Exception {
		logInfo("Entered into smartET_CreateNormalProgram() test.");			
//		
//		threadSleep(10000);
//		navigateToModule(alertsPage);
//		threadSleep(5000);
//		navigateToModule(sitesPage);
//		threadSleep(10000);		
//		selectExistingSite(existSmartStackSite);
		threadSleep(10000);
		selectMenuIconInSite(iconZone);
		selectMenuIconInSite(iconSiteConfig);
		String zoneLoaction=getTimeZone();		
		String zoneTime=date_Time(zoneLoaction);			
		selectMenuIconInSite(iconSiteHome);
		threadSleep(7000);
		double presentRainChance=getCurrentDayRainChance();			
		double getET=getCurrentDayET();
		
		selectMenuIconInSite(iconSiteConfig);
		double rainChanceToBe=rainChanceOfSiteConfig();
		
		double fwVer =getFWVersion();
		selectMenuIconInSite(iconZone);
		
		
		createZone(zoneSprayName);	
		selectZoneNumber();	
		irrigationType(irrTypeAll);		
		verifyDefaultFlowData(irrTypeSpray);
		addZoneFinalBtn();
		confirmModalBox(succssMsgText);	
		refreshScreen();
		selectMenuIconInSite(iconProgram);
		selectLargeButtonInProgram(addProg);
		createNewProgram(etProgName);
		typeOfWatering(labSmrtWaterET);
		selectZonesDD(labelSelectZone);		
		selectOptionFromDropDown(zoneSprayName);  
		programButtons(labAddZone);	
		timePeriod(labTimePM);
		setTime(11);
		programButtons(addProgram);
		String etTimeStamp=date_Time(timeZoneUTC);
		String mounatinTime=date_Time(timeZoneMountain);	
		confirmInProgram(msgAddedProg);			
		selectMenuIconInSite(iconZone);		
		selectMenuIconInSite(iconProgram);
		String proId = getProgramID(etProgName);	
		String date= getProgramDate(etProgName);
		
		threadSleep(7000);
		selectDotsBasedOnProgram(etProgName);                 //etProgName
		selectUpdateOrDelete(zoneUpdate);
		handleRedEye();
		float valGWL = (float) getETValue(etLabGWL);
		float valMad = (float) getETValue(etLabMAD);
		int valLA = getLAValue(etLabLA);
		double valIA = getETValue(etLabIrrgAmt);		
		selectMenuIconInSite(iconZone);
		String zoneNumber=getZoneNumber(zoneSprayName);	
		String zoneDuration= getZoneDuration(zoneSprayName);			
		selectMenuIconInSite(iconCalender);	
		selectMenuIconInSite(iconProgram);
		isProgramPresent(etProgName);			
		selectMenuIconInSite(iconCalender);
		selectMenuIconInSite(iconLogs);	
		int rowWaterSchedule = verifyDataFromColumn(10, alDescp,actSchCreatedBfr+etProgName+actSchCreatedAft);		
		if((fwVer==3)) {
			if(rainChanceToBe>presentRainChance) {					
				int rowSchCrDesc = verifyDataFromColumn(rowWaterSchedule, alDescp,etProgName+descEtProg1+valGWL);
			    verifyDataFromColumn(rowWaterSchedule, alDescp, descEtProg3+valLA+descEtProg4+valMad);
				verifyDataFromColumn(rowWaterSchedule, alDescp,descEtProg6+valIA+descEtProg7_1);
				int waterSchPack= verifyDataFromColumn(rowSchCrDesc, alDescp,actRunProgBfr+etProgName+actRunProgAft);
				selectExactPacketFromLogsTable(waterSchPack, alSeePacket);				
				getPacketData(FW3packSchd);
				getPacketData(packFW3ProID+proId);				
				getPacketData(packFW3SA+100);
				getPacketData(packFW3Cycle+1);				
				closePacket();
				
				int waterProgPack= verifyDataFromColumn(rowSchCrDesc, alDescp,actWaterProgBfr+etProgName+actRunProgAft);
				System.out.println(waterProgPack);
				selectExactPacketFromLogsTable(waterProgPack, alSeePacket);		
				getPacketData(FW3packProg);
				getPacketData(packFW3ProID+proId);	
				getPacketData(packFW3pgid+proId);
				getPacketData(packFW3ProgName+etProgName);
				closePacket();
			
			}
			
		}else if(fwVer>=(50)) {				
			if(rainChanceToBe>presentRainChance) {		
				int rowEtDesc = verifyDataFromColumn(rowWaterSchedule, alDescp,etProgName+descEtProg1); 
				selectExactPacketFromLogsTable(rowEtDesc, alSeePacket);
				getPacketData(timeStamp1+etTimeStamp);	
				getPacketData(packProgram);
				getPacketData(packProgramID+proId);			
				getPacketData(packProgName+etProgName);
				getPacketData(packTypeWatering+labSmrtWaterET);
				getPacketData(packStatus);
				getPacketData(pack50ZoneList+zoneNumber+" ]");
				getPacketData(zonesDuration+zoneDuration+" ],");
				closePacket();
			}else {
				System.out.println("eneterd here");
				int rowEtDesc = verifyDataFromColumn(rowWaterSchedule, alDescp,etProgName+descEtProg1); 
				isDataPresentInColumn(rowWaterSchedule-1, alDescp, descSuspendRain);
				isDataPresentInColumn(rowWaterSchedule-2, alDescp, etProgName+descEtProg1+valGWL+descEtProg2+getET+descEtProg3+valLA+descEtProg4+valMad+descEtProg5);
				selectExactPacketFromLogsTable(rowWaterSchedule-1, alSeePacket);
				getPacketData(packSuspend);	
				//getPacketData(timeStamp1+etTimeStamp);
				getPacketData(packProgramID+proId);
				getPacketData(proSuspendId);
				closePacket();
				
			}
		}else {
			System.err.println("Cannot create smart ET due to version is below 50");
		}
		
	}
	
	@Test(priority=602)
	public void smartET_verifyDefaultETValues() throws Exception {
		logInfo("Entered into smartET_verifyDefaultETValues() test.");		
		selectMenuIconInSite(iconProgram);
		selectLargeButtonInProgram(addProg);
		createNewProgram(etProgName);
		typeOfWatering(labSmrtWaterET);
		validateETLabels(etLabelText);
		compareDefaultETValues();	
		
	}
	
	@Test(priority=603)
	public void smartET_BucketValue() throws Exception {
		logInfo("Entered into smartET_BucketValue() test.");
		selectMenuIconInSite(iconZone);	
		selectMenuIconInSite(iconProgram);
		isProgramPresent(etProgName);
		selectDotsBasedOnProgram(etProgName);                 //etProgName
		selectUpdateOrDelete(zoneUpdate);
		handleRedEye();
		scrollToTop();
		validateBucketValues();		
	}
	
	@Test(priority=604)
	public void smartET_CycleSoak() throws Exception {
		logInfo("Entered into smartET_CycleSoak() test.");
		selectMenuIconInSite(iconProgram);
		selectMenuIconInSite(iconSiteConfig);
		double fwVer =getFWVersion();		
		selectMenuIconInSite(iconZone);	
		selectMenuIconInSite(iconProgram);
		selectDotsBasedOnProgram(etProgName);                 //etProgName
		selectUpdateOrDelete(zoneUpdate);
		scrollToTop();
		slideToggle(cycleSoak);
		programButtons(updateProgram);
		String updatedPacket=date_Time(timeZoneUTC);
		System.out.println(updatedPacket);
		waitTilldisableOfElement(30);
		confirmInProgram(progUpdMsg);    
		String proId = getProgramID(etProgName);			
		selectMenuIconInSite(iconCalender);
		selectMenuIconInSite(iconLogs);					
		int rowUpdated = verifyDataFromColumn(20, alDescp,actUpdated1+etProgName+actUpdated2); 
		if((fwVer==3)) {
			verifyDataFromColumn(rowUpdated-2, alDescp,actRunProgBfr+etProgName+actRunProgAft);
			selectExactPacketFromLogsTable(rowUpdated-2, alSeePacket);
			getPacketData(FW3packSchd);
			//getPacketData(packFW3Date+updatedPacket);
			getPacketData(packFW3SID+proId);
			getPacketData(packFW3Type+81+packFW3SA+100+packFW3Cycle+3);		
			
		}else {
			int rowWillWater =verifyDataFromColumn(rowUpdated, alDescp,etProgName+descEtProg1); 
			//verifyDataFromColumn(rowUpdated, alDescp,descBoosterDisabled);
			selectExactPacketFromLogsTable(rowWillWater, alSeePacket);
			getPacketData(timeStamp1+updatedPacket);	
			getPacketData(packProgram);
			getPacketData(packProgramID+proId);			
			getPacketData(packProgName+etProgName);
			//getPacketData(packTypeWatering+labSmrtWaterET);
			getPacketData(packStatus);
			closePacket();		
			
		}
		
		
		
		
		
	}
	
	@Test(priority=605)
	public void smartET_RainOverRide() throws Exception {
		logInfo("Entered into smartET_RainOverRide() test.");		
		selectMenuIconInSite(iconZone);	
		selectMenuIconInSite(iconSiteConfig);
		selectDotsToUpdateSiteDetails();   	
    	selectUpdateOrDelete(zoneUpdate);
    	rainSensor(rainSnsorNon);
    	selectSiteUpdateBtn();
    	selectMenuIconInSite(iconProgram);	
    	selectDotsBasedOnProgram(etProgName);                 //etProgName
		selectUpdateOrDelete(zoneUpdate);
		scrollToTop();
		slidersRain(rainOverride);
		//slidersRain(sp_BoosterPumpLab);
		
		programButtons(updateProgram);		
		waitTilldisableOfElement(30);
		confirmInProgram(progUpdMsg);  		
		selectMenuIconInSite(iconZone);
		selectMenuIconInSite(iconCalender);
		selectMenuIconInSite(iconLogs);	
		int rowSchedUpdated = verifyDataFromColumn(5, alDescp,actUpdated1+etProgName);
		verifyDataFromColDescription(rowSchedUpdated, descOverride);
		selectMenuIconInSite(iconSiteConfig);
		selectDotsToUpdateSiteDetails();   	
    	selectUpdateOrDelete(zoneUpdate);
    	rainSensor(rainSnsorBasic);
    	selectSiteUpdateBtn();
    	selectMenuIconInSite(iconProgram);	
    	selectDotsBasedOnProgram(etProgName);                 //etProgName
		selectUpdateOrDelete(zoneUpdate);
		scrollToTop();
		slidersRain(rainOverride);
		//slidersRain(sp_BoosterPumpLab);
		
		programButtons(updateProgram);
		String updatedPacket=date_Time(timeZoneUTC);
		waitTilldisableOfElement(30);
		confirmInProgram(progUpdMsg);  		
		String progId = getProgramID(etProgName);
		selectMenuIconInSite(iconZone);
		selectMenuIconInSite(iconCalender);
		selectMenuIconInSite(iconLogs);	
		int rowAgainUpdated = verifyDataFromColumn(20, alDescp,actUpdated1+etProgName);
		int rainRow=verifyDataFromColumn(rowAgainUpdated, alDescp,descOverride);
		selectExactPacketFromLogsTable(rainRow, alSeePacket);
		getPacketData(packRainOver);
		getPacketData(timeStamp1+updatedPacket);
		getPacketData(packProgramID2+progId);	
    	closePacket();
		
	}
	
	
	@Test(priority=606)
	public void smartET_SmartStack() throws Exception {
		logInfo("Entered into smartET_SmartStack() test.");	
		selectMenuIconInSite(iconSiteHome);	
		double presentRainChance=getCurrentDayRainChance();
		double getET=getCurrentDayET();
		selectMenuIconInSite(iconSiteConfig);
		double fwVer =getFWVersion();
		selectMenuIconInSite(iconProgram);
		deleteAllprograms();
		selectMenuIconInSite(iconProgram);
		selectLargeButtonInProgram(addProg);
		createNewProgram(smartStackETProg);
		typeOfWatering(labSmrtWaterET);
		handleSmartStackToggle();
	//	slideToggle(smartStackSlide);      // smartStackSlide); "PROGRAM.SMART_STACK") ;                 //smartStackSlide);
	
		timePeriod(labTimePM);
		setTime(11);
		//smartStackToggle();
		selectZoneButton();
		selectZoneButton();
		selectZoneButton();		
		selectZoneButton();	
    	createSchedule();	
		String zonesList= retrieveZoneNumbersOfSmartStack();
		System.out.println("zonesList "+zonesList);
		programButtons(addProgram);
		String runtimeUTC=date_Time(timeZoneUTC);	
		confirmInProgram(msgAddedProg);
		refreshScreen();
		selectMenuIconInSite(iconProgram);
		String proId = getProgramID(smartStackETProg);	
		System.out.println("profd Id : "+proId);
		threadSleep(7000);
		selectDotsBasedOnProgram(smartStackETProg);                 //etProgName
		selectUpdateOrDelete(zoneUpdate);
		handleRedEye();
		
		float valGWL = (float) getETValue(etLabGWL);
		double valMad = getETValue(etLabMAD);
		int valLA = (int) getETValue(etLabLA);
		double valIA = getETValue(etLabIrrgAmt);
		
		selectMenuIconInSite(iconCalender);
		selectMenuIconInSite(iconLogs);
		int rowSchdCreate= verifyDataFromColumn(5, alDescp,actSchCreatedBfr+smartStackETProg+actSchCreatedAft); 
		System.out.println("Size "+rowSchdCreate);
		if((fwVer==3)) {
			
		}else if(fwVer>=(50)) {	
			int etRow = verifyDataFromColumn(rowSchdCreate, alDescp,smartStackETProg+descEtProg1+valGWL);
//			+descEtProg2+getET+
//			descEtProg3+valLA+descEtProg4+valMad+descEtProg5);
			System.out.println("rows"+ etRow);
			selectExactPacketFromLogsTable(etRow, alSeePacket);	
			getPacketData(packProgram);	
			//getPacketData(timeStamp1+runtimeUTC);								
			getPacketData(packProgramID+proId);		
			getPacketData(packProgName+smartStackETProg);
			getPacketData(packTypeWatering+labSmrtWaterET);	
			getPacketData(packStatus);			
			//getPacketData(pack50ZoneList+zonesList);
			//getPacketData(expireTime);	
			closePacket();		
			
			
			
		}else {
			System.err.println("Cannot create smart ET due to version is below 50");
		}				
	}
	
	
	//Issue - https://smartrain.atlassian.net/browse/SR-21
		@Test(priority=607)
		public void smartET_GWLandMADBasedOnFC() throws Exception {
			logInfo("Entered into smartEt_GWLandMADBasedOnFC() test.");	
			double maxIA=4.0, MaxSSL=8.0, expVal=2.0, MAD=7.0;
					
			selectMenuIconInSite(iconCalender);		
			selectMenuIconInSite(iconProgram);		
			selectDotsBasedOnProgram(smartStackETProg);                 //etProgName
			selectUpdateOrDelete(zoneUpdate);	
			handleRedEye();
			inputETValue(etLabIrrgAmt, "4");
			handleConfirmModal(changeAlertMsg);
			inputETValue(etLabIAMul, "2");
			inputETValue(etLabGWL, "7");
			inputETValue(etLabMAD, "7");
			iterationETValue(etLabMAD, increment, 20);
			inputETValue(etLabMAD, "7");
			programButtons(updateProgram);				
			confirmInProgram(progUpdMsg);
			selectMenuIconInSite(iconCalender);		
			selectMenuIconInSite(iconProgram);		
			selectDotsBasedOnProgram(smartStackETProg);                 //etProgName
			selectUpdateOrDelete(zoneUpdate);
			handleRedEye();
			double valSSL =retrieveETValue(etLabSSL);	
			double valGWL =retrieveETValue(etLabGWL);	
			double valMAD =retrieveETValue(etLabMAD);	
			Assert.assertEquals(valSSL, MaxSSL);
			Assert.assertEquals(valGWL, MAD);
			Assert.assertEquals(valMAD, MAD);		
			inputETValue(etLabIrrgAmt, "1");
			handleConfirmModal(changeAlertMsg);
			programButtons(updateProgram);				
			confirmInProgram(progUpdMsg);
			selectMenuIconInSite(iconCalender);		
			selectMenuIconInSite(iconProgram);		
			selectDotsBasedOnProgram(smartStackETProg);                 //etProgName
			selectUpdateOrDelete(zoneUpdate);
			handleRedEye();
			double finalGWL =retrieveETValue(etLabGWL);	
			double finalMAD =retrieveETValue(etLabMAD);	
			Assert.assertEquals(finalGWL, expVal);
			Assert.assertEquals(finalMAD, expVal);
		
		}	
	
	
	//Issue - https://smartrain.atlassian.net/browse/SR-21
	@Test(priority=608)
	public void smartET_ProgamOff() throws Exception {
		logInfo("Entered into smartET_ProgamOff() test.");
		selectMenuIconInSite(iconLogs);
		selectMenuIconInSite(iconProgram);	
		selectDotsBasedOnProgram(smartStackETProg);                 //etProgName
		selectUpdateOrDelete(zoneUpdate);	
		programToggleSlider();
		programButtons(updateProgram);
		String mountainTime=date_Time(timeZoneMountain);		
		confirmInProgram(progUpdMsg);	
		selectMenuIconInSite(iconCalender);
		selectMenuIconInSite(iconLogs);
		int rowUpdated = verifyDataFromColumn(5, alDescp,actUpdated1+smartStackETProg);
		int rowSchedule= verifyDataFromColumn(rowUpdated, alDescp,smartStackETProg+waterOff);
		selectExactPacketFromLogsTable(rowSchedule, alSeePacket);	
		getPacketData(packStatusOff);
		//getPacketData(packAllDays);
		//getPacketData(enableTime+mountainTime);
		closePacket();			
	}
	
	@Test(priority=620, dependsOnMethods = {"smartET_ProgamOff"})
	public void smartET_DoNotListInRunProgram() throws Exception {
		logInfo("Entered into smartET_DoNotListInRunProgram() test.");
		selectMenuIconInSite(iconCalender);
		selectMenuIconInSite(iconProgram);				
		selectLargeButtonInProgram(runProg);
		doNotDisplayProgramToRun(smartStackETProg);
		refreshScreen();
		
	}
	
	
	@Test(priority=609)
	public void smartEt_IncrmentOrDecrement() throws Exception {
		logInfo("Entered into smartEt_IncrmentOrDecrement() test.");		
		selectMenuIconInSite(iconMap);
		selectMenuIconInSite(iconProgram);
		selectLargeButtonInProgram(addProg);
		createNewProgram(etProgName);
		typeOfWatering(labSmrtWaterET);
		//int saValue=getSeasonalAdjustmentInput();		
		double la= retrieveETValue(etLabLA);		
		incrementOrDecrementETValue(etLabLA, increment);
		handleConfirmModal(changeAlertMsg);
		double valLAinc = retrieveETValue(etLabLA);		
		Assert.assertEquals(valLAinc,la+5);
		/***Irrigation Amount***/
		double expIA= retrieveETValue(etLabIrrgAmt);		
		incrementOrDecrementETValue(etLabIrrgAmt, increment);
		incrementOrDecrementETValue(etLabIrrgAmt, increment);
		double incexpIA= retrieveETValue(etLabIrrgAmt);		
		Assert.assertEquals(incexpIA,(expIA+.2));		
		/***GWL***/
		double expGWL= retrieveETValue(etLabGWL);		
		incrementOrDecrementETValue(etLabGWL, increment);
		incrementOrDecrementETValue(etLabGWL, decrement);
		double incGWL= retrieveETValue(etLabGWL);		
		Assert.assertEquals(incGWL,expGWL);
		/***MAD***/
		double expMAD= retrieveETValue(etLabMAD);		
		incrementOrDecrementETValue(etLabMAD, increment);
		incrementOrDecrementETValue(etLabMAD, increment);
		incrementOrDecrementETValue(etLabMAD, increment);
		double incMAD= retrieveETValue(etLabMAD);		
		Assert.assertEquals(incMAD,(expMAD+.3));
		inputETValue(etLabLA, "150");
		iterationETValue(etLabLA, increment, 5);
		double actMaxLA= retrieveETValue(etLabLA);
		System.out.println("actMaxLA "+actMaxLA);
		Assert.assertEquals(actMaxLA,150.0);
		
		inputETValue(etLabLA, "15");
		incrementOrDecrementETValue(etLabIrrgAmt, increment);
		double actMinLA= retrieveETValue(etLabLA);
		Assert.assertEquals(actMinLA,50.0);
		
	}
	
	
	@Test(priority=610)
	public void smartET_ValidateIAandIAM() throws Exception {
		logInfo("Entered into smartET_ValidateIAandIAM() test.");	
		double maxIA=3.0, maxIAMultipler=4.0;
		double minIA=0.0, minIAMultipler=1.0;
				
		selectMenuIconInSite(iconCalender);
		selectMenuIconInSite(iconProgram);	
		selectLargeButtonInProgram(addProg);
		createNewProgram(etProgName);
		typeOfWatering(labSmrtWaterET);
		
		//Validates Max values IA & IAM
		inputETValue(etLabIrrgAmt, "2");		
		handleConfirmModal(changeAlertMsg);
		incrementOrDecrementETValue(etLabIrrgAmt, increment);
		
		iterationETValue(etLabIrrgAmt, increment, 20);
		double actMaxIAAmount= retrieveETValue(etLabIrrgAmt);
		System.out.println("maxIAAmount :"+actMaxIAAmount);
		Assert.assertEquals(actMaxIAAmount, maxIAMultipler);
		iterationETValue(etLabIAMul, increment, 20);
		double actMaxIAMul= retrieveETValue(etLabIAMul);
		System.out.println("actMaxIAMul :"+actMaxIAMul);
		Assert.assertEquals(actMaxIAMul, maxIA);
		//validates Min values IA & IAM
		
		inputETValue(etLabIrrgAmt, "0");
		inputETValue(etLabIAMul, "1");
		iterationETValue(etLabIrrgAmt, decrement, 22);
		iterationETValue(etLabIAMul, decrement, 15);
		double actMinIA= retrieveETValue(etLabIrrgAmt);
		double actMinIAMul= retrieveETValue(etLabIAMul);
		
		Assert.assertEquals(actMinIAMul, minIAMultipler);		
		Assert.assertEquals(actMinIA, minIA);
		double valSSL =retrieveETValue(etLabSSL);
		Assert.assertEquals(valSSL, minIA);	
	}	
	
	
	
	
	@Test(priority=612)
	public void smartET_MultiRunTimes() throws Exception {
		logInfo("Entered into smartET_MultiRunTimes() test.");	
		selectMenuIconInSite(iconSiteHome);	
		double presentRainChance=getCurrentDayRainChance();
		double getET=getCurrentDayET();
		selectMenuIconInSite(iconSiteConfig);
		double fwVer =getFWVersion();
		selectMenuIconInSite(iconProgram);
		deleteAllprograms();
		selectMenuIconInSite(iconProgram);
		selectLargeButtonInProgram(addProg);
		createNewProgram(etSmartMulti);
		typeOfWatering(labSmrtWaterET);
		slideToggle(smartStackSlide);      // smartStackSlide); "PROGRAM.SMART_STACK") ;   
		slideToggle(multiRunSlide);
		
		timePeriod(labTimePM);
		setTime(8);
		additionalTimeIcon();
		timePeriod(labTimePM);
		setTime(11);
		additionalTimeIcon();
		//smartStackToggle();
		selectZoneButton();
		selectZoneButton();
		selectZoneButton();		
		selectZoneButton();	
    	createSchedule();	
		String zonesList= retrieveZoneNumbersOfSmartStack();
		System.out.println("zonesList "+zonesList);
		programButtons(addProgram);
		String runtimeUTC=date_Time(timeZoneUTC);	
		confirmInProgram(msgAddedProg);
		refreshScreen();
		selectMenuIconInSite(iconProgram);
		String proId = getProgramID(etSmartMulti);	
		System.out.println("profd Id : "+proId);
		threadSleep(7000);
		selectDotsBasedOnProgram(etSmartMulti);                 //etProgName
		selectUpdateOrDelete(zoneUpdate);
		handleRedEye();
		
		float valGWL = (float) getETValue(etLabGWL);
		double valMad = getETValue(etLabMAD);
		int valLA = (int) getETValue(etLabLA);
		double valIA = getETValue(etLabIrrgAmt);		
		selectMenuIconInSite(iconCalender);
		selectMenuIconInSite(iconLogs);
		int rowSchCreated = verifyDataFromColumn(5, alDescp,actSchCreatedBfr+etSmartMulti+actSchCreatedAft); 
		
		int etRow = verifyDataFromColumn(rowSchCreated, alDescp,etSmartMulti+descEtProg1+valGWL);

		System.out.println("rows"+ etRow);
		selectExactPacketFromLogsTable(etRow, alSeePacket);	
		getPacketData(packProgram);	
		//getPacketData(timeStamp1+runtimeUTC);								
		getPacketData(packProgramID+proId);		
		getPacketData(packProgName+etSmartMulti);
		getPacketData(packTypeWatering+labSmrtWaterET);	
		getPacketData(packStatus);			
		getPacketData(pack50ZoneList+zonesList+", "+zonesList);
		//getPacketData(expireTime);	
		closePacket();
		
	
		
	
	}
	
	
	@Test(priority=613)
	public void smartET_SmartStackWithCycleSoak() throws Exception {
		logInfo("Entered into smartET_SmartStackWithCycleSoak() test.");	
		selectMenuIconInSite(iconSiteHome);	
		double presentRainChance=getCurrentDayRainChance();
		double getET=getCurrentDayET();
		selectMenuIconInSite(iconSiteConfig);
		double fwVer =getFWVersion();
		selectMenuIconInSite(iconProgram);
		deleteAllprograms();
		selectMenuIconInSite(iconProgram);
		selectLargeButtonInProgram(addProg);
		createNewProgram(etSmartMulti);
		typeOfWatering(labSmrtWaterET);
		slideToggle(smartStackSlide);      // smartStackSlide); "PROGRAM.SMART_STACK") ;   
		slideToggle(cycleSoak);
		
		timePeriod(labTimePM);
		setTime(8);
		additionalTimeIcon();
		timePeriod(labTimePM);
		setTime(11);
		additionalTimeIcon();
		//smartStackToggle();
		selectZoneButton();
		selectZoneButton();
		selectZoneButton();		
		selectZoneButton();	
    	createSchedule();	
		String zonesList= retrieveZoneNumbersOfSmartStack();
		System.out.println("zonesList "+zonesList);
		programButtons(addProgram);
		String runtimeUTC=date_Time(timeZoneUTC);	
		confirmInProgram(msgAddedProg);
		refreshScreen();
		selectMenuIconInSite(iconProgram);
		String proId = getProgramID(etSmartMulti);	
		System.out.println("profd Id : "+proId);
		threadSleep(7000);
		selectDotsBasedOnProgram(etSmartMulti);                 //etProgName
		selectUpdateOrDelete(zoneUpdate);
		handleRedEye();		
		float valGWL = (float) getETValue(etLabGWL);
		double valMad = getETValue(etLabMAD);
		int valLA = (int) getETValue(etLabLA);
		double valIA = getETValue(etLabIrrgAmt);		
		selectMenuIconInSite(iconCalender);
		selectMenuIconInSite(iconLogs);
		int rowSchCreated = verifyDataFromColumn(5, alDescp,actSchCreatedBfr+etSmartMulti+actSchCreatedAft); 
		
		int etRow = verifyDataFromColumn(rowSchCreated, alDescp,etSmartMulti+descEtProg1+valGWL);

		System.out.println("rows"+ etRow);
		selectExactPacketFromLogsTable(etRow, alSeePacket);	
		getPacketData(packProgram);	
		//getPacketData(timeStamp1+runtimeUTC);								
		getPacketData(packProgramID+proId);		
		getPacketData(packProgName+etSmartMulti);
		getPacketData(packTypeWatering+labSmrtWaterET);	
		getPacketData(packStatus);			
		getPacketData(pack50ZoneList+zonesList+", "+zonesList);
		//getPacketData(expireTime);	
		closePacket();	
	
	}
	
	
	@Test(priority=614)
	public void smartStackWithMultipleRunTimes() throws Exception {
		logInfo("Entered into smartStackWithMultipleRunTimes() test.");
		sleep(4000);
		selectMenuIconInSite(iconZone);	
		selectMenuIconInSite(iconProgram);
//		selectLargeButtonInProgram(addProg);
//		createNewProgram(ssMultiProg);
//		smartStackToggle();	
//		slideToggle(multiRun);
//		additionalTimeIcon();
//		timePeriod(labTimePM);
//		setTime(11);
//		additionalTimeIcon();
//		typeOfWatering(labSmrtWater);
//		handleSmartStackToggle();
//		clickOnRepeatsDP(selctDaysDp);
//		selectOptionFromDropDown("Even"); 		
//		selectZoneButton();
//		selectZoneButton();
//		selectZoneButton();
//		selectZoneButton();
//		selectZoneButton();
//		selectZoneButton();		
//		createSchedule();	
//		String zonesList= retrieveZoneNumbersOfSmartStack();
//		System.out.println("zonesList "+zonesList);
//		programButtons(addProgram);
//		String runtimeUTC=date_Time(timeZoneUTC);		
//		confirmInProgram(msgAddedProg);	
		refreshScreen();
		selectMenuIconInSite(iconProgram);
		String proId = getProgramID(ssMultiProg);	
		System.out.println(proId +" proId");
		selectMenuIconInSite(iconProgram);
		String weekDays = getSelectedDays(ssMultiProg);	
		System.out.println(weekDays +" weekDays");
		selectMenuIconInSite(iconCalender);
		selectMenuIconInSite(iconLogs);
		verifyDataFromColumn(15, alDescp,actSchCreatedBfr+ssMultiProg+actSchCreatedAft); 
		int rowWaterSchedule = verifyDataFromColumn(15, alDescp,actRunProgBfr+ssMultiProg+actRunProgAft);
		selectExactPacketFromLogsTable(rowWaterSchedule, alSeePacket);		
		//getPacketData(timeStamp1+runtimeUTC);		
		getPacketData(packProgram);		
		getPacketData(packProgramID+proId);		
		getPacketData(packProgName+ssMultiProg);
		getPacketData(packTypeWatering+labSmrtWater);	
		getPacketData(packStatus);	
		getPacketData(packDays+weekDays+zonesEnd);
		//getPacketData(pack50ZoneList+zonesList+","+zonesList+zonesEnd);	
		getPacketData(expireTime);			
		closePacket();		
	}
	
	//SMRTMB-1757	
		@Test(priority=615)
		public void stack_UpdateProgramByAddingZones() throws Exception {
			logInfo("Entered into stack_UpdateProgramByAddingZones() test.");
			sleep(7000);	
			selectMenuIconInSite(iconZone);
			selectMenuIconInSite(iconProgram);
			selectDotsBasedOnProgram(smartStackProg);                 //progAllName
			selectUpdateOrDelete(zoneUpdate);
			scrollToTop();
			typeOfWatering(labSmrtWater);
			selectZoneButton();
			createSchedule();	
			String zonesList= retrieveZoneNumbersOfSmartStack();
			
			programButtons(updateProgram);	
			String runtimeUTC=date_Time(timeZoneUTC);		
			confirmInProgram(progUpdMsg);
			
			String proId = getProgramID(smartStackProg);			
			
			selectMenuIconInSite(iconProgram);
			String weekDays = getSelectedDays(smartStackProg);
			
			
			selectMenuIconInSite(iconCalender);
			selectMenuIconInSite(iconLogs);
			verifyDataFromColumn(7, alDescp,actUpdated1+smartStackProg); 
			int rowWaterSchedule = verifyDataFromColumn(5, alDescp,actRunProgBfr+smartStackProg+actRunProgAft);
			selectExactPacketFromLogsTable(rowWaterSchedule, alSeePacket);			
			getPacketData(timeStamp1+runtimeUTC);		
			getPacketData(packProgram);						
			getPacketData(packProgramID+proId);		
			getPacketData(packProgName+smartStackProg);
			getPacketData(packTypeWatering+labSmrtWater);	
			getPacketData(packStatus);	
			getPacketData(packDays+weekDays+zonesEnd);
			getPacketData(pack50ZoneList+zonesList);
			getPacketData(expireTime);	
			closePacket();		
		}	
		
		
		@Test(priority=616)
		public void stack_ManualStackOn() throws Exception {
			logInfo("Entered into stack_ManualStackOn() test.");
			selectMenuIconInSite(iconZone);
			selectMenuIconInSite(iconProgram);
			selectDotsBasedOnProgram(smartStackProg);                 //progAllName
			selectUpdateOrDelete(zoneUpdate);
			scrollToTop();
			manualStack("on");
			//dragZoneInStackGraph();
			programButtons(updateProgram);	
			String runtimeUTC=date_Time(timeZoneUTC);		
			confirmInProgram(progUpdMsg);		
		}
		
		@Test(priority=617)
		public void deleteZoneWhichAssignedToProgram() throws Exception {
			logInfo("Entered into deleteZoneWhichAssignedToProgram() test.");		
			selectMenuIconInSite(iconCalender);			
			selectMenuIconInSite(iconZone);	
			int bfrZoneCount= getNoOfZonesFromGrid();		
			selectExistingZone(stackZone2);             
			deleteZone(zoneDetContentText);
			selectMenuIconInSite(iconZone);	
			int AftZoneCount= getNoOfZonesFromGrid();		
			if(bfrZoneCount>AftZoneCount) {
				zoneNotToPresent(stackZone2);
			//System.out.println("status :"+isZonePresent(zoneRotorName));			
			}else {
				
				Assert.assertNotEquals(bfrZoneCount, AftZoneCount);
			}			
		}
		
		//SMRTMB-1857 - 16th issue.	
		@Test(priority=618)
		public void stack_ValidateOverTheMaxFlow() throws Exception {
			logInfo("Entered into stack_ValidateOverTheMaxFlow() test.");			
			sleep(7000);
			selectMenuIconInSite(iconSiteConfig);			
			double fwVer = getFWVersion();
			System.out.println(fwVer);
			
			selectMenuIconInSite(iconProgram);
			selectMenuIconInSite(iconZone);
			createZone(stackZone);
			selectZoneNumber();
			verifyDefaultFlowData(irrTypeDrip);
			addZoneFinalBtn();								
			confirmModalBox(succssMsgText);					
			String zoneNumber=getZoneNumber(stackZone);
			
			System.out.println("zoneNumber:"+zoneNumber);
			
			selectMenuIconInSite(iconProgram);
			selectLargeButtonInProgram(addProg);
			createNewProgram(ssMaxFlow);
			smartStackToggle();
			typeOfWatering(labRegWater);
			selectZonesDD(labelSelectRepeat);
			selectOptionFromDropDown(selctDaysDp); 
			selectDaysForSmartStack(3);		
			selectExactZoneInStack(zoneNumber);		
			createSchedule();	
			String zonesList= retrieveZoneNumbersOfSmartStack();
			System.out.println("zonesList "+zonesList);
			programButtons(addProgram);
			String runtimeUTC=date_Time(timeZoneUTC);		
			confirmInProgram(msgAddedProg);	
			String proId = getProgramID(ssMaxFlow);		
		}	
	

}
