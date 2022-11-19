package smrtRain.programs;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.lib.Priority;

import smrtRain.settings.SettingMethods;

@Priority(8)
public class RunProgramTests extends SettingMethods {			
		
		@Test(priority=801)
		public void runProgramForFullTime() throws Exception {
			logInfo("Entered into runProgramForFullTime() test.");		
//			threadSleep(10000);
//			navigateToModule(alertsPage);
//			threadSleep(5000);
//			navigateToModule(sitesPage);
//			threadSleep(10000);		
//			selectExistingSite(existSiteFM50);
//			refreshScreen();
			threadSleep(10000);
			selectMenuIconInSite(iconSiteConfig);			
			double fwVer = getFWVersion();			
			selectDotsToUpdateSiteDetails();   	
	    	selectUpdateOrDelete(zoneUpdate);
	    	String zoneLoaction=getTimeZone();	    	
			selectMenuIconInSite(iconCalender);
			sleep(7000);
			selectMenuIconInSite(iconProgram);	
			selectLargeButtonInProgram(addProg);
			createNewProgram(progRunProgName);
			handleStartDate();
			selectZonesDD(labelSelectZone);
			selectOptionFromDropDown("All");
			typeOfWatering(labRegWater);
			programButtons(labAddZone);
			createNewProgram(progRunProgName);
			selectZonesDD(labelSelectDays);
			selectOptionFromDropDown("Even");
			programButtons(addProg);
						
			String timePacket=date_Time(timeZoneUTC);
			System.out.println("timePacket"+timePacket);			
			confirmInProgram(msgAddedProg);			
			selectMenuIconInSite(iconCalender);
			selectMenuIconInSite(iconLogs);	
			int schdCreate=verifyDataFromColumn(20, alDescp,actSchCreatedBfr+progRunProgName+actSchCreatedAft); 
			System.out.println("schdCreate :"+schdCreate);
			selectMenuIconInSite(iconCalender);
			selectMenuIconInSite(iconProgram);				
			selectLargeButtonInProgram(runProg);			
			selectSiteProgramFromDP(progRunProgName); 
			fullOrOtherTime(fullTimeLabel);
			
			String runtimePacket=date_Time(timeZoneUTC);
    		System.out.println("runtimePacket "+runtimePacket);
    		confirmInProgram(runProgConf);			
			sleep(7000);
			selectMenuIconInSite(iconProgram);	
    		String proId = getProgramID(progRunProgName);
    		System.out.println("proId "+proId);
    		int percentage = getSeasonalAdjustmentPercentage(progRunProgName);  
    		System.out.println("percentage "+percentage);
    		
			selectMenuIconInSite(iconZone);	
			String zoneslist= retrieveAllZoneNumbers();
			System.out.println(zoneslist);	
			selectMenuIconInSite(iconZone);					
			String waterSchedRunTime =retrieveAllZoneRunTimes(percentage,nonMulti);	
			selectMenuIconInSite(iconCalender);
			selectMenuIconInSite(iconLogs);				
			if(fwVer>=50){	
				int rowRunProg = verifyDataFromColumn(20, alDescp,descProgSchBfr+progRunProgName+actRunProgAft);  	
				System.out.println("rowRunProg "+rowRunProg);
				selectExactPacketFromLogsTable(rowRunProg, alSeePacket);				
				getPacketData(packManualStart);		
				//getPacketData(timeStamp1+runtimePacket);				
				getPacketData(pack50ZoneList+zoneslist+zonesEnd);	
				getPacketData(zonesDuration+waterSchedRunTime+zonesEnd);									
			}else if(fwVer==49){			
				int rowRunProg = verifyDataFromColumn(20, alDescp,actRunProgBfr+progRunProgName+actRunProgAft);  	
				selectExactPacketFromLogsTable(rowRunProg, alSeePacket);				
				getPacketData(packSchedule);					
				//getPacketData(timeStamp1+runtimePacket);						
				getPacketData(packZoneList+zoneslist+zonesEnd);
				getPacketData(packEnb1);					
			}
			closePacket();
			selectMenuIconInSite(iconProgram);
			selectLargeButtonInProgram(stopProgram);
			confirmInProgram(msgConfStop);	
			
		}
		
