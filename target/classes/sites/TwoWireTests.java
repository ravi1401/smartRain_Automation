package smrtRain.sites;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.lib.Priority;
import com.lib.TestBase;

@Priority(3)
public class TwoWireTests extends SiteMethods{	
	
	@Test(priority=301)
	public void validateControllerTypes()throws Exception{
        logInfo("Entered into validateNewSiteFields() test.");
        sleep(7000);
		navigateToModule(reportsPage);
		sleep(7000);
		navigateToModule(reportsPage);
		sleep(5000);		
		navigateToModule(sitesPage);
		handleAddSite();
		controllerTypes(contTypes);        
        selectionAndVericationOfControllers(contTypeProCom,proComSize);
        selectionAndVericationOfControllers(contType2Wire,twoWireSize);
        selectionAndVericationOfControllers(contTypeProLite,proLiteSize);
	   }
	
	@Test(priority=302)
	public void createTwoWireNewSite() throws Exception {
		logInfo("Entered into createTwoWireNewSite() test.");		
		sleep(7000);
		navigateToModule(reportsPage);
		sleep(7000);
		navigateToModule(reportsPage);
		sleep(5000);		
		navigateToModule(sitesPage);		
		createNewSite(newSiteName,serialNumber);
		selectionAndVericationOfControllers(contType2Wire,twoWireSize);		
		inputChanceOfRain(70);
        addressDetails(countryUsa);   //countryCanada    //countryUsa
        rainSensor(rainSnsorBasic);		
		organisation(orgName);	
		createSiteFromGetLocation();
        confirmModalBox(succesMsg);	
        selectSiteByWildSearch(newSiteName);	        
		
	}	
	
	@Test(priority=303)
	public void addZoneWithMaxZoneNumber() throws Exception{
		logInfo("Entered into addZoneWithSprayType() test.");	
		String zoneSprayName= "GREEN SPRAY " +TestBase.generateRandomNumberInRange(500, 900);
		threadSleep(7000);
		navigateToModule(reportsPage);	
		sleep(10000);
		navigateToModule(sitesPage);
		sleep(10000);
		selectSiteByWildSearch(newSiteName);	
		
		selectMenuIconInSite(iconProgram);	
		selectMenuIconInSite(iconZone);	
		createZone(zoneSprayName);
		selectLastZoneNumber();
		verifyDefaultFlowData(irrTypeSpray);
		addZoneFinalBtn();	
		//confirmModalBox(succssMsgForInactive);	
		refreshScreen();
	}
	
	@Test(priority=304)
	public void addDripZoneWithMaxNumber() throws Exception {
		logInfo("Entered into addDripZoneWithMaxNumber() test.");		
		String zoneDripName1= "GREEN DRIP " +TestBase.generateRandomNumberInRange(1000, 9000);
		selectMenuIconInSite(iconZone);	
		createZone(zoneDripName1);
		selectLastZoneNumber();	
		verifyDefaultFlowData(irrTypeDrip);
		addZoneFinalBtn();
		//confirmModalBox(succssMsgForInactive);		
		refreshScreen();
	}	
	
	@Test(priority=311)
	public void addZoneinActiveTwoWireSite() throws Exception {
		logInfo("Entered into verifyAddedZonesInLogs() test.");				
		threadSleep(7000);
		navigateToModule(reportsPage);	
		sleep(10000);
		navigateToModule(sitesPage);
		sleep(10000);
		selectSiteByWildSearch(twoWireSire);	
		selectMenuIconInSite(iconCalender);	
		selectMenuIconInSite(iconZone);	
		createZone(zoneSprayName);
		selectLastZoneNumber();
		verifyDefaultFlowData(irrTypeSpray);
		addZoneFinalBtn();	
		confirmModalBox(succssMsgText);	
		refreshScreen();
		
		
	}
	
	
	
	
	//@Test(priority=399)
	public void deleteTwoWireSite() throws Exception {
		logInfo("Entered into deleteTwoWireSite() test.");
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
	
	}



