package smrtRain.settings;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.lib.Priority;



@Priority (16)
public class BulkOperations extends SettingMethods{	
	
	//@Test(priority= 1601)
	public void bo_verifyUnSuspenededSite() throws Exception {
		logInfo("Entered into bo_verifyUnSuspenededSite() method.");
		sleep(20000);
		navigateToModule(userManagementPage);
		sleep(10000);
		navigateToModule(settingsPage);
		sleep(20000);
		settingHeader(bulkOp);
		sleep(7000);
		selectSiteStatus(opUnSuspend);
		String selectedSite = retrieveSelectedSite();	
		sleep(4000);
		navigateToModule(userManagementPage);
		sleep(5000);	
		navigateToModule(sitesPage);
		sleep(20000);
		searchAndSelectExistingSite(selectedSite);                //selectedSite);
		sleep(20000);
		selectMenuIconInSite(iconMap);
		selectMenuIconInSite(iconSiteConfig);
		String deviceStatus =getCustomDetails(devStatus);		
		if((deviceStatus=="Active")||(deviceStatus=="Inactive")) {
			System.out.println(deviceStatus);
		}else {
			Assert.assertNotEquals(deviceStatus, "Suspened");
		}		
	}
	
//	@Test(priority= 1602)
	public void bo_verifySuspenededSite() throws Exception {
		logInfo("Entered into bo_verifySuspenededSite() method.");
		sleep(20000);
		navigateToModule(userManagementPage);
		sleep(10000);
		navigateToModule(settingsPage);
		sleep(7000);
		settingHeader(bulkOp);	
		selectSiteStatus(opSuspend);
		String selectedSite = retrieveSelectedSite();		
		navigateToModule(alertsPage);
//		Thread.sleep(10000);	
//		navigateToModule(sitesPage);
//		sleep(20000);
//		searchAndSelectExistingSite(selectedSite);                //selectedSite);
//		sleep(20000);
//		selectMenuIconInSite(iconMap);
//		selectMenuIconInSite(iconSiteConfig);
//		String deviceStatus =getCustomDetails(devStatus);
//		System.out.println("deviceStatus: "+deviceStatus);
//		Assert.assertEquals(deviceStatus, "Suspended");
		
	}
	
	/***Search sites and verify the status as well as If sites are not available,
	 * verify the information message.
	 * @throws Exception
	 */
	
//	@Test(priority= 1603)
	public void bo_retriveSiteBasedOnSearch() throws Exception {
		logInfo("Entered into bo_retriveSiteBasedOnSearch() method.");
		sleep(20000);
		navigateToModule(userManagementPage);
		sleep(10000);
		navigateToModule(settingsPage);
		sleep(7000);
		settingHeader(bulkOp);
		wildSearch("Acteweweew123");
		wildSearch("Act");	
		
	}
	
	/******verify bulk operations Type based on selected Status asSuspended or UnSuspended
	 * 
	 * 
	 * @throws Exception
	 */
	
	//@Test(priority= 1604)
	public void bo_validateBulkOperationsTypeBasedOnStatus() throws Exception {
		logInfo("Entered into bo_validateBulkOperationsTypeBasedOnStatus() method.");	
		//refreshSearch();
		sleep(20000);
		navigateToModule(settingsPage);
		sleep(10000);
		settingHeader(bulkOp);
		sleep(10000);
		selectSiteStatus(opUnSuspend);
		retrieveSelectedSite();	
		verifyOperationTypeOptions(opTypeOptions);		
		selectSiteStatus(opSuspend);
		retrieveSelectedSite();	
		verifyOperationTypeOptions(opTypeSuspendedOptions);
		
		
	}
	