		/*****  Run Program with Others option as 20 minutes time.
		 * Validate logs as each zone time is 20 min 
		 * Again Stop the program.
		 * @throws Exception
		 */
		@Test(priority=802)
		public void runProgramForOtherConfiguredMinutes() throws Exception {
			logInfo("Entered into runProgramForOtherConfiguredMinutes() test.");
			selectMenuIconInSite(iconProgram);
			selectLargeButtonInProgram(runProg);			
			selectSiteProgramFromDP(progRunProgName);
			fullOrOtherTime(otherTimeLabel);
			confirmInProgram(runProgConf);	
			selectMenuIconInSite(iconCalender);
			selectMenuIconInSite(iconLogs);	
			int rowRunProg = verifyDataFromColumn(20, alDescp,descProgSchBfr+progRunProgName+actRunProgAft);  
			selectExactPacketFromLogsTable(rowRunProg, alSeePacket);				
			getPacketData(packManualStart);				
			getPacketData(zonesDuration+duration20);
			closePacket();
			selectMenuIconInSite(iconProgram);
			selectLargeButtonInProgram(stopProgram);
			confirmInProgram(msgConfStop);		
			
		}
		
		
		
		@Test(priority=803)
		public void runProgram_ValidateAlertsOfOthers() throws Exception {
			logInfo("Entered into runProgram_ValidateAlertsOfOthers() test.");
			selectMenuIconInSite(iconProgram);
			selectLargeButtonInProgram(runProg);
			fullOrOtherTime(otherTimeLabel);
			alertMsg_RunProgram(progAlertMsg);	
			
		}
		
		
		//ZoneDetails - Trigger water for 2 min  
		@Test(priority=811)
		public void zonesDetails_StartTiggerFor2Minutes() throws Exception {
			logInfo("Entered into zonesDetails_StartTiggerFor2Minutes() test.");	
			selectMenuIconInSite(iconLogs);	
			selectMenuIconInSite(iconSiteConfig);			
			double fwVer = getFWVersion();
			System.out.println(fwVer);
			selectMenuIconInSite(iconProgram);
			selectMenuIconInSite(iconSiteHome);
			String beforeFlowRate= getCurrentFlowRate();
			System.out.println("beforeFlowRate " +beforeFlowRate);
			verifyFlowRateMinutes(minList);
			handleStartFlowRate(expectedMinutes);
			String timePacket=date_Time(timeZoneUTC);
			waitOnZoneMinutes();
			try {
				selectMenuIconInSite(iconLogs);				
				int row = verifyDataFromColumn(10, alDescp,zoneDescManulOn); 		
				selectExactPacketFromLogsTable(row, alSeePacket);
				getPacketData(packManual);		
				//getPacketData(timeStamp1+timePacket);
				getPacketData(zoneOffSet);
				getPacketData(zone2MinDuration);
				getPacketData(setFlowRead);				
				closePacket();
				
				int masterValueOnFow = verifyDataFromColumn(row, alDescp,masterValueDesp);  
				selectExactPacketFromLogsTable(masterValueOnFow, alSeePacket);
				getPacketData(packMasterOn);	
				getPacketData(timeStamp1+timePacket);
				getPacketData(packProgramID+50);
				closePacket();
				
			}catch(Exception ex) {
				selectMenuIconInSite(iconSiteHome);	    		
				stopTheFlow();				
			}			
			selectMenuIconInSite(iconZone);
			selectMenuIconInSite(iconSiteHome);
    		String afterFlowRate= getCurrentFlowRate();
			stopTheFlow();
			Assert.assertEquals(beforeFlowRate, afterFlowRate);
		}
		
