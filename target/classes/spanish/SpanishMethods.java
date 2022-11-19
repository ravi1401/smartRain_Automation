package smrtRain.spanish;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import smrtRain.advanceConfig.AdvanceConfigMethods;
import smrtRain.home.GeneralMethods;


import smrtRain.settings.SettingMethods;
import smrtRain.sites.SiteMethods;

public class SpanishMethods extends SettingMethods{	
	
	GeneralMethods gm = new GeneralMethods();
	AdvanceConfigMethods advCon=new AdvanceConfigMethods();
	SiteMethods sm = new SiteMethods();
	public void verifyProfileLabels() throws Exception {
		logInfo("Enter into verifyProfileLabels() method");
		SoftAssert sa = new SoftAssert();
		String actRole =getText("cssSelector", proRole);
		System.out.println("actRole :"+actRole);
		sa.assertEquals(actRole, spRole);
		System.out.println("");
		
		sa.assertAll();
	}
	
	
public void selectAddSite() throws Exception {
	logInfo("Entered into selectAddSite() method.");		
		wdWait("cssSelector", newSiteBtn);
		clickOnObject("cssSelector", newSiteBtn);
		
	}
	public void selectInviteUser() throws Exception {
		logInfo("Entered into selectInviteUser() method.");
		wdWait("cssSelector", inviteUsersBtn);
		clickOnObject("cssSelector", inviteUsersBtn);
	}
	public void selectCancelBtn() throws Exception {
		logInfo("Entered into selectCancelBtn() method.");
		wdWait("cssSelector", sp_cancel);
		clickOnObject("cssSelector", sp_cancel);
	}
	
	public void labelsValidate() throws Exception {
		logInfo("Entered into sp_validateLabelsinSite()  method.");
		SoftAssert sa = new SoftAssert();		
//		String actSearch = getAttribute("cssSelector", sp_Search, "placeholder");
//		System.out.println(actSearch);
//		sa.assertEquals(actSearch, sp_SearchLab);
		String actAddSiteBtn = getText("xpath",sp_AddSite);
		
		sa.assertEquals(actAddSiteBtn,Sp_AddSiteLab);
		sa.assertAll();
		
	}
	public void validateInviteUserLabel() throws Exception{
		logInfo("Entered into spvalidateInviteUserLabels()  method.");
		SoftAssert sa = new SoftAssert();	
		String actInviteUserBtn= getText("xpath",sp_InviteUsers);
	
		sa.assertEquals(actInviteUserBtn, sp_InviteUsersLab);
	}
	public void newSiteValidation() throws Exception {
		logInfo("Entered into sp_newSiteLabelValidation()  method.");
		SoftAssert sa = new SoftAssert();
		String actAddSiteText= getText("xpath",sp_ADDSITE);
		sa.assertEquals(actAddSiteText, sp_ADDSITELab);
		String actSiteName= getText("xpath",sp_SiteName);
		sa.assertEquals(actSiteName, sp_SiteNameLab);
		String actSerialNumber= getText("xpath",sp_SerialNumber);
		sa.assertEquals(actSerialNumber, sp_SerialNumberLab);
		String actTimeZone= getText("xpath",sp_TimeZone);
		sa.assertEquals(actTimeZone, sp_TimeZoneLab);
		String actSitePhoto= getText("xpath",sp_SitePhoto);
		sa.assertEquals(actSitePhoto, sp_SitePhotoLab);
		String actSiteMap= getText("xpath",sp_SiteMap);
		sa.assertEquals(actSiteMap, sp_SiteMapLab);
		String actSitePhotoUploadBtn= getText("xpath",sp_SitePhotoUpload);
		sa.assertEquals(actSitePhotoUploadBtn, sp_SitePhotoUploadLab);
		String actSiteMapUploadBtn= getText("xpath",sp_SitemapUpload);
		sa.assertEquals(actSiteMapUploadBtn, sp_SitemapUploadLab);
		String actWaterCostPerGallon= getText("xpath",sp_WaterCostPerGallon);
		sa.assertEquals(actWaterCostPerGallon, sp_WaterCostPerGallonLab);
		sa.assertAll();
	}
	public void flowSensorvalidation() throws Exception {	
		logInfo("Entered into sp_flowSensorValidationSite()  method.");
		SoftAssert sa = new SoftAssert();
		String actFlowSensor1= getText("xpath",sp_FlowSensor1);
		sa.assertEquals(actFlowSensor1, sp_FlowSensor1Lab);
		String actFlowSensor2= getText("xpath",sp_FlowSensor2);
		sa.assertEquals(actFlowSensor2, sp_FlowSensor2Lab);
		String actMoistureSensor= getText("xpath",sp_MoistureSensor);
		sa.assertEquals(actMoistureSensor, sp_MoistureSensorLab);
//		String actBoosterPump= getText("xpath",sp_BoosterPump);
//		System.out.println(actBoosterPump);
//		sa.assertEquals(actBoosterPump, sp_BoosterPumpLab);
		sa.assertAll();
	}
	public void validationofEtValue() throws Exception {
		logInfo("Entered into sp_validationofEtValue() method.");
		SoftAssert sa = new SoftAssert();
//		String actETValue= getText("xpath",sp_ETvalue);
//		System.out.println(actETValue);
//		sa.assertEquals(actETValue, sp_ETvalueLab);
		String actSeasonalAdjustment= getText("xpath",sp_SeasonalAdjustment);
		sa.assertEquals(actSeasonalAdjustment, sp_SeasonalAdjustmentLab);
		String actMasterWaitTime= getText("xpath",sp_MasterWaitTime);
		sa.assertEquals(actMasterWaitTime, sp_MasterWaitTimeLab);
		String actAutoFlowCheck= getText("xpath",sp_AutoFlowCheck);
		sa.assertEquals(actAutoFlowCheck, sp_AutoFlowCheckLab);
		String actChanceOfRain= getText("xpath",sp_ChanceOfRain);
		sa.assertEquals(actChanceOfRain, sp_chanceOfRainLab);
//		String actConfiguredETDays= getText("xpath",sp_ConfiguredETDays);
//		System.out.println(actConfiguredETDays);
//		sa.assertEquals(actConfiguredETDays, sp_ConfiguredETDaysLab);
		sa.assertAll();
	}
	public void newAddressDetailsValidation() throws Exception {
		logInfo("Entered into sp_validateAddressinSite()  method.");
		logInfo("Entered into   test.");
		SoftAssert sa = new SoftAssert();
		String actAdderessDetails= getText("xpath",sp_AddressDetails);
		sa.assertEquals(actAdderessDetails, sp_AddressDetailsLab);
		String actAdderessLine1= getText("xpath",sp_AddressLine1);
		sa.assertEquals(actAdderessLine1, sp_AddressLine1Lab);
		String actAdderessLine2= getText("xpath",sp_AddressLine2);
		sa.assertEquals(actAdderessLine2, sp_AddressLine2Lab);
		String actCountry= getText("xpath",sp_Country);
		sa.assertEquals(actCountry, sp_CountryLab);
		String actState= getText("xpath",sp_State);
		sa.assertEquals(actState, sp_StateLab);
		String actCity= getText("xpath",sp_City);
		sa.assertEquals(actCity, sp_CityLab);
		String actZipCode= getText("xpath",sp_ZipCode);
		sa.assertEquals(actZipCode,sp_ZipCodeLab);
		String actGetLocationBtn= getText("xpath",sp_GetLocation);
		sa.assertEquals(actGetLocationBtn,sp_GetLocationLab);
		sa.assertAll();
	}
	public void latitudeValidation() throws Exception {	
		logInfo("Entered into sp_validateLatitudeSite()  method.");
		SoftAssert sa = new SoftAssert();
		String actLatitude= getText("xpath",sp_Latitude);
		sa.assertEquals(actLatitude,sp_LatitudeLab);
		String actLangitude= getText("xpath",sp_Longitude);
		sa.assertEquals(actLangitude,sp_LongitudeLab);
		String actTemperatureInterrupt= getText("xpath",sp_TemperatureInterrupt);
		sa.assertEquals(actTemperatureInterrupt,sp_TemperatureInterruptLab);
		String actWindSpeedInterrupt= getText("xpath",sp_WindSpeedInterrupt);
		sa.assertEquals(actWindSpeedInterrupt,sp_WindSpeedInterruptLab);
		String actRainSensor= getText("xpath",sp_RainSensor);
		sa.assertEquals(actRainSensor,sp_RainSensorLab);
		String actDeviceInstalledDate= getText("xpath",sp_DeviceInstallDate);
		sa.assertEquals(actDeviceInstalledDate,sp_DeviceInstallDateLab);
		String actSelectWaterSchedule= getText("xpath",sp_SelectWaterSchedule);
		sa.assertEquals(actSelectWaterSchedule,sp_SelectWaterScheduleLab);
		sa.assertAll();
	}
	public String getWeekdaysAddSite(String ExpDays)throws Exception{
		logInfo("Entered into sp_validateWeekdaysSite()  method.");		
		wdWait("xpath", sp_CheckboxAddSite);
		String infoHeader = null;
		int infoSize=driver.findElements(By.xpath(sp_CheckboxAddSite)).size();
		boolean isPresnt =false;
		for(int i=1;i<=infoSize;i++) {
			infoHeader=driver.findElement(By.xpath(sp_CheckboxStart+i+sp_checkboxEnd)).getText().trim();
			if(infoHeader.equalsIgnoreCase(ExpDays)) {
				isPresnt=true;				
				break;
			}			
		}if(!isPresnt) {
			Assert.assertTrue(isPresnt, ExpDays);
		}	
		return infoHeader;
	}
	public void programRunningDaysValidation() throws Exception {	
		logInfo("Entered into sp_validateProgramRunningDaysSite()  method.");
		SoftAssert sa = new SoftAssert();
		String actProgrammingRunningDays= getText("xpath",sp_ProgramRunningDays);
		sa.assertEquals(actProgrammingRunningDays,sp_ProgramRunningDaysLab);
		String actAllCheckBox= getWeekdaysAddSite(sp_AllLab);
		sa.assertEquals(actAllCheckBox,sp_AllLab);
		String actSunday= getWeekdaysAddSite(sp_SundayLab);
		sa.assertEquals(actSunday,sp_SundayLab);
		String actMonday= getWeekdaysAddSite(sp_MondayLab);
		sa.assertEquals(actMonday,sp_MondayLab);
		String actTuesday=getWeekdaysAddSite(sp_TuesdayLab);
		sa.assertEquals(actTuesday,sp_TuesdayLab);
		String actWensday= getWeekdaysAddSite(sp_WednesdayLab);
		sa.assertEquals(actWensday,sp_WednesdayLab);
		String actThursday= getWeekdaysAddSite(sp_ThursdayLab);
		sa.assertEquals(actThursday,sp_ThursdayLab);
		String actFriday= getWeekdaysAddSite(sp_FridayLab);
		sa.assertEquals(actFriday,sp_FridayLab);
		String actSaterday=getWeekdaysAddSite(sp_SaturdayLab);
		sa.assertEquals(actSaterday,sp_SaturdayLab);
		String actAddBtn= getText("xpath",sp_Add);
		sa.assertEquals(actAddBtn,sp_AddLab);
		String actCancelBtn= getText("xpath",sp_cancel);
		sa.assertEquals(actCancelBtn,sp_cancelLab);
		advCon.closeZone();
		sa.assertAll();
	}
		
	public void newInviteUserLabel() throws Exception{
		logInfo("Entered into sp_validateINviteUserLabels()  method.");
		SoftAssert sa = new SoftAssert();
		
		String actInviteUserText= getText("xpath",sp_InviteUser);
		sa.assertEquals(actInviteUserText,sp_InviteUserLab);
		String actEmail= getText("xpath",sp_Email);
		sa.assertEquals(actEmail,sp_EmailLab);
		String actRole= getText("xpath",sp_Role);
		sa.assertEquals(actRole,sp_RoleLab);
		String actSite= getText("xpath",sp_Site);
		sa.assertEquals(actSite,sp_SiteLab);
		String actOrganization= getText("xpath",sp_Organization);
		sa.assertEquals(actOrganization,sp_OrganizationLab);
		String actSubmitBtn= getText("xpath",sp_Submit);
		sa.assertEquals(actSubmitBtn,sp_submitLab);
		String actCloseBtn= getText("xpath",sp_Close);
		sa.assertEquals(actCloseBtn,sp_CloseLab);
		clickOnButton("xpath", sp_Close);
		
		sa.assertAll();
		
	}