	//@Test(priority= 1605)
	public void bo_ForceDeviceActive() throws Exception {
		logInfo("Entered into bo_ForceDeviceActive() method.");	
		String userName=getProfileName();		
		//refreshSearch();
		sleep(20000);
		navigateToModule(settingsPage);
		sleep(10000);
		settingHeader(bulkOp);
		sleep(10000);
		selectSiteStatus(opUnSuspend);
		sleep(7000);
		String siteIs=retrieveSelectedSite();	
		System.out.println("siteIs "+siteIs);
		isSelectedSite();
		selectOperationType(deviceForceBtn);
		String deviceTime=date_Time(timeZoneUTC);
		System.out.println("deviceTime :"+deviceTime);
		confirmPopup(deviceInfoText);
		navigateToModule(homePage);
		sleep(7000);
		showMore();
		overlayHeaderFunctions(alRfsh);
		int deviceActRow = verifyDataFromColumn(5, alDescp,logDeviceActive); 		
		System.out.println("row : "+deviceActRow);	
		isDataPresentInColumn(deviceActRow, alEmp, userName);

		
		
		
	}
	
//	@Test(priority= 1606)
	public void bo_ForceDeviceInActive() throws Exception {
		logInfo("Entered into bo_ForceDeviceInActive() method.");
		sleep(20000);
		navigateToModule(userManagementPage);
		sleep(10000);
		navigateToModule(settingsPage);
		sleep(7000);
		settingHeader(bulkOp);	
		String userName=getProfileName();
		System.out.println(userName);
		refreshSearch();
		selectSiteStatus(opUnSuspend);
		retrieveSelectedSite();	
		isSelectedSite();		
		selectOperationType(deviceForceInactiveBtn);
		String deviceTime=date_Time(timeZoneUTC);		
		confirmPopup(deviceInfoText);
		navigateToModule(homePage);
		sleep(7000);
		showMore();
		overlayHeaderFunctions(alRfsh);
		verifyDataFromColumn(10, alDescp,logDeviceInactive); 		
	}
	
	//Failure - SMRTMB-1900
	
	//@Test(priority= 1607)
	public void bo_getDeviceInformation() throws Exception {
		logInfo("Entered into bo_getDeviceInformation() method.");
		sleep(20000);
		navigateToModule(userManagementPage);
		sleep(10000);
		navigateToModule(settingsPage);
		sleep(7000);
		settingHeader(bulkOp);	
		selectSiteStatus(opUnSuspend);	
		retrieveSelectedSite();		
		isSelectedSite();		
		selectOperationType(deviceInfoBtn);
		String deviceTime=date_Time(timeZoneUTC);
		System.out.println("deviceTime :"+deviceTime);
		confirmPopup(deviceInfoText);
		navigateToModule(homePage);
		sleep(7000);
		showMore();
		overlayHeaderFunctions(alRfsh);
		int deviceInfoRow = verifyDataFromColumn(10, alDescp,deviceInfoLog); 		
		System.out.println("row : "+deviceInfoRow);
		selectExactPacketFromLogsTable(deviceInfoRow, alSeePacket);
		getPacketData(packDevice);
		getPacketData(timeStamp1+deviceTime);
		closePacket();
		
	}
	
	
	//Failure - SMRTMB-1900
	@Test(priority= 1608)
	public void bo_getNetworkInformation() throws Exception {
		logInfo("Entered into bo_getNetworkInformation() method.");
		sleep(20000);
		navigateToModule(userManagementPage);
		sleep(10000);
		navigateToModule(settingsPage);
		sleep(7000);
		settingHeader(bulkOp);			
		selectSiteStatus(opUnSuspend);	
		retrieveSelectedSite();		
		isSelectedSite();		
		selectOperationType(networkInfo);
		String deviceTime=date_Time(timeZoneUTC);
		System.out.println("networkInfo :"+deviceTime);
		confirmPopup(deviceInfoText);
		navigateToModule(homePage);
		sleep(7000);
		showMore();
		overlayHeaderFunctions(alRfsh);
		int deviceNetRow = verifyDataFromColumn(10, alDescp,devNetInfoLog); 		
		System.out.println("row : "+deviceNetRow);
		selectExactPacketFromLogsTable(deviceNetRow, alSeePacket);
		getPacketData(packNetwork);
		getPacketData(timeStamp1+deviceTime);
		closePacket();
		
	}
	