		/*******SITE  FUNCTION & ZONE DETAILS
		 * Opens active Green zone, Initially get current flow and open Run Zones tab.
		 * verify all zones are present as per created zones. 
		 * Selects given zone and 2 minutes , once started flow -retrieve current flow, which should be more than 
		 * previously collected flow rate.\
		 * Verifies whether opted zones is selected or displays in dropdown.
		 * */
		@Test(priority=812) 
		public void runSelectedZonesFor2Minutes() throws Exception {
			logInfo("Entered into runSelectedZonesFor2Minutes() test.");							
			selectMenuIconInSite(iconZone);
			int zonesSize = zonesGridList()+1;
			selectMenuIconInSite(iconSiteHome);
			String beforeFlowRate= getCurrentFlowRate();
			System.out.println("beforeFlowRate: "+beforeFlowRate);
			selectMenuIconInSite(iconZone);
			threadSleep(6000);
			selectMenuIconInSite(iconSiteHome);
			threadSleep(9000);
			selectRunZonesTab();
			runZonesLabelsValidation();
			int zoneInDropDown=getNoOfZonesFromRunZones(zoneDripName1);    //"Green Popup 24" zonePopName
			Assert.assertEquals(zonesSize, zoneInDropDown);
			selectMinutesRadioBtn(expectedMinutes);
			String timeOfManualOn=date_Time(timeZoneUTC);	
			System.out.println("timeOfManualOn :"+timeOfManualOn);
			waitOnZoneMinutes();
			selectMenuIconInSite(iconMap);	
			threadSleep(4000);
			selectMenuIconInSite(iconProgram);	
			selectMenuIconInSite(iconSiteHome);
			refreshScreen();
			runZonesStop();			
			selectMenuIconInSite(iconLogs);				
			int getRow = verifyDataFromColumn(10, alDescp,zoneDescManulOn);
			selectExactPacketFromLogsTable(getRow, alSeePacket);
			getPacketData(packManual);		
			getPacketData(timeStamp1+timeOfManualOn);
			getPacketData(zoneOffSet);
			getPacketData(zone2MinDuration);
			getPacketData(setFlowRead);				
			closePacket();			
			int masterValueOnFow = verifyDataFromColumn(getRow, alDescp,masterValueDesp);  
			selectExactPacketFromLogsTable(masterValueOnFow, alSeePacket);
			getPacketData(packMasterOn);	
			getPacketData(timeStamp1+timeOfManualOn);
			getPacketData(packProgramID+50);
			closePacket();					
		}	
		
		@Test(priority=813) 
		public void runZonesFor1Minute() throws Exception {
			logInfo("Entered into runZonesFor1Minute() test.");							
			selectMenuIconInSite(iconZone);			
			selectMenuIconInSite(iconSiteHome);	
			threadSleep(9000);
			selectMenuIconInSite(iconZone);
			threadSleep(6000);
			selectMenuIconInSite(iconSiteHome);
			threadSleep(9000);
			selectRunZonesTab();		
			int zoneInDropDown=getNoOfZonesFromRunZones(zoneDripName1);    //"Green Popup 24" zonePopName
			selectMinutesRadioBtn(expOtherMinutes);
			String timeOfManualOn=date_Time(timeZoneUTC);	
			System.out.println("timeOfManualOn :"+timeOfManualOn);
			waitOnZoneMinutes();
			selectMenuIconInSite(iconMap);	
			threadSleep(4000);
			selectMenuIconInSite(iconProgram);	
			selectMenuIconInSite(iconSiteHome);
			refreshScreen();
			runZonesStop();			
			selectMenuIconInSite(iconLogs);				
			int getRow = verifyDataFromColumn(10, alDescp,zoneDescManulOn);
			selectExactPacketFromLogsTable(getRow, alSeePacket);
			getPacketData(packManual);		
			getPacketData(timeStamp1+timeOfManualOn);
			getPacketData(zoneOffSet);
			getPacketData(zone1MinDuration);
			getPacketData(setFlowRead);				
			closePacket();			
			int masterValueOnFow = verifyDataFromColumn(getRow, alDescp,masterValueDesp);  
			selectExactPacketFromLogsTable(masterValueOnFow, alSeePacket);
			getPacketData(packMasterOn);	
			//getPacketData(timeStamp1+timeOfManualOn);
			getPacketData(packProgramID+50);
			closePacket();					
		}	
		
		
			
	
	//@Test(priority=6041)
	public void syncProgram() throws Exception {
		logInfo("Entered into syncProgram() test.");
		selectMenuIconInSite(iconCalender);
		selectMenuIconInSite(iconProgram);
		sleep(7000);
		selectLargeButtonInProgram(syncBtn);		
		confirmMesgOfSync(syncConfText);			
	}
	
	
		

}
