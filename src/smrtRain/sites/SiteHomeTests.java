package smrtRain.sites;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.lib.Priority;

import smrtRain.settings.SettingMethods;



@Priority(11)
public class SiteHomeTests extends SiteMethods{
	SettingMethods setMed=new SettingMethods();	
	
	@Test(priority=1101)
	public void weatherReportSection() throws Exception {
		logInfo("Entered into weatherReportSection() test.");		
		sleep(10000);
		navigateToModule(reportsPage);
		sleep(20000);
		navigateToModule(sitesPage);
		sleep(20000);
		selectSiteByWildSearch("Exact");   
		getWeatherSourceLabel(weatherCSI);		
	}
	
	
	@Test(priority=1111)
	public void verifyExistingExactETDetails() throws Exception {
		logInfo("Entered into verifyExistingExactETDetails() test.");		
		Thread.sleep(10000);
		navigateToModule(reportsPage);
		Thread.sleep(10000);
		navigateToModule(sitesPage);
		Thread.sleep(10000);
		selectSiteByWildSearch("Exact");   
		getWeatherSourceLabel(weatherCSI);
		
	}
	
	
	@Test(priority=1112)
	public void createCanadaSiteAndExactET12() throws Exception {
		logInfo("Entered into createCanadaSiteAndExactET() test.");		
		navigateToModule(reportsPage);		
		sleep(5000);
		
		navigateToModule(sitesPage);
//		createNewSite(siteWithoutRainSensr,serialNumber+1);					
//        addressDetails(countryUsa);
//        selectWeatherSource(weatherListIBM);
//        rainSensor(rainSnsorNon);
//        createSiteFormGetLocation();
//        sleep(10000);
//        confirmModalBox(succesMsg);		
	
		
	}
	
	
	
	
	
	
	
	
	//Partner Screen
	/***Open any site an navigate to various screen. Verify this site in Most Recent grid.**/
	@Test(priority=1121)
	public void mostRecent_isRecentSitePresent() throws Exception {
		logInfo("Entered into mostRecent_isRecentSitePresent() test.");		
		sleep(20000);
		navigateToModule(reportsPage);		
		sleep(20000);
		navigateToModule(sitesPage);		
		getRecentSites();
		String siteName=selectAndGetRamdomlySite();
		selectMenuIconInSite(iconSiteConfig);
		selectMenuIconInSite(iconCalender);
		selectMenuIconInSite(iconProgram);
		navigateToModule(sitesPage);
		sleep(20000);
		verifyRecentSites(siteName);
		
	}
	
	/******Get site count from MostRecent. Create site and delete the site. 
	 * This site should not display as well as Count should decrease recentCount *********/
	
	@Test(priority=1122)
	public void recent_DoNotDisplaydeletedSite() throws Exception {
		logInfo("Entered into recent_DoNotDisplaydeletedSite() test.");		
		
		navigateToModule(reportsPage);				
		navigateToModule(sitesPage);
		int bfrRecentCount=getCountOfSites();
		System.out.println("bfrRecentCount :"+bfrRecentCount);		
		sleep(7000);
		navigateToModule(reportsPage);
		sleep(7000);
		navigateToModule(reportsPage);
		sleep(5000);		
		navigateToModule(sitesPage);
		System.out.println("partnerSite : "+partnerSite);
		createNewSite(partnerSite,serialNumber+"02");	
		inputChanceOfRain(70);
		addressDetails(countryUsa); 
        rainSensor(rainSnsorBasic);
        organisation(orgName);			
        createSiteFromGetLocation();
        confirmModalBox(succesMsg);			
        navigateToModule(sitesPage);
        int aftRecentCount=getCountOfSites();
		System.out.println("aftRecentCount :"+aftRecentCount);
		if(bfrRecentCount==4) {
			verifyRecentSites(partnerSite);			
		}else if(bfrRecentCount<=3) {
			Assert.assertEquals(bfrRecentCount+1, aftRecentCount);
			
			}
		sleep(20000);			
		searchAndSelectExistingSite(partnerSite);
		sleep(10000);
		selectMenuIconInSite(iconCalender);	
		selectMenuIconInSite(iconSiteConfig);
    	selectDotsToUpdateSiteDetails();   	
    	selectUpdateOrDelete(zoneDelete);
    	handleConfirmModal(siteDeleteTemp+partnerSite+progDeleteAft);    	
    	confirmPopup(siteDelSucess);
    	navigateToModule(sitesPage);
    	if(bfrRecentCount==0) {
    		Assert.assertEquals(0, aftRecentCount);    		
    	}else {
    		Assert.assertEquals(bfrRecentCount-1, aftRecentCount);
    	}	
		
	}
	/*******open a site from Most Recent grid and check That site should display 
	 * at Right Side End ofMost Recent. 	
	 */
	@Test(priority=1123)
	public void recent_OpenRecentSiteForPositionInGrid() throws Exception {
		logInfo("Entered into recent_OpenRecentSiteForPositionInGrid() test.");		
		sleep(20000);
		navigateToModule(reportsPage);
		sleep(20000);
		navigateToModule(sitesPage);
		sleep(20000);
		int bfrRecentCount=getCountOfSites();
		System.out.println("bfrRecentCount :"+bfrRecentCount);	
		if(bfrRecentCount==0) {
			System.out.println("No Sites are present in Most Recent Grid");
			
		}else {				
			sleep(7000);
			String openedSite =openSiteFromRecent();
			System.out.println(openedSite);
			selectMenuIconInSite(iconCalender);	
			selectMenuIconInSite(iconSiteConfig);
			navigateToModule(sitesPage);
			sleep(20000);
			verifyRecentSitePosition(bfrRecentCount, openedSite);
		}	
		
	}
	