	//Failure - SMRTMB-1900
	//@Test(priority= 1609)
	public void bo_ProgramOff() throws Exception {
		logInfo("Entered into bo_ProgramOff() method.");		
		navigateToModule(userManagementPage);
		sleep(10000);
		navigateToModule(settingsPage);
		sleep(20000);
		settingHeader(bulkOp);
		sleep(6000);
		
		selectSiteStatus(opUnSuspend);	
		retrieveSelectedSite();		
		isSelectedSite();		
		selectOperationType(boProgOff);
		confirmPopup(deviceInfoText);
		navigateToModule(homePage);
		sleep(7000);
		showMore();
		overlayHeaderFunctions(alRfsh);
		verifyDataFromColumn(4, alDescp,logProgOff); 
		
		
		
		
	}
	
	//@Test(priority= 1610)
	public void bo_ProgramOn() throws Exception {
		logInfo("Entered into bo_ProgramOffOrOn() method.");
		navigateToModule(userManagementPage);
		sleep(10000);
		navigateToModule(settingsPage);
		sleep(20000);
		settingHeader(bulkOp);
		sleep(6000);		
		selectSiteStatus(opUnSuspend);	
		retrieveSelectedSite();		
		isSelectedSite();		
		selectOperationType(boProgOn);
		confirmPopup(deviceInfoText);
		navigateToModule(homePage);
		sleep(7000);
		showMore();
		overlayHeaderFunctions(alRfsh);
		int pr_OnRow=verifyDataFromColumn(4, alDescp,logProgOn);
		verifyDataFromColumn(pr_OnRow, alActivity,textEmp);
		
	}
	
	//@Test(priority= 1611)
	public void bo_SkipCycle() throws Exception {
		logInfo("Entered into bo_SkipCycle() method.");
		sleep(20000);
		navigateToModule(userManagementPage);
		sleep(10000);
		navigateToModule(settingsPage);
		sleep(7000);
		settingHeader(bulkOp);		
		
	}
	
	//@Test(priority= 1612)
	public void bo_SuspendIrrigation() throws Exception {
		logInfo("Entered into bo_SuspendIrrigation() method.");
		navigateToModule(userManagementPage);
		sleep(10000);
		navigateToModule(settingsPage);
		sleep(20000);
		settingHeader(bulkOp);
		sleep(6000);		
		selectSiteStatus(opUnSuspend);	
		String siteName=retrieveSelectedSite();		
		System.out.println(siteName);
		isSelectedSite();		
		selectOperationType(susProg);
		confirmPopup(deviceInfoText);
		navigateToModule(homePage);
		sleep(7000);
		showMore();
		overlayHeaderFunctions(alRfsh);
		verifyDataFromColumn(4, alDescp,logDescSusp);
		
		
	}
	
