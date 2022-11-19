package smrtRain.settings;

import org.testng.annotations.Test;

import com.lib.Priority;



@Priority (25)
public class FirmwareMaintenanceTests extends SettingMethods{
	
	@Test(priority= 2501)
	public void firmware_Update() throws Exception {
		logInfo("Entered into firmware_Update() test.");
		sleep(20000);
		navigateToModule(userManagementPage);
		sleep(10000);
		navigateToModule(settingsPage);
		sleep(10000);
		settingHeader(siteNotification);
		sleep(15000);
		settingHeader(firmware);
		firmwareAction(version,zoneUpdateBtn );
		updateFirmDetails(version);
		confirmModalBox(sucUpdateFirmMsg);
		settingHeader(siteNotification);
		settingHeader(bulkOp);
		settingHeader(firmware);
		firmwareAction(version,zoneUpdateBtn );
		updateFirmDetails(version);
		confirmModalBox(sucUpdateFirmMsg);
		
		
	}
	
	@Test(priority= 2502)
	public void firmware_Delete() throws Exception {
		logInfo("Entered into firmware_Update() test.");
		sleep(20000);		
		settingHeader(siteNotification);
		settingHeader(firmware);
		String fileName= getFileName(version);
		firmwareAction(version,zoneDelete );
		deleteModelBox(delConfMsgBfr+fileName+delConfMsgAfr);

		
		
	}
	
	@Test(priority=2503)
	public void verifyAllChooseTypeOptions() throws Exception{
		logInfo("Entered into verifyAllChooseTypeOptions() test.");	
		sleep(20000);
		navigateToModule(reportsPage);
		sleep(10000);
		navigateToModule(sitesPage);
		sleep(20000);
		//refreshScreen();
		searchAndSelectExistingSite(newSiteName);		
		sleep(10000);
		selectMenuIconInSite(iconMap);
		selectMenuIconInSite(iconSiteConfig);
		validateChooseType(5, optTypes);
				
	}
	
	
	@Test(priority=2504)
	public void changeDeviceStatusFromActiveToInactive() throws Exception{
		logInfo("Entered into changeDeviceStatusFromActiveToInactive() test.");		
		String deviceStatus =getCustomDetails("Device Status");		
		confirmTypeOfDeviceStatus(deviceStatus);		
		String deviceStatus2 =getCustomDetails("Device Status");		
		confirmTypeOfDeviceStatus(deviceStatus2);
		
	}
	
	/****SMRTMB-2266 - Site Config - Flow Sensor 2 is displaying twice when enabled any 
	 * flow sensor at site config
	 * @throws Exception **/
	@Test(priority=2505)
	public void siteConfig_VerifyFlowSensorLabels() throws Exception {
		logInfo("Entered into siteConfig_VerifyFlowSensorLabels() test.");	
		sleep(20000);
		navigateToModule(alertsPage);
		sleep(10000);
		navigateToModule(sitesPage);
		sleep(15000);		
		selectExistingSite(existSmartStackSite);
		sleep(10000);
		selectMenuIconInSite(iconProgram);		
		selectMenuIconInSite(iconSiteConfig);
		getSiteHeaderLabels(flowSensor1);
		getSiteHeaderLabels(flowSensor2);	
		
	}	
	
	@Test(priority=2515)
	public void verifyNetWorkInformation() throws Exception{
		logInfo("Entered into verifyNetWorkInformation() test.");
		sleep(20000);
		navigateToModule(alertsPage);
		sleep(10000);
		navigateToModule(sitesPage);
		sleep(15000);		
		selectExistingSite(existSmartStackSite);
		sleep(10000);
		selectMenuIconInSite(iconMap);		
		selectMenuIconInSite(iconSiteConfig);
		//String imei= getCustomDetails(networkImei);
		//String phone= getCustomDetails(networkPhone);
		//String vendor= getCustomDetails(networkVendor);
		String mac=getCustomDetails(networkMac);
		String version=getCustomDetails(devFWVer);				
		selectChooseType(networkInfo);
		String networkTime=date_Time(timeZoneUTC);		
		confirmModalBox(networkConfirm);	
		selectMenuIconInSite(iconLogs);			
		int getnetworkRow= verifyDataFromColumn(5, alDescp,networkinfo); 
		selectExactPacketFromLogsTable(getnetworkRow, alSeePacket);
		getPacketData(packNetwork);
		getPacketData(timeStamp1+networkTime);
		closePacket();
		selectExactPacketFromLogsTable(getnetworkRow-1, alSeePacket);
		getPacketData(packNetworkFromdevice);
		//getPacketData(timeStampOfNetwork+networkTime);
//		getPacketData(packImei+imei);
//		getPacketData(packCellNum+phone);
//		getPacketData(packVendor+vendor);
		getPacketData(packMac+mac);
		//getPacketData(packFWVersion+version);
		closePacket();
		
	}
	
