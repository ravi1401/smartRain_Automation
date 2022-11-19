package smrtRain.spanish;




import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.lib.Priority;

@Priority(22)
public class SpanishTests extends SpanishMethods{
	
	@Test(priority=2201)
	public void changeProfileToSpanish() throws Exception {
		logInfo("Entered into changeProfileToSpanish() test.");		
		sleep(20000);
		navigateToModule(reportsPage);		
		sleep(15000);		
		navigateToModule(alertsPage);		
		gm.editProfile();
		gm.chooseLanguage(lanSpan);
		gm.confirmUpdatedProfile(succProfileMsgInSpanish);
	
	}
	
	@Test(priority=2202)
	public void verifySpanishProfile() throws Exception {
		logInfo("Entered into spanishProfile() test.");	
		sleep(20000);
		navigateToModule(spSites);            //spSites);
		gm.editProfile();
		verifyProfileLabels();
		
	}
	
	
	@Test(priority=2203)
	public void sp_validateHomePage() throws Exception {
		logInfo("Entered into sp_validateHomePage() test.");
		sleep(20000);
		navigateToModule(spHome);
		sleep(2000);
		gm.getCardTitle(spWaterSaved);
		validateWaterDaysDetails();
		gm.getCardTitle(spSiteAlerts);
		gm.getCardTitle(spMoney);
		validateMoneyDaysDetails();
		validatesHomePage();
		validateActivityLogHomep();
		validateNotes();
		validateUpcommingMaintanance();
		validateAddnew();
		
		
	}
	@Test(priority=2204)
	public void sp_validateAddSiteLabels() throws Exception {
		logInfo("Entered into sp_validateAddSiteLabels() test.");	
//		sleep(20000);
//		navigateToModule(spSetting);
//		sleep(20000);
		navigateToModule(spReports);
		sleep(20000);
		navigateToModule(spSites);
		sleep(20000);
		labelsValidate();
		selectAddSite();
		newSiteValidation();
		flowSensorvalidation();
		validationofEtValue();
		newAddressDetailsValidation();
		latitudeValidation();
		programRunningDaysValidation();
		
	}
	
	@Test(priority=2205)
	public void sp_validateInviteUserLabel() throws Exception{
	logInfo("Entered into sp_validateInviteUserLabel() test.");
	sleep(2000);
	validateInviteUserLabel();
	selectInviteUser();
	newInviteUserLabel();
	
	}
	
	@Test(priority=2206)
	public void sp_validateAlerts() throws Exception{
	logInfo("Entered into sp_validateAlerts()  test.");
//	sleep(20000);
//	navigateToModule(spReports);
	sleep(2000);
	navigateToModule(spAlerts);
	sleep(2000);
	validateAlertsPage();
	validateTableHeaders();
	
	
	}
	