	@Test(priority= 1613)
	public void bo_WaterDelay() throws Exception {
		logInfo("Entered into bo_WaterDelay() method.");
		sleep(20000);
		int delayHrs=6;
		int minutes=58;
		navigateToModule(userManagementPage);
		sleep(10000);
		navigateToModule(settingsPage);
		sleep(7000);
		settingHeader(bulkOp);		
		wildSearch(existSiteFM50);
		String siteIs=retrieveSelectedSite();	
		System.out.println("siteIs "+siteIs);
		selectOperationType(waterDelatBtn);
		BO_WateringDelay();
		clickOnSubmit();
		String timeUTC=date_Time(timeZoneUTC);			
		String zoneTime=date_Time(timeZoneMountain);
		String zoneEndTime=getFutureTime(timeZoneMountain, delayHrs);
		confirmPopup(deviceInfoText);
		navigateToModule(sitesPage);
		sleep(20000);
		selectSiteFromAllSites(existSiteFM50);	
		sleep(7000);
		String timer= getTimerTime(delayHrs,minutes);
		isTimer(timer);
		selectMenuIconInSite(iconLogs);	
		int rowDelayHrs= verifyDataFromColumn(5, alDescp, programDelayActivated+delayHrs);
		int rowWatDelay= verifyDataFromColumn(rowDelayHrs, alDescp, waterDelayDescr);
		selectExactPacketFromLogsTable(rowWatDelay, alSeePacket);
		getPacketData(packSuspend);
		getPacketData(timeStamp1+timeUTC);
		getPacketData(startTime+zoneTime);
		getPacketData(endTime+zoneEndTime);						
		getPacketData(reasonWaterDelay);	
		closePacket();
		selectMenuIconInSite(iconSiteHome);
		waterDelayOff();
		sleep(10000);
		selectMenuIconInSite(iconLogs);
		int deactDescRow= verifyDataFromColumn(5, alDescp, deactivated);
		int rowSuspend = verifyDataFromColumn(deactDescRow, alDescp, clearSuspend);
		selectExactPacketFromLogsTable(rowSuspend, alSeePacket);
		getPacketData(packetClearType);
		getPacketData(programSuspendId);
		closePacket();
		
		
		
	}
	

	@Test(priority= 1614)
	public void bo_LocalTimeOffset() throws Exception {
		logInfo("Entered into bo_LocalTimeOffset() method.");
		sleep(20000);
		navigateToModule(userManagementPage);
		sleep(10000);
		navigateToModule(settingsPage);
		sleep(7000);
		settingHeader(bulkOp);		
		
	}
	

	@Test(priority= 1615)
	public void bo_RecentActivities() throws Exception {
		logInfo("Entered into bo_RecentActivities() method.");
		sleep(20000);
		navigateToModule(userManagementPage);
		sleep(10000);
		navigateToModule(settingsPage);
		sleep(7000);
		settingHeader(bulkOp);	
		viewAllRecentActivities();
		int matCard=verifyDataFromMatcard(3,ReasonSuspend);
		selectExactPacket(matCard,alSeePacket);
		closePacket();
		
	}

