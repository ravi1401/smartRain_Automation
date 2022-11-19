package smrtRain.programs;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.lib.Priority;

import smrtRain.settings.SettingMethods;

@Priority(9)
public class AppSmartWateringET extends SettingMethods{
	
	@Test(priority=901)
	public void smartET_WillWater() throws Exception {
		logInfo("Entered into smartStackProgramWithRegularWatering() test.");						
		navigateToModule(reportsPage);	
		sleep(10000);
		//waitTilldisableOfElement(10);	
		navigateToModule(sitesPage);
		waitTilldisableOfElement(7);	
		selectSiteByWildSearch(existSmartStackSite);
		waitTilldisableOfElement(10);	
		selectMenuIconInSite(iconZone);	
		
		selectMenuIconInSite(iconSiteConfig);
		double rainChanceToBe=rainChanceOfSiteConfig();
		int windSpeedSiteConfig = windSpeedOfSiteConfig();
		System.out.println(rainChanceToBe + " "+windSpeedSiteConfig);
		/******** Handle Weather Report on Dashboard   *****/		
		
		selectMenuIconInSite(iconSiteHome);	
		double presentRainChance=getCurrentDayRainChance();
		System.out.println(presentRainChance);
		chanceOfRainForAllDays();

		
		
		
		
		
		
		
//		double getET=getCurrentDayET();
//		System.out.println("getET "+getET);
//		selectMenuIconInSite(iconZone);	
//		
//		
//		String fwVer = getFWVersion();		
//		if(fwVer.equals("50")) {			
//			selectMenuIconInSite(iconZone);
//			createZone(zoneSprayName);
//			//validateZoneFields();		
//			selectZoneNumber();	
//			irrigationType(irrTypeAll);		
//			verifyDefaultFlowData(irrTypeSpray);
//			addZoneFinalBtn();
//			confirmModalBox(succssMsgText);			
//			selectMenuIconInSite(iconProgram);
//			selectLargeButtonInProgram(addProg);
//			createNewProgram(etProgName);
//			typeOfWatering(labSmrtWaterET);
//			clickOnDropDown(labelSelectZone);			
//			selectOptionFromDropDown(zoneSprayName);           //zoneSprayName
//			programButtons(labAddZone);	
//			timePeriod(labTimePM);
//			setTime(11);
//			programButtons(addProgram);
//			String etTimeStamp=date_Time(timeZoneUTC);
//			String mounatinTime=date_Time(timeZoneMountain);
//			System.out.println(mounatinTime);
//			System.out.println(etTimeStamp);
//			confirmInProgram(msgAddedProg);	
//			//confirmMessToHandleinProgram(msgAddedProg);
//			String proId = getProgramID(etProgName);			
//			System.out.println("profd Id : "+proId);
//			sleep(7000);
//			selectDotsBasedOnProgram(etProgName);                 //etProgName
//			selectUpdateOrDelete(zoneUpdate);
//			
//			String valGWL = getETValue(etLabGWL);
//			String valMad = getETValue(etLabMAD);
//			String valLA = getETValue(etLabLA);
//			String valIA = getETValue(etLabIrrgAmt);
//			System.out.println("valGWL"+valGWL+" "+valMad+""+valLA+""+valIA);
//			
//			
//			selectMenuIconInSite(iconZone);
//			String zoneNumber=getZoneNumber(zoneSprayName);	
//			selectMenuIconInSite(iconCalender);	
//			selectMenuIconInSite(iconProgram);
//			isProgramPresent(etProgName);			
//			selectMenuIconInSite(iconCalender);
//			selectMenuIconInSite(iconLogs);					
//			int rowWaterSchedule = verifyDataFromColumn(7, alDescp,actSchCreatedBfr+etProgName+actSchCreatedAft); 
//			if(rainChanceToBe>presentRainChance) {		
//				int rowEtDesc = verifyDataFromColumn(rowWaterSchedule, alDescp,etProgName+descEtProg1); 
//				selectExactPacketFromLogsTable(rowEtDesc, alSeePacket);
//				getPacketData(timeStamp1+etTimeStamp);	
//				getPacketData(packProgram);
//				getPacketData(packProgramID+proId);			
//				getPacketData(packProgName+etProgName);
//				getPacketData(packTypeWatering+labSmrtWaterET);
//				getPacketData(packStatus);
//				closePacket();
//			}else {
//				System.out.println("eneterd here");
//				int rowEtDesc = verifyDataFromColumn(rowWaterSchedule, alDescp,etProgName+descEtProg1); 
//				isDataPresentInColumn(rowWaterSchedule-1, alDescp, descSuspendRain);
//				isDataPresentInColumn(rowWaterSchedule-2, alDescp, etProgName+descEtProg1+valGWL+descEtProg2+getET+descEtProg3+valLA+descEtProg4+valMad+descEtProg5);
//				selectExactPacketFromLogsTable(rowWaterSchedule-1, alSeePacket);
//				getPacketData(packSuspend);	
//				getPacketData(timeStamp1+etTimeStamp);
//				getPacketData(packProgramID+proId);
//				getPacketData(proSuspendId);
//				closePacket();
//				
//			}
//		}else {
//			System.err.println("Cannot create smart ET due to version is below 50");
//		}
		
	}
	
		

}