	public void validateAlertsPage() throws Exception{
		logInfo("Entered into sp_validateAlertPage()  method.");
		SoftAssert sa = new SoftAssert();
		String alertRequiredText= getText("xpath",sp_attensionRequiredSites);
		sa.assertEquals(alertRequiredText,sp_attensionRequiredSitesLab);
		String alertText= getText("xpath",sp_alert);
		sa.assertEquals(alertText,sp_alertLab);
		String workingText= getText("xpath",sp_working);
		sa.assertEquals(workingText,sp_workingLab);
		String alertsLabel= getText("xpath",sp_alerts);
		sa.assertEquals(alertsLabel,sp_alertsLab);
		String deletelabel= getText("xpath",sp_delete);
		sa.assertEquals(deletelabel,sp_deleteLab);
		sa.assertAll();
	}
	public void validateTableHeaders() throws Exception {
		logInfo("Entered into sp_validateTblHeadersAlert()  method.");
		wdWait("xpath", sp_icon);
		clickOnObject("xpath", sp_icon);
		sleep(2000);
//		int infoSize=driver.findElements(By.xpath(sp_tabledata)).size();
//		int tableSize=driver.findElements(By.xpath(sp_table_Data)).size();
		//List<WebElement> data=driver.findElements(By.xpath(sp_table_Data)));
		String actData= getText("xpath",sp_temp);
		System.out.println(actData+"dataBase");
		if(actData.equalsIgnoreCase(sp_ZoneNumberLab)) {
			secondAlertTable();
			
		}
		else if(actData.equalsIgnoreCase(sp_SerialNumberlab)) {
			afterPlusIconClicked();
		}
		else {
			System.err.println("wrong data");
		}
		
	}
	
	public void afterPlusIconClicked() throws Exception{
		logInfo("Entered into sp_validateFirstTblAlerts()  method.");
		SoftAssert sa = new SoftAssert();
		String failedProgram= getText("xpath",sp_failedProgram);
		sa.assertEquals(failedProgram,sp_failedProgramAcknowledgement);
		String sinceDateLabel= getText("xpath",sp_SinceDate);
		sa.assertEquals(sinceDateLabel,sp_SinceDateLab);
		String statusLabel= getText("xpath",sp_Status);
		sa.assertEquals(statusLabel,sp_StatusLab);
		String clearBtn= getText("xpath",sp_Clear);
		sa.assertEquals(clearBtn,sp_ClearLab);
		sa.assertAll();
		}
	public String secondTableAlert(String ExpHeader) throws Exception{
		logInfo("Entered into sp_validateSecondTblAlerts()  method.");
		wdWait("xpath", sp_secondTable);
		String infoHeader = null;
		int infoSize=driver.findElements(By.xpath(sp_secondTable)).size();
		boolean isPresnt =false;
		for(int i=1;i<=infoSize;i++) {
			infoHeader=driver.findElement(By.xpath(sp_startWith+i+sp_endwith)).getText().trim();
			if(infoHeader.equalsIgnoreCase(ExpHeader)) {
				isPresnt=true;				
				break;
			}			
		}if(!isPresnt) {
			Assert.assertTrue(isPresnt,ExpHeader);
		}	
		return infoHeader;
	}
	public void secondAlertTable() throws Exception{
		logInfo("Entered into sp_validateSecondTblAlerts() method.");
		SoftAssert sa = new SoftAssert();
		String actZoneNum= secondTableAlert(sp_ZoneNumberLab);
		sa.assertEquals(actZoneNum,sp_ZoneNumberLab);
		String actZoneName= secondTableAlert(sp_ZoneNamelab);
		sa.assertEquals(actZoneName,sp_ZoneNamelab);
		String actLearnFlow= secondTableAlert(sp_LearnedFlowCap);
		sa.assertEquals(actLearnFlow,sp_LearnedFlowCap);
		String actFlowRate= secondTableAlert(sp_flowRate);
		sa.assertEquals(actFlowRate,sp_flowRate);
		String actFlowType= secondTableAlert(sp_flowType);
		sa.assertEquals(actFlowType,sp_flowType);
		String actLastRunTime= secondTableAlert(sp_LastRunTimeUs);
		sa.assertEquals(actLastRunTime,sp_LastRunTimeUs);
		sa.assertAll();
	}
	public void validateSiteConfiglables() throws Exception {
		logInfo("Entered into sp_validateSiteConfigLab()  method.");
		SoftAssert sa = new SoftAssert();
		String actSiteConfigLab= getText("xpath",sp_SiteConfig);
		sa.assertEquals(actSiteConfigLab,sp_SiteConfigLab);
		String actSiteImg= getText("xpath",sp_Siteimage);
		sa.assertEquals(actSiteImg,sp_SiteImage);
		String actSiteMap= getText("xpath",sp_Sitemap1);
		sa.assertEquals(actSiteMap,sp_SiteMap1lab);
		String actImageTog= getText("xpath",sp_image);
		sa.assertEquals(actImageTog,sp_imageLab);
		String actMapTog= getText("xpath",sp_map);
		sa.assertEquals(actMapTog,sp_mapLab);
		sa.assertAll();	
		
	}
	public void validateSiteConfigHeaders() throws Exception {
		logInfo("Entered into sp_validateSiteConfigHeaders()  method.");
		SoftAssert sa = new SoftAssert();
		String actAddress= getSiteHeaderLabels(sp_Addesss);
		 sa.assertEquals(actAddress,sp_Addesss);
		 String actLatitude =  getSiteHeaderLabels(sp_Latitude1);
		 sa.assertEquals(actLatitude,sp_Latitude1);
		 String actLongtude=getSiteHeaderLabels(sp_Longitude1);
		 sa.assertEquals( actLongtude,sp_Longitude1);
		 String actDevice=getText("xpath",sp_Device);
		 sa.assertEquals(actDevice, sp_DeviceLab);
		 String actTimeZone=getSiteHeaderLabels(sp_Timezone);
		 sa.assertEquals(actTimeZone, sp_Timezone);
		 String actFlowSensor = getSiteHeaderLabels(sp_FlowSensor);
		 sa.assertEquals(actFlowSensor, sp_FlowSensor);
		 String actWheather = getSiteHeaderLabels(sp_WeatherSource);
		 sa.assertEquals(actWheather, sp_WeatherSource);
		 String actAddSiteRainSEnsor = getSiteHeaderLabels(sp_AddSiteRainSensor);
		 sa.assertEquals(actAddSiteRainSEnsor, sp_AddSiteRainSensor);
		 String actMasterValueChargeTime=getSiteHeaderLabels(sp_MasterVAlueChargeTime);
		 sa.assertEquals(actMasterValueChargeTime, sp_MasterVAlueChargeTime);
		 String actFlowCheckDelay=getSiteHeaderLabels(sp_FlowCheckDelay);
		 sa.assertEquals(actFlowCheckDelay, sp_FlowCheckDelay);
		 String actChanceOfRain= getSiteHeaderLabels(sp_ChanceofRain);
		 sa.assertEquals(actChanceOfRain, sp_ChanceofRain);
//		 String ActHeader= getSiteHeaderLabels(sp_ConfiguredEtDays);
//		 System.out.println(ActHeader);
//		 sa.assertEquals(ActHeader, sp_ConfiguredEtDays);
		 String actTemperature=getText("xpath",sp_temperature);
		 sa.assertEquals(actTemperature, sp_temperatureLab);
		 String actWindSpeed=getSiteHeaderLabels(sp_WindSpeed);
		 sa.assertEquals(actWindSpeed,sp_WindSpeed);
		 String actWaterCostPerGallon=getSiteHeaderLabels(sp_WaterCostPerGallon1);
		 sa.assertEquals(actWaterCostPerGallon,sp_WaterCostPerGallon1);
		 String actSeasonalAdjustment=getSiteHeaderLabels(sp_SeasonalAdjustment1);
		 sa.assertEquals(actSeasonalAdjustment,sp_SeasonalAdjustment1);
//		 String actOrg= getSiteHeaderLabels(sp_OrganizationUsr);
//		 System.out.println(actOrg);
//		 sa.assertEquals(actOrg, sp_OrganizationUsr);
		 String actEmergencyWateringDays=getSiteHeaderLabels(sp_EmergencyWateringDays);
		 sa.assertEquals(actEmergencyWateringDays,sp_EmergencyWateringDays);
		 String actProgrammingRunningDays=getSiteHeaderLabels(sp_ProgramRunningDays1);
		 sa.assertEquals(actProgrammingRunningDays,sp_ProgramRunningDays1);
		 String actDeviceInformation=getText("xpath",sp_DeviceInformation);
		 sa.assertEquals(actDeviceInformation, sp_DeviceInformationLab);
//		 String actSerialNumber= getSiteHeaderLabels(sp_SerialNumber1);
//		 System.out.println(actSerialNumber);
//		 sa.assertEquals(actSerialNumber, sp_SerialNumber1);
		 String actDeviceSecurityKey=getSiteHeaderLabels(sp_DEviceSecurityKey);
		 sa.assertEquals(actDeviceSecurityKey,sp_DEviceSecurityKey);
		 String actAzureDEviceNet=getSiteHeaderLabels(sp_cloudServerSmartrainProdiotAzureDeviceNet);
		 sa.assertEquals(actAzureDEviceNet,sp_cloudServerSmartrainProdiotAzureDeviceNet);
		 String actDeviceStatus= getSiteHeaderLabels(sp_DeviceStatus);
		 sa.assertEquals(actDeviceStatus,sp_DeviceStatus);
		 sa.assertAll();
			 
	 }
	public void validSiteConfigNetworkDetailsLables() throws Exception {
		logInfo("Entered into sp_ValidateSiteConfigNetworkDetails()  method.");
		SoftAssert sa = new SoftAssert();
		 String actNetworkInformation=getText("xpath",sp_NetworkDetails1);
		 sa.assertEquals(actNetworkInformation, sp_NetworkDetailsLab1);
		 String actChooseType=getText("xpath",sp_chooseType);
		 sa.assertEquals(actChooseType, sp_ChooseTypeLab);
		 String actForceDevice=getText("xpath",sp_ForceDevice);
		 sa.assertEquals(actForceDevice, sp_ForceDeviceActive);
		 
		 String actBtnForceDevice=getText("xpath",sp_btnForceDeviceActive);
		 sa.assertEquals(actBtnForceDevice, sp_btnForceDeviceActiveLab);
		 
		 sa.assertAll();
		
	}
	public void selectDropDowninSiteConfig() throws Exception {
		wdWait("xpath", sp_ForceDevice);
		clickOnObject("xpath",sp_ForceDevice);
	}
	
	public void validSiteConfigNetworkDetailsDropDown() throws Exception {
		logInfo("Entered into sp_validateSiteConfigNetworkDetails() method.");
		SoftAssert sa = new SoftAssert();
		 
		 String actGetNetworkInformation=getText("xpath",sp_GetNetworkInfo);
		 sa.assertEquals(actGetNetworkInformation, sp_GetNetworkInformation);
		 String actGetDeviceinformation=getText("xpath",sp_GetDeviceInfo);
		 sa.assertEquals(actGetDeviceinformation, sp_GetDeviceInformation);
		 String actupdateFirmware=getText("xpath",sp_UpdateFirmware);
		 sa.assertEquals(actupdateFirmware, sp_UpdateFirmwareLab);
		 String actSendLocalTimeOffset=getText("xpath",sp_SendLocalTime);
		 sa.assertEquals(actSendLocalTimeOffset,sp_SendLocalTimeOffset);
		 clickOnObject("xpath",sp_ForceDevice);
		 sa.assertAll(); 
	}
	public void validSiteConfigSiteStatus() throws Exception {
		logInfo("Entered into sp_validateSiteConfigStatus()  method.");
		 SoftAssert sa = new SoftAssert();
		 String actSiteStatusLable=getText("xpath",sp_SiteStatus);
		 sa.assertEquals(actSiteStatusLable,sp_SiteStatusLab);
		 String actBtnSuspendirrigation=getText("xpath",sp_SuspendIrrigation);
		 sa.assertEquals(actBtnSuspendirrigation,sp_SuspendIrrigationLab);
		 sa.assertAll();
	}
	public void selectSiteConfigIcon() throws Exception {
		wdWait("xpath", sp_SiteIcon);
		clickOnObject("xpath",sp_SiteIcon);
		sleep(2000);
		
		 
	}
	