	@Test(priority=2207)
	public void sp_validateSettings() throws Exception{
	logInfo("Entered into sp_validateSettings()  test.");
//	sleep(20000);
//	navigateToModule(spReports);
	sleep(2000);
	navigateToModule(spSetting);
	settingHeader(sp_FirmwareMaintenance);
	validFirmwareTblHeadings();
	validateAddfirmwarePopup();
	validateFirmWareTableHeaders();
	validateUpdateFirmWare();
	validateDeleteFirmware();
	settingHeader(sp_DeviceDetailsList);
	sleep(20000);
	validateDeviceDetails();
	settingHeader(sp_siteNotifications);
	validateAddNotifications();
	validateAddNotificationPopup();
	validateUpdateNotification();
	validateDEleteNotificationPopup();
	validateAddNotificationTable();
	settingHeader(sp_siteZoneColors);
	validateZoneColors();
	validateUpdateColor();
	settingHeader(sp_moistureDetails);
	validateMoistureDetails();
	validateMoistureGatewayDetails();
	settingHeader(sp_bulkOperations);
	validateBulkOperations();
	clickUnsuspend();
	afterClicking();
	validateBulkOperationTable();
	validateDropDownBulkOperation();
	
	}
	
	
	@Test(priority=2208)
	public void sp_validateReportLabels() throws Exception{
	logInfo("Entered into sp_validateReportLabels()  test.");
	sleep(20000);
	navigateToModule(spSetting);
	sleep(2000);
	navigateToModule(spReports);
	sleep(2000);
	validateReportLabels();
	clickOnDropDowns(alDevice);
	reportTypeDropdownList(siteText);
	sleep(2000);
	validateReportSitedropdown();
	sitesDropDownclick();
	sleep(35000);
	selectSiteFromDropdown(sitenameREport);
	sleep(2000);
	viewBtn();
	sleep(2000);
	validateSitesTableReport();
	sleep(2000);
	refreshScreen();
	sleep(10000);
	
	clickOnDropDowns(alDevice);
	reportTypeDropdownList(waterUsage);
	sitesDropDownclick();
	sleep(35000);
	selectSiteFromDropdown(sitenameREport);
	recordsNotFound();
	sleep(2000);
	refreshScreen();
	sleep(10000);
	
	clickOnDropDowns(alDevice);
	reportTypeDropdownList(waterUsage);
	WebElement head=driver.findElement(By.xpath(sp_checkboxDateRange));
	head.click();
	sitesDropDownclick();
	sleep(35000);
	selectSiteFromDropdown(reportSitename);
	validtaeWaterUsage();
	validateWaterUsageTblRepots();
	sleep(2000);
	refreshScreen();
	sleep(10000);
	
	clickOnDropDowns(alDevice);
	reportTypeDropdownList(wether);
	sitesDropDownclick();
	sleep(35000);
	selectSiteFromDropdown(reportSitename);
	viewBtn();
	sleep(5000);
	validateWetherTbl();
	sleep(2000);
	refreshScreen();
	sleep(10000);
	
	
	clickOnDropDowns(alDevice);
	reportTypeDropdownList(activityLog);
	sitesDropDownclick();
	sleep(35000);
	selectSiteFromDropdown(sitenameREport);
	viewBtn();
	sleep(5000);
	validateActivityLogTbl();
	sleep(2000);
	refreshScreen();
	sleep(10000);
	
	
	clickOnDropDowns(alDevice);
	reportTypeDropdownList(rebootCount);
	sitesDropDownclickRebootCount();
	sleep(35000);
	selectSiteFromDropdown(sitenameREport);
	viewBtn();
	sleep(5000);
	validateRebootCountTbl();
	WebElement clear= driver.findElement(By.xpath(sp_ClearBtnReport));		
	JavascriptExecutor execut = (JavascriptExecutor)driver;
	execut.executeScript("arguments[0].click();", clear);
	sleep(2000);
	refreshScreen();
	sleep(10000);
	
	sitesDropDownclickRebootCount();
	sleep(35000);
	selectSiteFromDropdown(sitenameREport);
	viewBtn();
	sleep(5000);
	validateDeviceTbl();
	sleep(2000);
	refreshScreen();
	sleep(10000);
	
	
	}
	@Test(priority=2209)
	public void sp_validateUsermanagement() throws Exception{
	logInfo("Entered into sp_validateUsermanagement()  test.");
//	sleep(20000);
//	navigateToModule(spSetting);
//	sleep(20000);
//	navigateToModule(spReports);
	sleep(2000);
	navigateToModule(spUserMang);
	sleep(2000);
	validateUsermanagementLabels();
	
	}


	@Test(priority=2209)
	public void sp_validateSiteConfigDetails() throws Exception{
	logInfo("Entered into sp_validateSiteConfigDetails()  test.");
	navigateToModule(spReports);
	sleep(10000);
	navigateToModule(spSites);
	sleep(35000);
	selectSiteFromAllSites(newSiteName);
	sleep(2000);
	selectMenuIconInSite(iconMap);
	selectMenuIconInSite(iconSiteConfig);
	validateSiteConfiglables();
	validateSiteConfigHeaders();
	validSiteConfigNetworkDetailsLables();
	selectDropDowninSiteConfig();
	validSiteConfigNetworkDetailsDropDown();
	validSiteConfigSiteStatus();
	selectDotsToUpdateSiteDetails();
	selectUpdateOrDelete(sp_deleteLab);
	deleteSitepopupMsg();
	sleep(2000);
	}
	
