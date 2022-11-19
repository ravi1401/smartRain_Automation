package smrtRain.programs;

import org.testng.annotations.Test;

import com.lib.Priority;
import com.lib.TestBase;



@Priority(5)
public class ProgramTests extends ProgramMethods{	
	
	@Test(priority=501)
	public void verifyAddedZonesInLogs() throws Exception {
		logInfo("Entered into verifyAddedZonesInLogs() test.");				
		threadSleep(7000);
		navigateToModule(reportsPage);	
		sleep(10000);
		navigateToModule(sitesPage);
		sleep(10000);
		selectSiteByWildSearch(existSiteFM50);	
		selectMenuIconInSite(iconCalender);	;	
		selectMenuIconInSite(iconZone);
		String firstZone=getFirstZoneName();
		selectExistingZone(firstZone);		
		deleteZone(zoneDetContentMsg);	
		String firstZone1=getFirstZoneName();
		selectExistingZone(firstZone1);		
		deleteZone(zoneDetContentMsg);	
		String firstZone2=getFirstZoneName();
		selectExistingZone(firstZone2);		
		deleteZone(zoneDetContentMsg);			
		createZone(zoneRotorName);	  
		selectZoneNumber();	
		irrigationType(irrTypeAll);	
		verifyDefaultFlowData(irrTypeRotor);
		addZoneFinalBtn();
		confirmModalBox(succssMsgText);		
		selectMenuIconInSite(iconZone);	
		createZone(zoneSprayName);
		selectZoneNumber();	
		verifyDefaultFlowData(irrTypeSpray);
		addZoneFinalBtn();	
		confirmModalBox(succssMsgText);	
		selectMenuIconInSite(iconZone);	
		createZone(zoneDripName1);
		selectZoneNumber();	
		verifyDefaultFlowData(irrTypeSpray);
		addZoneFinalBtn();	
		confirmModalBox(succssMsgText);	
		selectMenuIconInSite(iconZone);		
		createZone(zoneDripName2);
		selectZoneNumber();
		verifyDefaultFlowData(irrTypeDrip);
		addZoneFinalBtn();
		
		String runtimePacket=date_Time(timeZoneUTC);							
		confirmModalBox(succssMsgText);					
		String zoneNumber=getZoneNumber(zoneDripName2);				
		selectMenuIconInSite(iconLogs);	
		verifyDataFromColumn(30, alDescp, zoneDesc+zoneDripName2);
		int rowDeviceRequested = verifyDataFromColumn(30, alDescp,actDeviceReqested);
		selectExactPacketFromLogsTable(rowDeviceRequested, alSeePacket);
		getPacketData(actFlowLimit1+runtimePacket);
		getPacketData(actFlowLimit2+zoneNumber+actFlowLimit3);	
		closePacket();			
		
	}
	
	@Test(priority=502)
	public void addNewRegularWateringProgram() throws Exception {
		logInfo("Entered into addNewRegularWateringProgram() test.");		
		
		threadSleep(7000);
		selectMenuIconInSite(iconProgram);		
		selectLargeButtonInProgram(addProg);
		createNewProgram(programName);		
		typeOfWatering(labRegWater);
		handleStartDate();
		selectZonesDD(labelSelectZone);		
		selectOptionFromDropDown(zoneDripName2);           //zoneDripName	
		programButtons(labAddZone);		
		clickOnRepeatsDP("Even");
		selectOptionFromDropDown("Even"); 	
		createNewProgram(programName);
		programButtons(addProgram);
		confirmInProgram(msgAddedProg);
		sleep(7000);
		selectMenuIconInSite(iconCalender);	
		selectMenuIconInSite(iconProgram);
		isProgramPresent(programName);		
	}
	
	@Test(priority=503)
	public void addSmrtWateringProgram() throws Exception {
		logInfo("Entered into addSmrtWateringProgram() test.");
		//String zoneRotorName= "Green Rotor 20";
		selectMenuIconInSite(iconCalender);	
		selectMenuIconInSite(iconProgram);	
		selectLargeButtonInProgram(addProg);
		createNewProgram(progSmartName);
		typeOfWatering(labSmrtWater);
		handleStartDate();
		selectZonesDD(labelSelectZone);		
		//dynamicSelectionFromDropdown();    //zoneRotorName
		selectOptionFromDropDown(zoneRotorName);
		programButtons(labAddZone);
		clickOnRepeatsDP(labelSelectRepeat);
		selectOptionFromDropDown("Even");
		programButtons(addProgram);
		confirmInProgram(msgAddedProg);
		threadSleep(7000);
		selectMenuIconInSite(iconCalender);	
		selectMenuIconInSite(iconProgram);
		isProgramPresent(progSmartName);
		
	}
	
	
	
	/***Same configured with  1st addNewRegularWateringProgram *****/
	