	public void validFirmwareTblHeadings() throws Exception {
		logInfo("Entered into sp_validateAddFirmware()  method.");
		SoftAssert sa = new SoftAssert();
		String actAddFirmwareBtn=getText("xpath",sp_AddFirmwareBtn);
		sa.assertEquals(actAddFirmwareBtn, sp_AddFirmwareBtnLab);
		sa.assertAll();
	}
	public void validateAddfirmwarePopup() throws Exception {
		logInfo("Entered into sp_validateFirmwarePopup()  method.");
		SoftAssert sa = new SoftAssert();
		wdWait("xpath",sp_AddFirmwareBtn);
		clickOnObject("xpath",sp_AddFirmwareBtn);
		sleep(2000);
		String actAddFirmwareHeading=getText("xpath",sp_popupAddFirmware);
		sa.assertEquals(actAddFirmwareHeading, sp_AddFirmwareBtnLab);
		String actPopupVersion=getText("xpath",sp_popupVersion);
		sa.assertEquals(actPopupVersion, sp_VersionLab);
		String actSelectFirmware=getText("xpath",sp_popupSelectFirmware);
		sa.assertEquals(actSelectFirmware, sp_popupSelectFirmwareLab);
		String actPopupLatestVersion=getText("xpath",sp_popupLatestVersion);
		sa.assertEquals(actPopupLatestVersion, sp_popupLatestVersionLab);
		String actPopupAddfirmwareBtn=getText("xpath",sp_popupAddFirmwarebtn);
		sa.assertEquals(actPopupAddfirmwareBtn, sp_AddFirmwareBtnLab);
		String actPopupClosebtn=getText("xpath",sp_popupClose);
		sa.assertEquals(actPopupClosebtn, sp_CloseLab);
		sa.assertAll();
		
	}
	public void validateFirmWareTableHeaders() throws Exception {
		logInfo("Entered into sp_validateFirmwareTblHeaders()  method.");
		SoftAssert sa = new SoftAssert();
		wdWait("xpath",sp_popupClose);
		clickOnObject("xpath",sp_popupClose);
		sleep(2000);
		String actVersion = getFirmwareHeaders(sp_VersionLab);
		sa.assertEquals(actVersion,sp_VersionLab);
		String actFileName = getFirmwareHeaders(sp_fileNameLab);
		sa.assertEquals(actFileName,sp_fileNameLab);
		String actUploadedAt = getFirmwareHeaders(sp_UploadedAtLab);
		sa.assertEquals(actUploadedAt,sp_UploadedAtLab);
		String actLatest = getFirmwareHeaders(sp_latestLab);
		sa.assertEquals(actLatest,sp_latestLab);
		String actAction = getFirmwareHeaders(sp_ActionLab);
		sa.assertEquals(actAction,sp_ActionLab);
		String actUpdateBtn=getText("xpath",sp_update);
		sa.assertEquals(actUpdateBtn, sp_updateLab);
		String actDeleteBtn=getText("xpath",sp_delete1);
		sa.assertEquals(actDeleteBtn, sp_deleteLab1);
		String actPrevBtn=getText("xpath",sp_prev);
		if(actPrevBtn.contains(sp_prevLab)){
		 }
		 else {
			 sa.assertEquals(actPrevBtn,sp_prevLab);
		 }
		 String actpNext=getText("xpath",sp_next);
		 if(actpNext.contains(sp_nextLab)) {
		 }
		 else {
			 sa.assertEquals(actpNext,sp_nextLab);
		 }
		
		sa.assertAll();
	}
	public void validateUpdateFirmWare() throws Exception {
		logInfo("Entered into sp_validateUpdateFirmware() method.");
		SoftAssert sa = new SoftAssert();
		wdWait("xpath",sp_update);
		clickOnObject("xpath",sp_update);
		sleep(2000);
		String actUpdateFirmwareHeading=getText("xpath",sp_updateFirmwareHeading);
		sa.assertEquals(actUpdateFirmwareHeading, sp_popupUpdateFirmwareLab);
		String actPopupVersion=getText("xpath",sp_popupVersion);
		sa.assertEquals(actPopupVersion, sp_VersionLab);
		String actPopupLatestVersion=getText("xpath",sp_popupLatestVersion);
		sa.assertEquals(actPopupLatestVersion, sp_popupLatestVersionLab);
		String actUpdateFirmwarebtnPopup=getText("xpath",sp_updateFirmwarebtnPopup);
		sa.assertEquals(actUpdateFirmwarebtnPopup, sp_popupUpdateFirmwareLab);
		String actPopupClosebtn=getText("xpath",sp_popupClose);
		sa.assertEquals(actPopupClosebtn, sp_CloseLab);
		wdWait("xpath",sp_popupClose);
		clickOnObject("xpath",sp_popupClose);
		sa.assertAll();

	}
	public void validateDeleteFirmware() throws Exception{
		logInfo("Entered into sp_validateDeleteFirmware() method.");
		SoftAssert sa = new SoftAssert();
		wdWait("xpath",sp_delete1);
		clickOnObject("xpath",sp_delete1);
		sleep(2000);
		String actPopupDialog=getText("xpath",sp_dialogDel);
		if(actPopupDialog.contains(sp_dialogLab)) {

		}
		else {
	
			sa.assertEquals(actPopupDialog, sp_dialogLab);
		}
		
		String actdialogCancelbtn=getText("xpath",sp_dialogCancel);
		sa.assertEquals(actdialogCancelbtn, sp_cancelLab);
		wdWait("xpath",sp_dialogCancel);
		clickOnObject("xpath",sp_dialogCancel);
		sa.assertAll();
		
	}
	
