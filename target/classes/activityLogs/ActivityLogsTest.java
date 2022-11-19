package smrtRain.activityLogs;

import org.testng.annotations.Test;
import com.lib.Priority;
import com.lib.TestBase;

@Priority(10)
public class ActivityLogsTest extends ActivityMethods{
	
	@Test(priority=1001)
	public void log_CreateSiteForLogs() throws Exception {
		logInfo("Entered into log_CreateSiteForLogs() test.");
		String serialNumber =TestBase.generateRandomNumberInRange(1,10000)+"S";
		sleep(25000);
		navigateToModule(settingsPage);		
		sleep(20000);		
		navigateToModule(sitesPage);
//		sleep(10000);
//		createNewSite(logSiteName,serialNumber);	
//		//sitePhoto();
//        addressDetails(countryUsa); 
//        rainSensor(rainSnsorBasic);
//        createSiteFormGetLocation();
//        confirmModalBox(succesMsg);	
        
        
	}
	
	@Test(priority=1002)
	public void log_validateSiteHomeGrid() throws Exception {
		logInfo("Entered into log_validateSiteHomeGrid() test.");
		sleep(20000);       
		navigateToModule(settingsPage);		
		sleep(10000);  		
		navigateToModule(sitesPage);
		sleep(20000); 
		selectExistingSite(newSiteName);              //logSiteName);	   //newSiteName  "ActLog Site 256"
		sleep(10000);
		verifyActivityGrid();
		verifyGridHeaders();
		
        
	}
	
	@Test(priority=1003)
	public void log_SiteCreated() throws Exception {
		logInfo("Entered into log_SiteCreated() test.");		
		showMore();
		overlayHeaderFunctions(alRfsh);
		verifyGridHeaders();
//		String actEmp = getDataFromLogsTable(alEmp);
//		System.out.println("get empl "+actEmp);
//		String getSite = getDataFromLogsTable(alSite);
		logsOfSiteCreated(newSiteName);		
	}
	
	
	@Test(priority=1004)	
	public void log_ValidateLabels() throws Exception {
		logInfo("Entered into log_ValidateLabels() test.");
		overlayHeaderFunctions(alRfsh);		
		overlayHeaderFunctions(alClr);
		activityObjects(alTitText);
		activityObjects(alCatg);
		
	}
	
	// Category 
	@Test(priority=1005)
	public void log_SearchByCatgeory() throws Exception {
		logInfo("Entered into log_SearchByCatgeory() test.");
		sleep(20000);
		navigateToModule(alertsPage);		
		sleep(20000);		
		navigateToModule(sitesPage);
		sleep(20000);
		selectExistingSite(existSmartStackSite);  
		sleep(10000);
		showMore();
		overlayHeaderFunctions(alRfsh);
		categoryOption(alEmp);
		verifyDataFromColumn(alActivity, alEmp);		
		categoryOption(alDevice);
		verifyDataFromColumn(alActivity, alDevice);
		categoryOption(alNotifi);
		verifyDataFromColumn(alActivity, alNotifi);
		categoryOption(alCatSite);
		verifyDataFromColumn(alSite, existSmartStackSite);
		categoryOption(alSystem);
		verifyDataFromColumn(alActivity,alSystem);
		categoryOption(alTask);
		verifyDataFromColumn(alActivity,alSystem);	
	}
	
	@Test(priority=1006)
	public void log_WildCardSearch() throws Exception {
		logInfo("Entered into log_WildCardSearch() test.");
		String userName=getProfileName();		
		categoryOption(alAll);
		searchByInput(userName);
		verifyDataFromColumn(alEmp, userName);			
	}
	
	@Test(priority=1007)
	public void log_HandlePackets() throws Exception {
		logInfo("Entered into log_handlePackets() test.");
		categoryOption(alAll);
		searchByInput(" ");
		selectPacketFromLogsTable(alPack,alSeePacket);		
	}
	
	@Test(priority=1008)
	public void log_HandleDashBoardLogs() throws Exception {
		logInfo("Entered into log_HandleDashBordLogs() test.");
		Thread.sleep(20000);	
		navigateToModule(settingsPage);
		Thread.sleep(10000);		
		navigateToModule(homePage);
		sleep(10000);
		verifyActivityGrid();
		verifyGridHeaders();
		showMore();
		overlayHeaderFunctions(alRfsh);		
//		categoryOption(alAll);
//		searchByInput(" ");
//		selectPacketFromLogsTable(alPack,alSeePacket);
//		closePacket();
	}

}