	@Test(priority=504)
	public void validateProgramWithSameConfig() throws Exception {
		logInfo("Entered into validateProgramWithSameConfig() test.");
		String programName="REGPRO "+TestBase.generateRandomNumberInRange(0, 2000);
		threadSleep(3000);
		selectMenuIconInSite(iconCalender);	
		selectMenuIconInSite(iconProgram);	
		selectLargeButtonInProgram(addProg);
		createNewProgram(programName);
		handleStartDate();
		selectZonesDD(labelSelectZone);
		selectOptionFromDropDown(zoneDripName2);  
		typeOfWatering(labRegWater);
		programButtons(labAddZone);		
		clickOnRepeatsDP("Even"); 
		programButtons(addProgram);
		handleConfirmModal(msgSameTime);			
		cancelButton();
		
	}
	
	
	@Test(priority=505)
	public void programOverlapStartOrEndTimes() throws Exception {
		logInfo("Entered into programOverlapStartOrEndTimes() test.");
		String programName="OverLap "+TestBase.generateRandomNumberInRange(0, 2000);
		sleep(7000);
		selectMenuIconInSite(iconCalender);	
		selectMenuIconInSite(iconProgram);	
		selectLargeButtonInProgram(addProg);
		createNewProgram(programName);
		typeOfWatering(labRegWater);
		handleStartDate();
		selectZonesDD(labelSelectZone);
		selectOptionFromDropDown(zoneDripName2);  		
		programButtons(labAddZone);
		timePeriod(labTimePM);
		setTime(8);
		clickOnRepeatsDP(labelSelectRepeat);
		selectOptionFromDropDown("Even"); 
		programButtons(addProgram);
		handleConfirmModal(msgtimeOverLap);				
		sleep(3000);
		confirmInProgram(msgAddedProg);
		sleep(4000);		
		selectMenuIconInSite(iconCalender);	
		selectMenuIconInSite(iconProgram);
		isProgramPresent(programName);
		selectDotsBasedOnProgram(programName);                 //progAllName
		selectUpdateOrDelete(zoneDelete);
		confirmStatusModelBox(progDelete+programName+progDeleteAft);
		confirmInProgram(progDelMsg+programName);
		
		
		
	}	
	
	@Test(priority=506)
	public void updateExistingProgram() throws Exception {
		logInfo("Entered into updateExistingProgram() test.");
		//String programName="REGPRO 540";       
		selectMenuIconInSite(iconCalender);	
		selectMenuIconInSite(iconProgram);
		selectDotsBasedOnProgram(programName);              //programName);                 //progAllName
		selectUpdateOrDelete(zoneUpdate);
		scrollToTop();
		createNewProgram(progUpdatedName);
		typeOfWatering(labRegWater);		
		//slideToggle(cycleSoak);
		slideToggle(multiRun);
		confirmInProgram(multiConfirmText); 
		timePeriod(labTimePM);
		setTime(8);
		additionalTimeIcon();
		timePeriod(labTimePM);
		setTime(11);
		additionalTimeIcon();
		createSchedule();	
		programButtons(updateProgram);	
		confirmInProgram(progUpdMsg);      
		sleep(7000);
		selectMenuIconInSite(iconCalender);	
		selectMenuIconInSite(iconProgram);
		isProgramPresent(progUpdatedName);
		
	}
	
	
	
	
	
	@Test(priority=520)
	public void deleteAllPrograms() throws Exception {
		logInfo("Entered into deleteAllPrograms() test.");
		//String progSmartName="TEST";               
		selectMenuIconInSite(iconCalender);	
		selectMenuIconInSite(iconProgram);
		selectDotsBasedOnProgram(progSmartName);                 //progAllName
		selectUpdateOrDelete(zoneDelete);
		confirmStatusModelBox(progDelete+progSmartName+progDeleteAft);
		confirmInProgram(progDelMsg+progSmartName);		
		selectMenuIconInSite(iconProgram);
		deleteAllprograms(); 

	}	
	
	//SMRTMB-2311 - Seasonal adjustment value accepting 0
		@Test(priority=507)
		public void program_ValidateSeasonalAdjustment() throws Exception {
			logInfo("Entered into program_ValidateSeasonalAdjustment() test.");					
			selectMenuIconInSite(iconCalender);
			selectMenuIconInSite(iconProgram);	
			selectLargeButtonInProgram(addProg);
			createNewProgram(etProgName);
			typeOfWatering(labSmrtWater);
			setTime(3);
			seasonalAdjustmentInput("0");
			isWarningPresent(warnSAText);
			int saValue=getSeasonalAdjustmentInput();
			System.out.println(saValue);
			
			selectZonesDD(labelSelectZone);
			dynamicSelectionFromDropdown();
			programButtons(labAddZone);		
			selectZonesDD(labelSelectRepeat);
			selectOptionFromDropDown("Even"); 	

			seasonalAdjustmentInput("5");			
			programButtons(addProgram);
			
			confirmInProgram(msgAddedProg);
			sleep(7000);
			selectMenuIconInSite(iconCalender);	
			selectMenuIconInSite(iconProgram);
			isProgramPresent(etProgName);		

			
		}
		
		/****This scenarios does not required as functionality changes. Add button will be disable
		 * till all mandatory fields are filled.   ****/
		@Test(priority=508)
		public void program_ValidateWarningMessages() throws Exception {
			logInfo("Entered into program_ValidateWarningMessages() test.");					
			selectMenuIconInSite(iconCalender);
			selectMenuIconInSite(iconProgram);	
			selectLargeButtonInProgram(addProg);	
			programButtons(labAddZone);	
			isWarningPresent(warningAddZones);
			selectZonesDD(labelSelectZone);
			dynamicSelectionFromDropdown();
			programButtons(labAddZone);	
			programButtons(addProgram);
			isWarningPresent(warningProgName);
			createNewProgram(etProgName);			
			timePeriod(labTimeAM);
			setTimeAt05Min(12);
			programButtons(addProgram);	
			isWarningPresent(warningPastTime);
			handleStartDate();
			typeOfWatering(labSmrtWater);
			typeOfWatering(labSmrtWater);			
			clickOnRepeatsDP(labelSelectRepeat);
			programButtons(addProgram);	
			isWarningPresent(warningRepeats);

		}	
		
	@Test(priority=550)	
	public void deleteZones() throws Exception	{
		logInfo("Entered into deleteZones() test.");
		
		selectMenuIconInSite(iconZone);
		selectExistingZone(zoneRotorName);		
		deleteZone(zoneDetContentMsg);	
		selectExistingZone(zoneSprayName);		
		deleteZone(zoneDetContentMsg);	
		
			
		
		
		
		       
		
		
	}
		
	

}