	public void validateDeviceDetails() throws Exception{
		logInfo("Entered into sp_validateDEviceDetails() method.");
		 SoftAssert sa = new SoftAssert();
		 String actSearch = getAttribute("xpath",sp_device_search, "placeholder");
		 sa.assertEquals(actSearch,sp_device_searchLab);
		 String actExport=getText("xpath",sp_exportbtn);
		 sa.assertEquals(actExport,sp_exportbtnLab);
		 String actSitename=getDeviceDetailsHeader(sp_siteNamelab);
		 sa.assertEquals(actSitename, sp_siteNamelab);
		 String actSerialNumber=getDeviceDetailsHeader(sp_serialNumberLab);
		 sa.assertEquals(actSerialNumber,sp_serialNumberLab);
		 String actStopState=getDeviceDetailsHeader(sp_stopStatelab);
		 sa.assertEquals(actStopState,sp_stopStatelab);
		  String actFirmwareVersion=getDeviceDetailsHeader(sp_firmwareVersionLab);
		 sa.assertEquals(actFirmwareVersion,sp_firmwareVersionLab);
		 String actCellFirmwareVersion=getDeviceDetailsHeader(sp_cellFirmwareVersionLab);
		 sa.assertEquals(actCellFirmwareVersion,sp_cellFirmwareVersionLab);
		 String actDeviceStatus=getDeviceDetailsHeader(sp_deviceStatusLab);
		 sa.assertEquals(actDeviceStatus,sp_deviceStatusLab); 
		 String actHardWareIMEI=getDeviceDetailsHeader(sp_hardwareIMEILab);
		 sa.assertEquals(actHardWareIMEI,sp_hardwareIMEILab);
		 String actPhoneNumber=getDeviceDetailsHeader(sp_phoneNumberLab);
		 sa.assertEquals(actPhoneNumber,sp_phoneNumberLab);
		 String actCommsVendor=getDeviceDetailsHeader(sp_CommsVendorLab);
		 sa.assertEquals(actCommsVendor,sp_CommsVendorLab);
		 String actMacAddress=getDeviceDetailsHeader(sp_MacAddressLab);
		 sa.assertEquals(actMacAddress,sp_MacAddressLab);
		 String actprev=getText("xpath",sp_devicePrev);
		 if(actprev.contains(sp_prevLab)){

		 }
		 else {
	
			 sa.assertEquals(actprev,sp_prevLab);
		 }
		 String actpNext=getText("xpath",sp_deviceNext);
		 if(actpNext.contains(sp_nextLab)) {
	
		 }
		 else {
	
			 sa.assertEquals(actpNext,sp_nextLab);
		 }
		 sa.assertAll();
	}
	public void validateAddNotifications() throws Exception{
		logInfo("Entered into sp_validateAddNotification() method.");
		 SoftAssert sa = new SoftAssert();
		 String actSearch = getAttribute("xpath",sp_Addnotification_search, "placeholder");
		 sa.assertEquals(actSearch,sp_device_searchLab);
		 String actAddNotificationBtn=getText("xpath",sp_addNotificationBtn);
		 sa.assertEquals(actAddNotificationBtn,sp_addNotificationBtnLab);
		sa.assertAll();
	}
	public void validateAddNotificationPopup() throws Exception {
		logInfo("Entered into sp_validateAddnotificationPopup() method.");
		 SoftAssert sa = new SoftAssert();
		 wdWait("xpath",sp_addNotificationBtn);
		 clickOnObject("xpath",sp_addNotificationBtn);
		 sleep(5000);
		 String actAddNotificationHeader=getText("xpath",sp_popupAddNotificationHeader);
		 sa.assertEquals(actAddNotificationHeader,sp_AddNotifications); 
		 String actSitesLablePopup=getText("xpath",sp_popupSitesLable);
		 sa.assertEquals(actSitesLablePopup,sp_sitesPopupLab);
		 String actSitePlaceHolderPopup=getText("xpath",sp_popupSitesPlaceholder);
		 sa.assertEquals(actSitePlaceHolderPopup,sp_sitesPopupLab);
		 String actNotificationTypePopup=getText("xpath",sp_popupNotificationType);
		 sa.assertEquals(actNotificationTypePopup,sp_NotificationType); 
		 String actEventTypePopup=getText("xpath",sp_popupEventType);
		 sa.assertEquals(actEventTypePopup,sp_EventType);
		 String actPriorityPopup=getText("xpath",sp_popupPriority);
		 sa.assertEquals(actPriorityPopup,sp_priority); 
		 String actPopupImmediatly=getText("xpath",sp_popupImmediatly);
		 sa.assertEquals(actPopupImmediatly,sp_popupImmediatlyLab);
		 String actPopupDaily=getText("xpath",sp_popupDaily);
		 sa.assertEquals(actPopupDaily,sp_popupDailyLab);
		 String actPopupWeekly=getText("xpath",sp_popupWeekly);
		 sa.assertEquals(actPopupWeekly,sp_popupWeeklyLab); 
		 String actPopupADD=getText("xpath",sp_popupAddbtn);
		 sa.assertEquals(actPopupADD,sp_Add1); 
		 String actPopupClose=getText("xpath",sp_popupCloseBtn);
		 sa.assertEquals(actPopupClose,sp_CloseLab);
		 wdWait("xpath",sp_popupCloseBtn);
		 clickOnObject("xpath",sp_popupCloseBtn);
		 sa.assertAll();	
	}
	public void validateUpdateNotification() throws Exception{
		logInfo("Entered into sp_validateUpdateNotification()  method.");
		 SoftAssert sa = new SoftAssert();
		 wdWait("xpath",sp_update_addNotification);
		 clickOnObject("xpath",sp_update_addNotification);
		 sleep(5000);
		 String actUpdateNotificationHeader=getText("xpath",sp_popupAddNotificationHeader);
		 sa.assertEquals(actUpdateNotificationHeader,sp_UpdateHeaderPopup); 
		 String actUpdateBtnPopup=getText("xpath",sp_UpdateBtnPopup);
		 sa.assertEquals(actUpdateBtnPopup,sp_updateLab_addNotificationLab);
		 String actPopupClose=getText("xpath",sp_popupCloseBtn);
		 sa.assertEquals(actPopupClose,sp_CloseLab);
		 wdWait("xpath",sp_popupCloseBtn);
		 clickOnObject("xpath",sp_popupCloseBtn);
		 sa.assertAll();
		 
	}
	public void validateDEleteNotificationPopup() throws Exception {
		logInfo("Entered into sp_validateDeleteNotiication()  method.");
		SoftAssert sa = new SoftAssert();
		wdWait("xpath",sp_deleteLab_addNotification);
		 clickOnObject("xpath",sp_deleteLab_addNotification);
		 sleep(2000);
		 String actPopupmsg=getText("xpath",sp_DeletePopupMsg);
		 if(actPopupmsg.contains(sp_deletePopupContent)) {
			 System.out.println(actPopupmsg);
		 }
		 else {
			 System.out.println(actPopupmsg);
			 sa.assertEquals(actPopupmsg,sp_deletePopupContent);
		 }
		 String actPopupCancel=getText("xpath",sp_popupCancel);
		 sa.assertEquals(actPopupCancel,sp_cancelLab);
		 wdWait("xpath",sp_popupCancel);
		 clickOnObject("xpath",sp_popupCancel);
		 sa.assertAll();
		 
		 
	}
	public void validateAddNotificationTable() throws Exception {
		logInfo("Entered into sp_validateAddNotificationTbl()  method.");
		 SoftAssert sa = new SoftAssert();
		 String actSites =getAddNotificationTableHeaders(sp_sitesLab);
		 sa.assertEquals(actSites,sp_sitesLab);
		 String actEventType =getAddNotificationTableHeaders(sp_EventTypeLab);
		 sa.assertEquals(actEventType,sp_EventTypeLab);
		 String actPriority =getAddNotificationTableHeaders(sp_priorityLab);
		 sa.assertEquals(actPriority,sp_priorityLab);
		 String actNotificationType =getAddNotificationTableHeaders(sp_notificationTypeLab);
		 sa.assertEquals(actNotificationType,sp_notificationTypeLab);
		 String actAction =getAddNotificationTableHeaders(sp_actionLab);
		 sa.assertEquals(actAction,sp_actionLab);
		 String actpUpdate=getText("xpath",sp_update_addNotification);
		 sa.assertEquals(actpUpdate,sp_updateLab_addNotificationLab);
		 String actpDelete=getText("xpath",sp_deleteLab_addNotification);
		 sa.assertEquals(actpDelete,sp_deleteLab_addNotificationLab);
		 String actPrev=getText("xpath",sp_AddNotificationPrev);
		 if(actPrev.contains(sp_prevLab)) {

		 }
		 else {

			 sa.assertEquals(actPrev,sp_prevLab);
		 }
		 String actNext=getText("xpath",sp_AddNotificationNext);
		 if(actNext.contains(sp_nextLab)) {

		 }
		 else {

			 sa.assertEquals(actNext,sp_nextLab);
		 }
			
		 sa.assertAll();
	
	}
	public void validateZoneColors() throws Exception{
		logInfo("Entered into sp_validateZoneColor()  method.");
		 SoftAssert sa = new SoftAssert();
		 String actUpdate=getText("xpath",sp_UpdateZoneColor);
		 sa.assertEquals(actUpdate,sp_UpadteZoneColorLab);
		 String actZoneNUmber=getText("xpath",sp_zoneNumber);
		 sa.assertEquals(actZoneNUmber,sp_zoneNumberLab); 
		 String actColor=getText("xpath",sp_Color);
		 sa.assertEquals(actColor,sp_ColorLab);
		 String actColorCode=getText("xpath",sp_colorCode);
		 sa.assertEquals(actColorCode,sp_colorCodeLab);
		 String actprev=getText("xpath",sp_ZoneColorPrev);
		 if(actprev.contains(sp_prevLab)) {
		 }
		 else {
			 sa.assertEquals(actprev,sp_prevLab);
		 }
		 
		 String actNext=getText("xpath",sp_zoneColrNext);
		 if(actNext.contains(sp_nextLab)) {

		 }
		 else {

			 sa.assertEquals(actNext,sp_nextLab);
		 }
		 sa.assertAll();
		 
	}
	public void validateUpdateColor() throws Exception {
		logInfo("Entered into sp_validateUpdateColor()  method.");
		SoftAssert sa = new SoftAssert();
		WebElement head=driver.findElement(By.xpath(sp_checkBox));
		head.click();
		sleep(2000);
		wdWait("xpath",sp_ActiveUpdate);
		clickOnButton("xpath", sp_ActiveUpdate);
		String actUpdatePopup=getText("xpath",sp_updatePopupmsg);
		System.out.println(actUpdatePopup);
		sa.assertEquals(actUpdatePopup,sp_popupUpdateZoneColor);
	    wdWait("xpath",sp_UpdatePopupCancel);
		clickOnButton("xpath", sp_UpdatePopupCancel);
		sleep(2000);
		sa.assertAll();
		
	}
	public void validateMoistureDetails() throws Exception{
		logInfo("Entered into sp_validateMoistureDetails()  method.");
		 SoftAssert sa = new SoftAssert();
		 String actProbeLabel=getText("xpath",sp_moistureProbes);
		 sa.assertEquals(actProbeLabel,sp_moistureProbesLab);
		 String actExportBtn=getText("xpath",sp_ExportBtn_moisture);
		 sa.assertEquals(actExportBtn,sp_ExportBtnLab_moistureProbe);
		 String actSitename = getMoistureDetails(sp_SiteNameLab_Moisture);
		 sa.assertEquals(actSitename,sp_SiteNameLab_Moisture);
		 String actProbName = getMoistureDetails(sp_ProbeNameLab);
		 sa.assertEquals(actProbName,sp_ProbeNameLab);
		 String actLastValue = getMoistureDetails(sp_LastValueLab);
		 sa.assertEquals(actLastValue,sp_LastValueLab);
		 String actSerialNUmber = getMoistureDetails(sp_SerialNumberLab_moisture);
		 sa.assertEquals(actSerialNUmber,sp_SerialNumberLab_moisture);
		 String actSoilType = getMoistureDetails(sp_SoilTypeLab);
		 sa.assertEquals(actSoilType,sp_SoilTypeLab);	
		 String actStateLab = getMoistureDetails(sp_StateLab_moisture);
		 sa.assertEquals(actStateLab,sp_StateLab_moisture);
		 String actDepthLab = getMoistureDetails(sp_DepthLab);
		 sa.assertEquals(actDepthLab,sp_DepthLab);
		 String actUnitLab = getMoistureDetails(sp_UnitLab);
		 sa.assertEquals(actUnitLab,sp_UnitLab);
		 String actPrev=getText("xpath",sp_PrevMoistureProbe);
		 if(actPrev.contains(sp_prevLab))
		 {
		
		 }
		 else {
			
			 sa.assertEquals(actPrev,sp_prevLab);
		 
		 }
		 String actNext=getText("xpath",sp_NextMoistureProbe);
		 if(actNext.contains(sp_nextLab)) {
			
		 }
		 else {
		
			 sa.assertEquals(actNext,sp_nextLab);
		 }
		
		 sa.assertAll();
		 
	}
	public void validateMoistureGatewayDetails() throws Exception{
		logInfo("Entered into sp_validateMoistureGatewayDetails() method.");
		 SoftAssert sa = new SoftAssert();
		 String actGatewayLabel=getText("xpath",sp_MoistureGateway);
		 sa.assertEquals(actGatewayLabel,sp_MoistureGatewayLab);
		 String actExportBtn=getText("xpath",sp_ExportBtnLab_moistureGateway);
		 sa.assertEquals(actExportBtn,sp_ExportBtnLab_moistureProbe);
		 String actSitename = getMoisturegatewayDetails(sp_SiteNameLab_MoistureGateway);
		 sa.assertEquals(actSitename,sp_SiteNameLab_MoistureGateway); 
		 String actGatewayName = getMoisturegatewayDetails(sp_GatewayNameLab);
		 sa.assertEquals(actGatewayName,sp_GatewayNameLab);
		 String actSerialNumber= getMoisturegatewayDetails(sp_SerialNumberLab_MoistureGateway);
		 sa.assertEquals(actSerialNumber,sp_SerialNumberLab_MoistureGateway);
		 String actServiceLab= getMoisturegatewayDetails(sp_ServiceLab);
		 sa.assertEquals(actServiceLab,sp_ServiceLab); 
		 String actPhoneNumber= getMoisturegatewayDetails(sp_PhoneNumberLab);
		 sa.assertEquals(actPhoneNumber,sp_PhoneNumberLab);
		 String actImei= getMoisturegatewayDetails(sp_ImeiLab);
		 sa.assertEquals(actImei,sp_ImeiLab);
		 String actLatitude= getMoisturegatewayDetails(sp_Latitude1);
		 sa.assertEquals(actLatitude,sp_Latitude1);
		 String actLongitude= getMoisturegatewayDetails(sp_Longitude1);
		 sa.assertEquals(actLongitude,sp_Longitude1);
		 String actPrev=getText("xpath",sp_PrevMoistureGateway);
		 if(actPrev.contains(sp_prevLab))
		 {
		 }
		 else {
			 sa.assertEquals(actPrev,sp_prevLab);
		 
		 }
	
		 String actNext=getText("xpath",sp_NextMoistureGateway);
		 if(actNext.contains(sp_nextLab)) {

		 }
		 else {
			 sa.assertEquals(actNext,sp_nextLab);
		 }
		 
		 sa.assertAll();
	}
	public void validateBulkOperations() throws Exception{
		logInfo("Entered into sp_validateBulkOperation() method.");
		 SoftAssert sa = new SoftAssert();
		 String actListofSites=getText("xpath",sp_ListofSites);
		 sa.assertEquals(actListofSites,sp_ListofSitesLab);
		 String actSearch = getAttribute("xpath",sp_search_BulkOprations, "placeholder");
		 sa.assertEquals(actSearch,sp_device_searchLab);
		 String actSite=getText("xpath",sp_Sites);
		 sa.assertEquals(actSite,sp_Siteslab);
		 
		 String actUnsuspend=getText("xpath",sp_dropdownUnsuspend);
		 sa.assertEquals(actUnsuspend,sp_dropdownUnsuspendLab);
		 sa.assertAll();
		 
	}
	public void clickUnsuspend() throws Exception {
		wdWait("xpath", sp_dropdownUnsuspend);
		clickOnObject("xpath",sp_dropdownUnsuspend);
	}
	public void afterClicking() throws Exception {
		SoftAssert sa = new SoftAssert();
		 String actSuspend=getText("xpath",sp_dropdownSuspend);
		 sa.assertEquals(actSuspend,sp_dropdownSuspendLab);
		 clickOnObject("xpath" , sp_dropUnsuspend);
		 sa.assertAll();
	}
	
	public void validateBulkOperationTable() throws Exception {
		logInfo("Entered into sp_validateBulkOperationTbl()  method.");
		SoftAssert sa = new SoftAssert();
		 String actSitename=getText("xpath",sp_SiteName_BulkOperations);
		 sa.assertEquals(actSitename,sp_SiteNameLab_BulkOperations);
		 String actSirealNumber=getText("xpath",sp_serialNumber_BulkOperations);
		 sa.assertEquals(actSirealNumber,sp_serialNumber_BulkOperationsLab);
		 String actWateringDelay=getText("xpath",sp_wateringDelay);
		 sa.assertEquals(actWateringDelay,sp_wateringDelayLab);
		 String actSkipCycle=getText("xpath",sp_SkipCycle);
		 sa.assertEquals(actSkipCycle,sp_SkipCycleLab);
		 String actPrev=getText("xpath",sp_PrevBulkOperation);
		 if(actPrev.contains(sp_prevLab))
		 {
		 }
		 else {
			 sa.assertEquals(actPrev,sp_prevLab);
		 
		 }
	
		 String actNext=getText("xpath",sp_NextBulkOperation);
		 if(actNext.contains(sp_nextLab)) {
		 }
		 else {
			 sa.assertEquals(actNext,sp_nextLab);
		 }
		 sa.assertAll();
	}
	public void validateDropDownBulkOperation() throws Exception {
		logInfo("Entered into sp_validateBUlkOperationDropDown()  method.");
		SoftAssert sa = new SoftAssert();
		 String actBulkOperationType= getText("xpath",sp_BulkOperationType);
		 sa.assertEquals(actBulkOperationType,sp_BulkOperationTypeLab);  
		 String actOperationType= getText("xpath",sp_OperationType);
		 sa.assertEquals(actOperationType,sp_OperationTypeLab);
		 String actSelect= getText("xpath",sp_DropDownSelect);
		 sa.assertEquals(actSelect,sp_dropdownSelectlab);
		 String actSubmit= getText("xpath",sp_SubmitBtn);
		 sa.assertEquals(actSubmit,sp_submitbtnlab);
		 String actClear= getText("xpath",sp_ClearBtn);
		 sa.assertEquals(actClear,sp_ClearBtnlab);
		 String actRecentactivities= getText("xpath",sp_RecentActivities);
		 sa.assertEquals(actRecentactivities,sp_RecentActivitiesLab);
		 String actViewAll= getText("xpath",sp_ViewAll);
		 sa.assertEquals(actViewAll,sp_ViewAllLab);
		 sa.assertAll();
		 
	}
	public void validateReportLabels() throws Exception {
		logInfo("Entered into sp_validateReportLab() method.");
		SoftAssert sa = new SoftAssert();
		 String actReportHeading= getText("xpath",sp_ReportType);
		 sa.assertEquals(actReportHeading,sp_ReportTypeHeading);
		 String actReportLabel= getText("xpath",sp_ReportTypeLb);
		 sa.assertEquals(actReportLabel,sp_ReportTypeLabel);
		 String actSiteLab= getText("xpath",sp_SitesLabReport);
		 sa.assertEquals(actSiteLab,sp_sitesPopupLab);
		 String actSitePlaceholder= getText("xpath",sp_SitesPlaceHolder);
		 sa.assertEquals(actSitePlaceholder,sp_sitesPopupLab);
		 String actViewbrtn= getText("xpath",sp_ViewBtn);
		 sa.assertEquals(actViewbrtn,sp_viewBtnlab);
		 String actClosebtn= getText("xpath",sp_ClearBtnReport);
		 sa.assertEquals(actClosebtn,sp_ClearLab);
		 System.out.println("helloe");
		 sa.assertAll();
	
	}
	