	@Test(priority=2210)
	public void sp_validateProgramPage() throws Exception {
		logInfo("Entered into sp_validateProgramPage()  test.");
//		sleep(20000);
//		navigateToModule(spSetting);
//		sleep(20000);
//		navigateToModule(spReports);
//		sleep(20000);
//		navigateToModule(spSites);
//		sleep(60000);
//		selectSiteFromAllSites(newSiteName);
		sleep(3000);
		selectMenuIconInSite(iconMap);
		//sleep(2000);
		selectMenuIconInSite(iconProgram);
		
		programMainButtons();
		
		selectZonesDD(sp_selectZoneLab);
		selectOptionFromDropDown(sp_ALL);
		programButtons(sp_AddZoneLab);
		lableValidationAddProgram();
		toggleLabelValidationProgram();
		warningNameMessage();
		createNewProgram(programName);
		warningWaterTypeMessage();
		typeOfWatering(sp_smartWateringEt);
		//smartEtPopup();
		typeOfWatering(sp_smartWatering);
		typeOfWatering(sp_regularWatering);
		warningSelectRepeat();
		selectZonesDD(sp_SelectDropLab);
		selectOptionFromDropDown(sp_odd); 
		selectZonesDD(sp_odd);
		selectOptionFromDropDown(sp_selctDays);
		selectDaysProgram();
		selectZonesDD(sp_selctDays);
		selectOptionFromDropDown(sp_even); 
		programButtons(sp_AddLab);
		sleep(3000);
		confirmInProgram(msgAddedProg);
		selectLargeButtonInProgram(sp_RunProgramLab);
		runProgramPopup();
		
	}
	@Test(priority=2211)
	public void sp_validateUpdateExistingProgram() throws Exception {
		logInfo("Entered into sp_validateUpdateExistingProgram()  test.");
		selectDotsBasedOnProgram(programName);                 
		selectUpdateOrDelete(sp_editBtn);
		scrollToTop();
		createNewProgram(progUpdatedName);
		selectSliderButton(sp_multipleRunTimeLab);
		clickOnButton("xpath", sp_cross);
		sleep(2000);
	}
	
	@Test(priority=2212)
	public void sp_validateDeleteExistingProgram() throws Exception {
		logInfo("Entered into sp_validateDeleteExistingProgram()  test.");
		selectDotsBasedOnProgram(programName);                 
		selectUpdateOrDelete(sp_deleteLab1);
		sleep(2000);
		confirmStatusModelBox(sp_programDel+programName+progDeleteAft);
		clickOnButton("xpath", zonDetFlowCancel);
		
	}
	
	@Test(priority=2213)
	public void sp_validateProgramPageSameconfig() throws Exception {
		logInfo("Entered into sp_validateExistingProgram() test.");
		sleep(7000);
		selectMenuIconInSite(iconCalender);	
		selectMenuIconInSite(iconProgram);	
		selectLargeButtonInProgram(addProg);
		createNewProgram(programName);
		selectZonesDD(labelSelectZone);
		selectOptionFromDropDown(sp_ALL);  
		typeOfWatering(labRegWater);
		programButtons(labAddZone);
		selectZonesDD(labelSelectRepeat);
		selectOptionFromDropDown("Even"); 
		programButtons(addProgram);
		handleConfirmModal(msgSameTime);			
		cancelButton();
		
	}
	

	//@Test(priority=2220)
	public void changeProfileToEnglish() throws Exception {
		logInfo("Entered into changeProfileToEnglish() test.");	
		sleep(20000);
		navigateToModule(spReports);		
		sleep(15000);		
		navigateToModule(spAlerts);		
		gm.editProfile();
		gm.chooseLanguage(lanEng)	;
		gm.confirmUpdatedProfile(succProfileMsg);
	
	}
	
	
	
}