	@Test(priority=1124)
	public void recent_CompareListWithGrid() throws Exception {
		logInfo("Entered into recent_CompareListWithGrid() test.");		
		sleep(20000);
		navigateToModule(reportsPage);
		sleep(20000);
		navigateToModule(sitesPage);
		sleep(20000);
	    selectPartnerTabs(parGrid);
	    int gridSize =getTotalSitesFromGrid();
	    System.out.println("gridSize "+gridSize);	    
	    selectPartnerTabs(parList);
	    int listSize=getTotalSitesFromList();
	    System.out.println("listSize "+listSize);
	    Assert.assertEquals(gridSize, listSize);
	   
	}
	
	@Test(priority=1125)
	public void recent_map() throws Exception {
		logInfo("Entered into recent_map() test.");				
	    selectPartnerTabs(parGrid);
	    selectPartnerTabs(parMap);
	    confirmMapAlert(mapAlertText);
	    
	   
	}

	@Test(priority=1126)
	public void recent_FilterByOrganization() throws Exception {
		logInfo("Entered into recent_FilterByOrganization() test.");			
		//filterClose();
	    selectPartnerTabs(parGrid);
	    selectPartnerTabs(parFilter);
	    selectFilter(filOrg, orgName);			
	    apply();
	    String siteName=selectAndGetRamdomlySite();
	    System.out.println("siteName: "+siteName);
	    selectMenuIconInSite(iconCalender);	
		selectMenuIconInSite(iconSiteConfig);
		String actOrg =setMed.getCustomDetails(filOrg);	  
	    Assert.assertEquals(actOrg, orgName);
	    navigateToModule(reportsPage);
		sleep(10000);
		navigateToModule(sitesPage);
		sleep(10000);
		selectPartnerTabs(parGrid);
//	    selectPartnerTabs(parFilter);	    
//	    selectFilter(filOrg, orgName2);
//	    apply();
//	    String siteName2=selectAndGetRamdomlySite();
//	    System.out.println("siteName: "+siteName2);
//	    selectMenuIconInSite(iconCalender);	
//		selectMenuIconInSite(iconSiteConfig);
//		String actOrg2 =setMed.getCustomDetails(filOrg);	  
//	    Assert.assertEquals(actOrg2, orgName2);
//	    navigateToModule(sitesPage);
	    
	}
	
	@Test(priority=1127)
	public void recent_FilterByStatus() throws Exception {
		logInfo("Entered into recent_FilterByStatus() test.");			
		//filterClose();
		sleep(5000);		
		navigateToModule(sitesPage);
	    selectPartnerTabs(parGrid);
	    selectPartnerTabs(parFilter);	 	   		
	    selectFilter(filStatus, stSuspend);			
	    apply();
	    String siteName=selectAndGetRamdomlySite();
	    System.out.println("siteName: "+siteName);
	    selectMenuIconInSite(iconCalender);	
		selectMenuIconInSite(iconSiteConfig);
		String actDevStat =setMed.getCustomDetails(devStatus);	  
	    Assert.assertEquals(actDevStat, stSuspend);
	    navigateToModule(reportsPage);
		sleep(10000);
		navigateToModule(sitesPage);
		sleep(10000);
		selectPartnerTabs(parGrid);
	    selectPartnerTabs(parFilter);	    
	    selectFilter(filStatus, stUnsuspend);
	    apply();	    
	    noResults();
	}
	
	@Test(priority=1128)
	public void recent_FilterByState() throws Exception {
		logInfo("Entered into recent_FilterByState() test.");			
		//filterClose();
		sleep(5000);		
		navigateToModule(sitesPage);
	    selectPartnerTabs(parGrid);
	    selectPartnerTabs(parFilter);	 	   		
	    selectFilter(filState, stUtah);			
	    apply();
	    String siteName=selectAndGetRamdomlySite();
	    System.out.println("siteName: "+siteName);
	    selectMenuIconInSite(iconCalender);	
		selectMenuIconInSite(iconSiteConfig);
	   	selectDotsToUpdateSiteDetails();   	
    	selectUpdateOrDelete(zoneUpdate);
    	String actState1=getSelectedState();
    	Assert.assertEquals(actState1, stUtah);
    	navigateToModule(sitesPage);
		sleep(10000);
		selectPartnerTabs(parGrid);
	    selectPartnerTabs(parFilter);
	    selectFilter(filState, stArizona);			
	    apply();
	    String siteName2=selectAndGetRamdomlySite();
	    System.out.println("siteName2: "+siteName2);
	    selectMenuIconInSite(iconCalender);	
		selectMenuIconInSite(iconSiteConfig);
	   	selectDotsToUpdateSiteDetails();   	
    	selectUpdateOrDelete(zoneUpdate);
    	String actState2= getSelectedState();
    	Assert.assertEquals(actState2, stArizona);
	    
	    
	}
	
	
	

}