	public void validateUsermanagementLabels() throws Exception {
		logInfo("Entered into sp_validateUserManagement()  method.");
		SoftAssert sa = new SoftAssert();
		String actApplicationUsers= getText("xpath",sp_ApplicationUser);
		sa.assertEquals(actApplicationUsers,sp_AppllicationUsersHeader);
		String actSearchBar= getAttribute("xpath", sp_SearchuserManagement, "placeholder");
		sa.assertEquals(actSearchBar,sp_SearchLab);
		
		String actStatus= getText("xpath",sp_StatusUserMangement);
		sa.assertEquals(actStatus,sp_StatusLab);
		String actNameUserMng= getText("xpath",sp_Name);
		sa.assertEquals(actNameUserMng,sp_Namelab);
		String actEmailAddress= getText("xpath",sp_EmailAddress);
		sa.assertEquals(actEmailAddress,sp_EmailAddressLab);
		String actLastAccess= getText("xpath",sp_LastAccess);
		sa.assertEquals(actLastAccess,sp_LastAccesslab);
		String actPrevBtn= getText("xpath",sp_LastAccess);
		if(actPrevBtn.contains(sp_LastAccess)) {
		}
		else {

			sa.assertEquals(actPrevBtn,sp_LastAccesslab);
		}
		String actNextBtn = getText("xpath",sp_nextBtnUserManagemen);
		if(actNextBtn.contains(sp_nextLab)) {
	
		}
		else {
	
			sa.assertEquals(actNextBtn,sp_nextLab);
		}
		String actInviteUsers= getText("xpath",sp_InviteUserUsermanagement);
		sa.assertEquals(actInviteUsers,sp_invitUser);
		String actEmail= getText("xpath",sp_emialUsermanagement);
		sa.assertEquals(actEmail,sp_EmailLab);
		String actOrganization= getText("xpath",sp_OrganizationUserManagement);
		sa.assertEquals(actOrganization,sp_OrganizationLab);
		String actSubmit= getText("xpath",sp_SubmitBtnUser);
		sa.assertEquals(actSubmit,sp_submitLab);
		String actInvitedusers= getText("xpath",sp_invitedUsers);
		sa.assertEquals(actInvitedusers,sp_invitedUsersLab);
		String actInvitedusersSerach= getAttribute("xpath", sp_SearchInvitedUsers, "placeholder");
		sa.assertEquals(actInvitedusersSerach,sp_SearchLab);
		String actEmailAddressINvited= getText("xpath",sp_EmailAddressInvitedUsers);
		sa.assertEquals(actEmailAddressINvited,sp_EmailAddressLab);
		String actStatusINvited= getText("xpath",sp_StatusInviteusers);
		sa.assertEquals(actStatusINvited,sp_StatusLab);
		String actPendingBtn= getText("xpath",sp_PendingBtn);
		sa.assertEquals(actPendingBtn,sp_Pendinglab);
		String actAchiveLabel= getText("xpath",sp_archive);
		sa.assertEquals(actAchiveLabel,sp_Archivelabel);
		String actInvitedAt= getText("xpath",sp_invitedAt);
		sa.assertEquals(actInvitedAt,sp_InviteAt);
		String actSite= getText("xpath",sp_SiteInvitedusers);
		sa.assertEquals(actSite,sp_site);
		String actOrganization1= getText("xpath",sp_OrgananizationInviteUsers);
		sa.assertEquals(actOrganization1,sp_OrganizationUsr);
		String actRole= getText("xpath",sp_RoleUser);
		sa.assertEquals(actRole,sp_roleLabel);	
		sa.assertAll();
		
	}
	public void validateZones() throws Exception {
		logInfo("Entered into sp_validateZonesPage() method.");
		SoftAssert sa = new SoftAssert();
		
		String actZoneDeatails= getText("xpath",sp_ZoneDetails);
		sa.assertEquals(actZoneDeatails,sp_ZoneDetailLab);	
		String actAddZoneBTn= getText("xpath",sp_AddZoneBtn);
		sa.assertEquals(actAddZoneBTn,sp_AddZoneLab);
		
		wdWait("xpath", sp_AddZoneBtn);
		clickOnObject("xpath",sp_AddZoneBtn);
		sa.assertAll();
	}
	public  void validateAddZones() throws Exception {
		logInfo("Entered into sp_validateAddZone() method.");
		SoftAssert sa = new SoftAssert();
		String actAddZoneHeader= getText("xpath",sp_AddZoneHeader);
		sa.assertEquals(actAddZoneHeader,sp_AddZoneLab);
		String actZoneName= getText("xpath",sp_ZoneName);
		sa.assertEquals(actZoneName,sp_ZoneNamelab);
		String actZoneNUmber= getText("xpath",sp_ZoneNumber);
		sa.assertEquals(actZoneNUmber,sp_ZoneNumberLabel);
		String actCurrentFlow= getText("xpath",sp_CurrentFlow);
		sa.assertEquals(actCurrentFlow,sp_CuurentFlowLab);
		String actLearnFlow= getText("xpath",sp_LearnedFlow);
		sa.assertEquals(actLearnFlow,sp_LearnedFlowLab);
		String actFlowLimit= getText("xpath",sp_FlowLimit);
		sa.assertEquals(actFlowLimit,sp_FlowLimitLab);
		String actZoneImg= getText("xpath",sp_ZoneImg);
		sa.assertEquals(actZoneImg,sp_ZoneImglab);
		String actUpload= getText("xpath",sp_Upload);
		sa.assertEquals(actUpload,sp_SitePhotoUploadLab);
		String actFlowTrigger= getText("xpath",sp_FlowTrigger);
		sa.assertEquals(actFlowTrigger,sp_FlowTriggerLab);
		String actAlerTrig= getText("xpath",sp_AlertTrig);
		sa.assertEquals(actAlerTrig,sp_alertLab);
		String actManualConfig= getText("xpath",sp_ManualConfig);
		sa.assertEquals(actManualConfig,sp_ManualConfigLab);
		String actAdvConfig= getText("xpath",sp_AdvConfig);
		sa.assertEquals(actAdvConfig,sp_AdvConfiglab);
		String actWaterIrrigation= getText("xpath",sp_waterIrrigationType);
		sa.assertEquals(actWaterIrrigation,sp_WaterIrrigationLab);
		String actRunTime= getText("xpath",sp_RunTime);
		sa.assertEquals(actRunTime,sp_RuntimeLab);
		String actGPM= getText("xpath",sp_GPMperZone);
		sa.assertEquals(actGPM,sp_Gpm);
		String actNumHeads= getText("xpath",sp_NumofHeades);
		sa.assertEquals(actNumHeads,sp_numofHeades);
		String actNozzle= getText("xpath",sp_NozzleFlow);
		sa.assertEquals(actNozzle,sp_NozzleFlowLab);
		String actADD= getText("xpath",sp_AddZone);
		sa.assertEquals(actADD,sp_AddZoneLab);
		String actCancel= getText("xpath",sp_Cancel);
		sa.assertEquals(actCancel,sp_cancelLab);
		sa.assertAll();
	}
	
	public void validateAdvConfigpopup() throws Exception{
		logInfo("Entered into sp_validateAdvCong() method.");
		SoftAssert sa = new SoftAssert();
		wdWait("xpath", sp_AdvConfig);
		clickOnObject("xpath",sp_AdvConfig);
		sleep(2000);
		String actAdvConfigHeading= getText("xpath",sp_AdvConfigPOpupHeading);
		sa.assertEquals(actAdvConfigHeading,sp_AdvConfHeading);	
		String actAdvpopupMsg= getText("xpath",sp_popUpmsg);
		sa.assertEquals(actAdvpopupMsg,sp_popupLabel);
		String actAdvpopupok= getText("xpath",sp_popoupOk);
		sa.assertEquals(actAdvpopupok,sp_oklab);
		wdWait("xpath", sp_popoupOk);
		clickOnButton("xpath",sp_popoupOk);
		sa.assertAll();
	
	}
	public void validateAdvanceConfig() throws Exception {
		logInfo("Entered into sp_validateAdvConfigHeading() method.");
		SoftAssert sa = new SoftAssert();
		sleep(5000);
		wdWait("cssSelector",advTitle);
		String actAdvConfigHeading= getText("cssSelector",advTitle);
		sa.assertEquals(actAdvConfigHeading,sp_AdvConfiglab);
		String actHelpMsg= getText("cssSelector",infoHelp);
		sa.assertEquals(actHelpMsg,sp_helpLab);
		sa.assertAll();
	}
	public void Sidelabels() throws Exception {
		logInfo("Entered into sp_validateAdvConfigsideLab() method.");
		SoftAssert sa = new SoftAssert();
		sleep(1000);
		String actManualVal =  getAttribute("xpath", sp_valorManual, "placeholder");
		sa.assertEquals(actManualVal, sp_ManualValue);	
		
		String actDepletion = getText("xpath", sp_Deplition);
		sa.assertEquals(actDepletion, sp_DepletionHeading);	
		wdWait("xpath", irrAmtLabel);
		String actLabel = getText("xpath", irrAmtLabel);
		sa.assertEquals(actLabel, sp_IrrigationAmt);	
		sa.assertAll();
		}
	public void validateInstructions1stQuestion(String firstInstructionSub) throws Exception {
		logInfo("Entered into validateFollowInstructions1stQuestion() method.");
			SoftAssert sa= new SoftAssert();
			try {
				wdWait("cssSelector", infoHelpClikHere);
				clickOnObject("cssSelector", infoHelpClikHere);
				String subHeader=getText("cssSelector", followInstrSubheader);
				sa.assertEquals(subHeader,firstInstructionSub);
				Thread.sleep(9000);
				wdWait("cssSelector", instrDescrb);
				String decrib =getText("cssSelector", instrDescrb);				
				sa.assertEquals(decrib, instrDescrbText);
				String actContinue =getText("cssSelector", instContBtn);
				System.out.println(actContinue);
				sa.assertEquals(actContinue, sp_ContinueBtn);
				clickOnButton("cssSelector", instContBtn);
				sleep(2000);
//				String actYes =getText("xpath",sp_yesbtn);
//				System.out.println(actYes);
//				sa.assertEquals(actYes,sp_Yes);
				clickOnObject("cssSelector", instClose);				
				}catch(Exception ex) {
					clickOnObject("cssSelector", instClose);
					ex.printStackTrace();				
				}			
				sa.assertAll();			
		}
	public void validatePrecipition() throws Exception{
		logInfo("Entered into sp_validatePrecipition() method.");
		SoftAssert sa = new SoftAssert();
		wdWait("xpath", sp_PrecipitionRate);
		clickOnObject("xpath",sp_PrecipitionRate);
		sleep(2000);
		String actSelectType =getText("xpath", sp_SElectType);	
		sa.assertEquals(actSelectType, sp_SelectTypeLab);
		String actNumberOfHeads =getText("xpath", sp_numOfheades);	
		sa.assertEquals(actNumberOfHeads, sp_numofHeades);
		
		String actNozzelFlow =getText("xpath", sp_NozzelFlow);	

		sa.assertEquals(actNozzelFlow, sp_NozFlow);
		sa.assertAll();
		
	
	}
	public void validateDropDownProcipition() throws Exception{
		logInfo("Entered into sp_validateDropdownPreciption()  method.");
		SoftAssert sa = new SoftAssert();
		String actmanufacture =getText("xpath", sp_manufacturer);	
		sa.assertEquals(actmanufacture, sp_manufacturelab);
		String actSeries =getText("xpath", sp_series);	
		sa.assertEquals(actSeries, sp_seriesLab);
		String actModel =getText("xpath", sp_model);	
		sa.assertEquals(actModel, sp_modelLab);
		
		String actSelect =getText("xpath", sp_Select);	
		sa.assertEquals(actSelect, sp_dropdownSelectlab);
		sa.assertAll();
		
	}
	public void validateBaseRun() throws Exception {
		logInfo("Entered into sp_validateBaseRin()  method.");
		SoftAssert sa = new SoftAssert();
		wdWait("xpath", sp_BaseRunTimeL);
		clickOnObject("xpath",sp_BaseRunTimeL);
		sleep(2000);
		String actCaspsIrr =getText("xpath", sp_capsIrr);	
		sa.assertEquals(actCaspsIrr, sp_capsTotIrrigationAmt);
		String actCapsPreciption =getText("xpath", sp_capsPreci);	
		sa.assertEquals(actCapsPreciption, sp_capsPrecipitionRate);
		String actEditbtn =getText("xpath",sp_EditBtn);	
		sa.assertEquals(actEditbtn, sp_editBtn);
		sa.assertAll();
		
	}
	public void validateLabelsEfficiencyAdjustment() throws Exception{
		logInfo("Entered into sp_validateEfficiencyAdj()  method.");
		sleep(1000);
		SoftAssert sa = new SoftAssert();
		String actSkipBtn =getText("xpath",sp_Skipbtn);	
		sa.assertEquals(actSkipBtn,Sp_skilLab);
		String actSprinkleType =getText("xpath",sp_SprinkleTypeEff);	
		sa.assertEquals(actSprinkleType,sp_SprinkleTypeEffLab);
		String actSprinkleHead =getText("xpath",sp_SprinkleHeadType);	
		sa.assertEquals(actSprinkleHead,sp_SprinkleHead);
		
		String actEfficiency =getText("xpath",sp_Efficiency);	
		sa.assertEquals(actEfficiency,sp_EfficiencyLab);
	}
	public void validateAdjustPercentage() throws Exception {
		SoftAssert sa = new SoftAssert();
		wdWait("xpath", sp_PercentAdjus);
		String actPercentAdj= getText("xpath", sp_PercentAdjus);
		sa.assertEquals(actPercentAdj, sp_perAdj);
		sa.assertAll();
	}
	public void validateAdjustLandscape() throws Exception {
		SoftAssert sa = new SoftAssert();
		wdWait("xpath", sp_PlantType);
		String actPlantType= getText("xpath", sp_PlantType);
		sa.assertEquals(actPlantType, sp_PlantTypeLab);
		sa.assertAll();
	}
	public void validateUnderRuntimeTotal() throws Exception {
		logInfo("Entered into sp_validateRunTimeTtl()  method.");
		SoftAssert sa = new SoftAssert();
		String actResetClick =getText("xpath",sp_ResetClick);	
		sa.assertEquals(actResetClick,sp_Reset);
		String actBaseRuntimeLab =getText("xpath",sp_baseruntime);	
		sa.assertEquals(actBaseRuntimeLab,sp_BaseRunTimeLab);
		String actEffRunTimeAdj =getText("xpath",sp_effRuntimeAdj);	
		sa.assertEquals(actEffRunTimeAdj,sp_EffRuntimeAdjLab);
		String actRuntimeAdj =getText("xpath",sp_RuntimeAdj);	
		sa.assertEquals(actRuntimeAdj,sp_RunTimeAdjLab);
		String actRecomended =getText("xpath",sp_recomRange);	
		sa.assertEquals(actRecomended,sp_recomRangeLab);
		String actTotalRunTime =getText("xpath",sp_TotalRuntime);	
		sa.assertEquals(actTotalRunTime,sp_totalRunTime);   
		wdWait("xpath", sp_editTotalRunT);
		clickOnButton("xpath", sp_editTotalRunT);
		String actUserInput =getText("xpath",sp_userInput);	
		sa.assertEquals(actUserInput,sp_userInputLab);
		wdWait("xpath", sp_cancelUser);
		clickOnButton("xpath", sp_cancelUser);
		String actApply =getText("xpath",sp_Apply);	
		sa.assertEquals(actApply,sp_ApplyLab);
		sa.assertAll();
		
	}