	@Test(priority= 1616)
	public void bo_LabelValidateRefreshAndPagination() throws Exception {
		logInfo("Entered into bo_LabelValidateRefreshAndPagination() method.");
		sleep(20000);
		navigateToModule(userManagementPage);
		sleep(10000);
		navigateToModule(settingsPage);
		sleep(7000);
		settingHeader(bulkOp);	
		bo_validateLabels();
		String userName=getProfileName();
		selectSiteStatus(opSuspend);
		selectSiteStatus(opUnSuspend);	
		String site = retrieveSelectedSite();
		System.out.println("site"+site);
		isSelectedSite();
		verifyOperationTypeOptions(opTypeOptions);
//		selectOperationType(deviceInfoBtn);
//		String deviceTime=date_Time(timeZoneUTC);
//		System.out.println("deviceTime :"+deviceTime);
//		confirmPopup(deviceInfoText);
//		navigateToModule(homePage);
//		sleep(7000);
//		showMore();
//		overlayHeaderFunctions(alRfsh);
//		int deviceInfoRow = verifyDataFromColumn(5, alDescp,deviceInfoLog); 		
//		System.out.println("row : "+deviceInfoRow);
//		selectExactPacketFromLogsTable(deviceInfoRow, alSeePacket);
////		isDataPresentInColumn(deviceInfoRow, alAck, "Fail");
////    	isDataPresentInColumn(deviceInfoRow, alEmp, userName);
//		getPacketData(packDevice);
//		getPacketData(timeStamp1+deviceTime);
//		closePacket();
		
		
		
	}
	@Test(priority= 1617)
	public void forceDeviceActiveForFW50Sites() throws Exception {
		logInfo("Entered into forceDeviceActiveForFW50Sites() method.");
		String userName=getProfileName();
		sleep(20000);
		navigateToModule(userManagementPage);
		sleep(10000);
		navigateToModule(settingsPage);
		sleep(7000);
		settingHeader(bulkOp);
		sleep(10000);
		selectSiteStatus(opUnSuspend);
		sleep(7000);
		wildSearch(existSiteFM50);
		String siteIs=retrieveSelectedSite();	
		System.out.println("siteIs "+siteIs);
		selectOperationType(deviceForceBtn);
		String deviceTime=date_Time(timeZoneUTC);
		System.out.println("deviceTime :"+deviceTime);
		confirmPopup(deviceInfoText);
		sleep(1000);
		navigateToModule(homePage);
		sleep(7000);
		showMore();
		overlayHeaderFunctions(alRfsh);
		int deviceActRow = verifyDataFromColumn(10, alDescp,logDeviceActive); 		
		System.out.println("row : "+deviceActRow);	
		isDataPresentInColumn(deviceActRow, alEmp, userName);
		sleep(3000);
		navigateToModule(settingsPage);
		sleep(7000);
		settingHeader(bulkOp);	
		viewAllRecentActivities();
		verifyDataFromMatcard(10,logDeviceActive);
		closeRecentActivities();
		sleep(1000);
	}	
	@Test(priority= 1618)
	public void forceDeviceInActiveForFW50Sites() throws Exception {
		logInfo("Entered into forceDeviceInActiveForFW50Sites() method.");
		sleep(20000);
		navigateToModule(userManagementPage);
		sleep(10000);
		navigateToModule(settingsPage);
		sleep(7000);
		settingHeader(bulkOp);	
		String userName=getProfileName();
		System.out.println(userName);
		refreshSearch();
		selectSiteStatus(opUnSuspend);
		sleep(7000);
		wildSearch(existSiteFM50);
		String siteIs=retrieveSelectedSite();	
		System.out.println("siteIs "+siteIs);	
		selectOperationType(deviceForceInactiveBtn);
		String deviceTime=date_Time(timeZoneUTC);
		System.out.println("deviceTime :"+deviceTime);
		confirmPopup(deviceInfoText);
		navigateToModule(homePage);
		sleep(7000);
		showMore();
		overlayHeaderFunctions(alRfsh);
		verifyDataFromColumn(10, alDescp,logDeviceInactive); 
		sleep(3000);
		navigateToModule(settingsPage);
		sleep(7000);
		settingHeader(bulkOp);	
		viewAllRecentActivities();
		verifyDataFromMatcard(10,logDeviceInactive);
		closeRecentActivities();
		sleep(1000);
	}
	@Test(priority= 1619)
	public void getDeviceInformationForFW50() throws Exception {
		logInfo("Entered into getDeviceInformationForFW50() method.");
		sleep(20000);
		navigateToModule(userManagementPage);
		sleep(10000);
		navigateToModule(settingsPage);
		sleep(7000);
		settingHeader(bulkOp);	
		selectSiteStatus(opUnSuspend);	
		sleep(7000);
		wildSearch(existSiteFM50);
		String siteIs=retrieveSelectedSite();	
		System.out.println("siteIs "+siteIs);
		selectOperationType(deviceInfoBtn);
		String deviceTime=date_Time(timeZoneUTC);
		System.out.println("deviceTime :"+deviceTime);
		confirmPopup(deviceInfoText);
		navigateToModule(homePage);
		sleep(7000);
		showMore();
		overlayHeaderFunctions(alRfsh);
		int deviceInfoRow = verifyDataFromColumn(10, alDescp,deviceInfoLog); 		
		System.out.println("row : "+deviceInfoRow);
		selectExactPacketFromLogsTable(deviceInfoRow, alSeePacket);
		getPacketData(packDevice);
		getPacketData(timeStamp1+deviceTime);
		closePacket();
		sleep(3000);
		navigateToModule(settingsPage);
		sleep(7000);
		settingHeader(bulkOp);	
		viewAllRecentActivities();
		int card=verifyDataFromMatcard(10,deviceInfoLog);
		selectExactPacket(card,alSeePacket);
		getPacketData(packDevice);
		getPacketData(timeStamp1+deviceTime);
		closePacket();
		closeRecentActivities();

	
	}
	@Test(priority= 1620)
	public void getNetworkInformationForFW50() throws Exception {
		logInfo("Entered into getNetworkInformationForFW50() method.");
		sleep(20000);
		navigateToModule(userManagementPage);
		sleep(10000);
		navigateToModule(settingsPage);
		sleep(7000);
		settingHeader(bulkOp);			
		selectSiteStatus(opUnSuspend);
		sleep(7000);
		wildSearch(existSiteFM50);
		String siteIs=retrieveSelectedSite();	
		System.out.println("siteIs "+siteIs);
		sleep(2000);
		sleep(1000);		
		selectOperationType(networkInfo);
		String deviceTime=date_Time(timeZoneUTC);
		System.out.println("networkInfo :"+deviceTime);
		confirmPopup(deviceInfoText);
		navigateToModule(homePage);
		sleep(7000);
		showMore();
		overlayHeaderFunctions(alRfsh);
		int deviceNetRow = verifyDataFromColumn(10, alDescp,devNetInfoLog); 		
		System.out.println("row : "+deviceNetRow);
		selectExactPacketFromLogsTable(deviceNetRow, alSeePacket);
		getPacketData(packNetwork);
		getPacketData(timeStamp1+deviceTime);
		closePacket();
		sleep(3000);
		navigateToModule(settingsPage);
		sleep(7000);
		settingHeader(bulkOp);	
		viewAllRecentActivities();
		int card=verifyDataFromMatcard(10,devNetInfoLog);
		selectExactPacket(card,alSeePacket);
		getPacketData(packNetwork);
		getPacketData(timeStamp1+deviceTime);
		closePacket();
		closeRecentActivities();

	}
	@Test(priority= 1621)
	public void programOffForFW50() throws Exception {
		logInfo("Entered into programOffForFW50() method.");
		navigateToModule(userManagementPage);
		sleep(10000);
		navigateToModule(settingsPage);
		sleep(20000);
		settingHeader(bulkOp);
		sleep(6000);
		selectSiteStatus(opUnSuspend);	
		sleep(7000);
		wildSearch(existSiteFM50);
		String siteIs=retrieveSelectedSite();	
		System.out.println("siteIs "+siteIs);
		sleep(2000);
		selectOperationType(boProgOff);
		confirmPopup(deviceInfoText);
		navigateToModule(homePage);
		sleep(7000);
		showMore();
		overlayHeaderFunctions(alRfsh);
		verifyDataFromColumn(10, alDescp,logProgOff); 
		sleep(3000);
		navigateToModule(settingsPage);
		sleep(7000);
		settingHeader(bulkOp);	
		viewAllRecentActivities();
		verifyDataFromMatcard(10,logProgOff);
		closeRecentActivities();

	}
	@Test(priority= 1622)
	public void programONForFW50() throws Exception {
		logInfo("Entered into programONForFW50() method.");
		navigateToModule(userManagementPage);
		sleep(10000);
		navigateToModule(settingsPage);
		sleep(20000);
		settingHeader(bulkOp);
		sleep(6000);		
		selectSiteStatus(opUnSuspend);	
		sleep(7000);
		wildSearch(existSiteFM50);
		String siteIs=retrieveSelectedSite();	
		System.out.println("siteIs "+siteIs);
		sleep(2000);
		selectOperationType(boProgOn);
		confirmPopup(deviceInfoText);
		navigateToModule(homePage);
		sleep(7000);
		showMore();
		overlayHeaderFunctions(alRfsh);
		int pr_OnRow=verifyDataFromColumn(12, alDescp,logProgOn);
		verifyDataFromColumn(pr_OnRow, alActivity,textEmp);
		sleep(3000);
		navigateToModule(settingsPage);
		sleep(7000);
		settingHeader(bulkOp);	
		viewAllRecentActivities();
		verifyDataFromMatcard(10,logProgOn);
		closeRecentActivities();

		
	}
	@Test(priority= 1623)
	public void SuspendIrrigationFW50() throws Exception {
		logInfo("Entered into SuspendIrrigationFW50() method.");
		navigateToModule(userManagementPage);
		sleep(10000);
		navigateToModule(settingsPage);
		sleep(20000);
		settingHeader(bulkOp);
		sleep(6000);		
		selectSiteStatus(opUnSuspend);	
		sleep(7000);
		wildSearch(existSiteFM50);
		String siteIs=retrieveSelectedSite();	
		System.out.println("siteIs "+siteIs);
		sleep(2000);		
		selectOperationType(susProg);
		confirmPopup(deviceInfoText);
		navigateToModule(homePage);
		sleep(7000);
		showMore();
		overlayHeaderFunctions(alRfsh);
		verifyDataFromColumn(10, alDescp,logDescSusp);
		sleep(3000);
		navigateToModule(settingsPage);
		sleep(7000);
		settingHeader(bulkOp);	
		viewAllRecentActivities();
		verifyDataFromMatcard(10,logDescSusp);
		closeRecentActivities();

	}
	@Test(priority= 1624)
	public void getLocalOffsetFW50() throws Exception {
		logInfo("Entered into getLocalOffsetFW50() method.");
		sleep(20000);
		navigateToModule(userManagementPage);
		sleep(10000);
		navigateToModule(settingsPage);
		sleep(7000);
		settingHeader(bulkOp);	
		selectSiteStatus(opUnSuspend);	
		sleep(7000);
		wildSearch(existSiteFM50);
		String siteIs=retrieveSelectedSite();	
		System.out.println("siteIs "+siteIs);
		selectOperationType(sendLocalTime);
		String deviceTime=date_Time(timeZoneUTC);
		System.out.println("deviceTime :"+deviceTime);
		confirmPopup(deviceInfoText);
		navigateToModule(homePage);
		sleep(7000);
		showMore();
		overlayHeaderFunctions(alRfsh);
		int deviceInfoRow = verifyDataFromColumn(10, alDescp,offSetLogs); 		
		System.out.println("row : "+deviceInfoRow);
		selectExactPacketFromLogsTable(deviceInfoRow, alSeePacket);
		getPacketData(packDevice);
		getPacketData(timeStamp1+deviceTime);
		closePacket();
		sleep(3000);
		navigateToModule(settingsPage);
		sleep(7000);
		settingHeader(bulkOp);	
		viewAllRecentActivities();
		int card=verifyDataFromMatcard(10,offSetLogs);
		selectExactPacket(card,alSeePacket);
		getPacketData(packDevice);
		getPacketData(timeStamp1+deviceTime);
		closePacket();
		closeRecentActivities();	
	
	}
	
	
	@Test(priority= 1625)
	public void skipCyclesetFw50() throws Exception {
	logInfo("Entered into skipCyclesetFw50() method.");
	sleep(20000);
	navigateToModule(userManagementPage);
	sleep(10000);
	navigateToModule(settingsPage);
	sleep(7000);
	settingHeader(bulkOp);	
	selectSiteStatus(opUnSuspend);	
	sleep(7000);
	wildSearch(existSiteFM50);
	String siteIs=retrieveSelectedSite();	
	System.out.println("siteIs "+siteIs);
	selectOperationType(skipCycle);
	selectDateToSkip();
	String date=driver.findElement(By.xpath(skipInputDate)).getText().trim();
	clickOnSubmit();
	confirmPopup(deviceInfoText);
	navigateToModule(homePage);
	sleep(7000);
	showMore();
	overlayHeaderFunctions(alRfsh);
	verifyDataFromColumn(10, alDescp,skipActivity+date); 
	sleep(3000);
	navigateToModule(settingsPage);
	sleep(7000);
	settingHeader(bulkOp);	
	viewAllRecentActivities();
	verifyDataFromMatcard(10,skipActivity+date);
	sleep(1000);
	closeRecentActivities();

	
	}
}