	@Test(priority=2516)
	public void verifyDeviceInformation() throws Exception{
		logInfo("Entered into verifyDeviceInformation() test.");	
		selectMenuIconInSite(iconSiteConfig);
		sleep(7000);
		String serial= getCustomDetails(devSerial);
		String model= getCustomDetails(devModel);
		String fwVersion= getCustomDetails(devFWVer);
		//String serial= getCustomDetails(devSerial);
		
		selectChooseType(deviceInfo);
		String deviceTime=date_Time(timeZoneUTC);
		sleep(10000);
		confirmModalBox(deviceConfirm);	
		selectMenuIconInSite(iconLogs);	
		int tempDeviceInfo=verifyDataFromColumn(5, alDescp,tempDev);
		int deviceInfo=verifyDataFromColumn(tempDeviceInfo-1, alDescp,deviceInfoLogFromdevice);
		//int getdeviceRow= verifyDataFromColumn(5, alDescp,deviceInfoLog); 	
		selectExactPacketFromLogsTable(tempDeviceInfo, alSeePacket);		
		getPacketData(packDevice);		
		getPacketData(timeStamp1+deviceTime);
		closePacket();
		int getReceivedDeviceRow= verifyDataFromColumn(tempDeviceInfo, alDescp,deviceInfoLogFromdevice); 	
		selectExactPacketFromLogsTable(getReceivedDeviceRow, alSeePacket);
		getPacketData(packReceivedDevice);
		getPacketData(packSN+serial);
		getPacketData(packModel+model);
		getPacketData(packVer+fwVersion);
		closePacket();
		int getdeviceRow= verifyDataFromColumn(5, alDescp,deviceInfoLog); 	
		
		
		
	}
	
	
	@Test(priority=2517)
	public void verifyLocalOffSetTime() throws Exception{
		logInfo("Entered into verifyLocalOffSetTime() test.");
		
		selectMenuIconInSite(iconLogs);	
		selectMenuIconInSite(iconSiteConfig);
		selectChooseType(sendLocalTime);
		String deviceTime=date_Time(timeZoneUTC);		
		confirmModalBox(offSetTime);	
		selectMenuIconInSite(iconLogs);		
		int getOffSetRow= verifyDataFromColumn(5, alDescp,offSetLogs); 	
		selectExactPacketFromLogsTable(getOffSetRow, alSeePacket);		
		getPacketData(packOffSet);		
		getPacketData(timeStamp1+deviceTime);
		closePacket();		
	}
	
	@Test(priority=2520)
	public void updateFirmWare() throws Exception{
		logInfo("Entered into updateFirmWare() test.");		
		selectMenuIconInSite(iconSiteConfig);
		String userName=getProfileName();
		String fwVersion= getCustomDetails(devFWVer);
//		selectChooseType(updateFirm);
//		updateFirmwareVersion(fwVersion);		
//		handle2ndPopupUpdateFW(fwConfText+version+progDeleteAft);	
//		String firmwareTime=date_Time(timeZoneUTC);
//		confirmModalBox(fwInformation);		
//		selectMenuIconInSite(iconSiteHome);		
//		siteHomeCardsDisabled(cardProgDelay);
//		siteHomeCardsDisabled(cardView);
//		siteHomeCardsDisabled(cardSiteSt);
//		selectMenuIconInSite(iconZone);		
//		verifyZones();
		
//		selectMenuIconInSite(iconLogs);	
//		int getFirmRow= verifyDataFromColumn(5, alDescp,firmUpdate); 
//		selectExactPacketFromLogsTable(getFirmRow, alSeePacket);
//		getPacketData(packFirm);
//		getPacketData(timeStamp1+firmwareTime);
//		closePacket();	
//		isDataPresentInColumn(getFirmRow-1, alEmp, userName);
//		isDataPresentInColumn(getFirmRow-1, alActivity, alEmp);
//		isDataPresentInColumn(getFirmRow-1, alDescp, packFirmFailed);		
	}
	
	
	/*******************       MOISTURE DETAILS   *******************/
	@Test(priority=2401)
	public void verifyLocalOff() throws Exception{
		logInfo("Entered into verifyLocalOffSetTime() test.");
		
	}
	
	
	
	
		

}