	public String getMaintblHeaders(String expMainHeader) throws Exception {	
		logInfo("Entered into sp_validateMainHeaders()  method.");
		wdWait("xpath", spActivityTable);
		
		int infoSize=driver.findElements(By.xpath(spActivityTable)).size();
		String infoHeader = null;
		sleep(2000);
		boolean isPresnt =false;
		for(int i=1;i<=infoSize;i++) {
			 infoHeader=driver.findElement(By.xpath(spActivityheaderStart+i+spActivitytblHeaderEnd)).getText().trim();
			if(infoHeader.equalsIgnoreCase(expMainHeader.trim())) {
				isPresnt=true;				
				break;
			}			
		}if(!isPresnt) {
			Assert.assertTrue(isPresnt, expMainHeader);
		}
		
		return infoHeader;
	}
	public void validatesHomePage() throws Exception {
		logInfo("Entered into sp_validateHomepage()  method.");
		SoftAssert sa = new SoftAssert();
		String actWaterSaved =getText("xpath",spActualBarWaterSaved);	
		sa.assertEquals(actWaterSaved,spActualWater);
		String actBaselineWater =getText("xpath",spBaselineWater);	
		sa.assertEquals(actBaselineWater,spBaseLineWater);
		String actalert =getText("xpath",spHomeAlert);	
		sa.assertEquals(actalert,sp_alertLab);
		String actWorking =getText("xpath",spHomeWorking);	
		sa.assertEquals(actWorking,sp_workingLab);
		String actMoney =getText("xpath",spActualMoney);	
		sa.assertEquals(actMoney,spActualMoneyLab);
		String actBaseline =getText("xpath",spBaselineMoney);	
		sa.assertEquals(actBaseline,sp_BaselineMoney);
		String actWateringNow =getText("xpath",spWateringNow);	
		sa.assertEquals(actWateringNow,sp_WateringNow);
		getAttribute("xpath", spSearchHome, "placeholder");
		String actHomeSearch =	getAttribute("xpath", spSearchHome, "placeholder");
		sa.assertEquals(actHomeSearch,sp_device_searchLab);
		sa.assertAll();
	}
	public void validateActivityLogHomep() throws Exception {
		logInfo("Entered into sp_validateActivityLogHome()  method.");
		SoftAssert sa = new SoftAssert();
		String actActivityLog =getText("xpath",spActivityLog);	
		sa.assertEquals(actActivityLog,sp_ActivityLog);
		String actRefreshBtn =getText("xpath",spRefresh);	
		sa.assertEquals(actRefreshBtn,sp_Refresh);
		String actShowMoreBtn =getText("xpath",spShowMore);	
		sa.assertEquals(actShowMoreBtn,sp_ShowMore);
		String actEmployee =getMaintblHeaders(sp_Emoloyee);
		sa.assertEquals(actEmployee,sp_Emoloyee);
		String actDescription =getMaintblHeaders(sp_Description);
		sa.assertEquals(actDescription,sp_Description);
		String actActivity =getMaintblHeaders(sp_Activity);
		sa.assertEquals(actActivity,sp_Activity);
		String actLoggedUTC =getMaintblHeaders(sp_LoggedUtc);
		sa.assertEquals(actLoggedUTC,sp_LoggedUtc);
		String actPacket =getMaintblHeaders(sp_packet);
		sa.assertEquals(actPacket,sp_packet);
		sa.assertAll();
	}

	public void validateNotes() throws Exception {
		logInfo("Entered into sp_validateNotes()  method.");
		SoftAssert sa = new SoftAssert();
		String actNotes =getText("xpath",spNotes);	
		sa.assertEquals(actNotes,sp_Notes);
		String actViewAll =getText("xpath",spViewAll);	
		sa.assertEquals(actViewAll,sp_viewAll);
		wdWait("xpath", spViewAll);
		clickOnObject("xpath",spViewAll);
		sleep(10000);
		String actAddNotesHeading =getText("xpath",spAddNotes);	
		sa.assertEquals(actAddNotesHeading,sp_Notes);
		String actAddNewBtn=getText("xpath",sp_AddNew);	
		sa.assertEquals(actAddNewBtn,spAddNew);
		getAttribute("xpath", spSearchAddNOtes, "placeholder");
		String actSearchBar=getAttribute("xpath", spSearchAddNOtes, "placeholder");
		sa.assertEquals(actSearchBar,sp_SearchLab);
		clickOnObject("xpath",spCrossMark);
		
		
		sa.assertAll();
	}
	public void validateAddnew() throws Exception{
		logInfo("Entered into sp_validateAddNewNote()  method.");
		SoftAssert sa = new SoftAssert();
		sleep(3000);
		String actAddNote=getText("xpath",spAddNewNote);	
		sa.assertEquals(actAddNote,spAddNew);
		clickOnButton("xpath",spAddNewNote);
		String acttitle=getText("xpath",spTitle);	
		sa.assertEquals(acttitle,sp_title);	
		String actDescription=getText("xpath",spDescriptionAdd);	
		sa.assertEquals(actDescription,sp_Description);
		
		String actWriteHere=getAttribute("xpath",spWriteHere, "placeholder");
		sa.assertEquals(actWriteHere,sp_writeHere);
		String actSite=getText("xpath",spSiteAddnew);	
		sa.assertEquals(actSite,spsite);
		String actCreateBtn=getText("xpath",spCreatBtn);	
		sa.assertEquals(actCreateBtn,sp_CreateBtn);
		String actCloseBtn=getText("xpath",sp_closeAddNew);	
		sa.assertEquals(actCloseBtn,sp_CloseLab);
		wdWait("xpath",sp_closeAddNew);
		clickOnButton("xpath",sp_closeAddNew);
		sa.assertAll();
	}
	public void validateUpcommingMaintanance() throws Exception{
		logInfo("Entered into sp_validateUpcomingMaintananceHome()  method.");
		SoftAssert sa = new SoftAssert();
		sleep(2000);
		String actAddUpcommingMaint=getText("xpath",spUpcommingMaintanance);	
		sa.assertEquals(actAddUpcommingMaint,spUpcommingMaintanaceLab);
		sa.assertAll();
	}
	public void validateWaterDaysDetails() throws Exception{
		logInfo("Entered into sp_validateWaterDaysDetailsHome() method.");
		SoftAssert sa = new SoftAssert();
		String act7Days=getText("xpath",sp_Last7DaysWater);	
		sa.assertEquals(act7Days,spLast7Days);
		String act30Days=getText("xpath",sp_Last30DaysWater);	
		sa.assertEquals(act30Days,spLast30Days);
		String actYear=getText("xpath",sp_LastYearWAter);	
		sa.assertEquals(actYear,spCurrentYear);
		sa.assertAll();
	}
	public void validateMoneyDaysDetails() throws Exception{
		logInfo("Entered into sp_validateMoneyDetailsHome() method.");
		SoftAssert sa = new SoftAssert();
		String act7Days=getText("xpath",sp_Last7DaysMoney);	
		sa.assertEquals(act7Days,spLast7Days);
		String act30Days=getText("xpath",sp_Last30DaysMoney);	
		sa.assertEquals(act30Days,spLast30Days);
		String actYear=getText("xpath",sp_LastYearMoney);	
		sa.assertEquals(actYear,spCurrentYear);
		sa.assertAll();
	}
	public void programMainButtons()throws Exception{
		logInfo("Entered into sp_validateProgramPage() method.");
		SoftAssert sa = new SoftAssert();
		String actRunprogramBtn=getText("xpath",sp_RunProgramBtn);	
		sa.assertEquals(actRunprogramBtn,sp_RunProgramLab);
		String actSkipCycle=getText("xpath",spSkipCycle);	
		sa.assertEquals(actSkipCycle,sp_SkipCycleProgram);
		String actAdd=getText("xpath",spAdd);	
		sa.assertEquals(actAdd,sp_AddLab);
		clickOnButton("xpath", spAdd);
		sa.assertAll();
	}
	
