package smrtRain.sites;

import org.testng.annotations.Test;

import com.lib.Priority;

@Priority(101)
public class TearDownSites extends SiteMethods {
	
	@Test(priority=10104)
	public void deleteGeneralSite() throws Exception {
		logInfo("Entered into deleteGeneralSite() test.");
		sleep(20000);
		navigateToModule(reportsPage);
		navigateToModule(homePage);
		sleep(5000);		
		navigateToModule(sitesPage);
		sleep(10000);
		searchAndSelectExistingSite(newSiteName);
		sleep(10000);
		selectMenuIconInSite(iconCalender);	
		selectMenuIconInSite(iconSiteConfig);
    	selectDotsToUpdateSiteDetails();   	
    	selectUpdateOrDelete(zoneDelete);
    	handleConfirmModal(siteDelete+newSiteName+progDeleteAft);    	
    	confirmPopup(siteDelSucess);		
		
	}
	
	
	//@Test(priority=10101)
	public void deleteZonesFromLiveActiveSite() throws Exception {
		logInfo("Entered into deleteRainSensorSite() test.");	
		sleep(20000);	
		navigateToModule(alertsPage);
		sleep(20000);	
		navigateToModule(sitesPage);
		sleep(20000);	
		selectSiteByWildSearch(twoWireSire);
		selectMenuIconInSite(iconCalender);	
		selectMenuIconInSite(iconZone);				
		selectExistingZone(zoneDripName2);
		zoneStatus(zoneDelete);	
		
	}
	
	
	//@Test(priority=10102)
	public void deleteZonesOfProgramSite() throws Exception {
		logInfo("Entered into deleteZonesOfProgramSite() test.");			
		sleep(20000);	
		navigateToModule(sitesPage);
		sleep(20000);	
		selectSiteByWildSearch(existSmartStackSite);
		selectMenuIconInSite(iconCalender);	
		selectMenuIconInSite(iconZone);				
		selectExistingZone(zoneDripName1);
		zoneStatus(zoneDelete);
		
		selectExistingZone(zoneSprayName);
		zoneStatus(zoneDelete);
		selectExistingZone(zoneRotorName);
		zoneStatus(zoneDelete);
		
		
		
		
		
	}
	
	
	
	
	

}
