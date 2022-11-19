package smrtRain.sites;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.lib.Priority;
import com.lib.TestBase;

@Priority(2)
public class SitesTests extends SiteMethods{
	
	@Test(priority=201)
	public void validateNewSiteFields() throws Exception {
		logInfo("Entered into validateNewSiteFields() test.");
		sleep(10000);
		navigateToModule(reportsPage);		
		sleep(5000);
		navigateToModule(sitesPage);
		verifyMandatoryFields();			
	}	
	
	@Test(priority=202)
	public void validateAddressFields() throws Exception {
		logInfo("Entered into validateNewSiteFields() test.");
		verifyAddressFields();
		
	}
	
	@Test(priority=203)
	public void validateTimeZones() throws Exception {
		logInfo("Entered into validateTimeZones() test.");		
		verifyTimeZoneOptions(timeZoneOptions);
		selectTimeZone(timeZonePacific);
		
	}
	
	@Test(priority=204)
	public void validateCountryStateCity() throws Exception {
		logInfo("Entered into validateCountryStateCity() test.");
    	verifyCountries(expCountry);
    	handleAddSite();
    	verifyAddressFields();
    	verifyStates(countryUsa, stateList);
    	// 	refreshScreen();    	
       	int noOfCities =storeDataInProrpertyFile(usaCities,stAlabama);			
	    verifyCityBasedOnStateOrProvince(stAlabama,noOfCities,usaCities);	
		
	}	
	@Test(priority=205)
	public void createNewSite() throws Exception {
		logInfo("Entered into createNewSite() test.");		
		sleep(7000);
		navigateToModule(reportsPage);
		sleep(7000);
		navigateToModule(reportsPage);
		sleep(5000);		
		navigateToModule(sitesPage);
		System.out.println("newSiteName : "+newSiteName);
		createNewSite(newSiteName,serialNumber);	
		//sitePhoto();
		inputChanceOfRain(70);
        addressDetails(countryUsa);   //countryCanada    //countryUsa
        rainSensor(rainSnsorBasic);		
		organisation(orgName);	
		createSiteFromGetLocation();
        confirmModalBox(succesMsg);	
        selectSiteByWildSearch(newSiteName);	
        
		
	}	
	
	@Test(priority=207)
	public void addZonesToSite() throws Exception {
		logInfo("Entered into addZonesToSite() test.");
		String zoneRotorName="Green Rotor "+TestBase.generateRandomNumberInRange(1, 900);
		sleep(10000);
		navigateToModule(reportsPage);
		sleep(6000);	
		navigateToModule(sitesPage);
		sleep(10000);
		searchAndSelectExistingSite(newSiteName);    
		sleep(10000);
		selectMenuIconInSite(iconProgram);			
		selectMenuIconInSite(iconZone);
		createZone(zoneRotorName);
		//validateZoneFields();
		//verifyZonesNumber(noOfZonesSize);  //noOfZonesSize
		selectZoneNumber();	
		irrigationType(irrTypeAll);
		verifyDefaultFlowData(irrTypeDrip);
		verifyDefaultFlowData(irrTypeSpray);
		verifyDefaultFlowData(irrTypeRotor);
		//verifyDefaultFlowData(irrTypePopup);		
		addZoneFinalBtn();
		//confirmModalBox(succssMsgForInactive);	
		refreshScreen();
		
		}
	
	@Test(priority=208)
	public void addZoneWithSprayType() throws Exception{
		logInfo("Entered into addZoneWithSprayType() test.");	
		String zoneSprayName= "GREEN SPRAY " +TestBase.generateRandomNumberInRange(500, 900);
		selectMenuIconInSite(iconProgram);	
		selectMenuIconInSite(iconZone);	
		createZone(zoneSprayName);
		selectZoneNumber();	
		verifyDefaultFlowData(irrTypeSpray);
		addZoneFinalBtn();	
		//confirmModalBox(succssMsgForInactive);	
		refreshScreen();
	}
	
	@Test(priority=209)
	public void addZoneWithDripType() throws Exception {
		logInfo("Entered into addZoneWithDripType() test.");		
		String zoneDripName1= "GREEN DRIP " +TestBase.generateRandomNumberInRange(1000, 9000);
		selectMenuIconInSite(iconZone);	
		createZone(zoneDripName1);
		selectZoneNumber();	
		verifyDefaultFlowData(irrTypeDrip);
		addZoneFinalBtn();
		//confirmModalBox(succssMsgForInactive);		
		refreshScreen();
	}
	
	//SMRTMB-945
	@Test(priority=210) 
	public void deleteExistingZone() throws Exception {
		logInfo("Entered into deleteExistingZone() test.");	
		String zoneName= "Dry Zone"+TestBase.generateRandomNumberInRange(1, 900);
		sleep(5000);
		navigateToModule(reportsPage);
		sleep(6000);	
		navigateToModule(sitesPage);
		sleep(10000);
		searchAndSelectExistingSite(newSiteName);    
		sleep(10000);
		selectMenuIconInSite(iconSiteHome);	
		selectMenuIconInSite(iconZone);	
		createZone(zoneName);
		selectZoneNumber();	
		verifyDefaultFlowData(irrTypeDrip);
		addZoneFinalBtn();	
		//confirmModalBox(succssMsgForInactive);
		refreshScreen();
		selectMenuIconInSite(iconCalender);			
		selectMenuIconInSite(iconZone);	
		int bfrZoneCount= getNoOfZonesFromGrid();		
		selectExistingZone(zoneName);             //zoneSprayName
		zoneStatus(zoneDelete);
		int AftZoneCount= getNoOfZonesFromGrid();		
		if(bfrZoneCount>AftZoneCount) {
			zoneNotToPresent(zoneName);
		//System.out.println("status :"+isZonePresent(zoneRotorName));			
		}else {
			
			Assert.assertNotEquals(bfrZoneCount, AftZoneCount);
		}		
	}
	
	@Test(priority=211)
	public void addZoneWithoutIrrigationType() throws Exception {
		logInfo("Entered into addZoneWithoutIrrigationType() test.");
		int bfrZoneCount= getNoOfZonesFromGrid();		
		createZone(zoneRotor2Name);
		selectZoneNumber();
		irrigationTypeDuration();
		isAddBtnEnabled();		
		int afrZoneCount= getNoOfZonesFromGrid();		
		Assert.assertEquals(bfrZoneCount, afrZoneCount);
	
	 }	
	
	@Test(priority=221)
	public void verifyCitiesOfStateAlaska() throws Exception {
		logInfo("Entered into verifyCitiesOfStateAlaska() test.");
		String serialNumber=TestBase.generateRandomNumberInRange(1,10000)+"N";
		Thread.sleep(6000);
		navigateToModule(reportsPage);
		Thread.sleep(6000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stAlaska);  //187
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		Thread.sleep(6000);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stAlaska,noOfCities,usaCities);	
	}
	
	
	@Test(priority=222)
	public void verifyCitiesOfStateArizona() throws Exception {
		logInfo("Entered into verifyCitiesOfStateArizona() test.");
		Thread.sleep(6000);		
		navigateToModule(reportsPage);
		Thread.sleep(6000);
		int noOfCities =storeDataInProrpertyFile(usaCities,stArizona);
		System.out.println("noOfCities "+noOfCities);
		navigateToModule(sitesPage);
		openNewSiteAndSelectCountry(countryUsa);		
	    verifyCityBasedOnStateOrProvince(stArizona,noOfCities,usaCities);	
	
	}	
	
	
	
	}