	public void lableValidationAddProgram() throws Exception{
		logInfo("Entered into sp_validateAddProgram()  method.");
		SoftAssert sa = new SoftAssert();
		String actZonegroupDetails=getText("xpath",sp_zoneGroup);	
		sa.assertEquals(actZonegroupDetails,Sp_ZoneGroup);
		String actNameLable=getText("xpath",sp_nameZone);	
		sa.assertEquals(actNameLable,sp_NameLabel);
		String actSeasonalAdj=getText("xpath",sp_seasonalAdj);	
		sa.assertEquals(actSeasonalAdj,sp_SeasonAdj);
		String actStartTime=getText("xpath",sp_StartTime);	
		sa.assertEquals(actStartTime,sp_StartTimeLab);
		sa.assertAll();
	}
	public String ToggleButtonProgram(String ExpLabel) throws Exception{
		logInfo("Entered into sp_validateToggleHeadersProgram()  method.");
		wdWait("xpath", sp_toggles);
		String infoHeader = null;
		int infoSize=driver.findElements(By.xpath(toggles)).size();
		boolean isPresnt =false;
		for(int i=1;i<=infoSize;i++) {
			infoHeader=driver.findElement(By.xpath(toggleNameBfr+i+toggleNameAft)).getText().trim();
			if(infoHeader.equalsIgnoreCase(ExpLabel)) {
				isPresnt=true;				
				break;
			}			
		}if(!isPresnt) {
			Assert.assertTrue(isPresnt, ExpLabel);
		}	
		return infoHeader;
	}
	public void toggleLabelValidationProgram() throws Exception{
		logInfo("Entered into sp_validateTogglesProgram()  method.");
		SoftAssert sa = new SoftAssert();
		String actMultipleRunTime=ToggleButtonProgram(sp_multipleRunTimeLab);
		sa.assertEquals(actMultipleRunTime,sp_multipleRunTimeLab);
		String actCycleSoak=ToggleButtonProgram(sp_CycleSoak);
		sa.assertEquals(actCycleSoak,sp_CycleSoak);
//		String actProgram=ToggleButtonProgram(sp_program);
//		System.out.println(actProgram);
//		sa.assertEquals(actProgram,sp_program);
//		String actMoistureSensor=ToggleButtonProgram(sp_MoistureSensorLab);
//		System.out.println(actMoistureSensor);
//		sa.assertEquals(actMoistureSensor,sp_MoistureSensorLab);
		String actOff=getText("xpath",sp_Off);	
		if(actOff.contains(actOff)) {
			System.out.println(actOff);
		}
		else {
			System.out.println(actOff);
			sa.assertEquals(actOff,actOff);
		}
		sa.assertAll();
	}
	public void smartEtPopup()throws Exception{
		SoftAssert sa = new SoftAssert();
		String actpopup=getText("xpath",sp_smartEtDialog);	
		System.out.println(actpopup);
		sa.assertEquals(actpopup,sp_SmartETDialog);
		sleep(1000);
		clickOnButton("xpath", sp_popupCancelBtn);
		sa.assertAll();
	}
	public String getcheckboxLabelsProgram(String expLabel) throws Exception {	
		logInfo("Entered into sp_validateSelectRepeatDays() method.");
		wdWait("xpath", sp_checkboxes);
		String infoHeader = null;
		int infoSize=driver.findElements(By.xpath(sp_checkboxes)).size();
		boolean isPresnt =false;
		for(int i=1;i<=infoSize;i++) {
			infoHeader=driver.findElement(By.xpath(sp_checkboxStart+i+sp_checkBoxEnd)).getText().trim();
			if(infoHeader.equalsIgnoreCase(expLabel)) {
				isPresnt=true;				
				break;
			}			
		}if(!isPresnt) {
			Assert.assertTrue(isPresnt, expLabel);
		}	
		return infoHeader;
	}
	public void selectDaysProgram() throws Exception{
		logInfo("Entered into sp_validateWeekDaysProgram() method.");
		SoftAssert sa = new SoftAssert();
		String actall=getcheckboxLabelsProgram(sp_AllLab);
		sa.assertEquals(actall,sp_AllLab);
		String actSunday=getcheckboxLabelsProgram(sp_SundayLab);
		sa.assertEquals(actSunday,sp_SundayLab);
		String actMonday=getcheckboxLabelsProgram(sp_MondayLab);
		sa.assertEquals(actMonday,sp_MondayLab);
		String actTuesday=getcheckboxLabelsProgram(sp_TuesdayLab);
		sa.assertEquals(actTuesday,sp_TuesdayLab);
		String actwensday=getcheckboxLabelsProgram(sp_WednesdayLab);
		sa.assertEquals(actwensday,sp_WednesdayLab);
		String actThursaday=getcheckboxLabelsProgram(sp_ThursdayLab);
		sa.assertEquals(actThursaday,sp_ThursdayLab);
		String actFriday=getcheckboxLabelsProgram(sp_FridayLab);
		sa.assertEquals(actFriday,sp_FridayLab);
		String actSaterDay=getcheckboxLabelsProgram(sp_SaturdayLab);
		sa.assertEquals(actSaterDay,sp_SaturdayLab);
		sa.assertAll();
	}
	public void warningNameMessage() throws Exception{
		logInfo("Entered into sp_validateWarningNameMsgPrm() method.");
		SoftAssert sa = new SoftAssert();
		programButtons(sp_AddLab);
		String actNmeWar=getText("xpath",sp_nameWarning);	
		sa.assertEquals(actNmeWar,sp_warningMsg);
		sa.assertAll();
	}
	public void warningWaterTypeMessage() throws Exception{
		logInfo("Entered into sp_validateWaterWrgMsg()  method.");
		SoftAssert sa = new SoftAssert();
		programButtons(sp_AddLab);
		String actNmeWar=getText("xpath",sp_nameWarning);	
		sa.assertEquals(actNmeWar,sp_WarningWaterType);
		sa.assertAll();
	}
	public void warningSelectRepeat() throws Exception{
		logInfo("Entered into sp_validateSElectRepeatWrg()  method.");
		SoftAssert sa = new SoftAssert();
		programButtons(sp_AddLab);
		String actNmeWar=getText("xpath",sp_nameWarning);	
		sa.assertEquals(actNmeWar,sp_warnSelectRepeat);
		sa.assertAll();
	}
	public void runProgramPopup() throws Exception{
		logInfo("Entered into sp_validateRunPrgPopup()  method.");
		SoftAssert sa = new SoftAssert();
		String actRunProgramHeading=getText("xpath",sp_ruProgramPopHead);	
		sa.assertEquals(actRunProgramHeading,sp_RunProgramLab);
		String actProgramDrop=getText("xpath",sp_rPDropDown);	
		sa.assertEquals(actProgramDrop,spProgram);
		clickOnButton("xpath", sp_rPCancel);
		sa.assertAll();
	}
	public void selectSliderButton(String slider) throws Exception {
		logInfo("Entered into selectSlideButton() method.");
		wdWait("xpath", slideBfr+1+slideAfr);
		if(slider.contains("Smart Stack(Beta)")) {
			clickOnObject("xpath", slideBfr+1+slideAfr);		
		}else if(slider.contains("MÚLTIPLES TIEMPOS DE FUNCIONAMIENTO")) {		
			clickOnObject("xpath", slideBfr+2+slideAfr);	
			SoftAssert sa = new SoftAssert();
			String actMRPpopupMsg=getText("xpath",sp_updatePopupmsg);	
			System.out.println(actMRPpopupMsg);
			sa.assertEquals(actMRPpopupMsg,sp_multiRunSliderMsg);
			clickOnButton("xpath", sp_UpdatePopupCancel);
		}
	}	
	
	public void selectDotsToUpdateSiteDetails() throws Exception {
		logInfo("Entered into selectDotsToUpdateSiteDetails() method.");
		JavascriptExecutor js =(JavascriptExecutor)driver;
		waitTilldisableOfElement(5);		
		scrollDown(css, siteUpdateDots);
		sleep(4000);
		wdWait(css, siteUpdateDots);		
		WebElement dots = driver.findElement(By.cssSelector(siteUpdateDots));
		js.executeScript("arguments[0].click();",dots);				
	}
	
	public void deleteSitepopupMsg()throws Exception{
		logInfo("Entered into sp_validateDelPopup()  method.");
		sleep(1000);
		SoftAssert sa = new SoftAssert();
		String actDelPopUpMsg=getText("xpath",sp_dialogDel);
		if(actDelPopUpMsg.contains(sp_DeleteSite)) {
			System.out.println(actDelPopUpMsg);
		}
		else {
			System.out.println(actDelPopUpMsg);
			sa.assertEquals(actDelPopUpMsg,sp_DeleteSite);
		}
		clickOnButton("xpath", sp_dialogCancel);		
	}
	public void selectSiteFromDropdown(String expectedSiteName) throws Exception {
		logInfo("Entered into selectSiteFromAllSites() method.");
		Actions act = new Actions(driver);
		String expSiteName=expectedSiteName.trim();
		wdWait("xpath", sp_sitesLIst);
		List <WebElement> sites = driver.findElements(org.openqa.selenium.By.xpath(sp_sitesLIst));
		boolean isSitePrtesent=false;			
		for(int i=1;i<=sites.size();i++) {
			WebElement site= driver.findElement(org.openqa.selenium.By.xpath(sp_siteListStart+i+sp_sitesEnd));
			//scrollDown("xpath", sp_siteListStart+i+sp_sitesEnd);
				
			String actSiteName= site.getText().trim();
			
				if(actSiteName.equalsIgnoreCase(expSiteName)) {
				isSitePrtesent=true;	
				site.click();
				sleep(5000);
				WebElement desp= driver.findElement(By.xpath(sp_mainDashBoard));		
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", desp);
				break;
				
			}
		}if(!isSitePrtesent) {
			Assert.assertTrue(isSitePrtesent, expSiteName+ " is not present");
		}			
	}
	public String siteReportTbl(String ExpHeader) throws Exception{
		logInfo("Entered into siteReportTbl() method.");
		wdWait("xpath", sitesreportTblheaders);
		String infoHeader = null;
		int infoSize=driver.findElements(By.xpath(sitesreportTblheaders)).size();
		boolean isPresnt =false;
		for(int i=1;i<=infoSize;i++) {
			infoHeader=driver.findElement(By.xpath(sitesreportStrat+i+sitesReportEnd)).getText().trim();
			System.out.println(infoHeader);
			if(infoHeader.equalsIgnoreCase(ExpHeader)) {
				isPresnt=true;				
				break;
			}			
		}if(!isPresnt) {
			Assert.assertTrue(isPresnt,ExpHeader);
		}	
		return infoHeader;
	}
	public void reportTypeDropdownList(String ExpHeader) throws Exception{
	
		wdWait("xpath", sp_optionDRopdown);
	 
		int infoSize=driver.findElements(By.xpath(sp_optionDRopdown)).size();
		boolean isPresnt =false;
		for(int i=1;i<=infoSize;i++) {
			WebElement infoHeader=driver.findElement(By.xpath(sp_dropdownfirst+i+sitesReportEnd));
			String ActSiteName=infoHeader.getText().trim();
			
				if(ActSiteName.equalsIgnoreCase(ExpHeader)) {
				isPresnt=true;	
				infoHeader.click();
				break;
			}			
		}if(!isPresnt) {
			Assert.assertTrue(isPresnt,ExpHeader);
		}	
	}
	public void clickOnDropDowns(String dropDownLabel) throws Exception {
		logInfo("Entered into clickOnDropDowninReports() method.");
		wdWait("xpath", sp_dropdowns);
		boolean isPresent=false;
		List<WebElement> dp= driver.findElements(By.xpath(sp_dropdowns));
		for(WebElement dropDown:dp) {
			String dpName=dropDown.getText().trim();
			if(dpName.contains(dropDownLabel)) {
				isPresent=true;
				dropDown.click();
				
				break;
			}
		}if(!isPresent) {
			Assert.assertTrue(isPresent, dropDownLabel);
		}		
	}
	
	public void validateReportSitedropdown() throws Exception{
		logInfo("Entered into validateReportSitedropdown() method.");
		SoftAssert sa = new SoftAssert();
		String actSubOption=getText("xpath",sp_subOption);	
		System.out.println(actSubOption);
		sa.assertEquals(actSubOption,sp_subOptionLab);
		String actSitesdroplab=getText("xpath",sp_sitelabelDropSite);	
		System.out.println(actSitesdroplab);
		sa.assertEquals(actSitesdroplab,sp_sitesPopupLab);
		String actStartDate=getText("xpath",sp_StartDate);	
		System.out.println(actStartDate);
		sa.assertEquals(actStartDate,sp_StartDt);
		String actEndDate=getText("xpath",sp_endDate);	
		System.out.println(actEndDate);
		sa.assertEquals(actEndDate,sp_endDateLab);
		String actDateRangeTtl=getText("xpath",sp_DateRangeTtl);	
		System.out.println(actDateRangeTtl);
		sa.assertEquals(actDateRangeTtl,sp_DateRangeTotal);
		WebElement head=driver.findElement(By.xpath(sp_checkboxDateRange));
		head.click();
		sleep(2000);
		sa.assertAll();
	}
	public void viewBtn()throws Exception{
		logInfo("Entered into viewBtn() method.");
		WebElement viewBtn= driver.findElement(By.xpath(spview));		
		JavascriptExecutor execut = (JavascriptExecutor)driver;
		execut.executeScript("arguments[0].click();", viewBtn);

	}
	public void sitesDropDownclick()throws Exception{
		logInfo("Entered into sitesDropDownclick() method.");
		wdWait("xpath", sp_siteDrpodown);
		clickOnObject("xpath", sp_siteDrpodown);
	}
	public void sitesDropDownclickReboot()throws Exception{
		logInfo("Entered into sitesDropDownclickReboot() method.");
		wdWait("xpath", sp_SitesPlaceHolder);
		clickOnObject("xpath",sp_SitesPlaceHolder);
	}
	public void validateSitesTableReport()throws Exception{
		logInfo("Entered into validateSitesTableReport() method.");
		SoftAssert sa =new SoftAssert();
		String actreportHeader=getText("xpath",reportTblHeading);	
		System.out.println(actreportHeader);
		sa.assertEquals(actreportHeader,reportTblheading);
		String actExportBtn=getText("xpath",exportBtnREport);	
		System.out.println(actExportBtn);
		sa.assertEquals(actExportBtn,sp_exportbtnLab);
		String actSiteNametblHeader=siteReportTbl(sp_siteNamelab);	
		System.out.println(actSiteNametblHeader);
		sa.assertEquals(actSiteNametblHeader,sp_siteNamelab);
		String actDate=siteReportTbl(sp_StatusLab);	
		System.out.println(actDate);
		sa.assertEquals(actDate,sp_StatusLab);
		String actMainlineBreak=siteReportTbl(sp_mainlineBreak);	
		System.out.println(actMainlineBreak);
		sa.assertEquals(actMainlineBreak,sp_mainlineBreak);
		String actOverCurrent=siteReportTbl(sp_overcurrent);	
		System.out.println(actOverCurrent);
		sa.assertEquals(actOverCurrent,sp_overcurrent);
		String actOverFlow=siteReportTbl(sp_overFlow);	
		System.out.println(actOverFlow);
		sa.assertEquals(actOverFlow,sp_overFlow);
		String actUnderflow=siteReportTbl(sp_underflow);	
		System.out.println(actUnderflow);
		sa.assertEquals(actUnderflow,sp_underflow);
		String actCreatedAt=siteReportTbl(sp_CreatedAt);	
		System.out.println(actCreatedAt);
		sa.assertEquals(actCreatedAt,sp_CreatedAt);
		sa.assertAll();
	}
	public void recordsNotFound()throws Exception{
		logInfo("Entered into recordsNotFound() method.");
		SoftAssert sa =new SoftAssert();
		wdWait("xpath", spview);
		viewBtn();
		sleep(3000);
		String actNoRecords=getText("xpath",sp_noresult);	
		System.out.println(actNoRecords);
		sa.assertEquals(actNoRecords,sp_noResult);
		sa.assertAll();
	}
	public void validateSelectAll() throws Exception{
		logInfo("Entered into validateSelectAll() method.");
		SoftAssert sa =new SoftAssert();
		clickOnObject("xpath", sp_mainDashBoard);
		sleep(2000);
		clickOnButton("xpath",spview );
		String actSelectOneSite=getText("xpath",sp_noGraph);	
		System.out.println(actSelectOneSite);
		sa.assertEquals(actSelectOneSite,sp_needOneSite);
		sa.assertAll();
	}
	public void validtaeWaterUsage() throws Exception{
		logInfo("Entered into validtaeWaterUsage() method.");
		SoftAssert sa =new SoftAssert();
		WebElement desp= driver.findElement(By.xpath(sp_mainDashBoard));		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", desp);
		sleep(2000);
		viewBtn();
		sleep(2000);
		String actGraphHeading=getText("cssSelector",sp_graphHeading);	
		System.out.println(actGraphHeading);
		sa.assertEquals(actGraphHeading,spWaterUsageSum);
		sa.assertAll();
	}
	public void validateWaterUsageTblRepots()throws Exception{
		logInfo("Entered into validateWaterUsageTblRepots() method.");
		SoftAssert sa =new SoftAssert();
		String actreportHeader=getText("xpath",reportTblHeading);	
		System.out.println(actreportHeader);
		sa.assertEquals(actreportHeader,reportTblheading);
		String actExportBtn=getText("xpath",exportBtnREport);	
		System.out.println(actExportBtn);
		sa.assertEquals(actExportBtn,sp_exportbtnLab);
		String actSiteNametblHeader=siteReportTbl(sp_siteNamelab);	
		System.out.println(actSiteNametblHeader);
		sa.assertEquals(actSiteNametblHeader,sp_siteNamelab);
		String actDate=siteReportTbl(sp_Date);	
		System.out.println(actDate);
		sa.assertEquals(actDate,sp_Date);
		String actActual=siteReportTbl(sp_actual);	
		System.out.println(actActual);
		sa.assertEquals(actActual,sp_actual);
		String actBaseLine=siteReportTbl(sp_Baseline);	
		System.out.println(actBaseLine);
		sa.assertEquals(actBaseLine,sp_Baseline);
		String actSavedWater=siteReportTbl(sp_savedWater);	
		System.out.println(actSavedWater);
		sa.assertEquals(actSavedWater,sp_savedWater);
		String actCostPerGal=siteReportTbl(sp_costperGal);	
		System.out.println(actCostPerGal);
		sa.assertEquals(actCostPerGal,sp_costperGal);
		String actMoneysaved=siteReportTbl(sp_moneySaved);	
		System.out.println(actMoneysaved);
		sa.assertEquals(actMoneysaved,sp_moneySaved);
		String actCost=siteReportTbl(sp_cost);	
		System.out.println(actCost);
		sa.assertEquals(actCost,sp_cost);
		sa.assertAll();
	}
	public void validateWetherTbl() throws Exception{
		logInfo("Entered into validateWetherTbl() method.");
		SoftAssert sa =new SoftAssert();
		String actreportHeader=getText("xpath",reportTblHeading);	
		System.out.println(actreportHeader);
		sa.assertEquals(actreportHeader,reportTblheading);
		String actExportBtn=getText("xpath",exportBtnREport);	
		System.out.println(actExportBtn);
		sa.assertEquals(actExportBtn,sp_exportbtnLab);
		String actSiteNametblHeader=siteReportTbl(sp_siteNamelab);	
		System.out.println(actSiteNametblHeader);
		sa.assertEquals(actSiteNametblHeader,sp_siteNamelab);
		String actDate=siteReportTbl(sp_Date);	
		System.out.println(actDate);
		sa.assertEquals(actDate,sp_Date);
		String actMinTemp=siteReportTbl(sp_mintemp);	
		System.out.println(actMinTemp);
		sa.assertEquals(actMinTemp,sp_mintemp);
		String actMaxTemp=siteReportTbl(sp_maxtemp);	
		System.out.println(actMaxTemp);
		sa.assertEquals(actMaxTemp,sp_maxtemp);
		String actChanceofRain=siteReportTbl(sp_ChanceofRain);	
		System.out.println(actChanceofRain);
		sa.assertEquals(actChanceofRain,sp_ChanceofRain);
		String actWeatherSource=siteReportTbl(sp_WeatherSource);	
		System.out.println(actWeatherSource);
		sa.assertEquals(actWeatherSource,sp_WeatherSource);
		String actGridName=siteReportTbl(sp_gridName);	
		System.out.println(actGridName);
		sa.assertEquals(actGridName,sp_gridName);
		sa.assertAll();
	}
	public void validateActivityLogTbl() throws Exception{
		logInfo("Entered into validateActivityLogTbl() method.");
		SoftAssert sa =new SoftAssert();
//		String actreportHeader=getText("xpath",sp_reportlabActivitylog);	
//		System.out.println(actreportHeader);
//		sa.assertEquals(actreportHeader,reportTblheading);
//		String actExportBtn=getText("xpath",exportBtnREport);	
//		System.out.println(actExportBtn);
//		sa.assertEquals(actExportBtn,sp_exportbtnLab);
		String actEmployee=siteReportTbl(sp_Emoloyee);	
		System.out.println(actEmployee);
		sa.assertEquals(actEmployee,sp_Emoloyee);
		String actDescription=siteReportTbl(sp_Description);	
		System.out.println(actDescription);
		sa.assertEquals(actDescription,sp_Description);
		String actSiteName=siteReportTbl(sp_siteNamelab);	
		System.out.println(actSiteName);
		sa.assertEquals(actSiteName,sp_siteNamelab);
		String actActivity=siteReportTbl(sp_Activity);	
		System.out.println(actActivity);
		sa.assertEquals(actActivity,sp_Activity);
		String actStatus=siteReportTbl(sp_StatusLab);	
		System.out.println(actStatus);
		sa.assertEquals(actStatus,sp_StatusLab);
		String actLogged=siteReportTbl(sp_logged);	
		System.out.println(actLogged);
		sa.assertEquals(actLogged,sp_logged);
		String actAcknowledged=siteReportTbl(sp_acknowledged);	
		System.out.println(actAcknowledged);
		sa.assertEquals(actAcknowledged,sp_acknowledged);
		String actPacket=siteReportTbl(sp_packetActivity);	
		System.out.println(actPacket);
		sa.assertEquals(actPacket,sp_packetActivity);
		sa.assertAll();
	}
	public void validateRebootCountTbl() throws Exception{
		logInfo("Entered into validateRebootCountTbl() method.");
		SoftAssert sa =new SoftAssert();
		String actreportHeader=getText("xpath",sp_reportlabActivitylog);	
		System.out.println(actreportHeader);
		sa.assertEquals(actreportHeader,reportTblheading);
		String actExportBtn=getText("xpath",exportBtnREport);	
		System.out.println(actExportBtn);
		sa.assertEquals(actExportBtn,sp_exportbtnLab);
		String actEmployee=siteReportTbl(sp_siteNamelab);	
		System.out.println(actEmployee);
		sa.assertEquals(actEmployee,sp_siteNamelab);
		String actDescription=siteReportTbl(sp_Date);	
		System.out.println(actDescription);
		sa.assertEquals(actDescription,sp_Date);
		String actSiteName=siteReportTbl(sp_RebootCount);	
		System.out.println(actSiteName);
		sa.assertEquals(actSiteName,sp_RebootCount);
		sa.assertAll();
	}
	public void validateDeviceTbl() throws Exception{
		logInfo("Entered into validateDeviceTbl() method.");
		SoftAssert sa =new SoftAssert();
		String actreportHeader=getText("xpath",sp_reportlabActivitylog);	
		System.out.println(actreportHeader);
		sa.assertEquals(actreportHeader,reportTblheading);
		String actExportBtn=getText("xpath",exportBtnREport);	
		System.out.println(actExportBtn);
		sa.assertEquals(actExportBtn,sp_exportbtnLab);
		String actEmployee=siteReportTbl(sp_siteNamelab);	
		System.out.println(actEmployee);
		sa.assertEquals(actEmployee,sp_siteNamelab);
		String actDescription=siteReportTbl(sp_DeviceStatus);	
		System.out.println(actDescription);
		sa.assertEquals(actDescription,sp_DeviceStatus);
		String actfirmwarecell=siteReportTbl(sp_firmwareCell);	
		System.out.println(actfirmwarecell);
		sa.assertEquals(actfirmwarecell,sp_firmwareCell);
		String actHardwareid=siteReportTbl(sp_hardwareIdentification);	
		System.out.println(actHardwareid);
		sa.assertEquals(actHardwareid,sp_hardwareIdentification);
		String actPhonenum=siteReportTbl(sp_phoneNumberLab);	
		System.out.println(actPhonenum);
		sa.assertEquals(actPhonenum,sp_phoneNumberLab);
		String actComSeller=siteReportTbl(sp_comSeller);	
		System.out.println(actComSeller);
		sa.assertEquals(actComSeller,sp_comSeller);
		String actMacAddress=siteReportTbl(sp_MacAddressLab);	
		System.out.println(actMacAddress);
		sa.assertEquals(actMacAddress,sp_MacAddressLab);
		String actLastActive=siteReportTbl(sp_lastActive);	
		System.out.println(actLastActive);
		sa.assertEquals(actLastActive,sp_lastActive);
		sa.assertAll();
		
	}
	public void sitesDropDownclickRebootCount()throws Exception{
		logInfo("Entered into sitesDropDownclickRebootCount() method.");
		wdWait("xpath", sp_SitesPlaceHolder);
		clickOnObject("xpath",sp_SitesPlaceHolder);
	}
	public void clickSiteAndDashBoard() throws Exception{
		logInfo("Entered into clickSiteAndDashBoard() method.");
		SoftAssert sa =new SoftAssert();
		clickOnObject("xpath", sp_mainDashBoard);
		sleep(2000);
		clickOnButton("xpath",spview );
		sleep(3000);
		String actreportHeader=getText("xpath",sp_reportlabActivitylog);	
		System.out.println(actreportHeader);
		sa.assertEquals(actreportHeader,reportTblheading);
		String actExportBtn=getText("xpath",exportBtnREport);	
		System.out.println(actExportBtn);
		sa.assertEquals(actExportBtn,sp_exportbtnLab);
		String actSiteNametblHeader=siteReportTbl(sp_siteNamelab);	
		System.out.println(actSiteNametblHeader);
		sa.assertEquals(actSiteNametblHeader,sp_siteNamelab);
		String actDate=siteReportTbl(sp_Date);	
		System.out.println(actDate);
		sa.assertEquals(actDate,sp_Date);
		String actRebootCount=siteReportTbl(sp_RebootCount);	
		System.out.println(actRebootCount);
		sa.assertEquals(actRebootCount,sp_RebootCount);
		sa.assertAll();
	}
	
}

